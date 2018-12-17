package mobile.fuvh.cn.followupvisithelper.patient.view.report.inspect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.constant.AppConstants;
import mobile.fuvh.cn.followupvisithelper.databinding.PatientTestActivityBinding;
import mobile.fuvh.cn.followupvisithelper.patient.bean.TestrepMasteResponse;

/**
 *
 * @author sugar
 * @date 2018/11/30
 * 检验
 */

public class InspectDetailActivity extends BaseTitleActivity<PatientTestActivityBinding,InspectDetailViewModel>{

    public static void launch(Context context, TestrepMasteResponse.ResultsBean.ListBean listBean){
        Intent intent = new Intent(context,InspectDetailActivity.class);
        intent.putExtra(AppConstants.REPORT_TEST_BEAN,listBean);
        context.startActivity(intent);
    }

    @Override
    protected void initData() {
        TestrepMasteResponse.ResultsBean.ListBean listBean = (TestrepMasteResponse.ResultsBean.ListBean) getIntent().getSerializableExtra(AppConstants.REPORT_TEST_BEAN);
        binding.setModel(listBean);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
            normalTitle("检验报告");
            binding.testRV.setAdapter(viewModel.mCommonAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.patient_test_activity;
    }

    @Override
    protected Class<InspectDetailViewModel> getViewModelClass() {
        return InspectDetailViewModel.class;
    }
}
