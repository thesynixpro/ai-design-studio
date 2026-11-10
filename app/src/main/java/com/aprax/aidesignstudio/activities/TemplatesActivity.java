package com.aprax.aidesignstudio.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aprax.aidesignstudio.R;
import com.aprax.aidesignstudio.adapters.TemplateAdapter;

import java.util.ArrayList;

public class TemplatesActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView templatesRecycler;
    private TemplateAdapter templateAdapter;
    private Button previewTemplateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_templates);

        templatesRecycler = findViewById(R.id.templates_recycler);
        previewTemplateButton = findViewById(R.id.preview_template_button);

        if (templatesRecycler != null) {
            templatesRecycler.setLayoutManager(new LinearLayoutManager(this));
            templateAdapter = new TemplateAdapter();
            templatesRecycler.setAdapter(templateAdapter);
        }
        if (previewTemplateButton != null) {
            previewTemplateButton.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.preview_template_button) {
            Toast.makeText(this, "Previewing template...", Toast.LENGTH_LONG).show();
        }
    }
}