package cn.wowjoy.commonlibrary.utils;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import cn.bingoogolapple.badgeview.BGABadgeImageView;
import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import cn.wowjoy.commonlibrary.adapter.LayoutManagers;
import cn.wowjoy.commonlibrary.viewmodel.BaseListViewModel;

public class BindingAdapters {


    /***
     * 显示图片
     * @param image
     * @param imageRes
     */
    @BindingAdapter({"picRes"})
    public static void loadImageByRes(ImageView image, int imageRes) {
        image.setImageResource(imageRes);
    }


    @BindingAdapter({"imageBase64", "imageDef"})
    public static void loadBase64Image(ImageView image, String imageRes, Drawable imageDef) {
        if (!TextUtils.isEmpty(imageRes)) {
            image.setImageBitmap(ImageUtils.base64toBitmap(imageRes));
        } else {
            image.setImageDrawable(imageDef);
        }
    }

    /***
     * 显示图片
     * @param image
     * @param imageRes
     */
    @BindingAdapter({"imageRes", "imageDef"})
    public static void loadImage(ImageView image, Object imageRes, Drawable imageDef) {
        if (imageRes instanceof String) {
            String url = (String) imageRes;
            ImageLoadUtil.showImage(image, url, imageDef);
        } else if (imageRes instanceof Integer) {
            int resId = (int) imageRes;
            image.setImageResource(resId);
        } else {
            image.setImageDrawable(imageDef);
        }
    }


    @BindingAdapter({"imageResBGA", "imageBGADef"})
    public static void loadBGAImage(ImageView image, Object imageResBGA, Drawable imageBGADef) {
        BGABadgeImageView view = (BGABadgeImageView) image;
        if (imageResBGA instanceof String) {
            String url = (String) imageResBGA;
            ImageLoadUtil.showImage(view, url, imageBGADef);
        } else if (imageResBGA instanceof Integer) {
            int resId = (int) imageResBGA;
            view.setImageResource(resId);
        } else {
            view.setImageDrawable(imageBGADef);
        }
    }

    /***
     * 为recyclerView设置adapter,继承模式
     * @param baseListViewModel
     * @param <T>
     */
    @SuppressWarnings("unchecked")
    @BindingAdapter("adapter")
    public static <T> void setAdapter(RecyclerView recyclerView, BaseListViewModel baseListViewModel) {
        CommonAdapter oldAdapter = (CommonAdapter) recyclerView.getAdapter();
        CommonAdapter adapter = baseListViewModel.getAdapter();
        ObservableArrayList items = baseListViewModel.getItems();
        if (adapter == null) {
            if (oldAdapter == null) {
                adapter = new CommonAdapter(baseListViewModel.getLayoutId(), items) {
                };
            } else {
                adapter = oldAdapter;
            }
        }
        adapter.setItems(items);
        adapter.setOnItemClickListener(baseListViewModel.getOnItemClickListener());
        if (oldAdapter != adapter) {
            recyclerView.setAdapter(adapter);
        }
    }

    /***
     * 设置layoutManager
     * @param recyclerView
     * @param layoutManagerFactory
     */
    @BindingAdapter("layoutManager")
    public static void setLayoutManager(RecyclerView recyclerView, LayoutManagers.LayoutManagerFactory layoutManagerFactory) {
        recyclerView.setLayoutManager(layoutManagerFactory.create(recyclerView));
    }


    /**
     * 显示需要验证的图片
     *
     * @param imageUri
     * @param token
     */
    @BindingAdapter(value = {"imageUri", "token"}, requireAll = false)
    public static void showTokenImage(ImageView imageView, String imageUri, String token) {
        ImageLoadUtil.showTokenImage(imageView, imageUri, token);
    }


    @BindingAdapter("scope")
    public static void setScope(TextView textView, int scope) {
        if (scope == 1) {
            textView.setText("个人");
        } else if (scope == 2) {
            textView.setText("科室");
        } else if (scope == 3) {
            textView.setText("全院");
        }
    }

    /***
     * 根据文件路径显示图片
     * @param image
     * @param path
     */
    @BindingAdapter({"picPath"})
    public static void loadImageByFile(ImageView image, String path) {
            File file = new File(path);
            Log.e("path",path+"...");
            if (file.exists()) {
                Bitmap bitmap = BitmapFactory.decodeFile(path);
                image.setImageBitmap(bitmap);
            }

    }

  /*  @BindingAdapter({"typeCode"})
    public static void getTypeName(TextView textView, int typeCode) {
        String typeName = "";
        if (typeCode == 1) {
            typeName = "iMDT";
        } else if (typeCode == 2) {
            typeName = "预约挂号";
        } else if (typeCode == 3) {
            typeName = "预约检查";
        } else if (typeCode == 4) {
            typeName = "预约床位";
        }
        textView.setText(typeName);
    }*/


}
