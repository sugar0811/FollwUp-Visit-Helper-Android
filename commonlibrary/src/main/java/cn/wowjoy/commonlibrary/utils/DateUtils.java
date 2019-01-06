package cn.wowjoy.commonlibrary.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sugar on 2018/4/26.
 */

public class DateUtils {


    public static String getTodayFormat() {
        Date date = new Date();
        String mat = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(mat);
        String nowdate = format.format(date);
        DebugUtil.error("nowdate", nowdate + "//");
        return nowdate;
    }


    public static String getWorkDayFormat(String time) {
        if (!TextUtils.isEmpty(time)) {
            String[] split = time.split(" ");
            if (split.length == 2) {
                return split[0];
            }
        }
        return null;
    }

    public static String getSurgertDate(String date) {
        if (!TextUtils.isEmpty(date)) {
            int i = date.lastIndexOf(":");
            return date.substring(0, i);
        }
        return null;

    }

    /**
     * 把时间毫秒数转换成时间格式
     *
     * @param duration 时长
     */
    public static String toTime(long duration) {
        String time = "";
        long minute = duration / 60000;
        long seconds = duration % 60000;
        long second = Math.round((float) seconds / 1000);
        if (minute < 10) {
            time += "0";
        }
        time += minute + ":";
        if (second < 10) {
            time += "0";
        }
        time += second;
        return time;
    }

    public static String getCurrFullDay() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return sDateFormat.format(new Date());
    }

    public static String getCurrFullDay(Date date) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return sDateFormat.format(date);
    }

    public static String getMonthDay(Date date) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("MM-dd");
        return sDateFormat.format(date);
    }


    public static String getCurrFullTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sDateFormat.format(new Date());
    }

    public static String getCurrFullTime(Date date) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sDateFormat.format(date);
    }

    public static String getCurrFullTimeData() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        return sDateFormat.format(new Date());
    }
    public static String getCurrFullTimeDataSecond() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return sDateFormat.format(new Date());
    }

    public static String getCurrTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sDateFormat.format(new Date());
    }
    public static String getCurrTime(Date date) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sDateFormat.format(date);
    }

    public static String getCurrExamTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sDateFormat.format(new Date());
    }


    public static String getFormateTime(String time, String T) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(T);
        try {
            return sDateFormat.format(sDateFormat.parse(time));
        } catch (ParseException e) {
            return "";
        }
    }

    public static String getThreeWeekTime() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
//        Log.e("PXY", "getThreeWeeekTime: +"+sf.format(c.getTime()) );
        c.add(Calendar.DAY_OF_MONTH, 21);
//        Log.e("PXY", "getThreeWeeekTime2: +"+sf.format(c.getTime()) );
        return sf.format(c.getTime());
    }

    /**
     * 结束时间默认为23:59:59
     */
    public static String getEndDate(Date date) {
        String dateText = getCurrFullDay(date);
        String endFlag = " 23:59:59";
        return dateText + endFlag;
    }

    /**
     * 开始时间默认为00:00:00
     */
    public static String getStartDate(Date date) {
        String dateText = getCurrFullDay(date);
        String startFlag = " 00:00:00";
        return dateText + startFlag;
    }

    public static String getImdtPatAge(String patiBirthday) {
        if(!TextUtils.isEmpty(patiBirthday)){
            String[] split = patiBirthday.split(" ");
            String[] split1 = split[0].split("-");
            String year = split1[0];
            Calendar cal = Calendar.getInstance();
            int yearNow = cal.get(Calendar.YEAR);
            int i = yearNow - Integer.parseInt(year);
            return i+"";
        }

        return "";
    }
}
