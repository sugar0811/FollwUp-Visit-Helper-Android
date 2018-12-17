package mobile.fuvh.cn.followupvisithelper.patient.view.surgery.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.List;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemOpHisBinding;
import mobile.fuvh.cn.followupvisithelper.patient.bean.SurgeryreCodeListResponse;
import mobile.fuvh.cn.followupvisithelper.patient.view.surgery.view.detail.view.SurgeryDetailActivity;

/**
 *
 * @author sugar
 * @date 2018/11/30
 */

public class SurgeryViewModel extends AndroidViewModel{

    public SurgeryViewModel(@NonNull Application application) {
        super(application);
    }

    private ObservableArrayList<SurgeryreCodeListResponse.ResultsBean.ListBean> mTestDetails = new ObservableArrayList<>();
    public CommonAdapter mCommonAdapter = new CommonAdapter<SurgeryreCodeListResponse.ResultsBean.ListBean, ItemOpHisBinding>(R.layout.item_op_his, mTestDetails, new CommonAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            SurgeryDetailActivity.launch(v.getContext(),mTestDetails.get(position));
        }
    }) {
        @Override
        public void convert(ItemOpHisBinding mDataBinding, SurgeryreCodeListResponse.ResultsBean.ListBean listBean, int position) {
            if (position % 2 == 0)
                mDataBinding.opHisItemLL.setBackgroundResource(R.drawable.selector_white_item_clickable);
            else
                mDataBinding.opHisItemLL.setBackgroundResource(R.drawable.selector_gray_item_clickable);
        }
    };
    public void setItems(List<SurgeryreCodeListResponse.ResultsBean.ListBean> list){
        mTestDetails.clear();
        mTestDetails.addAll(list);
    }

}
