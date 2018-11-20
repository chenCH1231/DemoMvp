package com.yourparter.android.app;

import com.jess.arms.base.BaseApplication;

public class App extends BaseApplication {

    private static volatile App instance = null;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
