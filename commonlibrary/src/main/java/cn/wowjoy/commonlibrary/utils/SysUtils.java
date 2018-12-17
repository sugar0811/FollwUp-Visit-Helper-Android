package cn.wowjoy.commonlibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.io.File;

import cn.wowjoy.commonlibrary.app.BaseApplication;

public class SysUtils {

    public static int getVersionName() {
        int version = 0;
        try {
            PackageManager packageManager = BaseApplication.getInstance().getPackageManager();
            PackageInfo packInfo = packageManager.getPackageInfo(BaseApplication.getInstance().getPackageName(), 0);
            version = packInfo.versionCode;
        } catch (Exception e) {
        }
        return version;
    }

    public static void installApk(Context context, String fileName) {
//        if (Build.VERSION.SDK_INT >= 24) {
//            File file = new File(fileName);
//            Uri apkUri = FileProvider.getUriForFile(context, "cn.wowjoy.doc_host.fileprovider", file);
//            Intent install = new Intent(Intent.ACTION_VIEW);
//            install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            install.setDataAndType(apkUri, "application/vnd.android.package-archive");
//            context.startActivity(install);
//        } else {
            File fileLocation = new File(fileName);
            Intent install = new Intent(Intent.ACTION_VIEW);
            install.addCategory("android.intent.category.DEFAULT");
            install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setDataAndType(Uri.fromFile(fileLocation), "application/vnd.android.package-archive");
            context.startActivity(install);
//        }
    }
}
