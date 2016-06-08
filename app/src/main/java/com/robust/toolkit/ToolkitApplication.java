package com.robust.toolkit;

import android.app.Application;

import com.orhanobut.logger.Logger;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;


/**
 * Created by chenhewen on 16-6-8.
 */
public class ToolkitApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init().hideThreadInfo().methodCount(0);
        CustomActivityOnCrash.install(this);
    }
}
