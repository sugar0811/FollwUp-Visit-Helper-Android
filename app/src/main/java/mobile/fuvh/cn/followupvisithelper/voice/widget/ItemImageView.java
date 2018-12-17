package mobile.fuvh.cn.followupvisithelper.voice.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;

import java.io.File;

import cn.wowjoy.commonlibrary.utils.photo.PhotoViewActivity;
import mobile.fuvh.cn.followupvisithelper.R;

/**
 *
 * @author sugar
 * @date 2018/12/17
 */

public class ItemImageView extends IChatView{

    private ImageView mIvPic;
    private String mFilePath;


    public ItemImageView(@NonNull Context context) {
        this(context,null);
    }

    public ItemImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ItemImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_pick_camera,this);
        mIvPic = findViewById(R.id.ivPic);
        listener();
    }

    private void listener() {
        setOnClickListener((v)->{
            if(v.getContext() instanceof Activity){
                PhotoViewActivity.launch(v.getContext(),mFilePath);
            }
        });
    }

    public void imageByFile(File file){
        if(null != file) {
            mFilePath = file.getAbsolutePath();
            Bitmap bitmap = BitmapFactory.decodeFile(mFilePath);
            mIvPic.setImageBitmap(bitmap);
        }
    }

    @Override
    public String getTipText() {
        return "";
    }
}
