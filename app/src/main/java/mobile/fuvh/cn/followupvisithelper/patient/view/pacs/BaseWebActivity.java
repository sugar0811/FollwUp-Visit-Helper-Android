package mobile.fuvh.cn.followupvisithelper.patient.view.pacs;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.IAgentWebSettings;

import cn.wowjoy.commonlibrary.app.Constans;
import cn.wowjoy.commonlibrary.base.BaseActivity;
import cn.wowjoy.commonlibrary.utils.SPUtils;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.patient.view.report.chart.widget.WebLayout;

/**
 * Created by cenxiaozhong on 2017/5/26.
 * <p>
 * source CODE  https://github.com/Justson/AgentWeb
 * <p>
 * <p>
 */

public abstract class BaseWebActivity extends BaseActivity {


    protected AgentWeb mAgentWeb;
    private LinearLayout mLinearLayout;
    private Toolbar mToolbar;
    private TextView mTitleTextView;
    private AlertDialog mAlertDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.patient_report_pacs_activity;
    }

    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        mLinearLayout = (LinearLayout) this.findViewById(R.id.container);
        mToolbar = (Toolbar) this.findViewById(R.id.toolbar);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle(setTitle());
        mTitleTextView = (TextView) this.findViewById(R.id.toolbar_title);
        this.setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                showDialog();
                BaseWebActivity.this.finish();
            }
        });


        long p = System.currentTimeMillis();
        mAgentWeb = AgentWeb.with(this)//
                .setAgentWebParent(mLinearLayout, new LinearLayout.LayoutParams(-1, -1))//
                .useDefaultIndicator()
                .setAgentWebWebSettings(getSettings())
//                .defaultProgressBarColor()
//                .setReceivedTitleCallback(mCallback)
                .additionalHttpHeader("Authorization", "Bearer " + SPUtils.getString(Constans.GATEWAY_TOKEN, ""))
                .setWebChromeClient(mWebChromeClient)
                .setWebViewClient(mWebViewClient)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .setWebLayout(new WebLayout(this))
                .createAgentWeb()
                .ready()
                .go(getUrl());
        //mAgentWeb.getLoader().loadUrl(getUrl());
        long n = System.currentTimeMillis();
        Log.i("Info", "init used time:" + (n - p));


    }

    protected IAgentWebSettings getSettings() {
        return null;
    }

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
            Log.i("Info", "BaseWebActivity onPageStarted");
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);

        }
    };
    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //do you work
//            Log.i("Info","progress:"+newProgress);
        }

    };

   public abstract String getUrl();

    public abstract String setTitle();


//    private ChromeClientCallbackManager.ReceivedTitleCallback mCallback = new ChromeClientCallbackManager.ReceivedTitleCallback() {
//        @Override
//        public void onReceivedTitle(WebView view, String title) {
//            if (mTitleTextView != null)
//                mTitleTextView.setText(title);
//        }
//    };


    private void showDialog() {

        if (mAlertDialog == null)
            mAlertDialog = new AlertDialog.Builder(this)
                    .setMessage("您确定要关闭该页面吗?")
                    .setNegativeButton("再逛逛", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (mAlertDialog != null)
                                mAlertDialog.dismiss();
                        }
                    })//
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            if (mAlertDialog != null)
                                mAlertDialog.dismiss();

                            BaseWebActivity.this.finish();
                        }
                    }).create();
        mAlertDialog.show();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.i("Info", "result:" + requestCode + " result:" + resultCode);
//        mAgentWeb.uploadFileResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //mAgentWeb.destroy();
        mAgentWeb.getWebLifeCycle().onDestroy();
    }
}
