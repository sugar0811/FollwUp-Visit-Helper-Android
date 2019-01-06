package mobile.fuvh.cn.followupvisithelper.setting.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.SettingBiologyActivityBinding;
import mobile.fuvh.cn.followupvisithelper.setting.viewmodel.SettingBiologyViewModel;

/**
 *
 * @author sugar
 * @date 2019/1/6
 * 生物识别
 */

public class SettingBiologyActivity extends BaseTitleActivity<SettingBiologyActivityBinding,SettingBiologyViewModel>
{

    public static void launch(Context context){
        context.startActivity(new Intent(context,SettingBiologyActivity.class));
    }
    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("生物识别");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.setting_biology_activity;
    }

    @Override
    protected Class<SettingBiologyViewModel> getViewModelClass() {
        return SettingBiologyViewModel.class;
    }
}
