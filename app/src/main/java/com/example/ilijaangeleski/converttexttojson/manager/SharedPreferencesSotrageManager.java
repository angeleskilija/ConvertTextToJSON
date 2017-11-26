package com.example.ilijaangeleski.converttexttojson.manager;

import android.content.SharedPreferences;

/**
 * Created by Ilija Angeleski on 11/25/2017.
 */

public class SharedPreferencesSotrageManager implements StorageManager {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public SharedPreferencesSotrageManager(SharedPreferences preferences) {
        this.preferences = preferences;
        this.editor = preferences.edit();
    }

    @Override
    public void saveResult(String result) {
        editor.putString("result", result);
        editor.apply();
    }

    @Override
    public String getResult() {
        return preferences.getString("result", "");
    }
}
