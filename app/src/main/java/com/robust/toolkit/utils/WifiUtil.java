package com.robust.toolkit.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.format.Formatter;

/**
 * wifi 辅助工具类
 * Created by chenhewen on 16-6-15.
 */
public class WifiUtil {

    /**
     * 获取WifiInfo
     * @param context context
     * @return WifiInfo
     */
    private static WifiInfo getWifiInfo(Context context) {
        WifiManager wifiMgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiMgr.getConnectionInfo();
        return wifiInfo;
    }

    /**
     * 获取名称
     * @param context context
     * @return value
     */
    public static String getName(Context context) {
        WifiInfo wifiInfo = getWifiInfo(context);
        return wifiInfo.getSSID();
    }

    /**
     * 获取网速
     * @param context context
     * @return value (Mbps)
     */
    public static int getSpeed(Context context) {
        WifiInfo wifiInfo = getWifiInfo(context);
        return wifiInfo.getLinkSpeed();
    }

    /**
     * 获取"接收的信号强度指示(Received Signal Strength Indication)"
     * @param context context
     * @return rssi (dBm)
     *
     */
    public static int getRssi(Context context) {
        WifiInfo wifiInfo = getWifiInfo(context);
        return wifiInfo.getRssi();
    }

    /**
     * 获取IPV4
     * @param context
     * @return
     */
    public static String getIpV4(Context context) {
        WifiInfo wifiInfo = getWifiInfo(context);
        return Formatter.formatIpAddress(wifiInfo.getIpAddress());
    }
}
