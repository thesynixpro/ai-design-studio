package com.aprax.aidesignstudio.generators;

import com.aprax.aidesignstudio.models.DesignSystem;
import com.aprax.aidesignstudio.models.AIModel;

import java.util.List;
import java.util.ArrayList;

public class PromptProcessor {

    public static DesignSystem processPrompt(String prompt) {
        DesignSystem designSystem = new DesignSystem();
        
        if (prompt == null || prompt.trim().isEmpty()) {
            return designSystem;
        }

        String normalizedPrompt = prompt.toLowerCase();
        if (normalizedPrompt.contains("dark")) {
            designSystem.setBackgroundColor("#0F172A");
            designSystem.setForegroundColor("#F8FAFC");
        }
        if (normalizedPrompt.contains("light")) {
            designSystem.setBackgroundColor("#F8FAFC");
            designSystem.setForegroundColor("#0F172A");
        }
        if (normalizedPrompt.contains("blue")) {
            designSystem.setPrimaryColor("#2563EB");
            designSystem.setAccentColor("#3B82F6");
        }
        if (normalizedPrompt.contains("red")) {
            designSystem.setPrimaryColor("#DC2626");
            designSystem.setAccentColor("#EF4444");
        }
        if (normalizedPrompt.contains("minimal")) {
            designSystem.setStyle("Minimalist");
            designSystem.setPattern("Grid-based layout");
        }
        if (normalizedPrompt.contains("modern")) {
            designSystem.setStyle("Modern");
            designSystem.setPattern("Clean typography");
        }
        if (normalizedPrompt.contains("dashboard")) {
            designSystem.setPattern("Hero-Centric + Social Proof");
        }
        if (normalizedPrompt.contains("responsive")) {
            designSystem.setResponsiveGuidance("Mobile-first approach");
        }
        if (normalizedPrompt.contains("premium")) {
            designSystem.setShadows("Soft shadows + Context-appropriate transitions");
            designSystem.setPreDeliveryChecklist("Light mode: text contrast 4.5:1 minimum, Focus states visible for keyboard nav");
        }
        
        return designSystem;
    }

    public static List<String> extractKeywords(String prompt) {
        List<String> keywords = new ArrayList<>();
        
        if (prompt == null) return keywords;
        
        String[] words = prompt.split(" ");
        for (String word : words) {
            if (word.length() > 3) {
                keywords.add(word);
            }
        }
        return keywords;
    }

    public static String generateDesignSystemJson(DesignSystem designSystem) {
        // Generate a JSON representation for the design system
        return "{\n  \"pattern\": \"" + designSystem.getPattern() + "\",\n"
               + "  \"style\": \"" + designSystem.getStyle() + "\",\n"
               + "  \"colors\": {\n"
               + "    \"primary\": \"" + designSystem.getPrimaryColor() + "\",\n"
               + "    \"secondary\": \"" + designSystem.getSecondaryColor() + "\",\n"
               + "    \"accent\": \"" + designSystem.getAccentColor() + "\",\n"
               + "    \"background\": \"" + designSystem.getBackgroundColor() + "\",\n"
               + "    \"foreground\": \"" + designSystem.getForegroundColor() + "\"\n"
               + "  }\n"
               + "}";
    }
}
