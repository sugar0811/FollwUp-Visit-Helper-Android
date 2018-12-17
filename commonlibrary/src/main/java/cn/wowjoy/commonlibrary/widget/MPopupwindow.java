package cn.wowjoy.commonlibrary.widget;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import cn.wowjoy.commonlibrary.R;
import cn.wowjoy.commonlibrary.adapter.CommonAdapter;

public class MPopupwindow extends PopupWindow {
    private RecyclerView mListRV;
    private CommonAdapter mCommonAdapter;
    private Activity mActivity;
    private int width;

    public MPopupwindow(Activity activity, CommonAdapter commonAdapter, int width, int height) {
        mCommonAdapter = commonAdapter;
        mActivity = activity;
        this.width = width;
        mListRV = (RecyclerView) LayoutInflater.from(mActivity).inflate(R.layout.layout_popup, null, false);
        setContentView(mListRV);
        setWidth(width);
        setHeight(height);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0x00000000));
        update();
        mListRV.setLayoutManager(new LinearLayoutManager(activity));
        mListRV.setAdapter(mCommonAdapter);

        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
                lp.alpha = 1f;
                mActivity.getWindow().setAttributes(lp);
            }
        });
    }

    public void show(View deptTV) {
        WindowManager.LayoutParams lp = mActivity.getWindow().getAttributes();
        lp.alpha = 0.7f;
        mActivity.getWindow().setAttributes(lp);
        showAsDropDown(deptTV, -width / 4, 0);
    }
}
