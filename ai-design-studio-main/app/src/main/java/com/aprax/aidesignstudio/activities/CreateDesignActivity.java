package com.aprax.aidesignstudio.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.aprax.aidesignstudio.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

public class CreateDesignActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText projectNameInput;
    private Spinner designTypeSpinner;
    private EditText promptInput;
    private Button generateButton;
    private FloatingActionButton fabBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_design);

        projectNameInput = findViewById(R.id.project_name_input);
        designTypeSpinner = findViewById(R.id.design_type_spinner);
        promptInput = findViewById(R.id.prompt_input);
        generateButton = findViewById(R.id.generate_button);
        fabBack = findViewById(R.id.fab_back);

        String[] designTypes = {
            "Website UI",
            "Mobile App UI",
            "iOS-style App UI",
            "SaaS Dashboard",
            "Landing Page",
            "Admin Dashboard",
            "E-commerce Interface",
            "Portfolio Website",
            "Streaming Platform",
            "Custom Interface"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
            android.R.layout.simple_spinner_dropdown_item, designTypes);
        designTypeSpinner.setAdapter(adapter);

        generateButton.setOnClickListener(this);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.generate_button) {
            String projectName = projectNameInput.getText().toString().trim();
            String designType = designTypeSpinner.getSelectedItem().toString();
            String prompt = promptInput.getText().toString().trim();

            if (projectName.isEmpty() || prompt.isEmpty()) {
                Toast.makeText(this, "Please enter project name and prompt", Toast.LENGTH_LONG).show();
                return;
            }

            Toast.makeText(this, "Generating design: " + projectName, Toast.LENGTH_LONG).show();
        }
    }
}
