package mobile.fuvh.cn.followupvisithelper.app;

import com.iflytek.cloud.SpeechUtility;

import java.io.File;

import cn.wowjoy.commonlibrary.app.BaseApplication;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.constant.AppConstants;

/**
 *
 * @author sugar
 * @date 2018/11/29
 */

public class FollowUpVisitApplication extends BaseApplication{

    @Override
    public void onCreate() {
        // 初始化科大讯飞的SDK
        SpeechUtility.createUtility(FollowUpVisitApplication.this, "appid=" + getString(R.string.app_id));
        if(!new File(AppConstants.BASE_PATH_PIC).exists()){
            new File(AppConstants.BASE_PATH_PIC).mkdirs();
        }
        super.onCreate();
    }
}
