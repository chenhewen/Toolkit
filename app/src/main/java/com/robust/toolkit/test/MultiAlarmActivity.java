package com.robust.toolkit.test;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.orhanobut.logger.Logger;

/**
 * Created by chenhewen on 16-10-26.
 */

public class MultiAlarmActivity extends Activity {

    public static final String TAG = "MultiAlarmActivity";

    private AlarmReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        mReceiver = new AlarmReceiver();
        registerReceiver(mReceiver, mReceiver.getIntentFilter());

        for (int i = 0; i < 1000; i++) {
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, i, mReceiver.getIntent(i), PendingIntent.FLAG_ONE_SHOT);
            alarmManager.setRepeating(
                    AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis(),
                    1000, pendingIntent);
            //Logger.t(TAG).d("i : " + i);
        }
    }

    private static class AlarmReceiver extends BroadcastReceiver {

        public static final String ACTION_ALARM = "action_alarm";
        public static final String EXTRA_DATA = "extra_data";

        @Override
        public void onReceive(Context context, Intent intent) {
            if (ACTION_ALARM.equals(intent.getAction())) {
                int i = intent.getIntExtra(EXTRA_DATA, -1);
                Logger.t(TAG).d("receive : " + i);
            }
        }

        public Intent getIntent(int data) {
            Intent intent = new Intent(ACTION_ALARM);
            intent.putExtra(EXTRA_DATA, data);
            return intent;
        }

        public IntentFilter getIntentFilter() {
            return new IntentFilter(ACTION_ALARM);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}
