package mobile.fuvh.cn.followupvisithelper.voice.helper;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.cloud.ui.RecognizerDialogListener;

import cn.wowjoy.commonlibrary.utils.CommonUtils;
import cn.wowjoy.commonlibrary.utils.SPUtils;
import cn.wowjoy.commonlibrary.utils.ToastUtils;
import mobile.fuvh.cn.followupvisithelper.R;

/**
 *
 * @author sugar
 * @date 2018/11/29
 * 音频助手
 */

public class  VoiceHelper {

    private static VoiceHelper mVoiceHelper;

    public static VoiceHelper getInstance(){
        if(mVoiceHelper == null){
            synchronized (VoiceHelper.class) {
                mVoiceHelper = new VoiceHelper();
            }
        }
        return mVoiceHelper;
    }

    public static void init(Context context, RecognizerDialogListener mRecognizerListener){
        getInstance().initParams(context,mRecognizerListener);
    }

    /**
     * 讯飞语音合成服务
     */
    private SpeechSynthesizer mTts;

    /**
     * 是否设置翻译
     */
    private boolean mTranslateEnable = false;

    /**
     * 引擎类型
     */
    private String mEngineType = SpeechConstant.TYPE_CLOUD;

    /**
     * 讯飞自带语音录入提示
     */
//    private RecognizerDialog mIatDialog;


    /**
     * 语音听写对象
     */
    private SpeechRecognizer mIat;

    /**
     * tag
     */
    private final String TAG = "VoiceHelper";


    /**
     * 默认发音人
     */
    private String voicer = "xiaoyan";

    /**
     * 初始化讯飞语音文字服务
     * @param context
     * @param mRecognizerListener
     */
    private void initParams(Context context,RecognizerDialogListener mRecognizerListener){
        InitListener mInitListener = new InitListener() {
            @Override
            public void onInit(int code) {
                Log.d(TAG, "SpeechRecognizer init() code = " + code);
                if (code != ErrorCode.SUCCESS) {
                    ToastUtils.showShort(context,"初始化失败，错误码：" + code);
                }
            }
        };

        initIat(context, mRecognizerListener, mInitListener);
        initTls(context, mRecognizerListener, mInitListener);
    }

