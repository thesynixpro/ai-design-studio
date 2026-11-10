package com.aprax.aidesignstudio;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;

public class MobileAppGenerator implements Parcelable {
    private String projectId;
    private String projectName;
    private String designStyle;
    private String content;
    private String xml;
    private String layout;

    public MobileAppGenerator(String projectName, String designStyle, String content) {
        this.projectId = UUID.randomUUID().toString();
        this.projectName = projectName;
        this.designStyle = designStyle;
        this.content = content;
        this.xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n    android:layout_width=\"match_parent\"\n    android:layout_height=\"match_parent\"\n    android:orientation=\"vertical\">\n    <!-- Generated mobile app layout -->\n    <TextView\n        android:layout_width=\"wrap_content\"\n        android:layout_height=\"wrap_content\"\n        android:text=\"Project: " + projectName + "\"\n        android:textSize=\"18sp\" />\n</LinearLayout>";
        this.layout = xml;
    }

    protected MobileAppGenerator(Parcel in) {
        projectId = in.readString();
        projectName = in.readString();
        designStyle = in.readString();
        content = in.readString();
        xml = in.readString();
        layout = in.readString();
    }

    public static final Creator<MobileAppGenerator> CREATOR = new Creator<MobileAppGenerator>() {
        @Override
        public MobileAppGenerator createFromParcel(Parcel in) {
            return new MobileAppGenerator(in);
        }

        @Override
        public MobileAppGenerator[] newArray(int size) {
            return new MobileAppGenerator[size];
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
        dest.writeString(xml);
        dest.writeString(layout);
    }

    public String getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getXml() {
        return xml;
    }
}