package com.example.android_virtual_cam;

import android.util.Log;

public class XposedBridge {
    private static final String TAG = "XposedBridge";

    public static void log(String text) {
        Log.d(TAG, text);
    }
}
