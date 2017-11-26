package com.example.ilijaangeleski.converttexttojson;

import android.app.Application;

import com.example.ilijaangeleski.converttexttojson.di.component.BaseComponent;
import com.example.ilijaangeleski.converttexttojson.di.component.DaggerBaseComponent;
import com.example.ilijaangeleski.converttexttojson.di.module.AppModule;

/**
 * Created by Ilija Angeleski on 11/25/2017.
 */

public class MyApplication extends Application {

    BaseComponent baseComponent;
    @Override
    public void onCreate() {
        super.onCreate();

       //baseComponent = DaggerBaseComponent.builder().appModule(new AppModule(this)).build();
    }
}
