package mobile.fuvh.cn.followupvisithelper.patient.view.list.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.PatientListActivityBinding;
import mobile.fuvh.cn.followupvisithelper.patient.view.list.viewmodel.PatientListViewModel;

/**
 *
 * @author sugar
 * @date 2018/12/15
 */

public class PatientListActivity extends BaseTitleActivity<PatientListActivityBinding,PatientListViewModel>{

    public static void launch(Context context){
        context.startActivity(new Intent(context,PatientListActivity.class));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle(R.string.in_patient_title);
        binding.rvPatient.setAdapter(viewModel.getPatientAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.patient_list_activity;
    }

    @Override
    protected Class<PatientListViewModel> getViewModelClass() {
        return PatientListViewModel.class;
    }
}
