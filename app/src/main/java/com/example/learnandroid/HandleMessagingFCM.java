package com.example.learnandroid;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;

import static android.content.ContentValues.TAG;

public class HandleMessagingFCM extends FirebaseMessagingService {
    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

    }
}
