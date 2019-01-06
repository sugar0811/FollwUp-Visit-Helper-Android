package mobile.fuvh.cn.followupvisithelper.constant;

import android.os.Environment;

/**
 *
 * @author sugar
 * @date 2018/11/29
 */

public interface AppConstants {

    String VOICE_RECOGNIZE = "iat_recognize";

    String VOICE_TTS_PLAY = "tts_play";
    String SURGERY_BEAN = "surgery_bean";
    String DOCTOR_ADVICE_BEAN = "doctor_advice_bean";

    int ADVICECHOOSE_A = 1000;
    int ADVICECHOOSE_I = 1001;
    int ADVICECHOOSE_S = 1002;
    int ADVICECHOOSE_W = 1003;
    public static final int PHOTO_PICKED_WITH_PATH = 3022;
    public static final int CAMERA_WITH_DATA = 3023;
    String RECORD_DURATION = "record_duration";
    String REPORT_TYPE = "report_type";
    String REPORT_EXAM_BEAN = "report_exam_bean";
    String REPORT_TEST_BEAN = "report_test_bean";
    String BASE_PATH_PIC = Environment.getExternalStorageDirectory().getPath() + "/follow/pic/";
    int RECORD_DONE_SEND = 1004;
}
