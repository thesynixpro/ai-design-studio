package com.aprax.aidesignstudio.activities;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.aprax.aidesignstudio.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProjectsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button projectsBtn;
    private Button templatesBtn;
    private Button componentsBtn;
    private Button designSystemsBtn;
    private Button aiSettingsBtn;
    private Button appSettingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        projectsBtn = findViewById(R.id.btn_projects);
        templatesBtn = findViewById(R.id.btn_templates);
        componentsBtn = findViewById(R.id.btn_components);
        designSystemsBtn = findViewById(R.id.btn_design_systems);
        aiSettingsBtn = findViewById(R.id.btn_ai_settings);
        appSettingsBtn = findViewById(R.id.btn_app_settings);

        projectsBtn.setOnClickListener(this);
        templatesBtn.setOnClickListener(this);
        componentsBtn.setOnClickListener(this);
        designSystemsBtn.setOnClickListener(this);
        aiSettingsBtn.setOnClickListener(this);
        appSettingsBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_projects) {
            startActivity(new Intent(this, HomeActivity.class));
        } else if (v.getId() == R.id.btn_templates) {
            startActivity(new Intent(this, TemplatesActivity.class));
        } else if (v.getId() == R.id.btn_components) {
            startActivity(new Intent(this, ComponentsActivity.class));
        } else if (v.getId() == R.id.btn_design_systems) {
            startActivity(new Intent(this, DesignSystemsActivity.class));
        } else if (v.getId() == R.id.btn_ai_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        } else if (v.getId() == R.id.btn_app_settings) {
            startActivity(new Intent(this, AppSettingsActivity.class));
        }
    }
}