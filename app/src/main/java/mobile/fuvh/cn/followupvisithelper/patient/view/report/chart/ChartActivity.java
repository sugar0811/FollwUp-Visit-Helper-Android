package mobile.fuvh.cn.followupvisithelper.patient.view.report.chart;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.just.agentweb.AgentWeb;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import cn.wowjoy.commonlibrary.utils.DensityUtil;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.PatientChartActivityBinding;
import mobile.fuvh.cn.followupvisithelper.patient.view.report.chart.widget.WebLayout;

/**
 *
 * @author sugar
 * @date 2018/12/7
 */

public class ChartActivity extends BaseTitleActivity<PatientChartActivityBinding,ChartViewModel>{

    private AgentWeb mAgentWeb;
    private int width;


    public static void launch(Context context) {
        Intent intent = new Intent(context, ChartActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initData() {
        binding.chartRV.setAdapter(viewModel.getChartListAdapter());
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("刘建国 指标明细");
        width = DensityUtil.px2dip(DensityUtil.getWidthPixels());
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(binding.webRL, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT))
                .useDefaultIndicator()
                .setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        mAgentWeb.getJsAccessEntrace().quickCallJs("updateSize", "height:250px;width:" + 360+ "px;");
                    }
                })
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .setWebLayout(new WebLayout(this))
                .createAgentWeb()
                .ready()
                .go("https://shuyang0811.gitee.io/followhelper/zhibiao/line-styles.html");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.patient_chart_activity;
    }

    @Override
    protected Class<ChartViewModel> getViewModelClass() {
        return ChartViewModel.class;
    }
}
