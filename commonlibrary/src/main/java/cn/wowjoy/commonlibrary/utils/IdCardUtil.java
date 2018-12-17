package cn.wowjoy.commonlibrary.utils;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.wowjoy.commonlibrary.bean.IdCardResult;

/**
 *
 * @author sugar
 * @date 2018/10/10
 */

public class IdCardUtil {


    public static IdCardResult validateIDNum(String idNum) {
        IdCardResult result = new IdCardResult();// 记录验证结果
        result.setCode(100);
        //判断身份证是否为空
        if (TextUtils.isEmpty(idNum)) {
            result.setErrorMsg("身份证号码不能为空");
            return result;
        }
        //身份证号码的长度只能为15位或18位
        int idNumLength = idNum.length();
        if (idNumLength != 15 && idNumLength != 18) {
            result.setErrorMsg("身份证号码应该为15位或18位");
            return result;
        }
        //对身份证的字符做判断
        if (!isAllNum(idNum)) {
            result.setErrorMsg(idNum.length() == 18 ? "18位号码除最后一位外,都应为数字" : "15位号码都应为数字");
            return result;
        }

//        if (idNum.contains("x")) {
//            result.setError("身份证x必须为大写");
//            return result;
//        }

//        //判断地区编码
//        Hashtable<string, string=""> h = getAreaCode();
//        if (h.get(idNum.substring(0, 2)) == null) {
//            result.setError("身份证地区编码错误");
//            return result;
//        }

        // 出生年月是否有效
        String idNum17;
        if (idNum.length() == 18) {
            idNum17 = idNum.substring(0, 17);
        } else {
            //如果是15为身份证则加上出生年代:19
            idNum17 = idNum.substring(0, 6) + "19" + idNum.substring(6, 15);
        }
        String strYear = idNum17.substring(6, 10);// 年份
        String strMonth = idNum17.substring(10, 12);// 月份
        String strDay = idNum17.substring(12, 14);// 月份
        if (!validateDate(strYear + "-" + strMonth + "-" + strDay)) {
            result.setErrorMsg("身份证生日无效");
            return result;
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150 || (gc.getTime().getTime()
                    - format.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                result.setErrorMsg("身份证生日不在有效范围");
                return result;
            }
        } catch (NumberFormatException | java.text.ParseException e) {
            e.printStackTrace();
        }


//        //18位的身份证对最后一位校验码进行验证
//        if (idNum.length() == 18 && !isCorrectID(idNum)) {
//            result.setError("身份证无效,不是合法的身份证号码");
//            return result;
//        }
        result.setCode(200);
        result.setBirthday(strYear+"-"+strMonth+"-"+strDay);
        return result;
    }

    /**
     * 判断身份证字符是否合法
     */
    private static boolean isAllNum(String idNum) {
        String match = idNum.length() == 18 ? "^[0-9]{17}([0-9]|[Xx])$" : "^[0-9]{15}$";
        Pattern pattern = Pattern.compile(match);
        Matcher isNum = pattern.matcher(idNum);
        return isNum.matches();
    }

    /**
     * 功能：判断字符串是否为日期格式
     */
    private static boolean validateDate(String strDate) {
        Pattern pattern = Pattern.compile(
                "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        return m.matches();
    }
}
