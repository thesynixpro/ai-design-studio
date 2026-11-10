package com.aprax.aidesignstudio.utils;

public class Constants {
    // API Configuration
    public static final String GEMINI_BASE_URL = "https://generativelanguage.googleapis.com/";
    public static final String GEMINI_MODELS_ENDPOINT = "v1beta/models";
    public static final String GEMINI_API_KEY_PREF = "gemini_api_key";

    // Design Types
    public static final String DESIGN_TYPE_WEBSITE = "Website UI";
    public static final String DESIGN_TYPE_MOBILE_APP = "Mobile App UI";
    public static final String DESIGN_TYPE_IOS_APP = "iOS-style App UI";
    public static final String DESIGN_TYPE_SAAS_DASHBOARD = "SaaS Dashboard";
    public static final String DESIGN_TYPE_LANDING_PAGE = "Landing Page";
    public static final String DESIGN_TYPE_ADMIN_DASHBOARD = "Admin Dashboard";
    public static final String DESIGN_TYPE_ECOMMERCE = "E-commerce Interface";
    public static final String DESIGN_TYPE_PORTFOLIO = "Portfolio Website";
    public static final String DESIGN_TYPE_STREAMING = "Streaming Platform";
    public static final String DESIGN_TYPE_CUSTOM = "Custom Interface";

    // Design Styles
    public static final String STYLE_MODERN = "Modern";
    public static final String STYLE_MINIMAL = "Minimalist";
    public static final String STYLE_DARK = "Dark";
    public static final String STYLE_VIBRANT = "Vibrant";
    public static final String STYLE_ELEGANT = "Elegant";
    public static final String STYLE_BRUTALIST = "Brutalist";
    public static final String STYLE_GLASSMORPHISM = "Glassmorphism";
    public static final String STYLE_NEUMORPHISM = "Neumorphism";

    // Frameworks
    public static final String FRAMEWORK_HTML = "HTML";
    public static final String FRAMEWORK_CSS = "CSS";
    public static final String FRAMEWORK_JS = "JavaScript";
    public static final String FRAMEWORK_REACT = "React";
    public static final String FRAMEWORK_NEXT_JS = "Next.js";
    public static final String FRAMEWORK_TAILWIND = "Tailwind CSS";
    public static final String FRAMEWORK_VUE = "Vue";
    public static final String FRAMEWORK_JAVA_XML = "Java XML";
    public static final String FRAMEWORK_KOTLIN = "Kotlin";
    public static final String FRAMEWORK_FLUTTER = "Flutter";

    // Free Tier Models (verified from Google's pricing documentation)
    public static final String[] FREE_TIER_MODELS = {
        "gemini-1.5-flash",
        "gemini-1.5-flash-8b",
        "gemini-1.0-pro",
        "gemini-pro",
        "gemini-pro-vision"
    };

    // Preferences
    public static final String PREFS_NAME = "com.aprax.aidesignstudio.prefs";
    public static final String PREF_THEME = "theme";
    public static final String PREF_NOTIFICATIONS = "notifications";
    public static final String PREF_ANALYTICS = "analytics";
}
