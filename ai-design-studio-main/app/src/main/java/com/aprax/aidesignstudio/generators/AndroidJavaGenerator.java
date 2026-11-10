package com.aprax.aidesignstudio.generators;



public class AndroidJavaGenerator {

    public static String generate(String projectName, String prompt) {
        return generateXMLLayout(projectName, prompt);
    }

    public static String generateXMLLayout(String projectName, String prompt) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        xml.append("<LinearLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n");
        xml.append("    android:layout_width=\"match_parent\"\n");
        xml.append("    android:layout_height=\"match_parent\"\n");
        xml.append("    android:orientation=\"vertical\"\n");
        xml.append("    android:background=\"@color/dark_surface\">\n\n");
        xml.append("    <TextView\n");
        xml.append("        android:layout_width=\"wrap_content\"\n");
        xml.append("        android:layout_height=\"wrap_content\"\n");
        xml.append("        android:text=\"").append(projectName).append("\"\n");
        xml.append("        android:textSize=\"24sp\"\n");
        xml.append("        android:textStyle=\"bold\"\n");
        xml.append("        android:layout_gravity=\"center\"\n");
        xml.append("        android:padding=\"16dp\" />\n\n");
        xml.append("</LinearLayout>");
        return xml.toString();
    }
}
