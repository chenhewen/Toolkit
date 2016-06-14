package com.robust.toolkit.utils;

import android.os.Build;

import java.util.Locale;

/**
 * 软件辅助类
 * Created by chenhewen on 16-6-14.
 */
public class SoftwareUtil {

    /**
     * 获取android版本号
     * @return  string
     */
    public static String getReleaseVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取android sdk版本号
     * @return int
     */
    public static int getSdkInt() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * 获取国家码，如CN
     * @return string
     */
    public static String getCountry() {
        return Locale.getDefault().getCountry();
    }

    /**
     * 获取语言码，如zh
     * @return string
     */
    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 获取展示的国家名称，如中国
     * @return string
     */
    public static String getDisplayCountry() {
        return Locale.getDefault().getDisplayCountry();
    }

    /**
     * 获取展示的语言名称，如中文
     * @return string
     */
    public static String getDisplayLanguage() {
        return Locale.getDefault().getDisplayLanguage();
    }

}
