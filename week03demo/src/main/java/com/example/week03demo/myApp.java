package com.example.week03demo;

import android.app.Application;
import android.content.Context;

public class myApp extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
