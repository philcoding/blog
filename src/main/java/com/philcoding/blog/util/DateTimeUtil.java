package com.philcoding.blog.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeUtil {

    /**
     * 时间戳转换为 LocalDateTime
     *
     * @param timestamp 时间戳
     * @return LocalDateTime
     */
    public static LocalDateTime Of(long timestamp) {

        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();

        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * LocalDateTime 转换为时间戳
     *
     * @param localDateTime LocalDateTime
     * @return 时间戳
     */
    public static long Of(LocalDateTime localDateTime) {

        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();

        return instant.toEpochMilli();
    }
}
