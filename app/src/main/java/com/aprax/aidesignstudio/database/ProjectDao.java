package com.aprax.aidesignstudio.database;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.aprax.aidesignstudio.models.Project;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * JSON/persistence DAO for Project entities.
 *
 * Room is not available on the BUILD STUDIO classpath, so this class persists
 * projects as a JSON array inside SharedPreferences while preserving the
 * original Room-style DAO method names.
 */
public class ProjectDao {
    private static final String KEY_PROJECTS = "projects_json";

    private final SharedPreferences prefs;

    public ProjectDao(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public List<Project> getAllProjects() {
        List<Project> projects = load();
        Collections.sort(projects, new Comparator<Project>() {
            @Override
            public int compare(Project a, Project b) {
                long at = a.getCreatedAt() == null ? 0 : a.getCreatedAt().getTime();
                long bt = b.getCreatedAt() == null ? 0 : b.getCreatedAt().getTime();
                return Long.compare(bt, at);
            }
        });
        return projects;
    }

    public Project getProjectById(String projectId) {
        if (projectId == null) return null;
        for (Project p : load()) {
            if (projectId.equals(p.getProjectId())) {
                return p;
            }
        }
        return null;
    }

    public long insert(Project project) {
        if (project == null) return -1;
        List<Project> projects = load();
        // Replace existing project with the same id (REPLACE semantics).
        boolean replaced = false;
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getProjectId() != null
                && projects.get(i).getProjectId().equals(project.getProjectId())) {
                projects.set(i, project);
                replaced = true;
                break;
            }
        }
        if (!replaced) {
            projects.add(project);
        }
        save(projects);
        return 1;
    }

    public void delete(Project project) {
        if (project == null) return;
        List<Project> projects = load();
        List<Project> kept = new ArrayList<>();
        for (Project p : projects) {
            if (p.getProjectId() == null
                || !p.getProjectId().equals(project.getProjectId())) {
                kept.add(p);
            }
        }
        save(kept);
    }

    public void deleteAll() {
        prefs.edit().remove(KEY_PROJECTS).apply();
    }

    // --- persistence helpers ---

    private List<Project> load() {
        String json = prefs.getString(KEY_PROJECTS, null);
        List<Project> result = new ArrayList<>();
        if (TextUtils.isEmpty(json)) return result;
        try {
            JSONArray array = new JSONArray(json);
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = array.optJSONObject(i);
                if (obj != null) {
                    Project p = Project.fromJson(obj);
                    if (p != null) result.add(p);
                }
            }
        } catch (JSONException e) {
            // Corrupt store; start fresh.
        }
        return result;
    }

    private void save(List<Project> projects) {
        JSONArray array = new JSONArray();
        for (Project p : projects) {
            JSONObject obj = p == null ? null : p.toJson();
            if (obj != null) array.put(obj);
        }
        prefs.edit().putString(KEY_PROJECTS, array.toString()).apply();
    }
}