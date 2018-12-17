package cn.wowjoy.commonlibrary.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import cn.wowjoy.commonlibrary.R;


/**
 * Created by sugar on 2018/3/14.
 */

public class ImageLoadUtil {

    /**
     * 显示普通图片
     *
     * @param imageView
     * @param url
     */
    public static void showImage(ImageView imageView, String url, Drawable defaultImg) {
        Glide.with(imageView.getContext())
                .load(url)
                .crossFade(500)
                .placeholder(defaultImg)
                .error(defaultImg)
                .into(imageView);

    }


    /**
     * 显示需要验证的图片
     *
     * @param imageUrl
     * @param token
     */
    public static void showTokenImage(ImageView imageView, String imageUrl, String token) {
        GlideUrl glideUrl = new GlideUrl(imageUrl, new LazyHeaders.Builder()
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("Authorization", token)
                .build());
        Glide.with(imageView.getContext())
                .load(glideUrl)
                .centerCrop()
                .crossFade()
                .error(R.drawable.big_default)
                .placeholder(R.drawable.big_default)
                .into(imageView);
    }


}
