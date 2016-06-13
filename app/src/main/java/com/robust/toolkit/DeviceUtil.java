package com.robust.toolkit;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 设备辅助工具类
 * Created by Administrator on 2016/6/9.
 */
public class DeviceUtil {
    public static final String OS_ARCH = System.getProperty("os.arch");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String OS_VERSION = System.getProperty("os.version");

    public static final String ID = android.os.Build.ID;
    public static final String DISPLAY = android.os.Build.DISPLAY;
    public static final String PRODUCT = android.os.Build.PRODUCT;
    public static final String DEVICE = android.os.Build.DEVICE;
    public static final String BOARD = android.os.Build.BOARD;
    public static final String MANUFACTURER = android.os.Build.MANUFACTURER;
    public static final String BRAND = android.os.Build.BRAND;
    public static final String MODEL = android.os.Build.MODEL;
    public static final String HARDWARE = android.os.Build.HARDWARE;
    public static final String SERIAL = android.os.Build.SERIAL;
    public static final String RELEASE = android.os.Build.VERSION.RELEASE;

    public static final int SDK_INT = Build.VERSION.SDK_INT;
    public static final String CODENAME = Build.VERSION.CODENAME;

    public static final String USER = android.os.Build.USER;
    public static final String HOST = android.os.Build.HOST;

    private static final Map<String, String> sMap = new LinkedHashMap<String, String>(){
        {
            put("os_name", OS_NAME);
            put("os_version", OS_VERSION);
            put("os_arch", OS_ARCH);

            put("id", ID);
            put("display", DISPLAY);
            put("product", PRODUCT);
            put("device", DEVICE);
            put("board", BOARD);
            put("manufacturer", MANUFACTURER);
            put("brand", BRAND);
            put("model", MODEL);
            put("hardware", HARDWARE);
            put("serial", SERIAL);
            put("release", RELEASE);

            put("sdk_int", String.valueOf(SDK_INT));
            put("codename", CODENAME);
            put("user", USER);
            put("host", HOST);


        }
    };

    public static String getBasicInfo() {

        StringBuilder sb = new StringBuilder();

        Iterator<Map.Entry<String, String>> iterator = sMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            sb.append(next.getKey()).append(" = ").append(next.getValue()).append("\n");
        }

        return sb.toString();
    }

    //TODO：内存，存储空间， CPU， 屏幕信息

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
