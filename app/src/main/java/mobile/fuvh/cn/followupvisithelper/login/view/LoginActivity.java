package mobile.fuvh.cn.followupvisithelper.login.view;

import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.LoginActivityBinding;
import mobile.fuvh.cn.followupvisithelper.login.viewmodel.LoginViewModel;
import mobile.fuvh.cn.followupvisithelper.main.MainActivity;

/**
 *
 * @author sugar
 * @date 2019/1/4
 * 登录页面
 */

public class LoginActivity extends BaseActivity<LoginActivityBinding,LoginViewModel>{
    @Override
    protected void init(Bundle savedInstanceState) {
        binding.ivLogin.setOnClickListener((v)->{
            MainActivity.launch(v.getContext());
            finish();
        });
        binding.tvPwdMode.setOnClickListener((v)->{
            LoginByPwdActivity.launch(v.getContext());
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.login_activity;
    }

    @Override
    protected Class<LoginViewModel> getViewModelClass() {
        return LoginViewModel.class;
    }
}
