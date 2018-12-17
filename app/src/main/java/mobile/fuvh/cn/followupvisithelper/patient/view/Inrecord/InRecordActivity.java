package mobile.fuvh.cn.followupvisithelper.patient.view.Inrecord;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.data.DataManager;
import mobile.fuvh.cn.followupvisithelper.databinding.PatientAdmisActivityBinding;

/**
 *
 * @author sugar
 * @date 2018/11/30
 */

public class InRecordActivity extends BaseTitleActivity<PatientAdmisActivityBinding,InRecordViewModel>{

    public static void launch(Context context){
        Intent intent = new Intent(context,InRecordActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initData() {
        binding.setModel(DataManager.getPatInMsg());
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("入院记录");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.patient_admis_activity;
    }

    @Override
    protected Class<InRecordViewModel> getViewModelClass() {
        return InRecordViewModel.class;
    }
}
