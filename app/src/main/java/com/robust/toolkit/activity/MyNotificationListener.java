package com.robust.toolkit.activity;

import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

/**
 * Created by chenhewen on 16-6-7.
 */
public class MyNotificationListener extends NotificationListenerService {

    private static final String TAG = "MyNotificationListener";

    {
        Log.d(TAG, "service block");
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "service onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "service onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "service onBind");
        return super.onBind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "service onUnbind");
        return super.onUnbind(intent);
    }

    public void onListenerConnected() {
        Log.d(TAG, "service onListenerConnected");
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        Log.d(TAG, "service onNotificationPosted");
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        Log.d(TAG, "service onNotificationRemoved");
    }
}
