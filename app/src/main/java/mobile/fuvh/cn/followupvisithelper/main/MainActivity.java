package mobile.fuvh.cn.followupvisithelper.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;

import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.ui.RecognizerDialogListener;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import cn.wowjoy.commonlibrary.base.BaseActivity;
import cn.wowjoy.commonlibrary.rxbus.RxBus;
import cn.wowjoy.commonlibrary.utils.CommonUtils;
import cn.wowjoy.commonlibrary.utils.DateUtils;
import cn.wowjoy.commonlibrary.utils.InputTools;
import cn.wowjoy.commonlibrary.utils.StatusBarUtil;
import cn.wowjoy.commonlibrary.utils.ToastUtils;
import cn.wowjoy.commonlibrary.widget.MPopupwindow;
import cn.wowjoy.commonlibrary.widget.titlebar.TitleBar;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.constant.AppConstants;
import mobile.fuvh.cn.followupvisithelper.databinding.ActivityMainBinding;
import mobile.fuvh.cn.followupvisithelper.msg.view.MessageActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.advice.view.AdviceListActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.pacs.PacsLoginActivity;
import mobile.fuvh.cn.followupvisithelper.voice.bean.RecordBean;
import mobile.fuvh.cn.followupvisithelper.voice.helper.ChatHelper;
import mobile.fuvh.cn.followupvisithelper.voice.helper.JsonParser;
import mobile.fuvh.cn.followupvisithelper.voice.helper.PickImageHelper;
import mobile.fuvh.cn.followupvisithelper.voice.helper.VoiceHelper;
import mobile.fuvh.cn.followupvisithelper.voice.view.record.view.RecordActivity;
import mobile.fuvh.cn.followupvisithelper.voice.widget.IChatView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemChartView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemDiseaseCaseView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemDiseaseDetailView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemImageView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemVoice2TextView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemVoiceRecordView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemWardRoundView;

import static mobile.fuvh.cn.followupvisithelper.patient.view.pacs.BaseWebActivity.PACS_TAG;

/**
 * @author sugar
 */
