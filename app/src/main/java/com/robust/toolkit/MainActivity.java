package com.robust.toolkit;

import android.app.Activity;
import android.os.Bundle;

import com.orhanobut.logger.Logger;

/**
 * Created by chenhewen on 16-6-7.
 */
public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.t(TAG).d(DeviceUtil.getBasicInfo());
    }
}
