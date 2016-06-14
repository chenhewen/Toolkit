package com.robust.toolkit;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;

import com.orhanobut.logger.Logger;
import com.robust.toolkit.utils.HardwareUtil;
import com.robust.toolkit.utils.ScreenUtil;

/**
 * Created by chenhewen on 16-6-7.
 */
public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        float memoryUsed = HardwareUtil.getMemoryUsed(this);
        float memoryTotal = HardwareUtil.getMemoryTotal(this);
        Logger.t(TAG).d("memoryUsed = %.2f GB, memoryTotal = %.2f GB", memoryUsed, memoryTotal);

        float storageUsed = HardwareUtil.getStorageUsed();
        float storageTotal = HardwareUtil.getStorageTotal();
        Logger.t(TAG).d("storageUsed = %.2f GB, storageTotal = %.2f GB", storageUsed, storageTotal);
    }
}
