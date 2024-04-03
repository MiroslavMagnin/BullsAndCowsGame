package com.max.bullsandcowsgame;

public class SettingsVariables {
    public final static SettingsManager settingsManager = new SettingsManager("settings.xml");

    // Main window
    public final static double minWidthMain = Double.parseDouble(settingsManager.getSetting("minWidthMainWindow"));
    public final static double minHeightMain = Double.parseDouble(settingsManager.getSetting("minHeightMainWindow"));
    public final static double widthMain = Double.parseDouble(settingsManager.getSetting("defaultWidthMainWindow"));
    public final static double heightMain = Double.parseDouble(settingsManager.getSetting("defaultHeightMainWindow"));
    public final static boolean isMaximized = Boolean.parseBoolean(settingsManager.getSetting("isMaximizedMainWindow"));

    // Additional window
    public final static double minWidthAdditional = Double.parseDouble(settingsManager.getSetting("minWidthAdditionalWindow"));
    public final static double minHeightAdditional = Double.parseDouble(settingsManager.getSetting("minHeightAdditionalWindow"));
    public final static double maxWidthAdditional = Double.parseDouble(settingsManager.getSetting("maxWidthAdditionalWindow"));
    public final static double maxHeightMainAdditional = Double.parseDouble(settingsManager.getSetting("maxHeightAdditionalWindow"));

}
