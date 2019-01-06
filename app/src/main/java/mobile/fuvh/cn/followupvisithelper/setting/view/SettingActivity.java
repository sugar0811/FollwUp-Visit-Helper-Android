package mobile.fuvh.cn.followupvisithelper.setting.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.SettingActivityBinding;
import mobile.fuvh.cn.followupvisithelper.setting.viewmodel.SettingViewModel;

/**
 *
 * @author sugar
 * @date 2019/1/6
 */

public class SettingActivity extends BaseTitleActivity<SettingActivityBinding,SettingViewModel>{

    public static void launch(Context context){
        context.startActivity(new Intent(context,SettingActivity.class));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("设置");
        binding.llBiology.setOnClickListener((v)->{
            SettingBiologyActivity.launch(v.getContext());
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.setting_activity;
    }

    @Override
    protected Class<SettingViewModel> getViewModelClass() {
        return SettingViewModel.class;
    }
}
