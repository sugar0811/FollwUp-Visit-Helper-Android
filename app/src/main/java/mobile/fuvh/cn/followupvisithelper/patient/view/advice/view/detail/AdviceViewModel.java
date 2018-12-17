package mobile.fuvh.cn.followupvisithelper.patient.view.advice.view.detail;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;

import java.util.List;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemAdviceExeBinding;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemAdviceYpBinding;
import mobile.fuvh.cn.followupvisithelper.patient.bean.DoctoraDviceExeResponse;
import mobile.fuvh.cn.followupvisithelper.patient.bean.DoctoraDviceListResponse;

/**
 *
 * @author sugar
 * @date 2018/11/30
 */

public class AdviceViewModel extends AndroidViewModel{
    public AdviceViewModel(@NonNull Application application) {
        super(application);
    }




    private ObservableArrayList<DoctoraDviceExeResponse.ResultsBean.ListBean> mAdvices = new ObservableArrayList<>();
    public CommonAdapter mCommonAdapter = new CommonAdapter<DoctoraDviceExeResponse.ResultsBean.ListBean, ItemAdviceExeBinding>(R.layout.item_advice_exe, mAdvices, null) {
    };

    public void setDoctoradviceExecuteList(List<DoctoraDviceExeResponse.ResultsBean.ListBean> list) {
        mAdvices.clear();
        if (list != null && list.size() > 0)
            mAdvices.addAll(list);
    }


    private ObservableArrayList<DoctoraDviceListResponse.ResultsBean.ListBean.ChildrenBean> mYPs = new ObservableArrayList<>();
    public CommonAdapter mYPsCommonAdapter = new CommonAdapter<DoctoraDviceListResponse.ResultsBean.ListBean.ChildrenBean, ItemAdviceYpBinding>(R.layout.item_advice_yp, mYPs, null) {
    };

    public void setAdviceExeList(List<DoctoraDviceExeResponse.ResultsBean.ListBean> list) {
        mAdvices.clear();
        if (list != null && list.size() > 0)
            mAdvices.addAll(list);
    }

    public void setYPList(List<DoctoraDviceListResponse.ResultsBean.ListBean.ChildrenBean> list) {
        mYPs.clear();
        if (list != null && list.size() > 0)
            mYPs.addAll(list);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }

}
