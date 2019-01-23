package mobile.fuvh.cn.followupvisithelper.helper;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import cn.wowjoy.commonlibrary.utils.ScreenUtils;
import mobile.fuvh.cn.followupvisithelper.R;

/**
 *
 * @author sugar
 * @date 2018/3/13
 *
 */

public class AppDialogHelper {

    public static Dialog showShareDialog(Context context, View.OnClickListener listener) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_share, null);
        inflate.findViewById(R.id.ll_wechat).setOnClickListener(listener);
        inflate.findViewById(R.id.tv_cancel).setOnClickListener(listener);
        inflate.findViewById(R.id.llDoctor).setOnClickListener(listener);
        Dialog dialog = new Dialog(context, R.style.ActionSheetDialogStyle);
        //填充对话框的布局
        dialog.setContentView(inflate);
        Window dialogWindow = dialog.getWindow();
        //设置Dialog从窗体底部弹出
        dialogWindow.setGravity(Gravity.BOTTOM);
        //获得窗体的属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//        lp.y = 20;//设置Dialog距离底部的距离
        lp.width = ScreenUtils.getScreenWidth(context);
        //将属性设置给窗体
        dialogWindow.setAttributes(lp);
        dialog.show();//显示对话框
        return dialog;

    }


}
