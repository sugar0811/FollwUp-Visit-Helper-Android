package mobile.fuvh.cn.followupvisithelper.login.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import cn.wowjoy.commonlibrary.utils.AppActivityManager;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.LoginPwdActivityBinding;
import mobile.fuvh.cn.followupvisithelper.login.viewmodel.LoginByPwdViewModel;
import mobile.fuvh.cn.followupvisithelper.main.MainActivity;

/**
 *
 * @author sugar
 * @date 2019/1/6
 */

public class LoginByPwdActivity extends BaseTitleActivity<LoginPwdActivityBinding,LoginByPwdViewModel>{

    public static void launch(Context context){
        context.startActivity(new Intent(context,LoginByPwdActivity.class));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("登录");
        binding.btLogin.setOnClickListener((v)->{
            AppActivityManager.getInstance().killActivity(LoginActivity.class);
            MainActivity.launch(v.getContext());
            finish();
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.login_pwd_activity;
    }

    @Override
    protected Class getViewModelClass() {
        return null;
    }
}
