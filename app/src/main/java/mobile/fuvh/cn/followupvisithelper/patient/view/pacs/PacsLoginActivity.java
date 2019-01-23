package mobile.fuvh.cn.followupvisithelper.patient.view.pacs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.trello.rxlifecycle2.android.ActivityEvent;

import cn.wowjoy.commonlibrary.base.BaseConsumer;
import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import cn.wowjoy.commonlibrary.bean.BaseResponse;
import cn.wowjoy.commonlibrary.bean.baseLiveData.LiveDataWrapper;
import cn.wowjoy.commonlibrary.http.BaseSubscriber;
import cn.wowjoy.commonlibrary.rxbus.RxBus;
import cn.wowjoy.commonlibrary.utils.DialogUtils;
import cn.wowjoy.commonlibrary.utils.RxSchedulerTransformer;
import cn.wowjoy.commonlibrary.utils.ToastUtils;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.constant.AppConstants;
import mobile.fuvh.cn.followupvisithelper.databinding.PacsLoginActivityBinding;
import mobile.fuvh.cn.followupvisithelper.http.HttpClient;
import mobile.fuvh.cn.followupvisithelper.patient.view.pacs.viewmodel.PacsLoginViewModel;

/**
 *
 * @author sugar
 * @date 2019/1/16
 *
 */

public class PacsLoginActivity extends BaseTitleActivity<PacsLoginActivityBinding,PacsLoginViewModel>{


    public static void launch(Context context){
        context.startActivity(new Intent(context,PacsLoginActivity.class));
    }

    @Override
    protected void initData() {
        RxBus.getInstance().tObservable(AppConstants.POST_PACS_STATE, LiveDataWrapper.class)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(new BaseConsumer() {
                    @Override
                    protected void onSuccess(BaseResponse data) {
                        handleSuccess();
                    }

                    @Override
                    protected void onSuccessResultNull() {
                        super.onSuccessResultNull();
                        handleSuccess();
                    }

                    @Override
                    protected void onStart() {
                        super.onStart();
                        DialogUtils.waitingDialog(PacsLoginActivity.this);
                    }

                    @Override
                    protected void onError(Throwable error) {
                        super.onError(error);
                        DialogUtils.dismiss(PacsLoginActivity.this);
                    }
                });
    }

    private void handleSuccess() {
        DialogUtils.dismiss(PacsLoginActivity.this);
        ToastUtils.showSingleToast(PacsLoginActivity.this,"授权成功");
        finish();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("影像登录");
        binding.btLogin.setOnClickListener((v)->{
            HttpClient.getPacsService().postPacsState()
                    .compose(new RxSchedulerTransformer<>())
                    .subscribeWith(new BaseSubscriber<BaseResponse>(AppConstants.POST_PACS_STATE){
                    });
        });
        binding.btCancel.setOnClickListener((v)->{
                finish();
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.pacs_login_activity;
    }

    @Override
    protected Class<PacsLoginViewModel> getViewModelClass() {
        return PacsLoginViewModel.class;
    }
}
