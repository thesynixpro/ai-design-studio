package com.aprax.aidesignstudio.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aprax.aidesignstudio.R;
import com.aprax.aidesignstudio.generators.AndroidJavaGenerator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

public class MobileAppGeneratorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText appNameInput;
    private EditText appPromptInput;
    private Button generateAppButton;
    private FloatingActionButton fabBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_app_generator);

        appNameInput = findViewById(R.id.app_name_input);
        appPromptInput = findViewById(R.id.app_prompt_input);
        generateAppButton = findViewById(R.id.generate_app_button);
        fabBack = findViewById(R.id.fab_back);

        generateAppButton.setOnClickListener(this);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.generate_app_button) {
            String name = appNameInput.getText().toString().trim();
            String prompt = appPromptInput.getText().toString().trim();
            if (!name.isEmpty() && !prompt.isEmpty()) {
                String xml = AndroidJavaGenerator.generateXMLLayout(name, prompt);
                getSharedPreferences("generated", MODE_PRIVATE).edit().putString("latest_xml", xml).apply();
                Toast.makeText(this, "Mobile app layout generated successfully", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Please enter app name and prompt", Toast.LENGTH_LONG).show();
            }
        }
    }
}
