package com.robust.toolkit.utils;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenhewen on 16-6-14.
 */
public class TimeUtil {

    /**
     * 返回流逝的时间的展示字符串
     * @param durationMillis 流逝的时间millis
     * @return 展示字符串
     */
    public static String getDisplayDuration(long durationMillis) {
        long days = TimeUnit.MILLISECONDS.toDays(durationMillis);
        durationMillis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(durationMillis);
        durationMillis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(durationMillis);
        durationMillis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(durationMillis);

        return String.format(Locale.getDefault(), "%dd %dh %dm %ds", days, hours, minutes, seconds);
    }
}
