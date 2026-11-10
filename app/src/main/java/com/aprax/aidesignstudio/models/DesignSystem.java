package com.aprax.aidesignstudio.models;

import android.os.Parcel;
import android.os.Parcelable;

public class DesignSystem implements Parcelable {
    private String pattern;
    private String style;
    private String primaryColor;
    private String secondaryColor;
    private String accentColor;
    private String backgroundColor;
    private String foregroundColor;
    private String typography;
    private String spacingSystem;
    private String radiusSystem;
    private String shadows;
    private String accessibility;
    private String antiPatterns;
    private String preDeliveryChecklist;
    private String uiStyleRecommendations;
    private String responsiveGuidance;
    private String frameworkCompatibility;

    public DesignSystem() {}

    protected DesignSystem(Parcel in) {
        pattern = in.readString();
        style = in.readString();
        primaryColor = in.readString();
        secondaryColor = in.readString();
        accentColor = in.readString();
        backgroundColor = in.readString();
        foregroundColor = in.readString();
        typography = in.readString();
        spacingSystem = in.readString();
        radiusSystem = in.readString();
        shadows = in.readString();
        accessibility = in.readString();
        antiPatterns = in.readString();
        preDeliveryChecklist = in.readString();
        uiStyleRecommendations = in.readString();
        responsiveGuidance = in.readString();
        frameworkCompatibility = in.readString();
    }

    public static final Creator<DesignSystem> CREATOR = new Creator<DesignSystem>() {
        @Override
        public DesignSystem createFromParcel(Parcel in) {
            return new DesignSystem(in);
        }

        @Override
        public DesignSystem[] newArray(int size) {
            return new DesignSystem[size];
        }
    };

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pattern);
        dest.writeString(style);
        dest.writeString(primaryColor);
        dest.writeString(secondaryColor);
        dest.writeString(accentColor);
        dest.writeString(backgroundColor);
        dest.writeString(foregroundColor);
        dest.writeString(typography);
        dest.writeString(spacingSystem);
        dest.writeString(radiusSystem);
        dest.writeString(shadows);
        dest.writeString(accessibility);
        dest.writeString(antiPatterns);
        dest.writeString(preDeliveryChecklist);
        dest.writeString(uiStyleRecommendations);
        dest.writeString(responsiveGuidance);
        dest.writeString(frameworkCompatibility);
    }

    public String getPattern() { return pattern; }
    public void setPattern(String pattern) { this.pattern = pattern; }
    public String getStyle() { return style; }
    public void setStyle(String style) { this.style = style; }
    public String getPrimaryColor() { return primaryColor; }
    public void setPrimaryColor(String c) { this.primaryColor = c; }
    public String getSecondaryColor() { return secondaryColor; }
    public void setSecondaryColor(String c) { this.secondaryColor = c; }
    public String getAccentColor() { return accentColor; }
    public void setAccentColor(String c) { this.accentColor = c; }
    public String getBackgroundColor() { return backgroundColor; }
    public void setBackgroundColor(String c) { this.backgroundColor = c; }
    public String getForegroundColor() { return foregroundColor; }
    public void setForegroundColor(String c) { this.foregroundColor = c; }
    public String getTypography() { return typography; }
    public void setTypography(String t) { this.typography = t; }
    public String getSpacingSystem() { return spacingSystem; }
    public void setSpacingSystem(String s) { this.spacingSystem = s; }
    public String getRadiusSystem() { return radiusSystem; }
    public void setRadiusSystem(String r) { this.radiusSystem = r; }
    public String getShadows() { return shadows; }
    public void setShadows(String s) { this.shadows = s; }
    public String getAccessibility() { return accessibility; }
    public void setAccessibility(String a) { this.accessibility = a; }
    public String getAntiPatterns() { return antiPatterns; }
    public void setAntiPatterns(String a) { this.antiPatterns = a; }
    public String getPreDeliveryChecklist() { return preDeliveryChecklist; }
    public void setPreDeliveryChecklist(String c) { this.preDeliveryChecklist = c; }
    public String getUiStyleRecommendations() { return uiStyleRecommendations; }
    public void setUiStyleRecommendations(String u) { this.uiStyleRecommendations = u; }
    public String getResponsiveGuidance() { return responsiveGuidance; }
    public void setResponsiveGuidance(String r) { this.responsiveGuidance = r; }
    public String getFrameworkCompatibility() { return frameworkCompatibility; }
    public void setFrameworkCompatibility(String f) { this.frameworkCompatibility = f; }

    public String toString() {
        return "DesignSystem{pattern='" + pattern + "', style='" + style + "', colors="
            + primaryColor + "/" + secondaryColor + "/" + accentColor + "/" + backgroundColor + "/" + foregroundColor + "}";
    }
}
