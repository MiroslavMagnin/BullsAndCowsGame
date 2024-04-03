package com.max.bullsandcowsgame;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class SettingsManager {

    private String settingsFileName;
    private final String settingsFilePath;
    private File file;
    private Document document;

    public SettingsManager(String fileName) {
        String userHome = System.getProperty("user.home");
        this.settingsFileName = fileName;
        this.settingsFilePath = userHome + File.separator + "AppData" + File.separator + "Local" + File.separator +
                "BullsAndCowsGame" + File.separator + this.settingsFileName;

        this.file = new File(this.settingsFilePath);
        loadSettings();
    }

    private void loadSettings() {
        try {
            SAXBuilder builder = new SAXBuilder();
            document = builder.build(file);
        } catch (IOException e) {
            // The file hasn't been found or error reading the file
            // So create a new XML-file with the root element "settings"

            try {
                if (!file.exists()) {
                    File parentDir = file.getParentFile();
                    if (!parentDir.exists()) {
                        parentDir.mkdirs(); // Create a new direction, if it doesn't exist
                    }
                    file.createNewFile(); // Create a new XML-file, if it doesn't exist
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            document = new Document(new Element("settings"));

            // Default settings
            this.setSetting("minWidthMainWindow", "410");
            this.setSetting("minHeightMainWindow", "250");
            this.setSetting("minWidthAdditionalWindow", "520");
            this.setSetting("minHeightAdditionalWindow", "220");
            this.setSetting("maxWidthAdditionalWindow", "680");
            this.setSetting("maxHeightAdditionalWindow", "600");
            this.setSetting("defaultWidthMainWindow", "520");
            this.setSetting("defaultHeightMainWindow", "440");
            this.setSetting("isMaximizedMainWindow", "false");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveSettings() {
        XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
        try {
            FileWriter fileWriter = new FileWriter(this.settingsFilePath);
            xmlOutput.output(document, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSetting(String key, String value) {
        Element root = document.getRootElement();
        Element settingElement = root.getChild(key);

        if(settingElement != null) {
            settingElement.setText(value);
        } else {
            settingElement = new Element(key);
            settingElement.setText(value);
            root.addContent(settingElement);
        }

        saveSettings();
    }

    private String getSettingValue(Element element, String key) {
        if(element.getName().equals(key)) {
            return element.getText();
        }

        for(Element child : element.getChildren()) {
            String value = getSettingValue(child, key);
            if(value != null) {
                return value;
            }
        }

        return null;
    }

    public String getSetting(String key) {
        Element root = document.getRootElement();
        return getSettingValue(root, key);
    }

    public static void main(String[] args) throws IOException {
//        SettingsManager settingsManager = new SettingsManager("settings.xml");

        // Save settings
//        settingsManager.saveSetting("minWidthMainWindow", "300");
//        settingsManager.saveSetting("minHeightMainWindow", "150");


        // Load settings
//        String width = settingsManager.getSetting("windowWidth");
//        String height = settingsManager.getSetting("windowHeight");
//
//        System.out.println("Window width: " + width);
//        System.out.println("Window height: " + height);
    }
}