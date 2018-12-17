package mobile.fuvh.cn.followupvisithelper.voice.view.record.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;

import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Timer;
import java.util.TimerTask;

import cn.wowjoy.commonlibrary.base.BaseActivity;
import cn.wowjoy.commonlibrary.utils.DialogUtils;
import cn.wowjoy.commonlibrary.utils.RecorderUtil;
import cn.wowjoy.commonlibrary.utils.SPUtils;
import cn.wowjoy.commonlibrary.utils.StatusBarUtil;
import cn.wowjoy.commonlibrary.utils.ToastUtils;
import cn.wowjoy.commonlibrary.widget.MDialog;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.VoiceRecordActivityBinding;
import mobile.fuvh.cn.followupvisithelper.voice.view.record.viewmodel.RecordViewModel;

/**
 *
 * @author sugar
 * @date 2018/12/11
 */

public class RecordActivity extends BaseActivity<VoiceRecordActivityBinding,RecordViewModel> {

    private RecorderUtil recorderUtil;
    private long baseTimer;
    private MDialog mDialog;

    public static void launch(Context context){
        context.startActivity(new Intent(context,RecordActivity.class));
    }

    private static class StartTimeHandler extends Handler{

        private WeakReference<RecordActivity> mRecordActivity;

        public StartTimeHandler(RecordActivity recordActivity){
            this.mRecordActivity = new WeakReference<RecordActivity>(recordActivity);
        }


        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            RecordActivity recordActivity = mRecordActivity.get();
            if(recordActivity != null){
                recordActivity.updateTime((String) msg.obj);
            }
        }
    }

    private StartTimeHandler startTimeHandler = new StartTimeHandler(this);

    private Timer timer = new Timer("计时器");


    protected void initData() {
        recorderUtil = new RecorderUtil();
    }


    public void updateTime(String str){
            binding.tvTime.setText(str);
    }

    protected void initView(Bundle savedInstanceState) {
        StatusBarUtil.setTranslucent(this);
        listener();

    }

    private void listener() {
        binding.ivState.setOnClickListener((v)->{
            record();
        });
        binding.ivDone.setOnClickListener((v)->{
            ToastUtils.showShort(v.getContext(),"保存成功,可在录音记录中查看录音");
            finish();
        });
        binding.ivClose.setOnClickListener((v)->{
            if(recorderUtil != null && recorderUtil.isRecording()){
                if(mDialog == null) {
                    mDialog = DialogUtils.alertDialog(RecordActivity.this, "正在录音中,您确定要退出吗?", "取消", "确定",
                            (v1) -> {
                                mDialog.dismiss();
                            },
                            (v1) -> {
                                mDialog.dismiss();
                                finish();
                            });
                }
                mDialog.show();
            }else{
                if(recorderUtil != null){
                    recorderUtil.cancelRecording();
                }
                finish();
            }
        });
    }

    private void record() {
        if(recorderUtil.isRecording()) {
            putLocalFileDuration();
            if(timer != null) {
                timer.cancel();
                timer = null;
            }
            binding.ivState.setImageResource(R.drawable.record_play);
            binding.ivDone.setVisibility(View.VISIBLE);
        }else{
            binding.ivState.setImageResource(R.drawable.record_stop);
            binding.ivDone.setVisibility(View.GONE);
            recorderUtil.startRecording();
            this.baseTimer = SystemClock.elapsedRealtime();
            if(timer == null){
                timer = new Timer("计时器");
            }
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    int time = (int) ((SystemClock.elapsedRealtime() - baseTimer) / 1000);
                    String hh = new DecimalFormat("00").format(time / 3600);
                    String mm = new DecimalFormat("00").format(time % 3600 / 60);
                    String ss = new DecimalFormat("00").format(time % 60);
                    String timeFormat = new String(hh + ":" + mm + ":" + ss);
                    Message msg = new Message();
                    msg.obj = timeFormat;
                    startTimeHandler.sendMessage(msg);
                }

            }, 0, 1000L);
        }

    }

    private void putLocalFileDuration() {
        long l = recorderUtil.stopRecording();
        String filePath = recorderUtil.getFilePath();
        if(null != filePath) {
            String fileName = filePath.substring(filePath.lastIndexOf("/")+1, filePath.length());
            SPUtils.putLong(fileName, l);
        }
    }

    @Override
    protected void init(Bundle savedInstanceState) {
            initView(savedInstanceState);
            initData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.voice_record_activity;
    }

    @Override
    protected Class<RecordViewModel> getViewModelClass() {
        return RecordViewModel.class;
    }
}
