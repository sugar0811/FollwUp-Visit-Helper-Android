package mobile.fuvh.cn.followupvisithelper.patient.view.report.chart;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.view.View;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.data.DataManager;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemChartTestBinding;
import mobile.fuvh.cn.followupvisithelper.patient.bean.TestAnalyResponse;

/**
 *
 * @author sugar
 * @date 2018/12/7
 */

public class ChartViewModel extends AndroidViewModel{

    public ChartViewModel(@NonNull Application application) {
        super(application);
        makeData();
    }

    private void makeData() {
        msgs.addAll(DataManager.getTestIndicatorList());
    }


    private ObservableArrayList<TestAnalyResponse.ResultsBean.ListBean> msgs = new ObservableArrayList<>();


    public CommonAdapter getChartListAdapter(){
        return new CommonAdapter<TestAnalyResponse.ResultsBean.ListBean,ItemChartTestBinding>(R.layout.item_chart_test, msgs, new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
            }
        }) {

        };

    }

}
