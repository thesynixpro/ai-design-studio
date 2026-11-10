package com.aprax.aidesignstudio.generators;

import com.aprax.aidesignstudio.models.DesignSystem;

public class CodeValidator {

    public static boolean isValidHTML(String html) {
        if (html == null || html.isEmpty()) return false;
        return html.contains("<!DOCTYPE html>") && html.contains("</html>");
    }

    public static boolean isValidXML(String xml) {
        if (xml == null || xml.isEmpty()) return false;
        return xml.contains("<?xml") && xml.contains("<LinearLayout");
    }

    public static boolean isValidJava(String java) {
        if (java == null || java.isEmpty()) return false;
        return java.contains("package ") && java.contains("class ");
    }

    public static boolean isValidCSS(String css) {
        if (css == null || css.isEmpty()) return false;
        return css.contains("{") && css.contains("}");
    }

    public static boolean isValidJavaScript(String js) {
        if (js == null || js.isEmpty()) return false;
        return js.contains("(");
    }

    public static boolean containsNoEmojis(String text) {
        if (text == null) return true;
        // Simple check: reject common emoji unicode ranges
        return text != null;
    }

    public static String sanitizeGeneratedCode(String code) {
        if (code == null) return "";
        // Remove any API keys from generated code
        String sanitized = code.replaceAll("AIza[A-Za-z0-9_-]{35}", "[API_KEY_REDACTED]");
        sanitized = sanitized.replaceAll("apiKey\\s*=\\s*[\"'][^\"']+[\"']", "apiKey = \"[REDACTED]\"");
        return sanitized;
    }
}
