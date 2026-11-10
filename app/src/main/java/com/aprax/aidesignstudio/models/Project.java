package com.aprax.aidesignstudio.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

public class Project implements Parcelable {
    private String projectId;
    private String projectName;
    private String description;
    private String designType; // website, mobile_app, ios_app, saas_dashboard, landing_page, admin_dashboard, ecommerce, portfolio, streaming, custom
    private String designStyle;
    private String prompt;
    private String generatedCode;
    private String thumbnailPath;
    private Date createdAt;
    private Date updatedAt;
    private String selectedModelId;
    private DesignSystem designSystem;
    private String generatedFilesJson;
    private int version;
    private boolean isFavorite;

    public Project() {
        this.projectId = java.util.UUID.randomUUID().toString();
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.version = 1;
        this.isFavorite = false;
    }

    protected Project(Parcel in) {
        projectId = in.readString();
        projectName = in.readString();
        description = in.readString();
        designType = in.readString();
        designStyle = in.readString();
        prompt = in.readString();
        generatedCode = in.readString();
        thumbnailPath = in.readString();
        createdAt = new Date(in.readLong());
        updatedAt = new Date(in.readLong());
        selectedModelId = in.readString();
        designSystem = in.readParcelable(DesignSystem.class.getClassLoader());
        generatedFilesJson = in.readString();
        version = in.readInt();
        isFavorite = in.readByte() != 0;
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(projectId);
        dest.writeString(projectName);
        dest.writeString(description);
        dest.writeString(designType);
        dest.writeString(designStyle);
        dest.writeString(prompt);
        dest.writeString(generatedCode);
        dest.writeString(thumbnailPath);
        dest.writeLong(createdAt.getTime());
        dest.writeLong(updatedAt.getTime());
        dest.writeString(selectedModelId);
        dest.writeParcelable(designSystem, flags);
        dest.writeString(generatedFilesJson);
        dest.writeInt(version);
        dest.writeByte(isFavorite ? (byte) 1 : (byte) 0);
    }

    // Getters and setters
    public String getProjectId() { return projectId; }
    public void setProjectId(String id) { this.projectId = id; }
    public String getProjectName() { return projectName; }
    public void setProjectName(String name) { this.projectName = name; }
    public String getDescription() { return description; }
    public void setDescription(String d) { this.description = d; }
    public String getDesignType() { return designType; }
    public void setDesignType(String type) { this.designType = type; }
    public String getDesignStyle() { return designStyle; }
    public void setDesignStyle(String style) { this.designStyle = style; }
    public String getPrompt() { return prompt; }
    public void setPrompt(String p) { this.prompt = p; }
    public String getGeneratedCode() { return generatedCode; }
    public void setGeneratedCode(String code) { this.generatedCode = code; }
    public String getThumbnailPath() { return thumbnailPath; }
    public void setThumbnailPath(String path) { this.thumbnailPath = path; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date date) { this.createdAt = date; }
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date date) { this.updatedAt = date; }
    public String getSelectedModelId() { return selectedModelId; }
    public void setSelectedModelId(String id) { this.selectedModelId = id; }
    public DesignSystem getDesignSystem() { return designSystem; }
    public void setDesignSystem(DesignSystem ds) { this.designSystem = ds; }
    public String getGeneratedFilesJson() { return generatedFilesJson; }
    public void setGeneratedFilesJson(String json) { this.generatedFilesJson = json; }
    public int getVersion() { return version; }
    public void setVersion(int v) { this.version = v; }
    public boolean isFavorite() { return isFavorite; }
    public void setFavorite(boolean f) { this.isFavorite = f; }


    public static Project fromJson(org.json.JSONObject o) {
        Project p = new Project(); if(o==null)return p; p.projectId=o.optString("projectId",p.projectId); p.projectName=o.optString("projectName",""); p.description=o.optString("description",""); p.designType=o.optString("designType",""); p.designStyle=o.optString("designStyle",""); p.prompt=o.optString("prompt",""); p.generatedCode=o.optString("generatedCode",""); p.thumbnailPath=o.optString("thumbnailPath",""); p.selectedModelId=o.optString("selectedModelId",""); p.generatedFilesJson=o.optString("generatedFilesJson",""); p.version=o.optInt("version",1); p.isFavorite=o.optBoolean("isFavorite",false); return p;
    }
    public org.json.JSONObject toJson() { org.json.JSONObject o=new org.json.JSONObject(); try { o.put("projectId",projectId); o.put("projectName",projectName); o.put("description",description); o.put("designType",designType); o.put("designStyle",designStyle); o.put("prompt",prompt); o.put("generatedCode",generatedCode); o.put("thumbnailPath",thumbnailPath); o.put("selectedModelId",selectedModelId); o.put("generatedFilesJson",generatedFilesJson); o.put("version",version); o.put("isFavorite",isFavorite); } catch(org.json.JSONException ignored){} return o; }

    @Override
    public String toString() {
        return "Project{" + projectName + " (" + designType + ")}";
    }
}