    /**
     * 初始文字转语音服务
     * @return
     */
    private void initTls(Context context, RecognizerDialogListener mRecognizerListener, InitListener mInitListener){


        // 初始化合成对象
        mTts = SpeechSynthesizer.createSynthesizer(context, mInitListener);
        // 清空参数
        mTts.setParameter(SpeechConstant.PARAMS, null);
        // 根据合成引擎设置相应参数
        if(mEngineType.equals(SpeechConstant.TYPE_CLOUD)) {
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_CLOUD);
            mTts.setParameter(SpeechConstant.TTS_DATA_NOTIFY, "1");
            // 设置在线合成发音人
            mTts.setParameter(SpeechConstant.VOICE_NAME, voicer);
            //设置合成语速
            mTts.setParameter(SpeechConstant.SPEED, SPUtils.getString("speed_preference", "50"));
            //设置合成音调
            mTts.setParameter(SpeechConstant.PITCH, SPUtils.getString("pitch_preference", "50"));
            //设置合成音量
            mTts.setParameter(SpeechConstant.VOLUME, SPUtils.getString("volume_preference", "50"));
        }else {
            mTts.setParameter(SpeechConstant.ENGINE_TYPE, SpeechConstant.TYPE_LOCAL);
            // 设置本地合成发音人 voicer为空，默认通过语记界面指定发音人。
            mTts.setParameter(SpeechConstant.VOICE_NAME, "");
            /**
             * TODO 本地合成不设置语速、音调、音量，默认使用语记设置
             * 开发者如需自定义参数，请参考在线合成参数设置
             */
        }
        //设置播放器音频流类型
        mTts.setParameter(SpeechConstant.STREAM_TYPE, SPUtils.getString("stream_preference", "3"));
        // 设置播放合成音频打断音乐播放，默认为true
        mTts.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "true");

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mTts.setParameter(SpeechConstant.AUDIO_FORMAT, "pcm");
        mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH, Environment.getExternalStorageDirectory()+"/msc/tts.pcm");
    }



    /**
     * 初始语音转文字服务
     * @param context
     * @param mRecognizerListener
     * @param mInitListener
     */
    private void initIat(Context context, RecognizerDialogListener mRecognizerListener, InitListener mInitListener) {
//        mIatDialog = new RecognizerDialog(context, mInitListener);
//
//        mIatDialog.setListener(mRecognizerListener);

        mIat = SpeechRecognizer.createRecognizer(context, mInitListener);

        // 清空参数
        mIat.setParameter(SpeechConstant.PARAMS, null);

        // 设置听写引擎
        mIat.setParameter(SpeechConstant.ENGINE_TYPE, mEngineType);
        // 设置返回结果格式
        mIat.setParameter(SpeechConstant.RESULT_TYPE, "json");

        this.mTranslateEnable = SPUtils.getBoolean( CommonUtils.getString(R.string.pref_key_translate), false );
        if( mTranslateEnable ){
            Log.i( TAG, "translate enable" );
            mIat.setParameter( SpeechConstant.ASR_SCH, "1" );
            mIat.setParameter( SpeechConstant.ADD_CAP, "translate" );
            mIat.setParameter( SpeechConstant.TRS_SRC, "its" );
        }

        String lag = SPUtils.getString("iat_language_preference",
                "mandarin");
        if (lag.equals("en_us")) {
            // 设置语言
            mIat.setParameter(SpeechConstant.LANGUAGE, "en_us");
            mIat.setParameter(SpeechConstant.ACCENT, null);

            if( mTranslateEnable ){
                mIat.setParameter( SpeechConstant.ORI_LANG, "en" );
                mIat.setParameter( SpeechConstant.TRANS_LANG, "cn" );
            }
        } else {
            // 设置语言
            mIat.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
            // 设置语言区域
            mIat.setParameter(SpeechConstant.ACCENT, lag);

            if( mTranslateEnable ){
                mIat.setParameter( SpeechConstant.ORI_LANG, "cn" );
                mIat.setParameter( SpeechConstant.TRANS_LANG, "en" );
            }
        }
        //此处用于设置dialog中不显示错误码信息
        //mIat.setParameter("view_tips_plain","false");

        // 设置语音前端点:静音超时时间，即用户多长时间不说话则当做超时处理
        mIat.setParameter(SpeechConstant.VAD_BOS, SPUtils.getString("iat_vadbos_preference", "4000"));

        // 设置语音后端点:后端点静音检测时间，即用户停止说话多长时间内即认为不再输入， 自动停止录音
        mIat.setParameter(SpeechConstant.VAD_EOS, SPUtils.getString("iat_vadeos_preference", "1000"));

        // 设置标点符号,设置为"0"返回结果无标点,设置为"1"返回结果有标点
        mIat.setParameter(SpeechConstant.ASR_PTT, SPUtils.getString("iat_punc_preference", "1"));

        // 设置音频保存路径，保存音频格式支持pcm、wav，设置路径为sd卡请注意WRITE_EXTERNAL_STORAGE权限
        // 注：AUDIO_FORMAT参数语记需要更新版本才能生效
        mIat.setParameter(SpeechConstant.AUDIO_FORMAT,"wav");
        mIat.setParameter(SpeechConstant.ASR_AUDIO_PATH, Environment.getExternalStorageDirectory()+"/msc/iat.wav");
    }



    public static void startListening(RecognizerListener recognizerListener){
        if(getInstance().mIat != null){
            getInstance().mIat.startListening(recognizerListener);
        }
    }


    private int startSpeakingText(String text , SynthesizerListener synthesizerListener){
        if(null != mTts){
          return mTts.startSpeaking(text,synthesizerListener);
        }
        return -1;
    }


//    public static void showDialog(){
//        if(getInstance().mIatDialog != null) {
//            getInstance().mIatDialog.show();
//        }
//    }
//
//    public static void dismiss(){
//        if(getInstance().mIatDialog != null) {
//            getInstance().mIatDialog.dismiss();
//        }
//    }

    public static int startSpeaking(String text , SynthesizerListener synthesizerListener){
      return  getInstance().startSpeakingText(text,synthesizerListener);
    }

    public static void stopSpeaking(){
        getInstance().mTts.stopSpeaking();
        getInstance().mTts.pauseSpeaking();
    }

    public static void pauseSpeaking(){
        getInstance().mTts.pauseSpeaking();
    }

    public static void resumeSpeaking(){
        getInstance().mTts.resumeSpeaking();
    }


    public static boolean isSpeaking(){
        return getInstance().mTts.isSpeaking();
    }




    public static void destroy(){
        getInstance().onDestroy();
    }

    public void onDestroy(){
        if( null != mIat ){
            // 退出时释放连接
            mIat.cancel();
            mIat.destroy();
            mIat = null;
        }
        mVoiceHelper = null;
    }

}