public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {


    public static final int REQUEST_CODE_SCAN = 1099;
    private AnimationDrawable mAnimationDrawable;
    private MPopupwindow mPopupWindow;

    /**
     * 用HashMap存储听写结果
     */
    private HashMap<String, String> mIatResults = new LinkedHashMap<String, String>();

    public static void launch(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }

    protected void initData() {
        VoiceHelper.init(this, new RecognizerDialogListener() {
            @Override
            public void onResult(RecognizerResult recognizerResult, boolean b) {

            }

            @Override
            public void onError(SpeechError speechError) {

            }
        });
        VoiceHelper.startSpeaking("", null);


        RxBus.getInstance().tObservable(AppConstants.RECORD_DONE_SEND, RecordBean.class).
                subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RecordBean>() {
                    @Override
                    public void accept(RecordBean o) throws Exception {
                        ItemVoiceRecordView itemVoiceRecordView = new ItemVoiceRecordView(MainActivity.this);
                        itemVoiceRecordView.setParams(o);
                        addBottomView(itemVoiceRecordView);
                    }
                });


    }

    protected void initView(Bundle savedInstanceState) {
        title();
        content();
        drawer();
        recordViewInit();
    }

    private void recordViewInit() {
        binding.ivState.setOnClickListener((v) -> {
            if(timer == null) {
                // 未开始或者已结束
                showTip("请选择要录音的类型");
            }else{
                // 停止录音
                if(mItemWardRoundView != null){
                    mItemWardRoundView.record(mRecordMsgView,mCurrentRecordKey,mRecordName);
                }
                recordEnd();
            }
        });
        binding.ivDone.setOnClickListener((v)->{
                showTip("保存成功");
                binding.ivDone.setVisibility(View.GONE);
                binding.ivState.setImageResource(R.drawable.record_play);
        });
        binding.ivClose.setOnClickListener((v)->{
            if(timer != null){
                showTip("录音中,请先停止录音在关闭");
            }else{
                binding.rlRecord.setVisibility(View.GONE);
            }
        });
    }

    protected void showTip(String str) {
        ToastUtils.showSingleToast(this, str);
    }


    private void drawer() {
        binding.rvMenu.setAdapter(viewModel.getMenuAdapter());
    }

    private void title() {
        StatusBarUtil.setTranslucent(this);
        binding.tbTitle.setImmersive(true);
        binding.tbTitle.setTitle(CommonUtils.getString(R.string.app_name));
        right();
        left();
    }


    RecognizerListener recognizerListener = new RecognizerListener() {
        @Override
        public void onVolumeChanged(int i, byte[] bytes) {
            Log.e("onVolumeChanged", "i ==>" + i);
            if (i >= 10) {
                binding.wvWave.speechStarted();
            } else if (i <= 5) {
                binding.wvWave.speechEnded();
            }
        }

        @Override
        public void onBeginOfSpeech() {
            showTip("正在聆听...");
            DisplayMetrics dm = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(dm);
            binding.wvWave.initialize(dm);
        }

        @Override
        public void onEndOfSpeech() {
            binding.wvWave.setVisibility(View.GONE);
            binding.wvWave.stop();
            binding.ivVoice.setVisibility(View.VISIBLE);
        }

        @Override
        public void onResult(RecognizerResult recognizerResult, boolean b) {
            printResult(recognizerResult, b);
        }

        @Override
        public void onError(SpeechError speechError) {
            showTip(speechError.getPlainDescription(true));
        }

        @Override
        public void onEvent(int i, int i1, int i2, Bundle bundle) {

        }
    };

    public void start() {
        VoiceHelper.startListening(recognizerListener);
        mIatResults.clear();

    }

    private void printResult(RecognizerResult results, boolean isPrint) {

        String text = JsonParser.parseIatResult(results.getResultString());

        String sn = null;
        // 读取json结果中的sn字段
        try {
            JSONObject resultJson = new JSONObject(results.getResultString());
            sn = resultJson.optString("sn");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mIatResults.put(sn, text);

        StringBuffer resultBuffer = new StringBuffer();
        for (String key : mIatResults.keySet()) {
            resultBuffer.append(mIatResults.get(key));
        }
        if (isPrint) {
            ItemVoice2TextView voice2TextView = new ItemVoice2TextView(this);
            voice2TextView.right();
            voice2TextView.text(resultBuffer.toString());
            addBottomView(voice2TextView);
            parseQuestion(resultBuffer.toString());
        }
    }

    private void addBottomView(View view) {
        if(view instanceof ItemWardRoundView){
            binding.rlRecord.setVisibility(View.VISIBLE);
        }
        binding.llScrollRoot.addView(view);
        scrollToBottom(binding.nsScroll);
    }

    private void parseQuestion(String s) {
        IChatView view = ChatHelper.parseQ(s, this);
        if(view != null) {
            VoiceHelper.startSpeaking(view.getTipText(), null);
            addBottomView(view);
        }
    }


    private void content() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        binding.ivInput.setOnClickListener((v) -> {
            switchText();
            InputTools.showSoftInputFromWindow(MainActivity.this, binding.etMessage);
            Log.e("time", DateUtils.getCurrFullTimeData() + "..");
        });
        binding.ivSwitchVoice.setOnClickListener((v) -> {
            switchVoice();
        });
        CommonAdapter inputTipAdapter = viewModel.getInputTipAdapter();
        inputTipAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                switch (position) {
                    case 0:
                        addBottomView(new ItemDiseaseDetailView(v.getContext()));
                        break;
                    case 1:
                        addBottomView(new ItemChartView(v.getContext()));
                        break;
                    case 2:
                        addBottomView(new ItemDiseaseCaseView(v.getContext()));
                        break;
                    case 3:
                        AdviceListActivity.launch(v.getContext());
                        break;
                    case 4:
                        addBottomView(new ItemWardRoundView(v.getContext()));
                        break;
                    default:
                        break;
                }
            }
        });
        binding.rvInputTip.setAdapter(inputTipAdapter);
        binding.btSendMessage.setOnClickListener((v) -> {
            String text = binding.etMessage.getText().toString();
            if (!TextUtils.isEmpty(text)) {
                InputTools.HideKeyboard(binding.etMessage);
                switchVoice();
                binding.etMessage.setText("");
                ItemVoice2TextView rightTextView = ChatHelper.getRightTextView(v.getContext(), text);
                addBottomView(rightTextView);
                IChatView iChatView = ChatHelper.parseQ(text, v.getContext());
                addBottomView(iChatView);
                VoiceHelper.startSpeaking(iChatView.getTipText(), null);
            }
        });
        binding.ivVoice.setOnClickListener((v) -> {
            binding.ivVoice.setVisibility(View.GONE);
            binding.wvWave.setVisibility(View.VISIBLE);
            start();
        });
        CommonAdapter tipMsgAdapter = viewModel.getTipMsgAdapter();
        tipMsgAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                switch (position) {
                    case 0:
                        addBottomView(new ItemWardRoundView(v.getContext()));
                        break;
                    case 1:
                        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                        startActivityForResult(intent, REQUEST_CODE_SCAN);
                        break;
                    case 2:
                        RecordActivity.launch(v.getContext());
                        break;

                    default:
                        break;
                }

            }
        });
        binding.rvTipMsg.setAdapter(tipMsgAdapter);

    }

    public void goCamera(ItemWardRoundView itemWardRoundView , String key) {
        this.mItemWardRoundView = itemWardRoundView;
        this.mCurrentRecordKey = key;
        PickImageHelper.goCamera(this);
    }


    private Timer timer;
    private StartTimeHandler startTimeHandler = new StartTimeHandler(this);

    private static class StartTimeHandler extends Handler {

        private WeakReference<MainActivity> mRecordActivity;

        public StartTimeHandler(MainActivity mainActivity) {
            this.mRecordActivity = new WeakReference<MainActivity>(mainActivity);
        }


        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MainActivity recordActivity = mRecordActivity.get();
            if (recordActivity != null) {
                recordActivity.updateTime((String) msg.obj);
            }
        }
    }

    public void updateTime(String str) {
        binding.tvTime.setText(str);
    }

    private long baseTimer;
    private String mCurrentRecordKey;
    private String mRecordName;
    private TextView mRecordMsgView;
    private ItemWardRoundView mItemWardRoundView;

    public void recordStart(ItemWardRoundView itemWardRoundView, TextView recordMsgView, String recordKey, String recordName) {
        if (binding.rlRecord.getVisibility() == View.GONE) {
            binding.rlRecord.setVisibility(View.VISIBLE);
        }
        this.mItemWardRoundView = itemWardRoundView;
        this.mCurrentRecordKey = recordKey;
        this.mRecordMsgView = recordMsgView;
        this.mRecordName = recordName;
        binding.tvRecordState.setText(mRecordName+"录音中");
        binding.ivState.setImageResource(R.drawable.record_stop);
        binding.ivDone.setVisibility(View.GONE);
        this.baseTimer = SystemClock.elapsedRealtime();
        if (timer == null) {
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

    public void recordEnd() {
        binding.tvRecordState.setText("录音");
        binding.ivState.setImageResource(R.drawable.record_play);
        binding.ivDone.setVisibility(View.VISIBLE);
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }


    private void switchText() {
        binding.llBottomRoot.setVisibility(View.VISIBLE);
        binding.ivInput.setVisibility(View.GONE);
        binding.ivVoice.setVisibility(View.GONE);
    }

    private void switchVoice() {
        binding.llBottomRoot.setVisibility(View.GONE);
        binding.ivInput.setVisibility(View.VISIBLE);
        binding.ivVoice.setVisibility(View.VISIBLE);
        InputTools.HideKeyboard(binding.etMessage);
    }

    public static void scrollToBottom(final NestedScrollView scrollView) {

        Handler mHandler = new Handler();

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
    }


    private void left() {
        binding.tbTitle.setLeftImageResource(R.drawable.menu);
        binding.tbTitle.setLeftClickListener((v) -> {
            if (binding.dlMenu.isDrawerOpen(Gravity.LEFT)) {
                binding.dlMenu.closeDrawer(Gravity.LEFT);
            } else {
                binding.dlMenu.openDrawer(Gravity.LEFT);
                binding.dlMenu.setDrawerShadow(R.color.black, Gravity.LEFT);
            }
        });

    }

    private void right() {
        binding.tbTitle.addAction(new TitleBar.ImageAction(R.drawable.message) {
            @Override
            public void performAction(View view) {
                MessageActivity.launch(view.getContext());
            }
        });

        binding.tbTitle.addAction(new TitleBar.ImageAction(R.drawable.sacn_small) {
            @Override
            public void performAction(View view) {
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SCAN);
            }
        });
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initData();
        initView(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);
//                showTip("扫描结果为：" + content);
                if(PACS_TAG.equals(content)){
                    PacsLoginActivity.launch(this);
                }
                return;
            }
        }
        File file = PickImageHelper.onPickResult(requestCode, resultCode, data, this);
        if (file != null) {
            ItemImageView itemImageView = new ItemImageView(this);
            itemImageView.imageByFile(file);
//            addBottomView(itemImageView);
            if(mItemWardRoundView != null && mCurrentRecordKey != null) {
                mItemWardRoundView.dispatchImage(mCurrentRecordKey, file.getAbsolutePath());
            }
        }
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }
}
