package cn.wowjoy.commonlibrary.utils.photo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import cn.wowjoy.commonlibrary.R;
import cn.wowjoy.commonlibrary.base.BaseActivity;
import cn.wowjoy.commonlibrary.databinding.PhotoActivityBinding;
import cn.wowjoy.commonlibrary.utils.StatusBarUtil;

/**
 *
 * @author sugar
 * @date 2018/9/20
 */

public class PhotoViewActivity extends BaseActivity<PhotoActivityBinding,PhotoViewModel>{


    public static String PHOTO_PATH = "photo_path";

    public static void launch(Context context,String path){
        Intent intent = new Intent(context, PhotoViewActivity.class);
        intent.putExtra(PHOTO_PATH,path);
        context.startActivity(intent);
    }


    @Override
    protected void init(Bundle savedInstanceState) {
        StatusBarUtil.setTranslucent(this);
        String imagePath = getIntent().getStringExtra(PHOTO_PATH);
        if(!TextUtils.isEmpty(imagePath)){
            initView();
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            binding.photoView.setImageBitmap(bitmap);

        }
    }

    private void initView() {
        binding.photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.photo_activity;
    }

    @Override
    protected Class<PhotoViewModel> getViewModelClass() {
        return PhotoViewModel.class;
    }
}
