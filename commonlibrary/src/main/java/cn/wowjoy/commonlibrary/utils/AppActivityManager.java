package cn.wowjoy.commonlibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class AppActivityManager {
    private static List<Activity> mActivitys = Collections.synchronizedList(new LinkedList<Activity>());
    private static AppActivityManager mAppCompatActivity;

    public static AppActivityManager getInstance() {
        if (mAppCompatActivity == null) {
            mAppCompatActivity = new AppActivityManager();
        }
        return mAppCompatActivity;
    }

    public List<Activity> getActivities() {
        return mActivitys;
    }

    /**
     * 添加Activity到堆栈
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        mActivitys.add(activity);
        Log.i("------------------>", mActivitys.size() + "");
    }

    /**
     * 移除Activity到堆外
     */
    public void removeActivity(Activity activity) {
        mActivitys.remove(activity);
    }

    /**
     * 获取栈顶Activity
     */
    public Activity getTopActivity() {
        if (mActivitys == null || mActivitys.isEmpty()) {
            return null;
        }
        return mActivitys.get(mActivitys.size() - 1);
    }

    /**
     * 结束栈顶Activity
     */
    public void killTopActivity() {
        if (mActivitys == null || mActivitys.isEmpty()) {
            return;
        }
        killActivity(mActivitys.get(mActivitys.size() - 1));
    }

    /**
     * 结束指定的Activity
     */
    private void killActivity(Activity activity) {
        if (mActivitys == null || mActivitys.isEmpty()) {
            return;
        }
        if (activity != null) {
            mActivitys.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void killActivity(Class<?> cls) {
        try {
            if (mActivitys == null) {
                return;
            }
            Iterator<Activity> iActivity = mActivitys.iterator();
            while (iActivity.hasNext()) {
                Activity activity = iActivity.next();
                if (activity.getClass().equals(cls)) {
                    killActivity(activity);
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * 结束所有Activity
     * activity为排除页
     */
    public void killAllActivity(Class mClass) {
        try {
            if (mActivitys == null) {
                return;
            }
            Iterator<Activity> iActivity = mActivitys.iterator();
            while (iActivity.hasNext()) {
                Activity activity = iActivity.next();
                if (mClass == null || !activity.getClass().getName().equals(mClass.getName())) {
                    iActivity.remove();
                    activity.finish();
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * 退出应用程序
     */
    @SuppressWarnings("deprecation")
    public void AppExit(Context context) {
        try {
            killAllActivity(null);
//            android.app.ActivityManager activityMgr = (android.app.ActivityManager) context
//                    .getSystemService(Context.ACTIVITY_SERVICE);
//            activityMgr.restartPackage(context.getPackageName());
//            System.exit(0);
        } catch (Exception e) {
            Log.e("AppActivityManager", "" + e);
        }
    }
}
