package com.example.ilijaangeleski.converttexttojson.manager;

import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ilija Angeleski on 11/25/2017.
 */

public class SqlLiteStorageManager implements StorageManager {

    private SQLiteOpenHelper sql;

    @Override
    public void saveResult(String result) {

    }

    @Override
    public String getResult() {
        return null;
    }
}
