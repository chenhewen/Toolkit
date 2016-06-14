package com.robust.toolkit.utils;

import android.os.Build;

import java.util.Locale;

/**
 * 软件辅助类
 * Created by chenhewen on 16-6-14.
 */
public class SoftwareUtil {

    public static String getReleaseVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    public static int getSdkInt() {
        return Build.VERSION.SDK_INT;
    }

    public static String getCountry() {
        return Locale.getDefault().getCountry();
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getDisplayCountry() {
        return Locale.getDefault().getDisplayCountry();
    }

    public static String getDisplayLanguage() {
        return Locale.getDefault().getDisplayLanguage();
    }

}
