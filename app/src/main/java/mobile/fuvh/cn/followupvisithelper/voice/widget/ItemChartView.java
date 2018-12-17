package mobile.fuvh.cn.followupvisithelper.voice.widget;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.just.agentweb.AgentWeb;

import cn.wowjoy.commonlibrary.utils.CommonUtils;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.patient.view.report.chart.ChartActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.report.chart.widget.WebLayout;

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
            Log.e("ItemChartView","onclick");
            ChartActivity.launch(v.getContext());
        });

        View vRoot = LayoutInflater.from(getContext()).inflate(R.layout.item_chart_view, this);
        FrameLayout flChart = vRoot.findViewById(R.id.flChart);
        Context context = getContext();
        if(context instanceof Activity){
            Activity context1 = (Activity) context;
            LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            layoutParams.gravity = Gravity.CENTER;
            mAgentWeb = AgentWeb.with(context1)
                    .setAgentWebParent(flChart, layoutParams)
                    .useDefaultIndicator()
                    .setWebViewClient(new WebViewClient() {
                        @Override
                        public void onPageFinished(WebView view, String url) {
                            super.onPageFinished(view, url);
                            mAgentWeb.getJsAccessEntrace().quickCallJs("updateSize", "height:160px;width:320px;");
                        }
                    })
                    .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                    .setWebLayout(new WebLayout(context1))
                    .createAgentWeb()
                    .ready()
                    .go("https://shuyang0811.gitee.io/followhelper/zhibiao/line-styles.html");
        }

    }

    @Override
    public String getTipText() {
        return CommonUtils.getString(R.string.chat_tip_chart);
    }
}
