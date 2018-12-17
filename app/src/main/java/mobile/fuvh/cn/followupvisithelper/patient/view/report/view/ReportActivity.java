package mobile.fuvh.cn.followupvisithelper.patient.view.report.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.view.View;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.constant.AppConstants;
import mobile.fuvh.cn.followupvisithelper.data.DataManager;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemExamInpatientBinding;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemTestInpatientBinding;
import mobile.fuvh.cn.followupvisithelper.databinding.PatientCheckActivityBinding;
import mobile.fuvh.cn.followupvisithelper.patient.bean.ExamListResponse;
import mobile.fuvh.cn.followupvisithelper.patient.bean.TestrepMasteResponse;
import mobile.fuvh.cn.followupvisithelper.patient.view.report.check.CheckDetailActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.report.inspect.InspectDetailActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.report.viewmodel.ReportViewModel;

/**
 *
 * @author sugar
 * @date 2018/11/30
 */

public class ReportActivity extends BaseTitleActivity<PatientCheckActivityBinding,ReportViewModel>{



    public static void launch(Context context,int type){
        Intent intent = new Intent(context,ReportActivity.class);
        intent.putExtra(AppConstants.REPORT_TYPE,type);
        context.startActivity(intent);
    }



    private ObservableArrayList<TestrepMasteResponse.ResultsBean.ListBean> mTestrepMaster = new ObservableArrayList<>();

    @Override
    protected void initData() {
        int type = getIntent().getIntExtra(AppConstants.REPORT_TYPE, 0);
        if(0 == type){
            normalTitle("1051 刘建国 检验报告");
            mTestrepMaster.addAll(DataManager.getMedicalTestList());
            binding.reportRV.setAdapter(mTestrepMasterCommonAdapter);
            mTestrepMasterCommonAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View v, int position) {
                    TestrepMasteResponse.ResultsBean.ListBean mTRL = (TestrepMasteResponse.ResultsBean.ListBean) mTestrepMasterCommonAdapter.getItem(position);
                   InspectDetailActivity.launch(v.getContext(),mTRL);
                }
            });
        }else{
            normalTitle("1051 刘建国 检查报告");
            ExamListResponse.ResultsBean.ListBean examinationMsg = DataManager.getExaminationMsg();
            mExams.add(examinationMsg);
            binding.reportRV.setAdapter(mExamsCommonAdapter);
        }
    }

    public CommonAdapter mTestrepMasterCommonAdapter = new CommonAdapter<TestrepMasteResponse.ResultsBean.ListBean, ItemTestInpatientBinding>(R.layout.item_test_inpatient, mTestrepMaster, null) {
    };
    private ObservableArrayList<ExamListResponse.ResultsBean.ListBean> mExams = new ObservableArrayList<>();
    public CommonAdapter mExamsCommonAdapter = new CommonAdapter<ExamListResponse.ResultsBean.ListBean, ItemExamInpatientBinding>(R.layout.item_exam_inpatient, mExams, new CommonAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            CheckDetailActivity.launch(v.getContext(),mExams.get(position));
        }
    }) {
    };


    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.patient_check_activity;
    }

    @Override
    protected Class<ReportViewModel> getViewModelClass() {
        return ReportViewModel.class;
    }
}
