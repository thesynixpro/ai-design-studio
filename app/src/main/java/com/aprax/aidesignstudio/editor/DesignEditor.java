package com.aprax.aidesignstudio.editor;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.aprax.aidesignstudio.models.DesignSystem;
import com.aprax.aidesignstudio.models.Project;

public class DesignEditor {
    private Context context;
    private Project currentProject;
    private DesignSystem currentDesignSystem;

    public DesignEditor(Context context) {
        this.context = context;
    }

    public void loadProject(Project project) {
        this.currentProject = project;
        this.currentDesignSystem = project.getDesignSystem();
        Log.d("DesignEditor", "Loaded project: " + project.getProjectName());
    }

    public void editComponent(String componentId, String property, String value) {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        // Apply edit to the project
        Log.d("DesignEditor", "Editing component " + componentId + " property " + property + " to " + value);
    }

    public void deleteComponent(String componentId) {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("DesignEditor", "Deleting component: " + componentId);
    }

    public void duplicateComponent(String componentId) {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("DesignEditor", "Duplicating component: " + componentId);
    }

    public void reorderComponents(String componentId, int fromPosition, int toPosition) {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("DesignEditor", "Reordering component: " + componentId + " from " + fromPosition + " to " + toPosition);
    }

    public void changeColor(String componentId, String color) {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("DesignEditor", "Changing color of component " + componentId + " to " + color);
    }

    public void changeFont(String componentId, String font) {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("DesignEditor", "Changing font of component " + componentId + " to " + font);
    }

    public void adjustPadding(String componentId, int padding) {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("DesignEditor", "Adjusting padding of component " + componentId + " to " + padding);
    }

    public void adjustMargin(String componentId, int margin) {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("DesignEditor", "Adjusting margin of component " + componentId + " to " + margin);
    }

    public void adjustSpacing(String componentId, int spacing) {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("DesignEditor", "Adjusting spacing of component " + componentId + " to " + spacing);
    }

    public void changeCornerRadius(String componentId, int radius) {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("DesignEditor", "Changing corner radius of component " + componentId + " to " + radius);
    }

    public void saveModifications() {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        currentProject.setUpdatedAt(new java.util.Date());
        currentProject.setVersion(currentProject.getVersion() + 1);
        Log.d("DesignEditor", "Saved modifications for project: " + currentProject.getProjectName());
    }

    public void undo() {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("DesignEditor", "Undoing last action");
    }

    public void redo() {
        if (currentProject == null) {
            Toast.makeText(context, "No project loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("DesignEditor", "Redoing last action");
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public DesignSystem getCurrentDesignSystem() {
        return currentDesignSystem;
    }
}
