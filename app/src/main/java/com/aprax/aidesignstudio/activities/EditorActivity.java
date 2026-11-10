package com.aprax.aidesignstudio.activities;

import android.os.Bundle;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aprax.aidesignstudio.R;
import com.aprax.aidesignstudio.editor.ComponentEditor;
import com.aprax.aidesignstudio.editor.DesignEditor;
import com.aprax.aidesignstudio.editor.PreviewManager;

import androidx.appcompat.app.AppCompatActivity;

public class EditorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText promptInput;
    private EditText contentInput;
    private Button generateButton;
    private Button saveButton;
    private Button previewButton;
    private FloatingActionButton fabBack;
    private DesignEditor designEditor;
    private PreviewManager previewManager;
    private ComponentEditor componentEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        promptInput = findViewById(R.id.edit_prompt);
        contentInput = findViewById(R.id.edit_content);
        generateButton = findViewById(R.id.btn_generate);
        saveButton = findViewById(R.id.btn_save);
        previewButton = findViewById(R.id.btn_preview);
        fabBack = findViewById(R.id.fab_back);

        designEditor = new DesignEditor(this);
        previewManager = new PreviewManager(this);
        componentEditor = new ComponentEditor(this);

        generateButton.setOnClickListener(this);
        saveButton.setOnClickListener(this);
        previewButton.setOnClickListener(this);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_generate) {
            String prompt = promptInput.getText().toString().trim();
            String content = contentInput.getText().toString().trim();

            if (prompt.isEmpty()) {
                Toast.makeText(this, "Please enter a prompt", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Generating design...", Toast.LENGTH_LONG).show();
            // In a real implementation, this would call the AIRequestGenerator
            // to generate the design using the Gemini API

        } else if (v.getId() == R.id.btn_save) {
            Toast.makeText(this, "Saving design...", Toast.LENGTH_SHORT).show();
        } else if (v.getId() == R.id.btn_preview) {
            Toast.makeText(this, "Previewing design...", Toast.LENGTH_SHORT).show();
        }
    }
}
