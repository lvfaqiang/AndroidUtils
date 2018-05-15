package com.lvfq.library.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * DateUtil
 *
 * @author lvfq
 * @date 2017/7/9 上午10:19
 * @mainFunction :
 */

public class DateUtil {

    /**
     * 获取当前时间戳为星期几
     *
     * @param time 时间戳
     * @return
     * @throws Throwable
     */
    public static String dayForWeek(long time) throws Throwable {
        String pTime = num_format(time, "EEEE");
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.getDefault());
        Date tmpDate = sdf.parse(pTime);
        String week = sdf.format(tmpDate);
        return week;
    }

    /**
     * 时间戳转换对应的格式
     *
     * @param time 时间戳
     * @param type 转换的格式（eg: yyyy-MM-dd）
     * @return 最终返回结果（格式为 type 格式）
     */
    public static String num_format(long time, String type) {
        SimpleDateFormat sdf = new SimpleDateFormat(type, Locale.getDefault());
        String date = sdf.format(new Date(time));
        return date;
    }

    /**
     * 通过生日计算年龄
     *
     * @param birthday   日期
     * @param formatType 日期格式
     * @return
     */
    public static int birthDayToAge(String birthday, String formatType) {
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat(formatType, Locale.getDefault());
            String mDateTime = formatter.format(cal.getTime());// 当前时间
            java.util.Date today = formatter.parse(mDateTime);
            SimpleDateFormat sdf = new SimpleDateFormat(formatType, Locale.getDefault());
            java.util.Date birday = sdf.parse(birthday);// 当前对当前的情况
            int age = today.getYear() - birday.getYear();
            if (today.getMonth() == birday.getMonth()
                    && today.getDate() == birday.getDate()
                    && birday.getYear() % 4 != 0 && today.getYear() != 0
                    && birday.getMonth() != 1 && today.getMonth() != 1) { // 月份和日期都与当前时间相同(除去生日和当前年是闰年，并且是二月的情况)
                return age;
            } else if (today.getMonth() < birday.getMonth()) {// 生日的月份大于当前时间的月份
                return age - 1;
            } else if (birday.getMonth() == 1 && birday.getDate() == 29// 生日是闰年，当前年不一定是闰年
                    && today.getMonth() == 1) { // 生日是闰年的情况,并且本月是二月
                if (today.getYear() % 4 == 0) {// 当前年是闰年 2月有二十九
                    if (today.getDate() < birday.getDate()) {//
                        return age - 1;
                    } else {
                        return age;
                    }
                } else {// 当前是年二月是二十八天
                    if (today.getDate() < birday.getDate() - 1) {
                        return age - 1;
                    } else {
                        return age;
                    }
                }
            } else if (today.getMonth() == 1 && today.getDate() == 29
                    && birday.getMonth() == 1) { // 当前年是闰年，生日年不一定是闰年
                if (birday.getYear() % 4 == 0) {// 生日年是闰年 二月有二十九天
                    if (today.getDate() < birday.getDate()) {//
                        return age - 1;
                    } else {
                        return age;
                    }
                } else {// 生日年二月是二十八天
                    if (today.getDate() + 1 < birday.getDate()) {
                        return age - 1;
                    } else {
                        return age;
                    }
                }

            } else if (today.getMonth() > birday.getMonth()) {// 不是同一年，生日的月份不大于当前的月份的情况
                return age;

            } else if (today.getDate() < birday.getDate()) {// 正常的日期(非闰年) 当前 小于 出生
                return age - 1;
            } else if (today.getDate() == birday.getDate()) {// 当前 等于 出生
                return age;
            } else {
                return age; // 当前 大于 出生
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }


    /**
     * 获取发表时间
     *
     * @param time
     * @return （刚刚，xx分钟前，xx小时前 ，xx天前）
     */
    public static String getPublishTime(long time) {
        long curTime = new Date().getTime();
        long deftime = (curTime - time) / 1000;

        long min = deftime / 60;
        if (min == 0) {
            return "刚刚";
        } else if (min < 60) {
            return min + "分钟前";
        }
        int hours = (int) (deftime / 3600);
        if (hours < 24) {
            return hours + "小时前";
        }
        int days = (int) (deftime / (3600 * 24));
        return days + "天前";
    }

    /**
     * 设置时间
     * 今天就是 HH:mm
     * 昨天
     * 前天
     * yyyy[分隔符]MM[分隔符]dd
     *
     * @param inputTime 时间戳
     * @param symbol    分隔符
     */
    public static String getTimes(Long inputTime, String symbol) {
        try {
            String ret = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            String date2 = sdf.format(new Date(inputTime));
            Date date = sdf.parse(date2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int temphour = calendar.get(Calendar.HOUR_OF_DAY);
            int tempminutes = calendar.get(Calendar.MINUTE);
            String hour = "";
            String minutes = "";
            if (temphour < 10) {
                hour = "0" + temphour;
            } else {
                hour = String.valueOf(temphour);
            }
            if (tempminutes < 10) {
                minutes = "0" + tempminutes;
            } else {
                minutes = String.valueOf(tempminutes);
            }
            long create = sdf.parse(date2).getTime();
            Calendar now = Calendar.getInstance();
            long ms = 1000 * (now.get(Calendar.HOUR_OF_DAY) * 3600
                    + now.get(Calendar.MINUTE) * 60 + now.get(Calendar.SECOND));// 毫秒数
            long ms_now = now.getTimeInMillis();
            if (ms_now - create < ms) {
                return temphour + ":" + minutes;
            } else if (ms_now - create < (ms + 24 * 3600 * 1000)) {
                ret = "昨天 ";
            } else if (ms_now - create < (ms + 24 * 3600 * 1000 * 2)) {
                ret = "前天 ";
            } else {
                ret = year + symbol + month + symbol + day;
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
