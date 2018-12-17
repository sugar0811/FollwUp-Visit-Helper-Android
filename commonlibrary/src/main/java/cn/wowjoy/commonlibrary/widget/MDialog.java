package cn.wowjoy.commonlibrary.widget;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import cn.wowjoy.commonlibrary.R;
import cn.wowjoy.commonlibrary.adapter.DialogListAdapter;


public class MDialog extends Dialog {
    private String mBottonL;
    private String mBottonR;
    private View.OnClickListener mCancleClickListener;
    private View.OnClickListener mConfirmClickListener;
    private String mHintStr;
    private interfaceEdit mInterfaceEdit;

    public enum DG_TYPE {
        LOAD, BOTTOMLIST, ALERT, INPUT
    }

    private Activity mActivity;
    private DG_TYPE type;
    private List<String> mData;
    private RecyclerView mBottomListRV;
    private DialogListAdapter.OnItemClickListener mItemClickListener = null;

    public MDialog(Activity activity, int theme) {
        super(activity, theme);
        type = DG_TYPE.LOAD;
        mActivity = activity;
    }

    public MDialog(Activity activity, int theme, List<String> data, DialogListAdapter.OnItemClickListener itemClickListener) {
        super(activity, theme);
        type = DG_TYPE.BOTTOMLIST;
        mData = data;
        mActivity = activity;
        mItemClickListener = itemClickListener;
    }

    public MDialog(Activity activity, int theme, String hint, String BottonL, String BottonR, View.OnClickListener cancelBtnClickListener, View.OnClickListener confirmBtnClickListener) {
        super(activity, theme);
        type = DG_TYPE.ALERT;
        mActivity = activity;
        mHintStr = hint;
        mBottonL = BottonL;
        mBottonR = BottonR;
        mCancleClickListener = cancelBtnClickListener;
        mConfirmClickListener = confirmBtnClickListener;
    }

    public MDialog(Activity activity, int theme, String hint, DG_TYPE type) {
        super(activity, theme);
        this.type = type;
        mActivity = activity;
        mHintStr = hint;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (type == DG_TYPE.LOAD) {
            setContentView(R.layout.dialog_waiting);
        } else if (type == DG_TYPE.BOTTOMLIST) {
            RecyclerView root = (RecyclerView) LayoutInflater.from(mActivity).inflate(R.layout.dialog_pop_bottom, null);
            setContentView(root);
            mBottomListRV = findViewById(R.id.dataRV);
            mBottomListRV.setLayoutManager(new LinearLayoutManager(mActivity));
            DialogListAdapter mDialogListAdapter = new DialogListAdapter(mActivity, mData);
            mDialogListAdapter.setOnItemClickListener(mItemClickListener);
            mBottomListRV.setAdapter(mDialogListAdapter);

            Window dialogWindow = getWindow();
            dialogWindow.setGravity(Gravity.BOTTOM);
            dialogWindow.setWindowAnimations(R.style.popupAnimation);
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = mActivity.getResources().getDisplayMetrics().widthPixels;
            root.measure(0, 0);
            lp.height = root.getMeasuredHeight();
            dialogWindow.setAttributes(lp);
        } else if (type == DG_TYPE.ALERT) {
            setContentView(R.layout.dialog_alert);
            ((TextView) findViewById(R.id.alert_dialog_message)).setText(mHintStr);
            ((Button) findViewById(R.id.alert_dialog_cancel_btn)).setText(mBottonL);
            if (TextUtils.isEmpty(mBottonL))
                ((Button) findViewById(R.id.alert_dialog_cancel_btn)).setVisibility(View.GONE);
            ((Button) findViewById(R.id.alert_dialog_confirm_btn)).setText(mBottonR);
            findViewById(R.id.alert_dialog_cancel_btn).setOnClickListener(mCancleClickListener);
            findViewById(R.id.alert_dialog_confirm_btn).setOnClickListener(mConfirmClickListener);
        } else if (type == DG_TYPE.INPUT) {
            setContentView(R.layout.dialog_input);
            ((EditText) findViewById(R.id.alert_dialog_message)).setText(mHintStr);
            findViewById(R.id.alert_dialog_cancel_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cancel();
                }
            });
            findViewById(R.id.alert_dialog_confirm_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mInterfaceEdit != null)
                        mInterfaceEdit.Receive(((EditText) findViewById(R.id.alert_dialog_message)).getText().toString());
                    cancel();
                }
            });
        }
    }

    public interface interfaceEdit {
        void Receive(String message);
    }

    public void setMsgCallback(interfaceEdit callback) {
        this.mInterfaceEdit = callback;
    }
}
