package mobile.fuvh.cn.followupvisithelper.patient.view.report.check;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.constant.AppConstants;
import mobile.fuvh.cn.followupvisithelper.databinding.PatientCheckDetailActivityBinding;
import mobile.fuvh.cn.followupvisithelper.patient.bean.ExamListResponse;

/**
 *
 * @author sugar
 * @date 2018/11/30
 * 检查
 */

public class CheckDetailActivity extends BaseTitleActivity<PatientCheckDetailActivityBinding,CheckDetailViewModel>{


    public static void launch(Context context,ExamListResponse.ResultsBean.ListBean listBean){
        Intent intent = new Intent(context,CheckDetailActivity.class);
        intent.putExtra(AppConstants.REPORT_EXAM_BEAN,listBean);
        context.startActivity(intent);
    }

    @Override
    protected void initData() {
        ExamListResponse.ResultsBean.ListBean listBean = (ExamListResponse.ResultsBean.ListBean) getIntent().getSerializableExtra(AppConstants.REPORT_EXAM_BEAN);
        binding.setModel(listBean);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
            normalTitle("检查报告");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.patient_check_detail_activity;
    }

    @Override
    protected Class<CheckDetailViewModel> getViewModelClass() {
        return CheckDetailViewModel.class;
    }
}
