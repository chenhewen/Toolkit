package com.robust.toolkit.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Sim卡辅助类
 * Created by chenhewen on 16-6-14.
 */
public class SimUtil {

    public static String getPhoneNumber(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getLine1Number();
    }
}
