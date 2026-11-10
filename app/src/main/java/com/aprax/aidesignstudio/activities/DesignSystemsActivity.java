package com.aprax.aidesignstudio.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.aprax.aidesignstudio.R;

import androidx.appcompat.app.AppCompatActivity;

public class DesignSystemsActivity extends AppCompatActivity {

    private Button generateFromPromptBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_systems);

        generateFromPromptBtn = findViewById(R.id.generate_from_prompt_button);

        generateFromPromptBtn.setOnClickListener(v -> {
            Toast.makeText(this, "Generating from prompt...", Toast.LENGTH_LONG).show();
        });
    }
}