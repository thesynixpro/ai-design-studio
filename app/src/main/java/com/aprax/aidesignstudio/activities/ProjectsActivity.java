package com.aprax.aidesignstudio.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.aprax.aidesignstudio.R;

public class ProjectsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        Button createProjectButton = findViewById(R.id.start_projects);
        if (createProjectButton != null) {
            createProjectButton.setOnClickListener(v ->
                    startActivity(new Intent(this, CreateDesignActivity.class)));
        }
    }
}
