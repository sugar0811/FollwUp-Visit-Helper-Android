package mobile.fuvh.cn.followupvisithelper.voice.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;

import cn.wowjoy.commonlibrary.utils.CommonUtils;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.voice.bean.RecordBean;
import mobile.fuvh.cn.followupvisithelper.voice.view.record.view.list.view.PlaybackFragment;

/**
 *
 * @author sugar
 * @date 2018/12/13
 */

public class ItemVoiceRecordView extends IChatView {

    private static final String LOG_TAG = "ItemVoiceRecordView";
    private TextView tvDurationTime;
    private TextView tvDateTime;
    private TextView tvSize;
    private RecordBean mRecordBean;

    public ItemVoiceRecordView(@NonNull Context context) {
        this(context,null);
    }

    public ItemVoiceRecordView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ItemVoiceRecordView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }



    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_record_card,this);
        tvDurationTime = findViewById(R.id.tvDurationTime);
        tvDateTime = findViewById(R.id.tvDateTime);
        tvSize = findViewById(R.id.tvSize);

        setOnClickListener((v)->{
            try {
                PlaybackFragment playbackFragment =
                        new PlaybackFragment().newInstance(mRecordBean);
                FragmentTransaction transaction = ((FragmentActivity) v.getContext())
                        .getSupportFragmentManager()
                        .beginTransaction();
                playbackFragment.show(transaction, "dialog_playback");

            } catch (Exception e) {
                Log.e(LOG_TAG, "exception", e);
            }

        });
    }

    public void setParams(RecordBean recordBean){
            if(recordBean != null) {
                this.mRecordBean =  recordBean;
                tvDurationTime.setText(recordBean.getRecordDuration());
                tvDateTime.setText(recordBean.getRecordName() + recordBean.getRecordTime());
            }
    }

    @Override
    public String getTipText() {
        return CommonUtils.getString(R.string.chat_tip_case);
    }
}
