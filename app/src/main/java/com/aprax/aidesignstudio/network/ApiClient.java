package com.aprax.aidesignstudio.network;

/**
 * Holds the single Gemini HTTP API client.
 *
 * Kept as a singleton for API-compatibility with the original Retrofit design;
 * the transport is HttpURLConnection because Retrofit/OkHttp are not available
 * on the BUILD STUDIO classpath.
 */
public class ApiClient {
    private static ApiClient instance;
    private final GeminiApiService apiService;

    private ApiClient() {
        apiService = new GeminiApiService();
    }

    public static synchronized ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    public GeminiApiService getApiService() {
        return apiService;
    }
}