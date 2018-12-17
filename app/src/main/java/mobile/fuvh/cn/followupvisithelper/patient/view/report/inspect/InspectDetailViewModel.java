package mobile.fuvh.cn.followupvisithelper.patient.view.report.inspect;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.data.DataManager;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemTestDetailBinding;
import mobile.fuvh.cn.followupvisithelper.patient.bean.TestDetailResponse;

/**
 *
 * @author sugar
 * @date 2018/11/30
 */

public class InspectDetailViewModel extends AndroidViewModel {
    public InspectDetailViewModel(@NonNull Application application) {
        super(application);
        mTestDetails.add(DataManager.getTestDetailData());
    }

    private ObservableArrayList<TestDetailResponse.ResultsBean.ListBean> mTestDetails = new ObservableArrayList<>();
    public CommonAdapter mCommonAdapter = new CommonAdapter<TestDetailResponse.ResultsBean.ListBean, ItemTestDetailBinding>(R.layout.item_test_detail, mTestDetails, null) {
        @Override
        public void convert(ItemTestDetailBinding mDataBinding, TestDetailResponse.ResultsBean.ListBean listBean, int position) {
            if (position % 2 == 0)
                mDataBinding.testDetailItemLL.setBackgroundResource(R.drawable.selector_white_item_clickable);
            else
                mDataBinding.testDetailItemLL.setBackgroundResource(R.drawable.selector_gray_item_clickable);
        }
    };

}
