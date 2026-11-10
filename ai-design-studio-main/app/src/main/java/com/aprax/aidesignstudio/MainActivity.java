package com.aprax.aidesignstudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.aprax.aidesignstudio.activities.AppSettingsActivity;
import com.aprax.aidesignstudio.activities.ComponentsActivity;
import com.aprax.aidesignstudio.activities.CreateDesignActivity;
import com.aprax.aidesignstudio.activities.DesignSystemsActivity;
import com.aprax.aidesignstudio.activities.ProjectsActivity;
import com.aprax.aidesignstudio.activities.SettingsActivity;
import com.aprax.aidesignstudio.activities.TemplatesActivity;
import com.aprax.aidesignstudio.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ListView drawerList;

    private final String[] navigationItems = {
            "Home",
            "Create Design",
            "My Projects",
            "Templates",
            "Components",
            "Design Systems",
            "AI Settings",
            "App Settings"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.drawer_list);
        ImageButton menuButton = findViewById(R.id.btn_menu);
        TextView toolbarTitle = findViewById(R.id.toolbar_title);

        if (toolbarTitle != null) {
            toolbarTitle.setText(R.string.app_name);
        }

        if (drawerList != null) {
            drawerList.setAdapter(new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_list_item_1,
                    navigationItems
            ));
            drawerList.setOnItemClickListener((parent, view, position, id) ->
                    navigateTo(position));
        }

        if (menuButton != null && drawerLayout != null) {
            menuButton.setOnClickListener(v ->
                    drawerLayout.openDrawer(Gravity.START));
        }

        // Avoid adding the HomeFragment again after configuration changes.
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_content_container, new HomeFragment())
                    .commit();
        }
    }

    private void navigateTo(int position) {
        if (drawerLayout != null && drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START);
        }

        switch (position) {
            case 0:
                // Home is already the root screen.
                return;
            case 1:
                open(CreateDesignActivity.class);
                break;
            case 2:
                open(ProjectsActivity.class);
                break;
            case 3:
                open(TemplatesActivity.class);
                break;
            case 4:
                open(ComponentsActivity.class);
                break;
            case 5:
                open(DesignSystemsActivity.class);
                break;
            case 6:
                open(SettingsActivity.class);
                break;
            case 7:
                open(AppSettingsActivity.class);
                break;
            default:
                break;
        }
    }

    private void open(Class<?> activityClass) {
        startActivity(new Intent(this, activityClass));
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout != null && drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START);
        } else {
            super.onBackPressed();
        }
    }
}
