package com.mahdi.ordermanager.dbmanager.model;

import java.util.HashMap;
import java.util.Map;

public class Settings {
    private Map<String, String> settings;

    public Settings() {
        settings = new HashMap<String, String>();
    }

    public void add(String key, String value) {
        settings.put(key, value);
    }

    public void remove(String key) {
        settings.remove(key);
    }

    public void clear() {
        settings.clear();
    }
}
