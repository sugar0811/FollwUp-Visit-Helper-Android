package mobile.fuvh.cn.followupvisithelper.patient.view.diaseaserecord.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemDiseaseRecordBinding;
import mobile.fuvh.cn.followupvisithelper.databinding.PatientDiseaseRecordActivityBinding;
import mobile.fuvh.cn.followupvisithelper.patient.bean.DiseaseRecordItem;
import mobile.fuvh.cn.followupvisithelper.patient.view.diaseaserecord.view.detail.view.DiseaseRecordDetailActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.diaseaserecord.viewmodel.DiseaseRecordViewModel;

/**
 *
 * @author sugar
 * @date 2018/12/3
 */

public class DiseaseRecordActivity extends BaseTitleActivity<PatientDiseaseRecordActivityBinding,DiseaseRecordViewModel>{

    public static void launch(Context context){
        Intent intent = new Intent(context,DiseaseRecordActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle(R.string.disease_record_title);
        binding.rvDiseaseRecord.setAdapter(new CommonAdapter<DiseaseRecordItem,ItemDiseaseRecordBinding>(R.layout.item_disease_record, makeData(), new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                DiseaseRecordDetailActivity.launch(DiseaseRecordActivity.this);
            }
        }){});
    }
    private ObservableArrayList<DiseaseRecordItem> makeData() {
        ObservableArrayList<DiseaseRecordItem> list = new ObservableArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(new DiseaseRecordItem(getTimeString(i),"王子健",(getRomString(i)+"  病程记录"),i));
        }
        return list;
    }

    @NonNull
    private String getTimeString(int i) {
        return getRomString(i)+("   "+(i+2)+":10");
    }

    @NonNull
    private String getRomString(int i) {
        return "2018-11-"+(15-i);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.patient_disease_record_activity;
    }

    @Override
    protected Class<DiseaseRecordViewModel> getViewModelClass() {
        return DiseaseRecordViewModel.class;
    }
}
