package com.aprax.aidesignstudio.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.aprax.aidesignstudio.R;
import com.aprax.aidesignstudio.activities.CreateDesignActivity;
import com.aprax.aidesignstudio.activities.ProjectsActivity;
import com.aprax.aidesignstudio.activities.TemplatesActivity;
import com.aprax.aidesignstudio.activities.ComponentsActivity;
import com.aprax.aidesignstudio.activities.DesignSystemsActivity;
import com.aprax.aidesignstudio.activities.SettingsActivity;
import com.aprax.aidesignstudio.activities.AppSettingsActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btnCreateDesign;
    private Button btnProjects;
    private Button btnTemplates;
    private Button btnComponents;
    private Button btnDesignSystems;
    private Button btnAiSettings;
    private Button btnAppSettings;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnCreateDesign = view.findViewById(R.id.btn_create_design);
        btnProjects = view.findViewById(R.id.btn_projects);
        btnTemplates = view.findViewById(R.id.btn_templates);
        btnComponents = view.findViewById(R.id.btn_components);
        btnDesignSystems = view.findViewById(R.id.btn_design_systems);
        btnAiSettings = view.findViewById(R.id.btn_ai_settings);
        btnAppSettings = view.findViewById(R.id.btn_app_settings);

        btnCreateDesign.setOnClickListener(this);
        btnProjects.setOnClickListener(this);
        btnTemplates.setOnClickListener(this);
        btnComponents.setOnClickListener(this);
        btnDesignSystems.setOnClickListener(this);
        btnAiSettings.setOnClickListener(this);
        btnAppSettings.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (getActivity() == null) return;

        if (v.getId() == R.id.btn_create_design) {
            startActivity(new Intent(getActivity(), CreateDesignActivity.class));
        } else if (v.getId() == R.id.btn_projects) {
            startActivity(new Intent(getActivity(), ProjectsActivity.class));
        } else if (v.getId() == R.id.btn_templates) {
            startActivity(new Intent(getActivity(), TemplatesActivity.class));
        } else if (v.getId() == R.id.btn_components) {
            startActivity(new Intent(getActivity(), ComponentsActivity.class));
        } else if (v.getId() == R.id.btn_design_systems) {
            startActivity(new Intent(getActivity(), DesignSystemsActivity.class));
        } else if (v.getId() == R.id.btn_ai_settings) {
            startActivity(new Intent(getActivity(), SettingsActivity.class));
        } else if (v.getId() == R.id.btn_app_settings) {
            startActivity(new Intent(getActivity(), AppSettingsActivity.class));
        }
    }
}
