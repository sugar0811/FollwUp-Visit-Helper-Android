package mobile.fuvh.cn.followupvisithelper.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.widget.NestedScrollView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;

import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import cn.wowjoy.commonlibrary.base.BaseActivity;
import cn.wowjoy.commonlibrary.rxbus.RxBus;
import cn.wowjoy.commonlibrary.utils.DateUtils;
import cn.wowjoy.commonlibrary.utils.DensityUtil;
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
import mobile.fuvh.cn.followupvisithelper.databinding.ItemPopMenuBinding;
import mobile.fuvh.cn.followupvisithelper.msg.view.MessageActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.advice.view.AdviceListActivity;
import mobile.fuvh.cn.followupvisithelper.voice.bean.DrawerMenuBean;
import mobile.fuvh.cn.followupvisithelper.voice.bean.RecordBean;
import mobile.fuvh.cn.followupvisithelper.voice.helper.ChatHelper;
import mobile.fuvh.cn.followupvisithelper.voice.helper.JsonParser;
import mobile.fuvh.cn.followupvisithelper.voice.helper.PickImageHelper;
import mobile.fuvh.cn.followupvisithelper.voice.helper.VoiceHelper;
import mobile.fuvh.cn.followupvisithelper.voice.view.record.view.RecordActivity;
import mobile.fuvh.cn.followupvisithelper.voice.widget.IChatView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemChartView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemDiseaseCaseView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemDiseaseRecordView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemImageView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemReadPaperView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemVoice2TextView;
import mobile.fuvh.cn.followupvisithelper.voice.widget.ItemVoiceRecordView;

/**
 * @author sugar
 */
public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {


    private AnimationDrawable mAnimationDrawable;
    private MPopupwindow mPopupWindow;

    /**
     * 用HashMap存储听写结果
     */
    private HashMap<String, String> mIatResults = new LinkedHashMap<String, String>();

    public static void launch(Context context){
        context.startActivity(new Intent(context,MainActivity.class));
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
        binding.tbTitle.setTitle("随访助手");
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
        binding.llScrollRoot.addView(view);
        scrollToBottom(binding.nsScroll);
    }

    private void parseQuestion(String s) {
        IChatView view = ChatHelper.parseQ(s, this);
        VoiceHelper.startSpeaking(view.getTipText(), null);
        addBottomView(view);
    }


    private void content() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        binding.ivInput.setOnClickListener((v) -> {
            switchText();
            InputTools.showSoftInputFromWindow(MainActivity.this, binding.etMessage);
            Log.e("time", DateUtils.getCurrFullTimeData() + "..");
        });
        binding.ivSwitchVoice.setOnClickListener((v)->{
                switchVoice();
        });
        CommonAdapter inputTipAdapter = viewModel.getInputTipAdapter();
        inputTipAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                switch (position) {
                    case 0:
                        addBottomView(new ItemDiseaseRecordView(v.getContext()));
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
                        addBottomView(new ItemReadPaperView(v.getContext()).wardRoundType());
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
                        addBottomView(new ItemReadPaperView(v.getContext()).wardRoundType());
                        break;
                    case 1:
                        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        String mPhotoPath = PickImageHelper.getPhotoPath();
                        Uri imguri = Uri.fromFile(new File(mPhotoPath));
                        camera.putExtra(MediaStore.EXTRA_OUTPUT, imguri);
                        MainActivity.this.startActivityForResult(camera, AppConstants.CAMERA_WITH_DATA);
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
        CommonAdapter<DrawerMenuBean, ItemPopMenuBinding> deptAdapter = viewModel.getDeptAdapter();
        deptAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if (position == 0) {
                    RecordActivity.launch(v.getContext());
                }
                if (mPopupWindow != null) {
                    mPopupWindow.dismiss();
                }
            }

        });
        mPopupWindow = new MPopupwindow(MainActivity.this, deptAdapter, DensityUtil.dip2px(116), DensityUtil.dip2px(140));
        binding.tbTitle.addAction(new TitleBar.ImageAction(R.drawable.message) {
            @Override
            public void performAction(View view) {
                MessageActivity.launch(view.getContext());
            }
        });

        binding.tbTitle.addAction(new TitleBar.ImageAction(R.drawable.more) {
            @Override
            public void performAction(View view) {

                mPopupWindow.show(view);
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
        File file = PickImageHelper.onPickResult(requestCode, resultCode, data, this);
        if (file != null) {
            ItemImageView itemImageView = new ItemImageView(this);
            itemImageView.imageByFile(file);
            addBottomView(itemImageView);

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
