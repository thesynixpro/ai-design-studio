package com.aprax.aidesignstudio.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aprax.aidesignstudio.R;
import com.aprax.aidesignstudio.generators.WebsiteGenerator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

public class WebsiteGeneratorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText websiteNameInput;
    private EditText websitePromptInput;
    private Button generateWebsiteButton;
    private FloatingActionButton fabBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website_generator);

        websiteNameInput = findViewById(R.id.website_name_input);
        websitePromptInput = findViewById(R.id.website_prompt_input);
        generateWebsiteButton = findViewById(R.id.generate_website_button);
        fabBack = findViewById(R.id.fab_back);

        generateWebsiteButton.setOnClickListener(this);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.generate_website_button) {
            String name = websiteNameInput.getText().toString().trim();
            String prompt = websitePromptInput.getText().toString().trim();
            if (!name.isEmpty() && !prompt.isEmpty()) {
                String html = WebsiteGenerator.generateHTML(name, "Website", "Modern", prompt);
                getSharedPreferences("generated", MODE_PRIVATE).edit().putString("latest_html", html).apply();
                Toast.makeText(this, "Website generated successfully", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Please enter website name and prompt", Toast.LENGTH_LONG).show();
            }
        }
    }
}
