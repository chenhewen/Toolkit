package com.robust.toolkit.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

import com.robust.toolkit.UnitConstant;

/**
 * 硬件相关辅助类
 * Created by chenhewen on 16-6-14.
 */
public class HardwareUtil {

    /**
     * 获取MemoryInfo
     * @param context context
     * @return MemoryInfo
     */
    private static ActivityManager.MemoryInfo getMemoryInfo(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    /**
     * 获取总内存(GB)
     * @param context context
     * @return value
     */
    public static float getMemoryTotal(Context context) {
        ActivityManager.MemoryInfo memoryInfo = getMemoryInfo(context);
        return memoryInfo.totalMem * 1.0f / UnitConstant.GB;
    }

    /**
     * 获取已用内存(GB)
     * @param context context
     * @return value
     */
    public static float getMemoryUsed(Context context) {
        ActivityManager.MemoryInfo memoryInfo = getMemoryInfo(context);
        return (memoryInfo.totalMem - memoryInfo.availMem) * 1.0f / UnitConstant.GB;
    }

    /**
     * 获取StatFs
     * @return StatFs
     */
    private static StatFs getStorageStat() {
        return new StatFs(Environment.getExternalStorageDirectory().getPath());
    }

    /**
     * 获取存储空间总大小(GB)
     * @return value
     */
    public static float getStorageTotal() {
        StatFs storageStat = getStorageStat();
        long totalBytes = storageStat.getTotalBytes();
        return totalBytes * 1.0f / UnitConstant.GB;
    }

    /**
     * 获取存储空间占用大小(GB)
     * @return value
     */
    public static float getStorageUsed() {
        StatFs storageStat = getStorageStat();
        long totalBytes = storageStat.getTotalBytes();
        long freeBytes = storageStat.getFreeBytes();
        return (totalBytes - freeBytes) * 1.0f / UnitConstant.GB;
    }
}
