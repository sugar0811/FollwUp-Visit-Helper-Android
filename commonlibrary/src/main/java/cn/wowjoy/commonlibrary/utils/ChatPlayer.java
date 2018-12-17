package cn.wowjoy.commonlibrary.utils;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;

import java.io.IOException;

/**
 * 作者： wh
 * 时间： 2018/7/24
 * 名称：录音播放类
 * 附加注释：
 * 主要接口：
 */


public class ChatPlayer {
    private static final String TAG = ChatPlayer.class.getSimpleName();
    private static final int MSG_WHAT_PLAY = 1000;
    private static ChatPlayer mChatPlayer = null;
    private MediaPlayer mPlayer = null;
    private String path = "";
    private Handler mHandler = null;
    private ChatPlayer() {
        mPlayer = new MediaPlayer();
    }

    public static ChatPlayer getInstance() {
        if (mChatPlayer == null) {
            synchronized (ChatPlayer.class) {
                if (mChatPlayer == null) {
                    mChatPlayer = new ChatPlayer();
                }
            }
        }
        return mChatPlayer;
    }

    public void setup(String path) {
        if (mPlayer == null) {
            return;
        }
        Log.e("ndwndkwdnmwkl",path);
        try {
            mPlayer.reset();
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mPlayer.setDataSource(path);
            mPlayer.prepare();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void play() {
        if (mPlayer == null) {
            return;
        }
        if (mPlayer.isPlaying()) {
            mPlayer.stop();
        } else {
            mPlayer.start();
        }
    }

    public long getDuration() {
        long duration = 0;
        if (mPlayer != null) {
            duration = mPlayer.getDuration();
        }
        return duration;
    }

    public boolean isPlaying() {
        if (mPlayer == null) {
            return false;
        }
        return mPlayer.isPlaying();
    }

    public void stop() {
        if (mPlayer != null) {
            mPlayer.stop();
        }
    }
    public void release() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }
}
