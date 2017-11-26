package com.example.ilijaangeleski.converttexttojson.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ilijaangeleski.converttexttojson.manager.MainManager;
import com.example.ilijaangeleski.converttexttojson.manager.SharedPreferencesSotrageManager;
import com.example.ilijaangeleski.converttexttojson.manager.StorageManager;
import com.example.ilijaangeleski.converttexttojson.presenter.MainPresenter;
import com.example.ilijaangeleski.converttexttojson.view.MainView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ilija Angeleski on 11/25/2017.
 */
@Module
public class MainModule {
    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @Provides
    SharedPreferences provideSharedPref(Context context) {
        return context.getSharedPreferences("SharedPref", Context.MODE_PRIVATE);
    }

    @Provides
    StorageManager providesStorageManager(SharedPreferences preferences) {
        return new SharedPreferencesSotrageManager(preferences);
    }

    @Provides
    MainManager providesMainManager(StorageManager storageManager) {
        return new MainManager(storageManager);
    }

    @Provides
    MainPresenter providesMainPresenter(MainManager mainManager) {
        return new MainPresenter(view, mainManager);
    }
}
