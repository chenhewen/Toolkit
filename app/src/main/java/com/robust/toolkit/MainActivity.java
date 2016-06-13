package com.robust.toolkit;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.PointF;
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

        Point screenSizeInPx = DeviceUtil.getScreenSizeInPx(this);
        float density = DeviceUtil.getDensity(this);
        int densityDpi = DeviceUtil.getDensityDpi(this);
        String resourcesFrom = DeviceUtil.getResourcesFrom(this);
        Point screenSizeInDp = DeviceUtil.getScreenSizeInDp(this);
        PointF physicalDpi = DeviceUtil.getPhysicalDpi(this);
        PointF screenSizeInInCm = DeviceUtil.getScreenSizeInInCm(this);
        String screenHypotInInCm = DeviceUtil.getScreenHypotInInCm(this);


        Logger.t(TAG).d("screenSizeInPx width = %s, screenSizeInPx height = %s \n" +
                        "density = %s, densityDpi = %s, readResourcesFrom = %s \n" +
                        "screenSizeInDp width = %s, screenSizeInDp height = %s \n" +
                        "physicalDpi xDpi = %s, physicalDpi yDpi = %s \n" +
                        "screenSizeInInCm width = %.1f, screenSizeInInCm height = %.1f, screenHypotInInCm = %s",
                screenSizeInPx.x, screenSizeInPx.y,
                density, densityDpi, resourcesFrom,
                screenSizeInDp.x, screenSizeInDp.y,
                physicalDpi.x, physicalDpi.y,
                screenSizeInInCm.x, screenSizeInInCm.y, screenHypotInInCm
        );
    }
}
