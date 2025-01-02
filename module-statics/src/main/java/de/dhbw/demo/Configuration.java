package de.dhbw.demo;

import java.util.HashMap;
import java.util.Map;

public class Configuration {

    // statisches Feld

    public static final String SETTING_KEY_AUTHOR = "setting.author";

    private static final Map<String,String> settings = new HashMap<>();

    // statischer "Initialisierer"

    static {
        settings.put(SETTING_KEY_AUTHOR, "Johnny Walker");
    }

    // statische Methode

    public static String getSetting(String key) {
        return settings.get(key);
    }

}
