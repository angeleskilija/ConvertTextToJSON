package com.example.ilijaangeleski.converttexttojson.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ilija Angeleski on 11/25/2017.
 */
@Module
public class AppModule {
    Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    Context providesContext() {
        return context;
    }
}
