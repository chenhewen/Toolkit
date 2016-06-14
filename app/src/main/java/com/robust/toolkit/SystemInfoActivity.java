package com.robust.toolkit;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Bundle;

import com.orhanobut.logger.Logger;
import com.robust.toolkit.utils.ScreenUtil;

/**
 * Created by chenhewen on 16-6-14.
 */
public class SystemInfoActivity extends Activity {

    public static final String TAG = "SystemInfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Point screenSizeInPx = ScreenUtil.getScreenSizeInPx(this);
        float density = ScreenUtil.getDensity(this);
        int densityDpi = ScreenUtil.getDensityDpi(this);
        String resourcesFrom = ScreenUtil.getResourcesFrom(this);
        Point screenSizeInDp = ScreenUtil.getScreenSizeInDp(this);
        PointF physicalDpi = ScreenUtil.getPhysicalDpi(this);
        PointF screenSizeInInCm = ScreenUtil.getScreenSizeInInCm(this);
        String screenHypotInInCm = ScreenUtil.getScreenHypotInInCm(this);


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
