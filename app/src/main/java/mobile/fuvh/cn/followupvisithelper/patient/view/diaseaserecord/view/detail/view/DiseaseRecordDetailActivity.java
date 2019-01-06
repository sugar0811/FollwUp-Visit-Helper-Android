package mobile.fuvh.cn.followupvisithelper.patient.view.diaseaserecord.view.detail.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.DiseaseRecordDetailActivityBinding;
import mobile.fuvh.cn.followupvisithelper.patient.view.diaseaserecord.view.detail.viewmodel.DiseaseRecordDetailViewModel;
import mobile.fuvh.cn.followupvisithelper.patient.view.pacs.PacsWebActivity;

/**
 *
 * @author sugar
 * @date 2018/12/3
 */

public class DiseaseRecordDetailActivity extends BaseTitleActivity<DiseaseRecordDetailActivityBinding,DiseaseRecordDetailViewModel>{


    public static void launch(Context context){
        Intent intent = new Intent(context, DiseaseRecordDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("病程详情");
        binding.btConfirm.setOnClickListener((v)->{
            finish();
        });
        binding.tvPacs.setOnClickListener((v)->{
            PacsWebActivity.launch(v.getContext(),"");
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.disease_record_detail_activity;
    }

    @Override
    protected Class<DiseaseRecordDetailViewModel> getViewModelClass() {
        return DiseaseRecordDetailViewModel.class;
    }
}
