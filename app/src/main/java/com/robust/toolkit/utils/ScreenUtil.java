package com.robust.toolkit.utils;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.util.Locale;

/**
 * 手机屏幕信息的辅助类
 * Created by chenhewen on 16-6-14.
 */
public class ScreenUtil {

    /**
     * 获取屏幕宽高，单位px， 会跟随屏幕旋转改变
     * @param context context
     * @return point
     */
    public static Point getScreenSizeInPx(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point p = new Point();
        display.getRealSize(p);

        return p;
    }

    /**
     * 获取density， 该值是厂商定的， 一般为 1， 2， 3， 4
     * @param context context
     * @return value
     */
    public static float getDensity(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.density;
    }

    /**
     * 获取densityDpi, 其值为 density * 160
     * @param context context
     * @return value
     */
    public static int getDensityDpi(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.densityDpi;
    }

    /**
     * 理论上该手机应该从哪一个资源文件中读取资源
     * @param context context
     * @return string
     */
    public static String getResourcesFrom(Context context) {
        float density = getDensity(context);
        if (density <= 0.75) {
            return "l";
        } else if (density <= 1) {
            return "m";
        } else if (density <= 1.5) {
            return "h";
        } else if (density <= 2) {
            return "xh";
        } else if (density <= 3) {
            return "xxh";
        } else if (density <= 4) {
            return "xxxh";
        } else {
            return "unknown";
        }
    }

    /**
     * 获取屏幕宽高，单位dp， 会跟随屏幕旋转改变
     * @param context context
     * @return point
     */
    public static Point getScreenSizeInDp(Context context) {
        Point point = getScreenSizeInPx(context);
        float density = getDensity(context);
        return new Point((int) (point.x / density), (int) (point.y / density));
    }

    /**
     * 获取手机宽高dpi
     * @param context context
     * @return point
     */
    public static PointF getPhysicalDpi(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        PointF p = new PointF(metrics.xdpi, metrics.ydpi);
        return p;
    }

    /**
     * 获取手机宽高，单位英寸
     * @param context context
     * @return pointF
     */
    public static PointF getScreenSizeInInCm(Context context) {
        PointF pointDpi = getPhysicalDpi(context);
        Point pointSize = getScreenSizeInPx(context);

        return new PointF(pointSize.x / pointDpi.x, pointSize.y / pointDpi.y);
    }

    /**
     * 获取手机对角线长度，单位英寸
     * @param context context
     * @return string
     */
    public static String getScreenHypotInInCm(Context context) {
        PointF point = getScreenSizeInInCm(context);
        double hypot = Math.hypot(point.x, point.y);
        return String.format(Locale.getDefault(), "%.1f", hypot);
    }
}
