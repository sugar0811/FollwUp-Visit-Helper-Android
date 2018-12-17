package mobile.fuvh.cn.followupvisithelper.voice.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechEvent;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.cloud.ui.RecognizerDialogListener;
import com.iflytek.sunflower.FlowerCollector;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedHashMap;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.constant.AppConstants;
import mobile.fuvh.cn.followupvisithelper.databinding.VoiceActivityBinding;
import mobile.fuvh.cn.followupvisithelper.voice.helper.JsonParser;
import mobile.fuvh.cn.followupvisithelper.voice.helper.VoiceHelper;
import mobile.fuvh.cn.followupvisithelper.voice.viewmodel.VoiceViewModel;

/**
 *
 * @author sugar
 * @date 2018/11/29
 */

public class VoiceActivity extends BaseTitleActivity<VoiceActivityBinding,VoiceViewModel>{

    private static final String TAG = "VoiceActivity";

    /**
     * 缓冲进度
     */
    private int mPercentForBuffering = 0;

    /**
     * 用HashMap存储听写结果
     */
    private HashMap<String, String> mIatResults = new LinkedHashMap<String, String>();

    public static void launch(Context context){
        Intent intent = new Intent(context, VoiceActivity.class);
        context.startActivity(intent);
    }




    @Override
    protected void initData() {
        VoiceHelper.init(this,mRecognizerDialogListener);
    }

    /**
     * 听写UI监听器
     */
    private RecognizerDialogListener mRecognizerDialogListener = new RecognizerDialogListener() {
        @Override
        public void onResult(RecognizerResult results, boolean isLast) {
                printResult(results);

        }

        /**
         * 识别回调错误.
         */
        @Override
        public void onError(SpeechError error) {
             showTip(error.getPlainDescription(true));
        }

    };


    /**
     * 合成回调监听。
     */
    private SynthesizerListener mTtsListener = new SynthesizerListener() {

        @Override
        public void onSpeakBegin() {
            showTip("开始播放");
        }

        @Override
        public void onSpeakPaused() {
            showTip("暂停播放");
        }

        @Override
        public void onSpeakResumed() {
            showTip("继续播放");
        }

        @Override
        public void onBufferProgress(int percent, int beginPos, int endPos,
                                     String info) {
            // 合成进度
            mPercentForBuffering = percent;
        }

        @Override
        public void onSpeakProgress(int percent, int beginPos, int endPos) {
            // 播放进度

        }

        @Override
        public void onCompleted(SpeechError error) {
            if (error == null) {
                showTip("播放完成");
            } else if (error != null) {
                showTip(error.getPlainDescription(true));
            }
        }

        @Override
        public void onEvent(int eventType, int arg1, int arg2, Bundle obj) {
            // 以下代码用于获取与云端的会话id，当业务出错时将会话id提供给技术支持人员，可用于查询会话日志，定位出错原因
            // 若使用本地能力，会话id为null
            //	if (SpeechEvent.EVENT_SESSION_ID == eventType) {
            //		String sid = obj.getString(SpeechEvent.KEY_EVENT_SESSION_ID);
            //		Log.d(TAG, "session id =" + sid);
            //	}

            if (SpeechEvent.EVENT_TTS_BUFFER == eventType) {
                byte[] buf = obj.getByteArray(SpeechEvent.KEY_EVENT_TTS_BUFFER);
                Log.e("MscSpeechLog", "buf is =" + buf);
            }

        }
    };



    private void printResult(RecognizerResult results) {
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

        binding.etResult.setText(resultBuffer.toString());
        binding.etResult.setSelection(binding.etResult.length());
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
            initTitle();
            initViewListener();
    }

    private void initViewListener() {
        binding.btRecord.setOnClickListener((v)->{
            FlowerCollector.onEvent(VoiceActivity.this, AppConstants.VOICE_RECOGNIZE);
        });
        binding.btPlay.setOnClickListener((v)->{
            FlowerCollector.onEvent(VoiceActivity.this, AppConstants.VOICE_TTS_PLAY);
            int code = VoiceHelper.startSpeaking(binding.tvMsg.getText().toString(), mTtsListener);
//			/**
//			 * 只保存音频不进行播放接口,调用此接口请注释startSpeaking接口
//			 * text:要合成的文本，uri:需要保存的音频全路径，listener:回调接口
//			*/
			/*String path = Environment.getExternalStorageDirectory()+"/tts.pcm";
			int code = mTts.synthesizeToUri(text, path, mTtsListener);*/

            if (code != ErrorCode.SUCCESS) {
                showTip("语音合成失败,错误码: " + code);
            }
        });
    }

    private void initTitle() {
        normalTitle(R.string.voice_title);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VoiceHelper.destroy();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.voice_activity;
    }

    @Override
    protected Class<VoiceViewModel> getViewModelClass() {
        return VoiceViewModel.class;
    }
}
