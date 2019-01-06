package mobile.fuvh.cn.followupvisithelper.collect.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import cn.wowjoy.commonlibrary.viewmodel.BaseListViewModel;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.bean.SimpleBean;
import mobile.fuvh.cn.followupvisithelper.patient.view.diaseaserecord.view.detail.view.DiseaseRecordDetailActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.report.chart.ChartActivity;

/**
 *
 * @author sugar
 * @date 2019/1/3
 */

public class CollectViewModel extends BaseListViewModel<SimpleBean>{

    public CollectViewModel(@NonNull Application application) {
        super(application);
        List<SimpleBean> collects = new ArrayList<>();
        collects.add(new SimpleBean("12月28日刘建国2b16床 病程","2018/12月/28"));
        collects.add(new SimpleBean("刘建国2b16床 白细胞","2018/12月/26"));
        collects.add(new SimpleBean("12月20日日刘建国2b16床 病程","2018/12月/20"));
        setItems(collects);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_collect;
    }

    @Override
    public CommonAdapter.OnItemClickListener getOnItemClickListener() {
        return new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if(position ==0 || position == 2){
                    DiseaseRecordDetailActivity.launch(v.getContext());
                }else if(position == 1){
                    ChartActivity.launch(v.getContext());
                }
            }
        };
    }
}
