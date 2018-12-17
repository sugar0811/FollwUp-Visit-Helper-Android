package mobile.fuvh.cn.followupvisithelper.voice.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import cn.wowjoy.commonlibrary.utils.DateUtils;
import cn.wowjoy.commonlibrary.utils.ImageUtils;
import cn.wowjoy.commonlibrary.widget.SheetDialog;
import mobile.fuvh.cn.followupvisithelper.constant.AppConstants;

import static android.app.Activity.RESULT_OK;
import static mobile.fuvh.cn.followupvisithelper.constant.AppConstants.CAMERA_WITH_DATA;
import static mobile.fuvh.cn.followupvisithelper.constant.AppConstants.PHOTO_PICKED_WITH_PATH;

/**
 * Created by sugar on 2018/12/17.
 */

public class PickImageHelper {

    private static SheetDialog mTypePickDialog;
    private static String[] mBottomArray = {"拍照", "相册"};
    private static String mPhotoPath;

    public static void pickImage(Context context) {
        if (context instanceof Activity) {
            Activity context1 = (Activity) context;
            if (mTypePickDialog == null) {
                mTypePickDialog = new SheetDialog.Builder(context)
                        .addSheets(new ArrayList<>(Arrays.asList(mBottomArray)), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mTypePickDialog.dismiss();
                                mTypePickDialog = null;
                                if (i == 0) {
                                    // 选择了拍照
                                    Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                    mPhotoPath = getPhotoPath();
                                    Uri imguri = Uri.fromFile(new File(mPhotoPath));
                                    camera.putExtra(MediaStore.EXTRA_OUTPUT, imguri);
                                    context1.startActivityForResult(camera, AppConstants.CAMERA_WITH_DATA);
                                } else {
                                    // 选择了相册选择
                                    Intent intent = new Intent(Intent.ACTION_PICK);
                                    intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                                    context1.startActivityForResult(intent, AppConstants.PHOTO_PICKED_WITH_PATH);
                                }
                            }
                        }).create();

            }
            mTypePickDialog.show();
        }

    }

    private static String getPhotoPath() {
        return AppConstants.BASE_PATH_PIC + DateUtils.getCurrFullTimeDataSecond() + ".jpg";
    }

    public static File onPickResult(int requestCode, int resultCode, Intent data,Context context){
        File file = null;
        if (resultCode == RESULT_OK) {
            String photoPath = getPhotoPath();
            switch (requestCode) {
                case CAMERA_WITH_DATA:
                    File f = ImageUtils.zoomImageFile(mPhotoPath, photoPath, 720);
                    if (f != null) {
                        file = f;
                    }
                    break;
                case PHOTO_PICKED_WITH_PATH:
                    final Uri uri = data.getData();
                    if (uri != null) {
                        Log.e("压缩保存时命名",photoPath+"..");
                        file = ImageUtils.zoomBitmap(context, uri, photoPath, 720);
                    }
                    break;
                default:
                    break;
            }
        }
        return file;
    }


}
