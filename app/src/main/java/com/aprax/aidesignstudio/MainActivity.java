
package com.aprax.aidesignstudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.aprax.aidesignstudio.fragments.HomeFragment;
import com.aprax.aidesignstudio.activities.ProjectsActivity;
import com.aprax.aidesignstudio.activities.CreateDesignActivity;
import com.aprax.aidesignstudio.activities.TemplatesActivity;
import com.aprax.aidesignstudio.activities.ComponentsActivity;
import com.aprax.aidesignstudio.activities.DesignSystemsActivity;
import com.aprax.aidesignstudio.activities.SettingsActivity;
import com.aprax.aidesignstudio.activities.AppSettingsActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content_container, new HomeFragment())
                .commit();

        setupToolbar();
    }

    private void setupToolbar() {
        ActionBar ab = getSupportActionBar();

        if (ab != null) {
            ab.setTitle("AI Design Studio");
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_create) {
            startActivity(new Intent(this, CreateDesignActivity.class));
            return true;

        } else if (id == R.id.action_projects) {
            startActivity(new Intent(this, ProjectsActivity.class));
            return true;

        } else if (id == R.id.action_templates) {
            startActivity(new Intent(this, TemplatesActivity.class));
            return true;

        } else if (id == R.id.action_components) {
            startActivity(new Intent(this, ComponentsActivity.class));
            return true;

        } else if (id == R.id.action_design_systems) {
            startActivity(new Intent(this, DesignSystemsActivity.class));
            return true;

        } else if (id == R.id.action_ai_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;

        } else if (id == R.id.action_app_settings) {
            startActivity(new Intent(this, AppSettingsActivity.class));
            return true;

        } else if (id == android.R.id.home) {
            getOnBackPressedDispatcher().onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
