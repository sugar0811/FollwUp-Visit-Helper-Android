package mobile.fuvh.cn.followupvisithelper.patient.view.advice.view.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.constant.AppConstants;
import mobile.fuvh.cn.followupvisithelper.data.DataManager;
import mobile.fuvh.cn.followupvisithelper.databinding.PatientAdviceYpActivityBinding;
import mobile.fuvh.cn.followupvisithelper.patient.bean.DoctoraDviceListResponse;

/**
 *
 * @author sugar
 * @date 2018/11/30
 */

public class AdviceDetailActivity extends BaseTitleActivity<PatientAdviceYpActivityBinding,AdviceViewModel>{


    public static void launch(Context context, DoctoraDviceListResponse.ResultsBean.ListBean bean){
        Intent intent = new Intent(context, AdviceDetailActivity.class);
        intent.putExtra(AppConstants.DOCTOR_ADVICE_BEAN,bean);
        context.startActivity(intent);
    }


    @Override
    protected void initData() {
        DoctoraDviceListResponse.ResultsBean.ListBean listBean = (DoctoraDviceListResponse.ResultsBean.ListBean) getIntent().getSerializableExtra(AppConstants.DOCTOR_ADVICE_BEAN);
        binding.setModel(listBean);
        viewModel.setAdviceExeList(DataManager.getAdvicExeList());
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        normalTitle("1016 刘建国 药品医嘱");
        binding.jcRV.setNestedScrollingEnabled(false);
        binding.jcRV.setAdapter(viewModel.mCommonAdapter);
        binding.ypRV.setNestedScrollingEnabled(false);
        binding.ypRV.setAdapter(viewModel.mYPsCommonAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.patient_advice_yp_activity;
    }

    @Override
    protected Class<AdviceViewModel> getViewModelClass() {
        return AdviceViewModel.class;
    }
}
