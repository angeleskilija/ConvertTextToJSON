package com.example.ilijaangeleski.converttexttojson.presenter;

import com.example.ilijaangeleski.converttexttojson.manager.MainManager;
import com.example.ilijaangeleski.converttexttojson.view.MainView;

import org.json.JSONException;

import java.lang.ref.WeakReference;

/**
 * Created by Ilija Angeleski on 11/21/2017.
 */
public class MainPresenter {
    private MainManager mainManager;
    private WeakReference<MainView> weakView;

    public MainPresenter(MainView view, MainManager mainManager) {
        this.mainManager = mainManager;
        this.weakView = new WeakReference<>(view);
    }

    public void onTextChange(String text) {
        try {
            String json = mainManager.parseUserInput(text);
            MainView view = weakView.get();
            if (view != null) {
                view.showOutput(json);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
