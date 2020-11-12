package cn.nepenthes.miniupload.common.utils;


import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类。
 * 
 * @author Origin
 *
 */
public class DateUtil {
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String TIME_STR_170000 = "17:00:00";
    public static final String TIME_STR_235959 = "23:59:59";
    public static final String TIME_STR_000000 = "00:00:00";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_NUMBER_PATTERN = "yyyyMMdd";
    public static final String DATE_TIME = "HHmmss";
    public static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_PATTERN2 = "yyyyMMddHHmmss";
    public static final String TIME_PATTERN3 = "yyyy-MM-dd HHmmss";
    public static final String TIME_PATTERN4 = "HH:mm:ss";
    public static final String DATE_PATTERN1 = "yyyyMMddHHmm";
    public static final String DATE_PATTERN2 = "yyyyMMdd";

    private static int count = 0;

    /**
     * 由日期返回yyyy-MM-dd格式的字符串
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        return simpleDateFormat.format(date);

    }

    /**
     * 由日期返回yyyy-MM-dd格式的字符串
     * @return
     */
    public static String currentDateToString() {
        Date date = new Date();
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN1);
        return simpleDateFormat.format(date);
    }

    public static String dateToString(Date date, String format) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);

    }

    public static String dateToString8(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_NUMBER_PATTERN);
        return simpleDateFormat.format(date);
    }

    /**
     * 由日期返回HHmmss格式的字符串
     *
     * @param date
     * @return
     */
    public static String dateToTime(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_TIME);
        return simpleDateFormat.format(date);
    }

    /**
     * 由日期返回yyyyMMdd格式的字符串
     *
     * @param date
     * @return
     */
    public static String dateToNumber(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_NUMBER_PATTERN);
        return simpleDateFormat.format(date);
    }

    /**
     * 由日期返?? dd 格式的字符串
     *
     * @param date
     * @return
     */
    public static String getDay(Date date) {
        if (date == null)
            return null;
        return dateToNumber(date).substring(6, 8);
    }

    /**
     * 由日期返?? mm 格式的字符串
     *
     * @param date
     * @return
     */
    public static String getMonth(Date date) {
        if (date == null)
            return null;
        return dateToNumber(date).substring(4, 6);
    }

    /**
     * 由日期返?? yyyy 格式的字符串
     *
     * @param date
     * @return
     */
    public static String getYear(Date date) {
        if (date == null)
            return null;
        return dateToNumber(date).substring(0, 4);
    }

    /**
     * 由日期返回yyyy-MM-dd HH:mm:ss格式的字符串
     *
     * @param time
     * @return
     */
    public static String timeToString(Date time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_PATTERN);
        return simpleDateFormat.format(time);
    }

    /**
     * 由日期返回yyyyMMddHHmmss格式的字符串
     *
     * @param time
     * @return
     */
    public static String timeToNumber(Date time) {
        if (time == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return simpleDateFormat.format(time);
    }

    /**
     * 将date去除时间
     * @param date
     * @return
     */
    public static Date getDate(Date date) {
        if (date == null)
            return null;
        return stringToDate(dateToString(date));
    }

    /**
     * 由日期返回yyyy-MM-dd-HH.mm.ss.SSSSSS格式的字符串
     *
     * @param date Date格式日期
     * @return String yyyy-MM-dd-HH.mm.ss.SSSSSS格式 的字符串
     */
    public static String getTimeStampFormat(Date date) {
        if (date == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd-HH.mm.ss.SSSSSS");
        return simpleDateFormat.format(date);
    }

    /**
     * 由yyyy-MM-dd HH:mm:ss格式的字符串返回日期时间
     *
     * @param string 时间
     * @return
     */
    public static Date stringToTime(String string) {
        if (string == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_PATTERN);

        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 由yyyy-MM-dd格式的字符串返回日期
     *
     * @param string date字符??
     * @return
     */
    public static Date stringToDate(String string) {
        if (string == null)
            return null;
        if (string.trim().length() == 0)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);

        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 由yyyy-MM-dd HHmmss格式的字符串返回日期
     *
     * @param string
     * @return
     */
    public static Date stringToDate2(String string) {
        if (string == null)
            return null;
        if (string.trim().length() == 0)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_PATTERN3);

        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 由yyyyMMddHHmmss格式的字符串返回日期
     *
     */
    public static Date stringToDate3(String string) {
        if (string == null)
            return null;
        if (string.trim().length() == 0)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_PATTERN2);

        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 由yyyyMMddHHmmss格式的字符串转化为yyyy-MM-dd HH:mm:ss格式的字符串
     *
     * @param string
     * @return
     */
    public static String stringToDateString(String string) {
        if (string == null)
            return null;
        String time = "";
        for (int i = 0; i < 14; i++) {
            time += string.substring(i, i + 1);
            if (i == 3 || i == 5) {
                time += "-";
            } else if (i == 7) {
                time += " ";
            } else if (i == 9 || i == 11) {
                time += ":";
            }
        }
        return time;

    }

    /**
     * 由yyyyMMdd格式的字符串返回日期
     *
     * @param string
     * @return
     */
    public static Date numberToDate(String string) {
        if (string == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_NUMBER_PATTERN);
        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * ??"yyyy-mm-dd"格式的日期字符串转换??"yyyymmdd"的格??
     *
     * @param date
     *            日期
     * @return "yyyymmdd"的日期字符串
     */
    public static String dateStringToNumber(String date) {
        return date.replaceAll("-", "");
    }

    /**
     * ??"yyyymmdd"格式的日期字符串转换??"yyyy-mm-dd"的格??
     *
     * @param date 日期
     * @return "yyyy-mm-dd"的日期字符串
     */
    public static String numberToDateString(String date) {
        if (date == null || date.trim().length() != 8||"00000000".equalsIgnoreCase(date))
            return "";
        else
            return date.substring(0, 4) + "-" + date.substring(4, 6) + "-"
                    + date.substring(6, 8);
    }

    /**
     * ??"yyyymmddhhmmss"格式的日期字符串转换??"yyyy-mm-dd hh:mm:ss"的格??
     * @param time 日期时间字符??
     * @return "yyyy-mm-dd hh:mm:ss"的日期字符串
     */
    public static String numberToTimeString(String time) {
        if (time == null || time.trim().length() != 14)
            return "";
        else
            return time.substring(0, 4) + "-" + time.substring(4, 6) + "-"
                    + time.substring(6, 8) + " " + time.substring(8, 10) + ":"
                    + time.substring(10, 12) + ":" + time.substring(12, 14);
    }

    /**
     * ??"hhmmss"格式的日期字符串转换??"hh:mm:ss"的格?? Added by cx 08-09-28
     *
     * @param time
     *            时间
     * @return "hh:mm:ss"的日期字符串
     */
    public static String numberToTimeString2(String time) {
        if (time == null || time.trim().length() != 6)
            return "";
        else
            return time.substring(0, 2) + ":" + time.substring(2, 4) + ":"
                    + time.substring(4, 6);
    }

    /**
     * 由HHmmss格式的字符串返回日期 Added by cx 08-09-28
     *
     * @param string 时间字符??
     * @return
     */
    public static Date numberToTime(String string) {
        if (string == null)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_PATTERN4);

        try {
            return simpleDateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * ??"yyyy-mm-dd"格式的日期字符串转换??"yyyymm"的格??
     *
     * @param date
     *            Added by llb 08-10-21 日期
     * @return "yyyymmdd"的日期字符串
     */
    public static String dateStringToNumber6(String date) {
        return date.replaceAll("-", "").substring(0, 6);
    }

    /**
     * 返回两日期相隔天??
     *
     * @param bgdate
     * @param enddate
     * @return
     */
    public static long DaysBetween(Date bgdate, Date enddate) {
        long beginTime = bgdate.getTime();
        long endTime = enddate.getTime();
        long days = (long) ((endTime - beginTime) / (1000 * 60 * 60 * 24) + 0.5);
        return days;
    }

    /**
     * 返回两日期相隔天??
     *
     * @param bgdate
     * @param enddate
     * @return
     */
    public static long DaysBetween(java.sql.Date bgdate, java.sql.Date enddate) {
        long beginTime = bgdate.getTime();
        long endTime = enddate.getTime();
        long days = (long) ((endTime - beginTime) / (1000 * 60 * 60 * 24) + 0.5);
        return days;
    }

    public static Date addDate(Date date, int x) {
        // SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
        if (date == null)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, x);
        date = cal.getTime();
        // System.out.println("3 days after(or before) is " +
        // format.format(date));
        cal = null;
        return date;
    }

    /**
     * 当得当天
     */
    public static java.sql.Date getToday() {
//    Calendar today = Calendar.getInstance();
//
//    int tmonth = today.get(Calendar.MONTH);
//    int tyear = today.get(Calendar.YEAR);
//    int tday = today.get(Calendar.DAY_OF_MONTH);
//
//    Calendar ad = Calendar.getInstance();
//    ad.set(tyear, tmonth, tday);
//    return new java.sql.Date(ad.get(Calendar.YEAR) - 1900, ad.get(Calendar.MONTH), ad
//          .get(Calendar.DAY_OF_MONTH));
        return new java.sql.Date(System.currentTimeMillis());
    }

    /**
     *
     * @return
     */
    public static java.sql.Date getTomorrow() {
        Calendar today = Calendar.getInstance();
        today.roll(Calendar.DAY_OF_YEAR, 1);

        int tmonth = today.get(Calendar.MONTH);
        int tyear = today.get(Calendar.YEAR);
        int tday = today.get(Calendar.DAY_OF_MONTH);

        Calendar ad = Calendar.getInstance();
        ad.set(tyear, tmonth, tday);
        return new java.sql.Date(ad.get(Calendar.YEAR) - 1900, ad.get(Calendar.MONTH), ad
                .get(Calendar.DAY_OF_MONTH));
    }

    /**
     *
     * @param theday
     * @return
     */
    public static java.sql.Date getTomorrow(java.sql.Date theday) {
        int tyear = theday.getYear();
        int tmonth = theday.getMonth();
        int tday = theday.getDate();// getDate() means day of month, getDay()
        // means day of week

        Calendar ad = Calendar.getInstance();
        ad.set(tyear, tmonth, tday);
        ad.roll(Calendar.DAY_OF_YEAR, 1);
        return new java.sql.Date(ad.get(Calendar.YEAR), ad.get(Calendar.MONTH), ad
                .get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 当得??周前
     */
    public static java.sql.Date getWeekAgoDay() {
        Calendar today = Calendar.getInstance();
        today.roll(Calendar.DAY_OF_YEAR, -7);

        int tmonth = today.get(Calendar.MONTH);
        int tyear = today.get(Calendar.YEAR);
        int tday = today.get(Calendar.DAY_OF_MONTH);

        Calendar ad = Calendar.getInstance();
        ad.set(tyear, tmonth, tday);
        return new java.sql.Date(ad.get(Calendar.YEAR) - 1900, ad.get(Calendar.MONTH), ad
                .get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 返回前一个月的同????
     */
    public static java.sql.Date getMonthAgoDay() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        Calendar lastDate = (Calendar) c.clone();
        lastDate.add(Calendar.MONTH, -1);
        Date monthAgoDay = lastDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(monthAgoDay.getTime());
        return sqlDate;
    }

    /**
     * 返回??3个月(??)的同????
     */
    public static java.sql.Date getSeasonAgoDay() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        Calendar lastDate = (Calendar) c.clone();
        lastDate.add(Calendar.MONTH, -3);
        Date monthAgoDay = lastDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(monthAgoDay.getTime());
        return sqlDate;
    }

    /**
     * @Author Lucien.li
     * 返回传入月数前的同一天
     * 任务 513
     */
    public static Date getMonthsAgoDay(int months) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        Calendar lastDate = (Calendar) c.clone();
        lastDate.add(Calendar.MONTH, - months);
        Date monthAgoDay = lastDate.getTime();
        return monthAgoDay;
    }

    /**
     * 返回??1年的同一??
     */
    public static java.sql.Date getYearAgoDay() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        Calendar lastDate = (Calendar) c.clone();
        lastDate.add(Calendar.YEAR, -1);
        Date monthAgoDay = lastDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(monthAgoDay.getTime());
        return sqlDate;
    }

    /**
     * 本月度的第一??
     */
    public static java.sql.Date getToyearFirstDay() {
        Calendar today = Calendar.getInstance();
        return new java.sql.Date(today.get(Calendar.YEAR) - 1900, 0, 1);
    }

    public static String getCurrentDateString() {
        String result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date nowDate = new Date();
        result = sdf.format(nowDate);
        return result;
    }

    public static String convertDateToString(Date date) {
        String result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        result = sdf.format(date);
        return result;
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static String getCurrentTimeString() {
        String result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
        Date nowDate = new Date();
        result = sdf.format(nowDate);
        return result;
    }

    public static String getCurrentDateTime() {
        String result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date();
        result = sdf.format(nowDate);
        return result;
    }

    public static String getTimeStamp() {
        StringBuffer result = new StringBuffer();
        if (count < 100) {
            count++;
        } else {
            count = 1;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        Date nowDate = new Date();
        result.append(sdf.format(nowDate)).append(count);
        return result.toString();
    }

    public static String dateFormat(String date) {
        String result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date theDate = null;
        try {
            theDate = (Date) sdf.parse(date);
            String dateFormat = "yyyy-MM-dd hh:mm:ss";
            sdf = new SimpleDateFormat(dateFormat);
            result = sdf.format(theDate);
        } catch (Exception e) {
        }
        return result;
    }

    public static String dateFormat(String date, String format) {
        String result = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date theDate = null;
        try {
            theDate = (Date) sdf.parse(date);
            sdf = new SimpleDateFormat(format);
            result = sdf.format(theDate);
        } catch (Exception e) {
        }
        return result;
    }

    public static Date convertStrToDate(String str, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 根据设定的格式来格式化日期
     *
     * @param date 日期
     * @param format 格式字符串
     * @return 日期字符串
     */
    public static String convertDateToStrByFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (date != null) {
            return  sdf.format(date);
        } else {
            return EMPTY;
        }
    }

//    public static java.sql.Date convertStrToSqlDate(String str, String format) {
//        if("00000000".equals(str) || BizfocusStringUtils.isEmptyTrim(str)){
//            return null;
//        }
//        SimpleDateFormat sdf = new SimpleDateFormat(format);
//        Date date = new Date();
//        try {
//            date = sdf.parse(str);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return new java.sql.Date(date.getTime());
//    }

    public static long getCurrentTime() {
        return (new Date()).getTime();
    }

    /*
     * 增加1/1000??
     */
    public static Date addMillisecond(Date dt, int millisecond) {
        return addSecond(dt, (long) millisecond);
    }

    public static Date addMillisecond(Date dt, long millisecond) {
        dt.setTime(dt.getTime() + millisecond);
        return dt;
    }

    /*
     * 增加??
     */
    public static Date addSecond(Date dt, int second) {
        return addSecond(dt, (long) second);
    }

    public static Date addSecond(Date dt, float second) {
        return addSecond(dt, (long) second);
    }

    public static Date addSecond(Date dt, long second) {
        return addMillisecond(dt, 1000L * second);
    }

    public static Date addSecond(Date dt, double second) {
        Double millisecond = new Double(1000D * second);
        return addMillisecond(dt, millisecond.longValue());
    }

    /*
     * 增加分钟
     */
    public static Date addMinute(Date dt, int minute) {
        return addMinute(dt, (long) minute);
    }

    public static Date addMinute(Date dt, float minute) {
        return addMinute(dt, (long) minute);
    }

    public static Date addMinute(Date dt, long minute) {
        return addMillisecond(dt, 60000L * minute);
    }

    public static Date addMinute(Date dt, double minute) {
        Double millisecond = new Double(60000D * minute);
        return addMillisecond(dt, millisecond.longValue());
    }

    /*
     * 增加小时
     */
    public static Date addHour(Date dt, int hour) {
        return addHour(dt, (long) hour);
    }

    public static Date addHour(Date dt, float hour) {
        return addHour(dt, (long) hour);
    }

    public static Date addHour(Date dt, long hour) {
        return addMillisecond(dt, 0x36ee80L * hour);
    }

    public static Date addHour(Date dt, double hour) {
        Double millisecond = new Double(3600000D * hour);
        return addMillisecond(dt, millisecond.longValue());
    }

    /*
     * 增加??
     */
    public static Date addDay(Date dt, int day) {
        return addDay(dt, (long) day);
    }

    public static Date addDay(Date dt, float day) {
        return addDay(dt, (long) day);
    }

    public static Date addDay(Date dt, long day) {
        return addMillisecond(dt, 0x5265c00L * day);
    }

    public static Date addDay(Date dt, double day) {
        Double millisecond = new Double(86400000D * day);
        return addMillisecond(dt, millisecond.longValue());
    }

    /*
     * 增加??
     */
    public static Date addMonth(Date dt, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.set(2, cal.get(2) + month);

        return cal.getTime();
    }

    public static Date addMonth(Date dt, float month) {
        return addMonth(dt, (int) month);
    }

    public static Date addMonth(Date dt, long month) {
        return addMonth(dt, (new Long(month)).intValue());
    }

    public static Date addMonth(Date dt, double month) {
        double floorMonth = Math.floor(month);
        double decimalMonth = month - floorMonth;
        dt = addMonth(dt, (new Double(floorMonth)).intValue());
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.set(2, cal.get(2) + 1);
        Date nextdt = cal.getTime();
        long monthMillisecond = nextdt.getTime() - dt.getTime();
        double millisecond = (double) monthMillisecond * decimalMonth;
        return addMillisecond(dt, (long) millisecond);
    }

    /*
     * 增加??
     */
    public static Date addYear(Date dt, int year) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.set(1, cal.get(1) + year);
        return cal.getTime();
    }

    public static Date addYear(Date dt, float year) {
        return addYear(dt, (int) year);
    }

    public static Date addYear(Date dt, long year) {
        return addYear(dt, (new Long(year)).intValue());
    }

    public static Date addYear(Date dt, double year) {
        double floorYear = Math.floor(year);
        double decimalYear = year - floorYear;
        dt = addYear(dt, (new Double(floorYear)).intValue());
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        cal.set(1, cal.get(1) + 1);
        Date nextdt = cal.getTime();
        long yearMillisecond = nextdt.getTime() - dt.getTime();
        double millisecond = (double) yearMillisecond * decimalYear;
        return addSecond(dt, (long) millisecond);
    }

    /**
     * 取当前时间月的第??天日??
     *
     * @param date
     * @return
     */
    public static Date getFirstDateOfMonth(Date date) {
        Calendar calDate = Calendar.getInstance();
        calDate.setTime(date);
        calDate.set(Calendar.DATE, 1);
        return calDate.getTime();
    }

    /**
     * 取当前时间月的第??天日??
     *
     * @param date
     * @return
     */
    public static java.sql.Date getFirstDateOfMonth2(java.sql.Date date) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        c1.set(Calendar.DATE, 1);
        return new java.sql.Date(c1.getTimeInMillis());
    }

    public static Date getFirstDateOfYear(Date date) {
        Calendar calDate = Calendar.getInstance();
        calDate.setTime(date);
        calDate.set(Calendar.DATE, 1);
        calDate.set(Calendar.MONTH, 1);
        return calDate.getTime();
    }

    public static Calendar getCalendar(Date date) {
        Calendar calDate = Calendar.getInstance();
        calDate.setTime(date);
        return calDate;
    }

    public static Date getFirstDateOfWeek(Date date) {
        Date result = null;
        Calendar calDate = getCalendar(date);
        int firstDay = calDate.get(Calendar.DAY_OF_WEEK);
        result = addDay(calDate.getTime(), -firstDay + 1);
        return result;
    }

    public static Date getLastDateOfWeek(Date date) {
        Date result = null;
        Calendar calDate = getCalendar(date);
        int firstDay = calDate.get(Calendar.DAY_OF_WEEK);
        result = addDay(calDate.getTime(), 7 - firstDay);
        return result;
    }

    /**
     * 取当前时间月的最后一天日??
     *
     * @param date
     * @return
     */
    public static Date getLastDateOfMonth(Date date) {
        Calendar calDate = Calendar.getInstance();
        calDate.setTime(date);
        calDate.set(Calendar.DATE, calDate.getActualMaximum(Calendar.DATE));

        return calDate.getTime();
    }

    /**
     * 取当前时间月的最后一天日??
     *
     * @param date
     * @return
     */
    public static java.sql.Date getLastDateOfMonth2(java.sql.Date date) {
        Calendar calDate = Calendar.getInstance();
        calDate.setTime(date);
        calDate.setTime(date);
        calDate.set(Calendar.DATE, calDate.getActualMaximum(Calendar.DATE));
        return new java.sql.Date(calDate.getTimeInMillis());
    }

    /**
     * 取得??个月的天??
     *
     * @param date strDate
     * @return
     */
    public static int getDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.getActualMaximum(Calendar.DATE);

    }

    public static boolean beforeIgnoreDay(Date a, Date b) {
        boolean result = false;
        long la = a.getHours() * 60 * 60 + a.getMinutes() * 60 + a.getSeconds();
        long lb = b.getHours() * 60 * 60 + b.getMinutes() * 60 + b.getSeconds();
        if (la <= lb) {
            return true;
        }
        return result;
    }

    /**
     * 判断某一个时间是否在另一个时间之??
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean afterIgnoreDay(Date a, Date b) {
        boolean result = false;
        long la = a.getHours() * 60 * 60 + a.getMinutes() * 60 + a.getSeconds();
        long lb = b.getHours() * 60 * 60 + b.getMinutes() * 60 + b.getSeconds();
        if (la >= lb) {
            return true;
        }
        return result;
    }

    public static boolean equalDay(Date a, Date b) {
        boolean result = false;
        if (a.getYear() == b.getYear() && a.getMonth() == b.getMonth()
                && a.getDay() == b.getDay()) {
            result = true;
        }
        return result;
    }

    public static int monthsBetween(java.sql.Date from, java.sql.Date end) {
        try {
            Calendar c1 = Calendar.getInstance();
            Calendar c2 = Calendar.getInstance();
            c1.setTime(from);
            c2.setTime(end);
            int months = (c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR)) * 12
                    + (c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH));

            return months;

        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp getTimestamp(java.sql.Date date) {
        return new Timestamp(date.getTime());
    }

    public static Timestamp getTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    public static java.sql.Date getDateFromTimestamp(Timestamp time) {
        int year = time.getYear();
        int month = time.getMonth();
        int days = time.getDate();
        java.sql.Date targetDate = new java.sql.Date(year, month, days);
        return targetDate;
    }

    public static java.sql.Date getSqlDateForDB2(java.sql.Date date) {
        int year;
        int month;
        int days;
        year = date.getYear();
        month = date.getMonth();
        days = date.getDate();

        java.sql.Date targetDate = new java.sql.Date(year, month, days);
        return targetDate;
    }

    /**
     * 由yyyy-MM-dd格式的字符串返回日期
     *
     * @param string date字符??
     * @return
     */
    public static java.sql.Date stringToSqlDate(String string) {
        if (string == null)
            return null;
        if (string.trim().length() == 0)
            return null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);

        try {
            Date utilDate = simpleDateFormat.parse(string);
            if(utilDate!=null){
                return new java.sql.Date(utilDate.getTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getDateTimeString(Timestamp dateTime) {
        if(dateTime == null){
            return null;
        }
        String result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        result = sdf.format(dateTime);
        return result;
    }

    //取两个日期的较大??
    public static Date maxDate(Date d1,Date d2){
        Date d_max;
        if(d1.compareTo(d2)>=0){
            d_max = d1;
        }else{
            d_max = d2;
        }
        return d_max;
    }


    //取两个日期的较小??
    public static Date minDate(Date d1,Date d2){
        Date d_min;
        if(d1.compareTo(d2)<=0){
            d_min = d1;
        }else{
            d_min = d2;
        }
        return d_min;
    }

    //两个时间点中间存在时间段
    public static boolean existDateSection(Date d_max,Date d_min){
        boolean flag = true;
        if(d_max.compareTo(d_min)<=0){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }


    /**
     * Time转换为String
     * @param time
     */

    public static String TimeToString(Time time){

        if(null == time){
            return null;
        }

        return time.toString().replace(":", "");

    }



    /**
     * String(HHmmss)转换为Time
     * @param time
     */

    public static Time StringToTime(String time){

        if(null == time || "".equals(time.trim()) || "000000".equalsIgnoreCase(time.trim()) ){
            return null;
        }

        try {
            int houre = Integer.valueOf(time.trim().substring(0, 2));
            int miniter = Integer.valueOf( time.trim().substring(2, 4));
            int second = Integer.valueOf(  time.trim().substring(4, 6));

            return new Time(houre,miniter,second);
        } catch (NumberFormatException e) {

            e.printStackTrace();
            return null;
        }

    }



    /**
     * Date()+time返回date
     * @param date,time
     */
    public static Date DateAddTime(Date date, Time time){

        return new Date(date.getTime()+time.getTime());
    }


    /**
     * 根据日期、周几、以及时间来获取格式化后的日期
     *
     * @param date 日期 weekOfYear根据日期来设定
     * @param dayOfWeek 一周中的周几 例如：周四 则用Calendar.THURSDAY
     * @param time 截止的时间
     * @return
     */
//    public static Date getDateByDateAndDayOfWeekAndTime(Date date, int dayOfWeek ,String time){
//        Date tempDate = new Date();
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        cal.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一
//        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
//        tempDate = cal.getTime();
//        if (BizfocusStringUtils.isEmpty(time)) {
//            tempDate = convertStrToDate(dateToString(tempDate, TIME_PATTERN), TIME_PATTERN);
//        } else {
//            tempDate =convertStrToDate(dateToString(tempDate, TIME_PATTERN) + SPACE + time, TIME_PATTERN);
//        }
//        return tempDate;
//    }


/*    public static String addBar(String dateNoBar){
        String dateHasBar = "";
        if(BizfocusStringUtils.isNotEmptyTrim(dateNoBar)){
            dateNoBar = dateNoBar.trim();

            if(dateNoBar.length()==8&&(!"00000000".equalsIgnoreCase(dateNoBar))){
                dateHasBar = dateNoBar.substring(0, 4)+"-"+dateNoBar.substring(4, 6)+"-"+dateNoBar.substring(6, 8);
            }else{
                dateHasBar = dateNoBar;
            }
        }
        return dateHasBar;
    }

    public static String subtractBar(String dateHasBar){
        String dateNoBar = "";
        if(BizfocusStringUtils.isNotEmptyTrim(dateHasBar)){
            dateHasBar = dateHasBar.trim();
            if(dateHasBar.length()==10){
                dateNoBar = dateHasBar.substring(0, 4)+dateNoBar.substring(5, 7)+dateNoBar.substring(8, 10);
            }else{
                dateNoBar = dateHasBar;
            }
        }
        return dateNoBar;
    }*/

    /**
     * 获取正常??
     *
     * @param inputDate 输入的日??
     * @return
     */
//    public static String getWeekStrByDay(Date inputDate) {
//        if (inputDate == null) {
//            return "";
//        }
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//        Calendar date=Calendar.getInstance();
//        date.setTime(inputDate);
//        date.setFirstDayOfWeek(Calendar.MONDAY);//将每M第一天设为星期一，默认是星期??
//        String year = ""+date.get(Calendar.YEAR);
//        String week = ""+date.get(Calendar.WEEK_OF_YEAR);
//        week = BizfocusStringUtils.leftApped(week, "0", 2);
//        return year + week;
//    }

    /**
     * 获取下单周次日期，周次规??:
     *          当前周周四至下周??
     * @param weeks
     * @return Date[] index 0 是订单周次的??始日期，index 1是订单周次的结束日期
     */
    public static Date[] queryDayForCWeekOfSearch(String weeks){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        Date prevThursday = null;
        cal.setFirstDayOfWeek(Calendar.MONDAY);//将每周第??天设为星期一，默认是星期??
        int weekOfyear = 0;
        int years = 0;
        if(weeks != null && !"".equals(weeks) && !"000000".equals(weeks)){
            String yearStr = weeks.substring(0, 4);
            weeks = weeks.substring(4, 6);
            years = Integer.valueOf(yearStr);
            weekOfyear = Integer.valueOf(weeks);
        }
        if(years != 0 && weekOfyear != 0){
            cal.set(Calendar.YEAR, years);
            cal.set(Calendar.WEEK_OF_YEAR, weekOfyear);
            int dayForWeek = 0;
            if(cal.get(Calendar.DAY_OF_WEEK) == 1){
                dayForWeek = 7;
            }else{
                dayForWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
            }
            cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            Date time = new Date(cal.getTime().getTime());
            String currentWeekThursdayStr = format.format(cal.getTime());
            // 获取下周周四
            String nextWeekThursdayStr = getWeekThursday(1, time);
            Date currentWeekThursday = numberToDate(currentWeekThursdayStr);
            prevThursday = addDate(numberToDate(currentWeekThursdayStr), -7);
            // 下周周四减去????
            Date nextWeekWednesday = addDate(numberToDate(nextWeekThursdayStr), -1);
            Date[] dateArray = {prevThursday, nextWeekWednesday};
            return dateArray;
        } else {
            return null;
        }
    }






    /**
     * 根据当前日期获取当前日期所在周次的始末日期
     * @param time
     * @return
     */
    public static Date[] getDateTFByDate(Date time)
    {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(time);
        }catch(Exception e) {
            e.printStackTrace();
        }
        int d = 0;
        if(cal.get(Calendar.DAY_OF_WEEK) > 4){
            cal.add(Calendar.DAY_OF_WEEK, 7);
        }
        d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DAY_OF_WEEK, d);
        cal.add(Calendar.DAY_OF_WEEK, -4);
        // 所在周开始日期
        Date begin=cal.getTime();
        cal.add(Calendar.DAY_OF_WEEK, 6);
        // 所在周结束日期
        Date end=cal.getTime();
        Date[] dates1={begin,end};
        return dates1;
    }

    /**
     * 以周四到下周三为准 的下周起始日期和结束
     * @param date 日期
     * @param type start为开始日期,end为结束日期
     * @return 当期日期的周四或者下周三的日期 字符串
     */
    public static String getStartOrEndDate(Date date,String type){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        if(dayofweek==1){
            dayofweek = 8;
        }
        int end;
        int start;
        if(dayofweek<5){
            end = 4-dayofweek+calendar.get(Calendar.DAY_OF_MONTH);
            start = end-6;
            calendar.set(Calendar.DAY_OF_MONTH,end);
            if("start".equals(type)){
                calendar.add(Calendar.DAY_OF_MONTH,-6);
                System.out.println(df.format(calendar.getTime()));
            }else{
                System.out.println(df.format(calendar.getTime()));
            }
            return df.format(calendar.getTime());
        }else{
            start = calendar.get(Calendar.DAY_OF_MONTH)-(dayofweek-5);
            end = start+6;
            calendar.set(Calendar.DAY_OF_MONTH,start);
            if("start".equals(type)){
                System.out.println(df.format(calendar.getTime()));
            }else{
                calendar.add(Calendar.DAY_OF_MONTH,6);
                System.out.println(df.format(calendar.getTime()));
            }

            return df.format(calendar.getTime());
        }
    }

    /**
     * 获取上一周或下一周的周四-yyyy-MM-dd
     * @param x
     * @return
     */
    public static String getWeekThursday(int x,Date erdatDate){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar date=Calendar.getInstance();
        date.setTime(erdatDate);
        date.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一，默认是星期天
        date.add(Calendar.WEEK_OF_MONTH, x);//周数减一，即上周
        date.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);//日子设为星期四
        return format.format(date.getTime());
    }

    /**
     * 通过黄金周周次获取周次对应的两个周四日期
     * add 2015年8月20日14:47:54
     * @param gdWeek,type
     * @return
     */
    public static String getGoldenWeekStartOrEndDate(String gdWeek,String type) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);//将每周第一天设为星期一，默认是星期天
        int weekOfyear = 0;
        int years = 0;
        if (gdWeek != null && !"".equals(gdWeek) && !"000000".equals(gdWeek) && !"null".equals(gdWeek)) {
            String yearStr = gdWeek.substring(0, 4);
            gdWeek = gdWeek.substring(4, 6);
            years = Integer.valueOf(yearStr);
            weekOfyear = Integer.valueOf(gdWeek);
        }
        if (years != 0 && weekOfyear != 0) {
            cal.set(Calendar.YEAR, years);
            cal.set(Calendar.WEEK_OF_YEAR, weekOfyear);
            int dayForWeek = 0;
            if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
                dayForWeek = 7;
            } else {
                dayForWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
            }
            cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
            System.err.println("dayForWeek：" + dayForWeek);
            int weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
            System.err.println("weekOfYear:" + weekOfYear);
            Date time = new Date(cal.getTime().getTime());
            if ("start".equals(type)) {
                String currentWeekThursday = format.format(cal.getTime());
                return currentWeekThursday;
            } else {
                String nextWeekThursday = getWeekThursday(1, time);
                Date addDate = addDate(numberToDate(nextWeekThursday), -1);
                return format.format(addDate);
            }
        }
        return "";
    }
    /**
     * 日期转换星期
     */
    public static String dateWeek(String orderDate){
        Calendar c =  Calendar.getInstance();
        Date date = null;
        String week = "星期";
        SimpleDateFormat sdf =   null;
        if(orderDate.indexOf("/") != -1){
            sdf = new SimpleDateFormat( "yyyy/MM/dd" );
        }else if(orderDate.indexOf("-") != -1){
            sdf = new SimpleDateFormat( "yyyy-MM-dd" );
        }else {
            sdf = new SimpleDateFormat( "yyyyMMdd" );
        }
        try {
            date = sdf.parse(orderDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        switch (c.get(Calendar.DAY_OF_WEEK)-1){
            case 1:
                week = week+"一";
                break;
            case 2:
                week = week+"二";
                break;
            case 3:
                week = week+"三";
                break;
            case 4:
                week = week+"四";
                break;
            case 5:
                week = week+"五";
                break;
            case 6:
                week = week+"六";
                break;
            case 7:
                week = week+"日";
                break;
        }
        return week;
    }
    public static Date formatDate(String date_Str , String formatType){
        SimpleDateFormat sdf = new SimpleDateFormat(formatType);
        Date date;
        try {
            date = sdf.parse(date_Str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    /**
     *  字符串转换成日期
     * @param date_Str
     * @return
     */
    public static Date formatDate(String date_Str) {
        return formatDate( date_Str ,"yyyy-MM-dd");
    }

    public static Date formatTime(String date_Str , String formatType){
        SimpleDateFormat sdf = new SimpleDateFormat(formatType);
        Date date;
        try {
            date = sdf.parse(date_Str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }
    /**
     *  字符串转换成时间
     * @param date_Str
     * @return
     */
    public static Date formatTime(String date_Str) {
        return formatTime(date_Str, "HH:mm:ss");
    }

    /**
     * 日期转换为字符串
     */
    public static String getTimestamp(Date date, String formatType){
        SimpleDateFormat format = new SimpleDateFormat(formatType);
        return format.format(date);
    }

    /**
     * 日期转换为字符串 天
     */
    public static String getDate(Date date, String formatType){
        SimpleDateFormat format = new SimpleDateFormat(formatType);
        return format.format(date);
    }

    /**
     * 日期转换为字符串时间
     */
    public static String getTime(Date date, String formatType){
        SimpleDateFormat format = new SimpleDateFormat(formatType);
        return format.format(date);
    }
    public static String getTime(Date date){
        return getTime(date, "HH:mm:ss");
    }

    public static String getTimestampFixedFormat(Date date){
        return getTimestamp(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getDateFixedFormat(Date date){
        return getDate(date, "yyyy-MM-dd");
    }
    /**
     * @Author lucien.li
     * @DATE: 2017/4/5
     * 调用：用于判断字符串是否为日期
     */
//    public static boolean stringIsDate(String str){
//        boolean flag = true;
//        if(BizfocusStringUtils.isEmpty(str)){
//            flag = false;
//        }else {
//            try {
//                SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
//                format.setLenient(false);//严格执行日期校验
//                Date date = format.parse(str);
//                flag = true;
//            } catch (ParseException e) {
//                flag = false;
//            }
//        }
//        return flag;
//    }

    /**
     * 将yyyyMMdd字符串转为yyyy-MM-dd
     * @param date
     * @return
     */
    public static String convertDateStr(String date){
        DateFormat format1 =new SimpleDateFormat(DATE_NUMBER_PATTERN);
        DateFormat format2 =new SimpleDateFormat(DATE_PATTERN);
        try {
            return format2.format(format1.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}