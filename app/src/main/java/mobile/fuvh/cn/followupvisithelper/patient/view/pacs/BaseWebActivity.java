package mobile.fuvh.cn.followupvisithelper.patient.view.pacs;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.graphics.Bitmap;
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

import com.just.agentweb.AgentWeb;
import com.just.agentweb.IAgentWebSettings;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.common.Constant;

import cn.wowjoy.commonlibrary.base.BaseActivity;
import cn.wowjoy.commonlibrary.utils.ToastUtils;
import cn.wowjoy.commonlibrary.widget.titlebar.TitleBar;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.patient.view.report.chart.widget.WebLayout;

import static mobile.fuvh.cn.followupvisithelper.main.MainActivity.REQUEST_CODE_SCAN;

/**
 * Created by cenxiaozhong on 2017/5/26.
 * <p>
 * source CODE  https://github.com/Justson/AgentWeb
 * <p>
 * <p>
 */

public abstract class BaseWebActivity<DB extends ViewDataBinding, VM extends ViewModel> extends BaseActivity<DB,VM> {

    public static String PACS_TAG = "影像登录";
    protected AgentWeb mAgentWeb;
    private LinearLayout mLinearLayout;
    private Toolbar mToolbar;
//    private TextView mTitleTextView;
    private AlertDialog mAlertDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.patient_report_pacs_activity;
    }

    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        mLinearLayout = (LinearLayout) this.findViewById(R.id.container);
//        mTitleTextView = (TextView) this.findViewById(R.id.toolbar_title);
        TitleBar titleBar = this.findViewById(R.id.tbTitle);
        titleBar.setTitle("查看影像");
        titleBar.setLeftBack(this);
        titleBar.addAction(new TitleBar.ImageAction(R.drawable.scan) {
            @Override
            public void performAction(View view) {
                Intent intent = new Intent(BaseWebActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SCAN);
            }
        });
        long p = System.currentTimeMillis();
        mAgentWeb = AgentWeb.with(this)//
                .setAgentWebParent(mLinearLayout, new LinearLayout.LayoutParams(-1, -1))//
                .useDefaultIndicator()
                .setAgentWebWebSettings(getSettings())
//                .defaultProgressBarColor()
//                .setReceivedTitleCallback(mCallback)
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
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);
                showTip("扫描结果为：" + content);
                if(PACS_TAG.equals(content)){
                // 调接口
//                    PacsLoginHelper.postPacsState();
                    PacsLoginActivity.launch(this);
                }
                return;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    protected void showTip(String str) {
        ToastUtils.showSingleToast(this, str);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //mAgentWeb.destroy();
        mAgentWeb.getWebLifeCycle().onDestroy();
    }
}
