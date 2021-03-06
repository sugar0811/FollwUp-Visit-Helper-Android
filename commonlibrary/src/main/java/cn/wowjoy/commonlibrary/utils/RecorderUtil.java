package cn.wowjoy.commonlibrary.utils;

import android.media.MediaRecorder;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import cn.wowjoy.commonlibrary.app.BaseApplication;

/**
 * 作者： wh
 * 时间： 2018/7/23
 * 名称：录制音频
 * 附加注释：
 * 主要接口：
 */

public class RecorderUtil {
    private static final String TAG = "RecorderUtil";
    /**
     * 文件的姓名
     */
    private String mFileName = null;
    /**
     * 录音
     */
    private MediaRecorder mRecorder = null;
    /**
     * 开始时间
     */
    private long startTime;
    /**
     * 最短时间间隔
     */
    private long timeInterval;
    /**
     * 是否正在录音
     */
    private boolean isRecording;
    /**
     * 上下文本
     */
    private String basePath;

    public RecorderUtil() {
        basePath = FileUtils.getVoiceFilePath(BaseApplication.getInstance());

    }



    /**
     * 开始录音
     */
    public void startRecording() {
        mFileName = basePath + "/" + FileUtils.getVoiceName();
        Log.e("xsasasasas", "startRecording-------" + mFileName);
        if (isRecording) {
            mRecorder.release();
            mRecorder = null;
        }
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        startTime = System.currentTimeMillis();
        try {
            mRecorder.prepare();
            mRecorder.start();
            isRecording = true;
        } catch (Exception e) {
            Log.e(TAG, "prepare() failed");
        }
    }

    public boolean isRecording(){
        return isRecording;
    }

    @NonNull
    public String getFilePathStr() {
        return basePath + "/" + FileUtils.getVoiceName();
    }


    /**
     * 停止录音
     */
    public long stopRecording() {
        if (mFileName == null) return 0;
        if (mRecorder == null) return 0;
        timeInterval = System.currentTimeMillis() - startTime;
        try {
            mRecorder.stop();
            mRecorder.release();
            mRecorder = null;
            isRecording = false;
        } catch (Exception e) {
            Log.e(TAG, "release() failed");
        }
        if (timeInterval < 1000) {
            File file = new File(mFileName);
            file.deleteOnExit();
        }
        Log.e("xsasasasas", "stopRecording-------" + timeInterval);
        return timeInterval;
    }

    /**
     * 取消语音
     */
    public synchronized void cancelRecording() {
        if (mRecorder != null) {
            try {
                mRecorder.release();
                mRecorder = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            File file = new File(mFileName);
            file.deleteOnExit();
        }
        isRecording = false;
    }


    /**
     * 获取录音文件
     */
    public byte[] getData() {
        if (mFileName == null) return null;
        try {
            return readFile(new File(mFileName));
        } catch (IOException e) {
            Log.e(TAG, "read file error" + e);
            return null;
        }
    }

    /**
     * 获取录音文件地址
     */
    public String getFilePath() {
        return mFileName;
    }

    /**
     * 获取录音时长,单位秒
     */
    public long getTimeInterval() {
        return timeInterval;
    }

    public long getTimeBetween() {
        return System.currentTimeMillis() - startTime;
    }

    /**
     * 将文件转化为byte[]
     *
     * @param file 输入文件
     */
    public static byte[] readFile(File file) throws IOException {
        // Open file
        RandomAccessFile f = new RandomAccessFile(file, "r");
        try {
            // Get and check length
            long longlength = f.length();
            int length = (int) longlength;
            if (length != longlength)
                throw new IOException("File size >= 2 GB");
            // Read file and return data
            byte[] data = new byte[length];
            f.readFully(data);
            return data;
        } finally {
            f.close();
        }
    }



}