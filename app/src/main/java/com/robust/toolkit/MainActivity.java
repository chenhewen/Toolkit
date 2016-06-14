package com.robust.toolkit;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;

import com.orhanobut.logger.Logger;
import com.robust.toolkit.utils.DeviceUtil;
import com.robust.toolkit.utils.HardwareUsageUtil;
import com.robust.toolkit.utils.TimeUtil;

import java.util.Locale;

/**
 * Created by chenhewen on 16-6-7.
 */
public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.t(TAG).d("boot time = %s", TimeUtil.getDisplayDuration(HardwareUsageUtil.getMillisSinceBoot()));
    }
}
