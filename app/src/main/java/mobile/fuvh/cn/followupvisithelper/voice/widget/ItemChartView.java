package mobile.fuvh.cn.followupvisithelper.voice.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.IAgentWebSettings;

import cn.wowjoy.commonlibrary.utils.CommonUtils;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.patient.view.report.chart.ChartActivity;

/**
 *
 * @author sugar
 * @date 2018/12/13
 */

public class ItemChartView extends IChatView  {

    private AgentWeb mAgentWeb;

    public ItemChartView(@NonNull Context context) {
        this(context,null);
    }

    public ItemChartView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ItemChartView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        setOnClickListener((v)->{
            ChartActivity.launch(v.getContext());
        });

        View vRoot = LayoutInflater.from(getContext()).inflate(R.layout.item_chart_view, this);
//        LinearLayout flChart = vRoot.findViewById(R.id.flChart);
//        Context context = getContext();
//        if(context instanceof Activity){
//            Activity context1 = (Activity) context;
//            LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
//            layoutParams.gravity = Gravity.CENTER;
//            long p = System.currentTimeMillis();
//            mAgentWeb = AgentWeb.with(context1)//
//                    .setAgentWebParent(flChart, new LinearLayout.LayoutParams(-1, -1))//
//                    .useDefaultIndicator()
//                    .setAgentWebWebSettings(getSettings())
////                .defaultProgressBarColor()
////                .setReceivedTitleCallback(mCallback)
//                    .setWebChromeClient(mWebChromeClient)
//                    .setWebViewClient(mWebViewClient)
//                    .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
//                    .setWebLayout(new WebLayout(context1))
//                    .createAgentWeb()
//                    .ready()
//                    .go("https://shuyang0811.gitee.io/followhelper/zhibiao/line-styles.html");
//            //mAgentWeb.getLoader().loadUrl(getUrl());
//            long n = System.currentTimeMillis();
//            Log.i("Info", "init used time:" + (n - p));


//        }

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


    @Override
    public String getTipText() {
        return CommonUtils.getString(R.string.chat_tip_chart);
    }
}
