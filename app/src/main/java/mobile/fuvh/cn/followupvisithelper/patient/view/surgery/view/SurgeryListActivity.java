package mobile.fuvh.cn.followupvisithelper.patient.view.surgery.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.data.DataManager;
import mobile.fuvh.cn.followupvisithelper.databinding.PatientSurgeryListActivityBinding;
import mobile.fuvh.cn.followupvisithelper.patient.view.surgery.viewmodel.SurgeryViewModel;

/**
 *
 * @author sugar
 * @date 2018/11/30
 */

public class SurgeryListActivity extends BaseTitleActivity<PatientSurgeryListActivityBinding,SurgeryViewModel>{

    public static void launch(Context context) {
        Intent intent = new Intent(context, SurgeryListActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void initData() {
        viewModel.setItems(DataManager.getSurgeryList());
    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("手术记录");
        binding.ophisRV.setAdapter(viewModel.mCommonAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.patient_surgery_list_activity;
    }

    @Override
    protected Class<SurgeryViewModel> getViewModelClass() {
        return SurgeryViewModel.class;
    }


}
