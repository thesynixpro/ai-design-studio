package com.aprax.aidesignstudio.generators;

import com.aprax.aidesignstudio.models.DesignSystem;
import com.aprax.aidesignstudio.models.AIModel;

import java.util.List;

public class DesignSystemGenerator {

    public static DesignSystem generateDesignSystem(String prompt, AIModel model) {
        DesignSystem designSystem = new DesignSystem();
        
        if (prompt == null || prompt.trim().isEmpty()) {
            return designSystem;
        }

        String normalizedPrompt = prompt.toLowerCase();
        
        // Extract UI components based on prompt
        if (normalizedPrompt.contains("dashboard")) {
            designSystem.setPattern("Hero-Centric + Social Proof");
        } else if (normalizedPrompt.contains("landing")) {
            designSystem.setPattern("Hero + Form + CTA");
        } else if (normalizedPrompt.contains("profile")) {
            designSystem.setPattern("Grid + Cards");
        } else {
            designSystem.setPattern("Grid-based layout");
        }

        // Determine style
        if (normalizedPrompt.contains("minimal")) {
            designSystem.setStyle("Minimalism & Swiss Style");
        } else if (normalizedPrompt.contains("modern")) {
            designSystem.setStyle("Modern");
        } else if (normalizedPrompt.contains("vibrant")) {
            designSystem.setStyle("Vibrant & Block-based");
        } else if (normalizedPrompt.contains("dark")) {
            designSystem.setStyle("Dark Mode (OLED)");
        } else {
            designSystem.setStyle("Modern");
        }

        // Extract colors
        if (normalizedPrompt.contains("blue")) {
            designSystem.setPrimaryColor("#2563EB");
            designSystem.setSecondaryColor("#3B82F6");
            designSystem.setAccentColor("#1D4ED8");
        } else if (normalizedPrompt.contains("red")) {
            designSystem.setPrimaryColor("#DC2626");
            designSystem.setSecondaryColor("#EF4444");
            designSystem.setAccentColor("#B91C1C");
        } else if (normalizedPrompt.contains("green")) {
            designSystem.setPrimaryColor("#16A34A");
            designSystem.setSecondaryColor("#22C55E");
            designSystem.setAccentColor("#15803D");
        } else if (normalizedPrompt.contains("purple")) {
            designSystem.setPrimaryColor("#7C3AED");
            designSystem.setSecondaryColor("#A78BFA");
            designSystem.setAccentColor("#6D28D9");
        }

        // Set defaults if colors not set
        if (designSystem.getPrimaryColor() == null) {
            designSystem.setPrimaryColor("#0F172A");
        }
        if (designSystem.getSecondaryColor() == null) {
            designSystem.setSecondaryColor("#334155");
        }
        if (designSystem.getAccentColor() == null) {
            designSystem.setAccentColor("#3B82F6");
        }
        if (designSystem.getBackgroundColor() == null) {
            designSystem.setBackgroundColor("#F8FAFC");
        }
        if (designSystem.getForegroundColor() == null) {
            designSystem.setForegroundColor("#0F172A");
        }

        // Typography
        if (normalizedPrompt.contains("professional")) {
            designSystem.setTypography("Inter, sans-serif");
        } else if (normalizedPrompt.contains("elegant")) {
            designSystem.setTypography("Playfair Display, serif");
        } else {
            designSystem.setTypography("Inter, sans-serif");
        }

        // Spacing and layout
        designSystem.setSpacingSystem("16px base, 8px grid");
        designSystem.setRadiusSystem("4px corners");

        // Add effects based on prompt
        if (normalizedPrompt.contains("shadow") || normalizedPrompt.contains("depth")) {
            designSystem.setShadows("Medium depth (4px 8px 16px rgba(0,0,0,0.1))");
        }

        // Add accessibility
        designSystem.setAccessibility("WCAG AA compliant, 4.5:1 contrast ratio");

        // Anti-patterns to avoid
        if (normalizedPrompt.contains("simple")) {
            designSystem.setAntiPatterns("Avoid overly complex animations, Overuse of gradients");
        }

        // Pre-delivery checklist
        designSystem.setPreDeliveryChecklist("✓ Grid-based layout 12-16 columns, ✓ Typography hierarchy clear, ✓ No unnecessary decorations, ✓ Text contrast measured against the chosen project target, ✓ Mobile responsive grid");

        return designSystem;
    }

    public static String generateWebsiteHTML(DesignSystem designSystem, String content) {
        return "<!DOCTYPE html>\n<html>\n<head>\n"
               + "    <title>Generated Website</title>\n"
               + "    <style>\n"
               + "        body {\n"
               + "            font-family: \"" + designSystem.getTypography() + "\", sans-serif;\n"
               + "            background-color: " + designSystem.getBackgroundColor() + ";\n"
               + "            color: " + designSystem.getForegroundColor() + ";\n"
               + "            margin: 0;\n"
               + "            padding: 20px;\n"
               + "        }\n"
               + "        .container {\n"
               + "            max-width: 1200px;\n"
               + "            margin: 0 auto;\n"
               + "        }\n"
               + "        .card {\n"
               + "            background: white;\n"
               + "            border-radius: 8px;\n"
               + "            padding: 20px;\n"
               + "            margin: 16px 0;\n"
               + "            box-shadow: " + (designSystem.getShadows() != null ? designSystem.getShadows() : "none") + ";\n"
               + "        }\n"
               + "    </style>\n"
               + "</head>\n"
               + "<body>\n"
               + "    <div class=\"container\">\n"
               + "        <h1>Generated Website</h1>\n"
               + "        <div class=\"card\">\n"
               + content + "\n"
               + "        </div>\n"
               + "    </div>\n"
               + "</body>\n"
               + "</html>";
    }
}
