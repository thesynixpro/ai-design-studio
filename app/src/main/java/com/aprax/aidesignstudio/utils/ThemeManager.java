package com.aprax.aidesignstudio.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Log;

public class ThemeManager {

    public static void applyTheme(Activity activity, String theme) {
        if (theme == null) return;

        switch (theme) {
            case "dark":
                activity.setTheme(com.aprax.aidesignstudio.R.style.AppTheme_Dark);
                break;
            case "light":
                activity.setTheme(com.aprax.aidesignstudio.R.style.AppTheme_Light);
                break;
            case "auto":
                activity.setTheme(com.aprax.aidesignstudio.R.style.AppTheme);
                break;
            default:
                activity.setTheme(com.aprax.aidesignstudio.R.style.AppTheme);
                break;
        }
        Log.d("ThemeManager", "Applied theme: " + theme);
    }

    public static void applyDarkTheme(Activity activity) {
        activity.setTheme(com.aprax.aidesignstudio.R.style.AppTheme_Dark);
        Log.d("ThemeManager", "Applied dark theme");
    }

    public static void applyLightTheme(Activity activity) {
        activity.setTheme(com.aprax.aidesignstudio.R.style.AppTheme_Light);
        Log.d("ThemeManager", "Applied light theme");
    }
}
