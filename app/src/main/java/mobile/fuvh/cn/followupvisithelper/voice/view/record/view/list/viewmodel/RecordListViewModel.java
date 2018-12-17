package mobile.fuvh.cn.followupvisithelper.voice.view.record.view.list.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.util.List;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import cn.wowjoy.commonlibrary.app.BaseApplication;
import cn.wowjoy.commonlibrary.utils.DateUtils;
import cn.wowjoy.commonlibrary.utils.FileUtils;
import cn.wowjoy.commonlibrary.utils.SPUtils;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemRecordViewBinding;
import mobile.fuvh.cn.followupvisithelper.voice.bean.RecordBean;
import mobile.fuvh.cn.followupvisithelper.voice.view.record.view.list.view.PlaybackFragment;

/**
 *
 * @author sugar
 * @date 2018/12/12
 */

public class RecordListViewModel extends AndroidViewModel{

    private static final String LOG_TAG = "RecordListViewModel";
    ObservableArrayList<RecordBean> mRecordBeans = new ObservableArrayList<>();

    public RecordListViewModel(@NonNull Application application) {
        super(application);
        String voiceFilePath = FileUtils.getVoiceFilePath(BaseApplication.getInstance());
        File file = new File(voiceFilePath);
        File[] subFile = file.listFiles();
        for (int iFileLength = 0; iFileLength < subFile.length; iFileLength++) {
            // 判断是否为文件夹
            if (!subFile[iFileLength].isDirectory()) {
                RecordBean recordBean = new RecordBean();
                String filename = subFile[iFileLength].getName();
                recordBean.setRecordName(filename);
                Log.e("filename",filename+"..");
                long aLong = SPUtils.getLong(filename, 0);
                if(aLong != 0){
                    recordBean.setRecordDuration(DateUtils.toTime(aLong));
                }
                recordBean.setLength((int) (aLong/1000));
                recordBean.setRecordPath(subFile[iFileLength].getAbsolutePath());
                mRecordBeans.add(recordBean);
            }
        }
    }

    public CommonAdapter<RecordBean,ItemRecordViewBinding> getRecordListAdapter(){

        return new CommonAdapter<RecordBean, ItemRecordViewBinding>(R.layout.item_record_view, mRecordBeans, new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                try {
                    PlaybackFragment playbackFragment =
                            new PlaybackFragment().newInstance(mRecordBeans.get(position));

                    FragmentTransaction transaction = ((FragmentActivity) v.getContext())
                            .getSupportFragmentManager()
                            .beginTransaction();

                    playbackFragment.show(transaction, "dialog_playback");

                } catch (Exception e) {
                    Log.e(LOG_TAG, "exception", e);
                }
            }
        }) {

        };

    }

    private void recordList(List<RecordBean> list) {

        mRecordBeans.clear();
        if(null != list) {
            mRecordBeans.addAll(list);
        }

    }
}
