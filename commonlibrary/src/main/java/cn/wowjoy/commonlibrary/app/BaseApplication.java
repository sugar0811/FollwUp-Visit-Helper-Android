package cn.wowjoy.commonlibrary.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.utils.AppActivityManager;

public class BaseApplication extends Application {
    private static BaseApplication mBaseApplication;

    public static BaseApplication getInstance() {
        return mBaseApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mBaseApplication = this;
        registerActivityListener();
    }

    public void registerActivityListener() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                AppActivityManager.getInstance().addActivity(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
            }

            @Override
            public void onActivityResumed(Activity activity) {
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                if (!AppActivityManager.getInstance().getActivities().isEmpty()) {
                    if (AppActivityManager.getInstance().getActivities().contains(activity)) {
                        AppActivityManager.getInstance().removeActivity(activity);
                    }
                }
            }
        });
    }
}
