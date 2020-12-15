package com.example.androidlearning;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    private static final String TAG = "AL_ActivityCollector";

    public static List<Activity> activities = new ArrayList<>();
    public static void addActivity(Activity activity) {
        Log.d(TAG, "addActivity :" + activity);
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        Log.d(TAG, "removeActivity :" + activity);
        activities.remove(activity);
    }

    public static void finishAll() {
        Log.d(TAG, "finishAll !!");
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                Log.d(TAG, "finish :" + activity);
                activity.finish();
            }
        }
    }
}
