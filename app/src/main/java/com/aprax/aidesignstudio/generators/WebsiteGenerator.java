package com.aprax.aidesignstudio.generators;

import android.content.Context;



public class WebsiteGenerator {

    public static String generate(String projectName, String prompt, Context context) {
        return generateHTML(projectName, "Website", "Modern", prompt);
    }

    public static String generateHTML(String projectName, String designType, String designStyle, String prompt) {
        String html = "<!DOCTYPE html>\n<html>\n<head>\n"
                + "    <title>" + projectName + "</title>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <style>\n"
                + "        body {\n"
                + "            font-family: Inter, sans-serif;\n"
                + "            margin: 0;\n"
                + "            padding: 0;\n"
                + "            background: #0F172A;\n"
                + "            color: #F8FAFC;\n"
                + "        }\n"
                + "        .container {\n"
                + "            max-width: 1200px;\n"
                + "            margin: 0 auto;\n"
                + "            padding: 24px;\n"
                + "        }\n"
                + "        .header {\n"
                + "            text-align: center;\n"
                + "            margin-bottom: 48px;\n"
                + "        }\n"
                + "        .content {\n"
                + "            display: grid;\n"
                + "            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));\n"
                + "            gap: 24px;\n"
                + "        }\n"
                + "        .card {\n"
                + "            background: #1E293B;\n"
                + "            border-radius: 12px;\n"
                + "            padding: 24px;\n"
                + "            box-shadow: 0 4px 6px rgba(0,0,0,0.1);\n"
                + "        }\n"
                + "    </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <div class=\"container\">\n"
                + "        <header class=\"header\">\n"
                + "            <h1>" + projectName + "</h1>\n"
                + "            <p>Design Type: " + designType + "</p>\n"
                + "        </header>\n"
                + "        <div class=\"content\">\n"
                + "            <div class=\"card\">\n"
                + "                <h2>Main Section</h2>\n"
                + "                <p>" + prompt + "</p>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "    </div>\n"
                + "</body>\n"
                + "</html>";
        return html;
    }
}
