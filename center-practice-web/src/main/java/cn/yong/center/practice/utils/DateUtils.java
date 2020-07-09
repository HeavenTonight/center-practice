package cn.yong.center.practice.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ogy
 * @date 2020/5/18 15:21
 */
public class DateUtils {
    private static final String ZONE_ID = "Asia/Shanghai";
    private static final String YMD = "yyyyMMdd";
    private static final String Y_M_D = "yyyy-MM-dd";
    public static final String DATE_FORMAT_STR_H_M_S = "yyyy-MM-dd HH:mm:ss";
    public static final String DATA_FORMAT_STR_H_M = "yyyy-MM-dd HH:mm";
    public static final String DATA_FORMAT_STR_HMS = "yyyyMMddHHmmss";
    public static final String TIME_FORMAT_STR_HMS = "HH:mm:ss";
    /**
     * long to Date
     *
     * @param date long毫秒数
     * @return LocalDateTime
     */
    public static Date long2Date(Long date) {
        return new Date(date);
    }


    /**
     * 获取当前年份
     *
     * @param date
     * @return
     */
    public static String getYear(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int i = c.get(Calendar.YEAR);
        return String.valueOf(i);
    }


    /**
     * 获取当前月份
     *
     * @param date
     * @return
     */
    public static String getMonth(Date date) {
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int i = c.get(Calendar.MONTH) + 1;
        if (i < 10) {
            return String.format("0%d", i);
        }
        return String.valueOf(i);
    }

    /**
     * long to LocalDateTime
     *
     * @param date long毫秒数
     * @return LocalDateTime
     */
    public static LocalDateTime long2LocalDateTime(Long date) {
        ZoneId zoneId = ZoneId.of(ZONE_ID);
        return new Date(date).toInstant().atZone(zoneId).toLocalDateTime();
    }

    /**
     * 获取当前时间到今天零点的秒数
     *
     * @param currentDate 当前时间
     * @return 秒数
     */
    public static Long getRemainSecondsOneDay(Date currentDate) {
        LocalDateTime midnight = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault()).plusDays(1).withHour(0).withMinute(0)
                .withSecond(0).withNano(0);
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(),
                ZoneId.systemDefault());
        return ChronoUnit.SECONDS.between(currentDateTime, midnight);
    }

    /**
     * 获取YMD字符串时间
     *
     * @param date 时间
     * @return string
     */
    public static String getYMDString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YMD);
        return sdf.format(date);
    }

    /**
     * localDate 转 date
     *
     * @param localDate
     */
    public static Date localDate2Date(LocalDate localDate) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 配送数量默认时间
     *
     * @param date
     * @return
     */
    public static Date getDefaultDate(Date date) {
        if (null == date) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }


    /**
     * Date转LocalDate
     *
     * @param date
     */
    public static LocalDate date2LocalDate(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    /**
     * Date转LocalDateTime
     *
     * @param date
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        if (null == date) {
            return null;
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 获取当前的LocalDateTime
     *
     * @return LocalDateTime
     */
    public static LocalDateTime getNowLocalDateTime() {
        return LocalDateTime.now(Clock.system(ZoneId.of(ZONE_ID)));
    }

    /**
     * localdate转字符串
     *
     * @param date 需要转的时间
     * @return String
     */

    public static String LocalDate2String(LocalDate date) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(YMD);
        return date.format(fmt);
    }


    /**
     * localdate转字符串yyyy-MM-dd
     *
     * @param date 需要转的时间
     * @return String
     */

    public static String date2String(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Y_M_D);
        return simpleDateFormat.format(date);
    }
    /**
    * 字符串转时间
     * @param strDate 字符串
    *@return date
    */
    public static Date String2Date(String strDate) throws ParseException {
        SimpleDateFormat date_format_str_h_m_s = new SimpleDateFormat(DATE_FORMAT_STR_H_M_S);
        return date_format_str_h_m_s.parse(strDate);
    }

    /**localDateTime2String
     * @param time 时间
    * @param format 时间格式
    *@return  string
    */
    public static String getDateTimeAsString(Date time, String format) {
        LocalDateTime localDateTime = date2LocalDateTime(time);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

}
