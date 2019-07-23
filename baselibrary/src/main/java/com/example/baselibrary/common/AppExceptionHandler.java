package com.example.baselibrary.common;

import android.content.Context;



/**
 * Created by Wave on 2018/6/28 14:13UncaughtExceptionHandler
 */
public class AppExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final AppExceptionHandler ourInstance = new AppExceptionHandler();
    private static Context context;

    public static AppExceptionHandler getInstance() {
        return ourInstance;
    }

    private AppExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(ourInstance);
    }

    public void init(Context context) {
        this.context = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
