package com.aprax.aidesignstudio.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aprax.aidesignstudio.DesignStudio;
import com.aprax.aidesignstudio.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private DesignStudio designStudio;
    private FloatingActionButton fabCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        designStudio = new DesignStudio(this);

        fabCreate = findViewById(R.id.fab_create);
        TextView btnProjects = findViewById(R.id.btn_projects);
        TextView btnTemplates = findViewById(R.id.btn_templates);
        TextView btnComponents = findViewById(R.id.btn_components);
        TextView btnDesignSystems = findViewById(R.id.btn_design_systems);
        TextView btnAiSettings = findViewById(R.id.btn_ai_settings);
        TextView btnAppSettings = findViewById(R.id.btn_app_settings);

        fabCreate.setOnClickListener(this);
        btnProjects.setOnClickListener(this);
        btnTemplates.setOnClickListener(this);
        btnComponents.setOnClickListener(this);
        btnDesignSystems.setOnClickListener(this);
        btnAiSettings.setOnClickListener(this);
        btnAppSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fab_create) {
            designStudio.showPromptGenerator();
        } else if (v.getId() == R.id.btn_projects) {
            startActivity(new Intent(this, ProjectsActivity.class));
        } else if (v.getId() == R.id.btn_templates) {
            startActivity(new Intent(this, TemplatesActivity.class));
        } else if (v.getId() == R.id.btn_components) {
            startActivity(new Intent(this, ComponentsActivity.class));
        } else if (v.getId() == R.id.btn_design_systems) {
            startActivity(new Intent(this, DesignSystemsActivity.class));
        } else if (v.getId() == R.id.btn_ai_settings) {
            startActivity(new Intent(this, AppSettingsActivity.class));
        } else if (v.getId() == R.id.btn_app_settings) {
            startActivity(new Intent(this, AppSettingsActivity.class));
        }
    }
}
