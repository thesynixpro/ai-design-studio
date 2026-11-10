package com.aprax.aidesignstudio.network;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Parsed model-list response for GET v1beta/models.
 *
 * Hand-parsed with org.json (shipped on every Android device) because Gson is
 * not available on the BUILD STUDIO classpath.
 */
public class ModelListResponse {
    private List<ModelInfo> models;
    private String nextPageToken;

    public List<ModelInfo> getModels() { return models; }
    public void setModels(List<ModelInfo> models) { this.models = models; }
    public String getNextPageToken() { return nextPageToken; }
    public void setNextPageToken(String nextPageToken) { this.nextPageToken = nextPageToken; }

    /** Parse a JSON body of shape {"models":[...], "nextPageToken":"..."}. */
    public static ModelListResponse fromJson(String json) throws JSONException {
        ModelListResponse response = new ModelListResponse();
        JSONObject root = new JSONObject(json);
        response.nextPageToken = root.isNull("nextPageToken") ? null
            : root.optString("nextPageToken", null);

        List<ModelInfo> parsed = new ArrayList<>();
        JSONArray array = root.optJSONArray("models");
        if (array != null) {
            for (int i = 0; i < array.length(); i++) {
                JSONObject item = array.optJSONObject(i);
                if (item != null) {
                    parsed.add(ModelInfo.fromJson(item));
                }
            }
        }
        response.models = parsed;
        return response;
    }

    public static class ModelInfo {
        private String name;
        private String displayName;
        private String description;
        private List<String> supportedGenerationMethods;
        private int inputTokenLimit;
        private int outputTokenLimit;

        static ModelInfo fromJson(JSONObject item) throws JSONException {
            ModelInfo info = new ModelInfo();
            info.name = item.optString("name", null);
            info.displayName = item.optString("displayName", null);
            info.description = item.optString("description", null);
            info.inputTokenLimit = item.optInt("inputTokenLimit", 0);
            info.outputTokenLimit = item.optInt("outputTokenLimit", 0);

            JSONArray methods = item.optJSONArray("supportedGenerationMethods");
            List<String> parsedMethods = new ArrayList<>();
            if (methods != null) {
                for (int i = 0; i < methods.length(); i++) {
                    parsedMethods.add(methods.optString(i));
                }
            }
            info.supportedGenerationMethods = parsedMethods;
            return info;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getDisplayName() { return displayName; }
        public void setDisplayName(String displayName) { this.displayName = displayName; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public List<String> getSupportedGenerationMethods() { return supportedGenerationMethods; }
        public void setSupportedGenerationMethods(List<String> methods) { this.supportedGenerationMethods = methods; }
        public int getInputTokenLimit() { return inputTokenLimit; }
        public void setInputTokenLimit(int limit) { this.inputTokenLimit = limit; }
        public int getOutputTokenLimit() { return outputTokenLimit; }
        public void setOutputTokenLimit(int limit) { this.outputTokenLimit = limit; }
    }
}