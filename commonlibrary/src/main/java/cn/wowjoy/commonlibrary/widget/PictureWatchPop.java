package cn.wowjoy.commonlibrary.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.github.chrisbanes.photoview.PhotoView;

import java.io.File;

import cn.wowjoy.commonlibrary.R;

/**
 * 作者： wh
 * 时间： 2018/7/26
 * 名称：查看图片对话框
 * 附加注释：
 * 主要接口：
 */


public class PictureWatchPop extends PopupWindow {
    /**
     * 查看图片
     */
    private PhotoView mPhotoView;
    private ImageView ivCancel;
    private View contentView;
    private Context context;

    public PictureWatchPop(Context context) {
        this.context = context;
        init();
    }

    /**
     * 初始化popwindow各项参数
     */
    public void init() {
        initView();
        //设置SignPopupWindow的View
        this.setContentView(contentView);
        //设置SignPopupWindow弹出窗体的高
        this.setHeight(WindowManager.LayoutParams.MATCH_PARENT);
        //设置SignPopupWindow弹出窗体的宽
        this.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        //设置SignPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setTouchable(true);
        this.setOutsideTouchable(true);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        //设置SignPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        //防止虚拟软键盘被弹出菜单遮住
        this.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

    }

    private void initView() {
        contentView = LayoutInflater.from(context).inflate(R.layout.dialog_picture_watch, null);
        mPhotoView = contentView.findViewById(R.id.photoView);
        ivCancel = contentView.findViewById(R.id.cancelIV);
        ivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    public void setPhotoView(File file) {
        Log.e("sasassas", file.getName() + "----");
        Bitmap bitmap = BitmapFactory.decodeFile(file.getPath());
        //  Log.e("sasassas",bitmap.getHeight()+"----");
        mPhotoView.setImageBitmap(bitmap);
    }
}
