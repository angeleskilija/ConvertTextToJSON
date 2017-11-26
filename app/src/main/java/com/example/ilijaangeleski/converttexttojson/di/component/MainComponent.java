package com.example.ilijaangeleski.converttexttojson.di.component;

import com.example.ilijaangeleski.converttexttojson.di.module.AppModule;
import com.example.ilijaangeleski.converttexttojson.di.module.MainModule;
import com.example.ilijaangeleski.converttexttojson.view.MainActivity;

import dagger.Component;

/**
 * Created by Ilija Angeleski on 11/25/2017.
 */

@Component(modules = {AppModule.class, MainModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
