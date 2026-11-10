package com.aprax.aidesignstudio;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.aprax.aidesignstudio.activities.CreateDesignActivity;
import com.aprax.aidesignstudio.activities.WebsiteGeneratorActivity;
import com.aprax.aidesignstudio.activities.MobileAppGeneratorActivity;
import com.aprax.aidesignstudio.activities.ProjectsActivity;
import com.aprax.aidesignstudio.activities.SettingsActivity;
import com.aprax.aidesignstudio.activities.PreviewActivity;
import com.aprax.aidesignstudio.activities.TemplatesActivity;
import com.aprax.aidesignstudio.activities.ComponentsActivity;
import com.aprax.aidesignstudio.activities.DesignSystemsActivity;

public class DesignStudio {
    private Context context;

    public DesignStudio(Context context) {
        this.context = context;
    }

    public void showPromptGenerator() {
        Intent intent = new Intent(context, CreateDesignActivity.class);
        context.startActivity(intent);
    }

    public void showWebsiteGenerator() {
        Intent intent = new Intent(context, WebsiteGeneratorActivity.class);
        context.startActivity(intent);
    }

    public void showMobileAppGenerator() {
        Intent intent = new Intent(context, MobileAppGeneratorActivity.class);
        context.startActivity(intent);
    }

    public void showProjectManagement() {
        Intent intent = new Intent(context, ProjectsActivity.class);
        context.startActivity(intent);
    }

    public void showSettings() {
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }

    public void showPreview() {
        Intent intent = new Intent(context, PreviewActivity.class);
        context.startActivity(intent);
    }

    public void showTemplates() {
        Intent intent = new Intent(context, TemplatesActivity.class);
        context.startActivity(intent);
    }

    public void showComponents() {
        Intent intent = new Intent(context, ComponentsActivity.class);
        context.startActivity(intent);
    }

    public void showDesignSystems() {
        Intent intent = new Intent(context, DesignSystemsActivity.class);
        context.startActivity(intent);
    }
}