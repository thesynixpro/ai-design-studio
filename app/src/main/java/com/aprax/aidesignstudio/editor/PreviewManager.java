package com.aprax.aidesignstudio.editor;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.aprax.aidesignstudio.models.Project;

public class PreviewManager {
    private Context context;
    private Project currentProject;

    public PreviewManager(Context context) {
        this.context = context;
    }

    public void loadProject(Project project) {
        this.currentProject = project;
        Log.d("PreviewManager", "Loaded project for preview: " + project.getProjectName());
    }

    public void previewDesktop() {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("PreviewManager", "Previewing on Desktop device");
    }

    public void previewTablet() {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("PreviewManager", "Previewing on Tablet device");
    }

    public void previewMobile() {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("PreviewManager", "Previewing on Mobile device");
    }

    public void previewAndroidPhone() {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("PreviewManager", "Previewing on Android Phone");
    }

    public void previewIPhone() {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("PreviewManager", "Previewing on iPhone");
    }

    public void refreshPreview() {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("PreviewManager", "Refreshing preview");
    }
}
