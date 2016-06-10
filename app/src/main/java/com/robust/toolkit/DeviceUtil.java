package com.robust.toolkit;

import android.os.Build;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
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

        StringBuffer sb = new StringBuffer();

        Iterator<Map.Entry<String, String>> iterator = sMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            sb.append(next.getKey()).append(" = ").append(next.getValue()).append("\n");
        }

        return sb.toString();
    }

    //TODO：内存， CPU， 屏幕信息
}
