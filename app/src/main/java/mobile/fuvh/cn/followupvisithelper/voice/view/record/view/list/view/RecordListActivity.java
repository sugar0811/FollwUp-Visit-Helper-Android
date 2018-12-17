package mobile.fuvh.cn.followupvisithelper.voice.view.record.view.list.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.VoiceRecordListActivityBinding;
import mobile.fuvh.cn.followupvisithelper.voice.bean.RecordBean;
import mobile.fuvh.cn.followupvisithelper.voice.view.record.view.list.viewmodel.RecordListViewModel;

/**
 *
 * @author sugar
 * @date 2018/12/12
 */

public class RecordListActivity extends BaseTitleActivity<VoiceRecordListActivityBinding,RecordListViewModel>{

    ObservableArrayList<RecordBean> mRecordBeans = new ObservableArrayList<>();

    public static void launch(Context context){
        context.startActivity(new Intent(context,RecordListActivity.class));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("录音记录");
        binding.rvRecord.setAdapter(viewModel.getRecordListAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.voice_record_list_activity;
    }

    @Override
    protected Class<RecordListViewModel> getViewModelClass() {
        return RecordListViewModel.class;
    }
}
