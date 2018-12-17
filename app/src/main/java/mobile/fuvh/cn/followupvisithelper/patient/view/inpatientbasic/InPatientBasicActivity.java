package mobile.fuvh.cn.followupvisithelper.patient.view.inpatientbasic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.data.DataManager;
import mobile.fuvh.cn.followupvisithelper.databinding.PatientInpatientActivityBinding;
import mobile.fuvh.cn.followupvisithelper.patient.view.Inrecord.InRecordActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.advice.view.AdviceListActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.diaseaserecord.view.DiseaseRecordActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.report.view.ReportActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.surgery.view.SurgeryListActivity;

/**
 *
 * @author sugar
 * @date 2018/11/30
 */

public class InPatientBasicActivity extends BaseTitleActivity<PatientInpatientActivityBinding,InPatientBasicViewModel>{

    public static void launch(Context context){
        Intent intent = new Intent(context, InPatientBasicActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initData() {
        binding.setItem(DataManager.getInPatientData());
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
            normalTitle(R.string.in_patient_title);
            initViewClickListener();
    }

    private void initViewClickListener() {
        // 入院记录
        binding.admisLL.setOnClickListener((v)->{
            InRecordActivity.launch(this);
        });
        //病程记录
        binding.progLL.setOnClickListener((v)->{
            DiseaseRecordActivity.launch(this);
        });
        // 出院记录
        binding.outhisLL.setOnClickListener((v)->{

        });
        // 手术记录
        binding.opHisLL.setOnClickListener((v)->{
            SurgeryListActivity.launch(this);
        });
        // 会议记录
        binding.dgRecordLL.setOnClickListener((v)->{

        });
        // 医嘱管理
        binding.adviceLL.setOnClickListener((v)->{
            AdviceListActivity.launch(this);
        });
        // 检验报告
        binding.resLL.setOnClickListener((v)->{
            ReportActivity.launch(this,0);

        });
        // 检查报告
        binding.checkLL.setOnClickListener((v)->{
            ReportActivity.launch(this,1);
        });
        // 体征指标
        binding.tempLL.setOnClickListener((v)->{

        });
        // 查房备注
        binding.checkRemarkLL.setOnClickListener((v)->{

        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.patient_inpatient_activity;
    }

    @Override
    protected Class<InPatientBasicViewModel> getViewModelClass() {
        return InPatientBasicViewModel.class;
    }
}
