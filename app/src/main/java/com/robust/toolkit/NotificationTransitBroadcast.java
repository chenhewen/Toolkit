package com.robust.toolkit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

/**
 * 通知栏点击中转broadcast
 * Created by chenhewen on 16-6-8.
 */
public class NotificationTransitBroadcast extends BroadcastReceiver {

    private static final String ACTION_TRANSIT = "action_transit";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (ACTION_TRANSIT.equals(action)) {
            Logger.t(PopNotificationActivity.TAG).d("transit..");
        }
    }

    public static IntentFilter getFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_TRANSIT);
        return intentFilter;
    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent();
        intent.setAction(ACTION_TRANSIT);
        return intent;
    }
}
