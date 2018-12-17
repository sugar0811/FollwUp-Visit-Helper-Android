package mobile.fuvh.cn.followupvisithelper.voice.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SynthesizerListener;

import cn.wowjoy.commonlibrary.utils.CommonUtils;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.data.DataManager;
import mobile.fuvh.cn.followupvisithelper.voice.helper.PickImageHelper;
import mobile.fuvh.cn.followupvisithelper.voice.helper.VoiceHelper;

/**
 *
 * @author sugar
 * @date 2018/12/10
 * 晨报控件
 */

public class ItemReadPaperView extends IChatView{

    private boolean isPause = false;
    String str = "2B73床李星，白细胞49g/L上升，总胆红素 55umol/L 上升；值班医生张益生开临时医嘱头孢克洛缓释胶囊。";


    private AnimationDrawable mAnimationDrawable;
    private TextView mTvTitle;
    private TextView mTvContent;
    private FrameLayout mFlPickPic;

    public ItemReadPaperView(Context context) {
        this(context,null);
    }

    public ItemReadPaperView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ItemReadPaperView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    public String getTipText() {
        return CommonUtils.getString(R.string.chat_tip_chart);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_helper_morning,this);
        setOnClickListener((v)->{
            play();
        });

        mTvTitle = findViewById(R.id.tvTitle);
        mFlPickPic = findViewById(R.id.flPickPic);
        mTvContent = findViewById(R.id.tvContent);
        ImageView ivPlay = findViewById(R.id.ivPlay);
        ivPlay.setImageResource(R.drawable.animation_play_voice);
        mAnimationDrawable = (AnimationDrawable) ivPlay.getDrawable();
    }


    public ItemReadPaperView wardRoundType(){
        title("2B16床 刘建国");
        content(DataManager.wardRoundData);
        mFlPickPic.setVisibility(VISIBLE);
        mFlPickPic.setOnClickListener((v)->{
            PickImageHelper.pickImage(v.getContext());
        });
        return this;
    }

    public void play(){

        if(isPause){
            resume();
            return;
        }

        if(!VoiceHelper.isSpeaking()){
            VoiceHelper.startSpeaking(mTvContent.getText().toString(), mSynthesizerListener);
        }else{
            pause();
        }
    }

    private void resume() {
        VoiceHelper.resumeSpeaking();
        isPause = false;
    }

    public void title(String title){
        mTvTitle.setText(title);
    }

    public void content(String content){
        mTvContent.setText(content);
    }

    SynthesizerListener mSynthesizerListener = new SynthesizerListener() {
        @Override
        public void onSpeakBegin() {
            mAnimationDrawable.start();
        }

        @Override
        public void onBufferProgress(int i, int i1, int i2, String s) {

        }

        @Override
        public void onSpeakPaused() {
            mAnimationDrawable.stop();
        }

        @Override
        public void onSpeakResumed() {
            mAnimationDrawable.start();
        }

        @Override
        public void onSpeakProgress(int i, int i1, int i2) {

        }

        @Override
        public void onCompleted(SpeechError speechError) {
            endAnimation();
        }

        @Override
        public void onEvent(int i, int i1, int i2, Bundle bundle) {

        }
    };
    public void endAnimation(){
        mAnimationDrawable.selectDrawable(0);
        mAnimationDrawable.stop();
    }

    public void pause(){
        VoiceHelper.pauseSpeaking();
        isPause = true;
    }


}
