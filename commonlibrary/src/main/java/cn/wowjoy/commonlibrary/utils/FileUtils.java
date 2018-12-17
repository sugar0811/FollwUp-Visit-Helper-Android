package cn.wowjoy.commonlibrary.utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;

import okhttp3.ResponseBody;

public class FileUtils {
    /**
     * 限制图片最大宽度进行压缩
     */
    private static final int MAX_WIDTH = 720;
    /**
     * 限制图片最大高度进行压缩
     */
    private static final int MAX_HEIGHT = 1280;
    /**
     * 上传最大图片限制
     */
    private static final int MAX_UPLOAD_PHOTO_SIZE = 300 * 1024;
    public static boolean writeResponseBodyToDisk(ResponseBody body, String file) {
        try {
            File futureStudioIconFile = new File(file);

            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(futureStudioIconFile);

                while (true) {
                    int read = inputStream.read(fileReader);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(fileReader, 0, read);
                    fileSizeDownloaded += read;
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            return false;
        }
    }

    public static byte[] fileToStream(File file) {
        FileInputStream fs = null;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        try {
            fs = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len = 0;
            while (-1 != (len = fs.read(buffer))) {
                outStream.write(buffer, 0, len);
            }
            outStream.close();
            fs.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outStream.toByteArray();
    }

    public static File streamToFile(InputStream ins, String path) {
        File file = new File(path);
        OutputStream os = null;
        try {
            if (!file.exists()){
                file.createNewFile();

            }
            os = new FileOutputStream(file);
            int len = 0;
            byte[] buffer = new byte[1024*1024*5];
            while (-1 != (len = ins.read(buffer))) {
                os.write(buffer, 0, len);
            }
           // Log.e("cxdddadasa", file.length() + "文件创建文件成功");
            os.close();
            ins.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
    public static String getChoosePicture(Context context,Uri selectedImage ){
        String[] filePathColumns = {MediaStore.Images.Media.DATA};
        Cursor c = context.getContentResolver().query(selectedImage, filePathColumns, null, null, null);
        c.moveToFirst();
        int columnIndex = c.getColumnIndex(filePathColumns[0]);
        String imagePath = c.getString(columnIndex);
        c.close();
        return imagePath;
    }
    /**
     * 保存拍摄图片
     *
     * @param photoPath
     * @param bitmap
     * @return
     */
    public static File savePhoto(String photoPath,Bitmap bitmap) {
        if (bitmap==null){
            bitmap = BitmapFactory.decodeFile(photoPath);
        }
        if (photoPath != null) {
            File file = new File(photoPath);
            FileOutputStream fos = null;
            try {
                Bitmap preBitmap = compressBitmap(compressBitmapToBytes(bitmap,MAX_UPLOAD_PHOTO_SIZE), MAX_WIDTH, MAX_HEIGHT);
                Bitmap roBm = rotationBitmap(preBitmap);
                byte[] newDatas = compressBitmapToBytes(roBm, MAX_UPLOAD_PHOTO_SIZE);
                fos = new FileOutputStream(photoPath);
                fos.write(newDatas);
                return file;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeCloseable(fos);
            }
        }
        return null;
    }
    /**
     * 三星手机适配
     *
     * @param bitmap
     * @return
     */
    private static Bitmap rotationBitmap(Bitmap bitmap) {
        String model = Build.MODEL;
        if (model.startsWith("SM-") || model.startsWith("GT-")) {
            Matrix matrix = new Matrix();
            matrix.postRotate(90);
            Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0,
                    bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return resizedBitmap;
        } else {
            return bitmap;
        }
    }

    /**
     * 把字节流按照图片方式大小进行压缩
     * @param datas
     * @param w
     * @param h
     * @return
     */
    public static Bitmap compressBitmap(byte[] datas, int w, int h) {
        if (datas != null) {
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inJustDecodeBounds  = true;
            BitmapFactory.decodeByteArray(datas, 0, datas.length, opts);
            if (opts.outWidth != 0 && opts.outHeight != 0) {
                int scaleX = opts.outWidth / w;
                int scaleY = opts.outHeight / h;
                int scale = 1;
                if (scaleX >= scaleY && scaleX >= 1) {
                    scale = scaleX;
                }
                if (scaleX < scaleY && scaleY >= 1) {
                    scale = scaleY;
                }
                opts.inJustDecodeBounds = false;
                opts.inSampleSize = scale;
                return BitmapFactory.decodeByteArray(datas, 0, datas.length, opts);
            }
        }
        return null;
    }
    /**
     * 质量压缩图片
     *
     * @param bitmap
     * @param maxSize
     * @return
     */
    public static byte[] compressBitmapToBytes(Bitmap bitmap, int maxSize) {
        if (bitmap == null) return null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] datas = baos.toByteArray();
        int options = 80;
        int longs = datas.length;
        while (longs > maxSize && options > 0) {
            baos.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, options, baos);
            datas = baos.toByteArray();
            longs = datas.length;
            Log.e("compressBitmapToBytes",datas.length /1024 +"KB");
//            Log.e("compressBitmapToBytes",)
            options -= 20;
        }
        return datas;
    }
    /**
     * 关闭资源
     *
     * @param close
     */
    public static void closeCloseable(Closeable close) {
        if (close != null) {
            try {
                close.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 统一录音保存路径
     *
     * @param context 上下文本
     */
    public static String getVoiceFilePath(Context context) {
        return createFile(getExternalPath(context, "/follow/voice"));
    }

    /**
     * 判断文件夹是否存在并创建文件
     *
     * @param path 文件路径
     */
    public static String createFile(String path) {
        File file = new File(path);
        //判断文件夹是否存在,如果不存在则创建文件夹
        if (!file.exists()) {
            file.mkdirs();
        }
        Log.e("sdnkwdnwkw", path + "---------------" + file.exists());
        return path;
    }

    /**
     * 获取app缓存路径
     *
     * @param path    保存路径
     * @param context
     * @return
     */
    public static String getExternalPath(Context context, String path) {
        String mPath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            //外部存储可用
            mPath = Environment.getExternalStorageDirectory().getPath() + path;
        } else {
            //外部存储不可用
            mPath = context.getCacheDir().getPath() + path;
        }
        return mPath;
    }

    /**
     * 获取文件名字
     */
    public static String getVoiceName() {
        String name =   DateUtils.getCurrFullTimeData() + ".wav";
        return name;
    }
    public static boolean isSdCardExist() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
    public static String getFileSize(Number fileSize) {
        NumberFormat ddf1 = NumberFormat.getNumberInstance();
        //保留小数点后两位
        ddf1.setMaximumFractionDigits(2);
        double size = fileSize.doubleValue();
        String sizeDisplay;
        if (size> 1048576.0) {
            double result = size / 1048576.0;
            sizeDisplay = ddf1.format(result) + " MB";
        } else if (size > 1024) {
            double result = size/ 1024;
            sizeDisplay = ddf1.format(result) + " KB";

        } else {
            sizeDisplay = ddf1.format(size) + " B";
        }
        return sizeDisplay;
    }
}
