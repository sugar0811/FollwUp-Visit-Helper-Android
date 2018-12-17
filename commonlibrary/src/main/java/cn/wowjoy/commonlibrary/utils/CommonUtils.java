package cn.wowjoy.commonlibrary.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.wowjoy.commonlibrary.app.BaseApplication;


/**
 * 获取原生资源
 */
public class CommonUtils {

    /**
     * 随机颜色
     */
    public static int randomColor() {
        Random random = new Random();
        int red = random.nextInt(150) + 50;//50-199
        int green = random.nextInt(150) + 50;//50-199
        int blue = random.nextInt(150) + 50;//50-199
        return Color.rgb(red, green, blue);
    }

    /**
     * 得到年月日的"日"
     */
    private String getDate() {
        Date date = new Date();
        SimpleDateFormat dateFm = new SimpleDateFormat("dd");
        return dateFm.format(date);
    }


    public static Drawable getDrawable(int resid) {
        return getResoure().getDrawable(resid);
    }

    public static int getColor(int resid) {
        return getResoure().getColor(resid);
    }

    public static Resources getResoure() {
        return BaseApplication.getInstance().getResources();
    }

    public static String[] getStringArray(int resid) {
        return getResoure().getStringArray(resid);
    }

    public static String getString(int resid) {
        return getResoure().getString(resid);
    }

    public static float getDimens(int resId) {
        return getResoure().getDimension(resId);
    }

    public static void removeSelfFromParent(View child) {

        if (child != null) {

            ViewParent parent = child.getParent();

            if (parent instanceof ViewGroup) {

                ViewGroup group = (ViewGroup) parent;

                group.removeView(child);
            }
        }
    }
    public static String ArrayToString2(String[] array){
        StringBuffer sb1=new StringBuffer();
        if(array.length == 1){
            sb1.append(array[0]);
            return sb1.toString();
        }
        for (int i = 0; i < array.length; i++) {
            if (i==array.length-1){
                sb1.append(array[i]);
            }else {
                sb1.append(array[i]).append(",");
            }
        }
        return sb1.toString();
    }



    public static boolean isPhone(Context context, String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            ToastUtils.showShort(context,"手机号应为11位数");
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
//            LogUtil.e(isMatch);
            if (!isMatch) {
                ToastUtils.showShort(context,"请填入正确的手机号");
            }
            return isMatch;
        }

    }
}
