package com.kruma.core.configuration;

import android.app.Application;
import android.content.Context;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by John on 23/06/2016.
 */
public class App extends Application {

    private static final String TAG = "App";
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }

    public static Context getContext(){
        return mContext;
    }
}
