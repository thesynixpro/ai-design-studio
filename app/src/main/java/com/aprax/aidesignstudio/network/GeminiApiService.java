package com.aprax.aidesignstudio.network;

import java.io.IOException;

/**
 * Thin HTTP client for the Google Gemini API.
 *
 * BUILD STUDIO ships only the AndroidX/Material classpath (no Retrofit/OkHttp/Gson),
 * so all networking is implemented with HttpURLConnection against the same endpoint
 * contract: GET {BASE}v1beta/models with the x-goog-api-key header.
 */
public class GeminiApiService {

    public static class Response {
        public final int code;
        public final String body;

        public Response(int code, String body) {
            this.code = code;
            this.body = body;
        }

        public boolean isSuccessful() {
            return code >= 200 && code < 300;
        }
    }

    /**
     * GET v1beta/models
     *
     * @param apiKey   Google AI Studio API key sent as x-goog-api-key header
     * @param pageSize optional page size (0 to omit)
     * @param pageToken optional page token (null to omit)
     */
    public Response getModels(String apiKey, int pageSize, String pageToken) throws IOException {
        StringBuilder url = new StringBuilder(ConstantsHolder.BASE_URL)
            .append("v1beta/models");
        if (pageSize > 0) {
            url.append("?pageSize=").append(pageSize);
            if (pageToken != null && !pageToken.isEmpty()) {
                url.append("&pageToken=").append(pageToken);
            }
        } else if (pageToken != null && !pageToken.isEmpty()) {
            url.append("?pageToken=").append(pageToken);
        }

        java.net.HttpURLConnection connection =
            (java.net.HttpURLConnection) new java.net.URL(url.toString()).openConnection();
        try {
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.setRequestProperty("x-goog-api-key", apiKey);
            connection.setRequestProperty("Accept", "application/json");

            int code = connection.getResponseCode();
            java.io.InputStream stream =
                code >= 400 ? connection.getErrorStream() : connection.getInputStream();
            String body = readAll(stream);
            return new Response(code, body);
        } finally {
            connection.disconnect();
        }
    }

    /** Convenience overload: GET v1beta/models with default page size. */
    public Response getModels(String apiKey) throws IOException {
        return getModels(apiKey, 0, null);
    }

    private static String readAll(java.io.InputStream stream) throws IOException {
        if (stream == null) return "";
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        byte[] buffer = new byte[8192];
        int len;
        try {
            while ((len = stream.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        } finally {
            stream.close();
        }
        return out.toString("UTF-8");
    }

    /** Local holder so Constants stays in the utils package (single import point). */
    private static final class ConstantsHolder {
        static final String BASE_URL =
            com.aprax.aidesignstudio.utils.Constants.GEMINI_BASE_URL;
    }
}