package cn.wowjoy.commonlibrary.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;

import java.util.List;

import cn.wowjoy.commonlibrary.R;
import cn.wowjoy.commonlibrary.adapter.DialogListAdapter;
import cn.wowjoy.commonlibrary.widget.MDialog;


public class DialogUtils {
    static MDialog waitDialog;

    static public MDialog waitingDialog(final Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        if (waitDialog == null)
            waitDialog = new MDialog(activity, R.style.dialog_no_bg);
        waitDialog.setCanceledOnTouchOutside(false);
        waitDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (waitDialog != null) {
                    waitDialog.cancel();
                    waitDialog = null;
                }
            }
        });
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (!waitDialog.isShowing() && !activity.isFinishing())
                    waitDialog.show();
            }
        });

        return waitDialog;
    }

    public static void dismiss(Activity activity) {
        if (activity != null && !activity.isFinishing() && waitDialog != null && waitDialog.isShowing()) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    waitDialog.cancel();
                    waitDialog = null;
                }
            });
        }
    }

    static public MDialog alertDialog(Activity activity, String hint, String bottonL, String bottonR, View.OnClickListener cancelBtnClickListener, View.OnClickListener confirmBtnClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }

        MDialog alertDialog = new MDialog(activity, R.style.dialog_bg, hint, bottonL, bottonR, cancelBtnClickListener, confirmBtnClickListener);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(true);
        alertDialog.show();
        return alertDialog;
    }

    static public MDialog BottomListDialog(Activity activity, List<String> data, DialogListAdapter.OnItemClickListener itemClickListener) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }

        MDialog alertDialog = new MDialog(activity, R.style.dialog_bg, data, itemClickListener);
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.setCancelable(true);
        alertDialog.show();
        return alertDialog;
    }


    static public MDialog inputDialog(Activity activity, String s) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }

        MDialog alertDialog = new MDialog(activity, R.style.dialog_bg, s, MDialog.DG_TYPE.INPUT);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(true);
        alertDialog.show();
        return alertDialog;
    }

}

