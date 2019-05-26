package com.liangchao.shop.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
/**
 * Description:
 * User: Administrator-LiangChao
 * Date: 2019-05-20
 * Time: 9:54
 */
public class DateUtil {

    public static String data (Date date) {
        return new SimpleDateFormat ("yyyy-MM-dd").format (date);
    }

    public static String dataTime (Date date) {
        return new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").format (date);
    }

    public static String dataTime12 (Date date) {
        return new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss").format (date);
    }

    public static String dataTimeNumber (Date date) {
        return new SimpleDateFormat ("yyyyMMddhhmmss").format (date);
    }

    public static String time (Date date) {
        return new SimpleDateFormat ("HH:mm:ss").format (date);
    }

    public static String time (Long date) {
        SimpleDateFormat format = new SimpleDateFormat ("HH:mm:ss:SSS");
        format.setTimeZone (TimeZone.getTimeZone ("GMT"));
        return format.format (date);
    }
}
