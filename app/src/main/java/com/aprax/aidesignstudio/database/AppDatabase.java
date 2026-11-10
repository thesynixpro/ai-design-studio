package com.aprax.aidesignstudio.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.aprax.aidesignstudio.models.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * SQLite-backed project store.
 *
 * Room is not available on the BUILD STUDIO classpath, so this keeps the
 * original AppDatabase.getInstance(context).projectDao() API but persists
 * projects as JSON documents in SharedPreferences via ProjectStore.
 */
public class AppDatabase {
    private static final String TAG = "AppDatabase";
    private static volatile AppDatabase INSTANCE;

    private final ProjectDao projectDao;

    private AppDatabase(Context context) {
        SharedPreferences prefs = context.getApplicationContext()
            .getSharedPreferences("ai_design_studio.db", Context.MODE_PRIVATE);
        this.projectDao = new ProjectDao(prefs);
    }

    public ProjectDao projectDao() {
        return projectDao;
    }

    public static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AppDatabase(context);
                }
            }
        }
        return INSTANCE;
    }

    /** Kept for call-site compatibility with the original RoomDraft helper. */
    public static List<Project> snapshotProjects(ProjectDao dao) {
        try {
            return new ArrayList<>(dao.getAllProjects());
        } catch (Exception e) {
            Log.e(TAG, "Failed to snapshot projects", e);
            return new ArrayList<>();
        }
    }
}