package mobile.fuvh.cn.followupvisithelper.patient.view.surgery.view.detail.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.constant.AppConstants;
import mobile.fuvh.cn.followupvisithelper.databinding.PatientOphisDetailActivityBinding;
import mobile.fuvh.cn.followupvisithelper.patient.bean.SurgeryreCodeListResponse;
import mobile.fuvh.cn.followupvisithelper.patient.view.surgery.view.detail.viewmodel.SurgeryDetailViewModel;

/**
 *
 * @author sugar
 * @date 2018/11/30
 */

public class SurgeryDetailActivity extends BaseTitleActivity<PatientOphisDetailActivityBinding,SurgeryDetailViewModel>{


    public static void launch(Context context, SurgeryreCodeListResponse.ResultsBean.ListBean bean){
        Intent intent = new Intent(context, SurgeryDetailActivity.class);
        intent.putExtra(AppConstants.SURGERY_BEAN,bean);
        context.startActivity(intent);
    }


    @Override
    protected void initData() {
        normalTitle("手术详情");
        SurgeryreCodeListResponse.ResultsBean.ListBean listBean = (SurgeryreCodeListResponse.ResultsBean.ListBean) getIntent().getSerializableExtra(AppConstants.SURGERY_BEAN);
        binding.setModel(listBean);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.patient_ophis_detail_activity;
    }

    @Override
    protected Class<SurgeryDetailViewModel> getViewModelClass() {
        return SurgeryDetailViewModel.class;
    }
}
