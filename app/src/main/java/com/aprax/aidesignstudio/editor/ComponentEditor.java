package com.aprax.aidesignstudio.editor;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class ComponentEditor {
    private Context context;
    private String componentId;
    private String componentType;

    public ComponentEditor(Context context) {
        this.context = context;
    }

    public void loadComponent(String componentId, String componentType) {
        this.componentId = componentId;
        this.componentType = componentType;
        Log.d("ComponentEditor", "Loaded component: " + componentId + " of type " + componentType);
    }

    public void changeText(String newText) {
        if (componentId == null) {
            Toast.makeText(context, "No component loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("ComponentEditor", "Changing text of component " + componentId + " to " + newText);
    }

    public void changeColor(String color) {
        if (componentId == null) {
            Toast.makeText(context, "No component loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("ComponentEditor", "Changing color of component " + componentId + " to " + color);
    }

    public void changeFont(String font) {
        if (componentId == null) {
            Toast.makeText(context, "No component loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("ComponentEditor", "Changing font of component " + componentId + " to " + font);
    }

    public void adjustPadding(int padding) {
        if (componentId == null) {
            Toast.makeText(context, "No component loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("ComponentEditor", "Adjusting padding of component " + componentId + " to " + padding);
    }

    public void adjustMargin(int margin) {
        if (componentId == null) {
            Toast.makeText(context, "No component loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("ComponentEditor", "Adjusting margin of component " + componentId + " to " + margin);
    }

    public void adjustSpacing(int spacing) {
        if (componentId == null) {
            Toast.makeText(context, "No component loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("ComponentEditor", "Adjusting spacing of component " + componentId + " to " + spacing);
    }

    public void changeCornerRadius(int radius) {
        if (componentId == null) {
            Toast.makeText(context, "No component loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("ComponentEditor", "Changing corner radius of component " + componentId + " to " + radius);
    }

    public void duplicate() {
        if (componentId == null) {
            Toast.makeText(context, "No component loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("ComponentEditor", "Duplicating component: " + componentId);
    }

    public void delete() {
        if (componentId == null) {
            Toast.makeText(context, "No component loaded", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d("ComponentEditor", "Deleting component: " + componentId);
    }
}
