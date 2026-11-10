package com.aprax.aidesignstudio.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.aprax.aidesignstudio.R;

import androidx.appcompat.app.AppCompatActivity;

public class ComponentsActivity extends AppCompatActivity {

    private Button createNewComponentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components);

        createNewComponentBtn = findViewById(R.id.create_new_component_button);
        if (createNewComponentBtn != null) {
            createNewComponentBtn.setOnClickListener(v ->
                    Toast.makeText(this, "Component creator is ready for the next step.", Toast.LENGTH_SHORT).show());
        }
    }
}