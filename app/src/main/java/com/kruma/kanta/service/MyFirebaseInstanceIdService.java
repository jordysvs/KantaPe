package com.kruma.kanta.service;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by JORDY on 29/03/2017.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService{

    public static final String TAG = "KANTAPE";

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();

        Log.d(TAG, "Token : " + token);
    }
}

