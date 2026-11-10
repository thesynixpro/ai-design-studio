package com.aprax.aidesignstudio;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

public class WebsiteGenerator implements Parcelable {
    private String projectId;
    private String projectName;
    private String designStyle;
    private String content;
    private String html;
    private String css;
    private String js;

    public WebsiteGenerator(String projectName, String designStyle, String content) {
        this.projectId = UUID.randomUUID().toString();
        this.projectName = projectName;
        this.designStyle = designStyle;
        this.content = content;
        this.html = "<!DOCTYPE html>\n<html>\n<head>\n    <title>" + projectName + "</title>\n    <style>\n" + css + "\n    </style>\n</head>\n<body>\n" + content + "\n</body>\n</html>";
        this.css = css;
        this.js = js;
    }

    protected WebsiteGenerator(Parcel in) {
        projectId = in.readString();
        projectName = in.readString();
        designStyle = in.readString();
        content = in.readString();
        html = in.readString();
        css = in.readString();
        js = in.readString();
    }

    public static final Creator<WebsiteGenerator> CREATOR = new Creator<WebsiteGenerator>() {
        @Override
        public WebsiteGenerator createFromParcel(Parcel in) {
            return new WebsiteGenerator(in);
        }

        @Override
        public WebsiteGenerator[] newArray(int size) {
            return new WebsiteGenerator[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(projectId);
        dest.writeString(projectName);
        dest.writeString(designStyle);
        dest.writeString(content);
        dest.writeString(html);
        dest.writeString(css);
        dest.writeString(js);
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getHtml() {
        return html;
    }

    public String getCss() {
        return css;
    }

    public String getJs() {
        return js;
    }
}