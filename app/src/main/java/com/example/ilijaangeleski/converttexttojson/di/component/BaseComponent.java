package com.example.ilijaangeleski.converttexttojson.di.component;

import com.example.ilijaangeleski.converttexttojson.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface BaseComponent {
}