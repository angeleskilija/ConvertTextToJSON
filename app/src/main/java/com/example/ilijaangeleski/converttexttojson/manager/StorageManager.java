package com.example.ilijaangeleski.converttexttojson.manager;

/**
 * Created by Ilija Angeleski on 11/25/2017.
 */

public interface StorageManager {
    void saveResult(String result);

    String getResult();
}
