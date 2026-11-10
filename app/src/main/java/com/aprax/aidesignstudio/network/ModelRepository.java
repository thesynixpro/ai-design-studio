package com.aprax.aidesignstudio.network;

import com.aprax.aidesignstudio.models.AIModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Fetches the Gemini model catalogue and filters it to verified free-tier
 * models only (see free-tier list below, mirroring Google's pricing docs).
 */
public class ModelRepository {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final ApiClient apiClient = ApiClient.getInstance();
    private List<AIModel> cachedModels = new ArrayList<>();
    private ModelFetchListener listener;

    public interface ModelFetchListener {
        void onModelsFetched(List<AIModel> models);
        void onError(String error);
    }

    public void setListener(ModelFetchListener listener) {
        this.listener = listener;
    }

    public void fetchModels(final String apiKey) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    GeminiApiService.Response response =
                        apiClient.getApiService().getModels(apiKey);

                    if (response.isSuccessful() && response.body != null) {
                        ModelListResponse parsed = ModelListResponse.fromJson(response.body);
                        List<AIModel> models = convertToAIModels(parsed.getModels());
                        filterFreeTierModels(models);
                        cachedModels = models;
                        if (listener != null) {
                            listener.onModelsFetched(models);
                        }
                    } else {
                        if (listener != null) {
                            listener.onError("Failed to fetch models: " + response.code);
                        }
                    }
                } catch (Exception e) {
                    if (listener != null) {
                        listener.onError("Error fetching models: " + e.getMessage());
                    }
                }
            }
        });
    }

    private List<AIModel> convertToAIModels(List<ModelListResponse.ModelInfo> infos) {
        List<AIModel> models = new ArrayList<>();
        if (infos == null) return models;
        for (ModelListResponse.ModelInfo info : infos) {
            AIModel model = new AIModel();
            model.setModelId(info.getName());
            model.setDisplayName(info.getDisplayName() != null ? info.getDisplayName() : info.getName());
            model.setDescription(info.getDescription());
            model.setContextWindow(String.valueOf(info.getInputTokenLimit()));
            model.setProvider("Google");

            // Text-generation capability check
            boolean isTextModel = false;
            if (info.getSupportedGenerationMethods() != null) {
                for (String method : info.getSupportedGenerationMethods()) {
                    if ("generateContent".equals(method) || "streamGenerateContent".equals(method)) {
                        isTextModel = true;
                        break;
                    }
                }
            }
            model.setCodeGeneration(isTextModel ? "supported" : "not_supported");
            models.add(model);
        }
        return models;
    }

    private void filterFreeTierModels(List<AIModel> models) {
        // Keep only known free-tier eligible models; paid/unverified models are hidden.
        List<AIModel> filtered = new ArrayList<>();
        for (AIModel model : models) {
            String modelId = model.getModelId() == null
                ? "" : model.getModelId().toLowerCase();
            if (isFreeTierEligible(modelId)) {
                model.setFreeTierEligible(true);
                filtered.add(model);
            } else {
                model.setFreeTierEligible(false);
            }
        }
        models.clear();
        models.addAll(filtered);
    }

    private boolean isFreeTierEligible(String modelId) {
        // Known free-tier models from Google's pricing documentation.
        String[] freeModels = {
            "gemini-1.5-flash",
            "gemini-1.5-flash-8b",
            "gemini-1.0-pro",
            "gemini-pro",
            "gemini-pro-vision",
            "gemini-1.5-pro-latest",
            "models/gemini-1.5-flash",
            "models/gemini-1.5-flash-8b",
            "models/gemini-1.0-pro",
            "models/gemini-pro",
            "models/gemini-pro-vision"
        };

        for (String free : freeModels) {
            if (modelId.contains(free)) {
                return true;
            }
        }
        return false;
    }

    public List<AIModel> getCachedModels() {
        return new ArrayList<>(cachedModels);
    }

    public void refreshModels(String apiKey) {
        fetchModels(apiKey);
    }
}