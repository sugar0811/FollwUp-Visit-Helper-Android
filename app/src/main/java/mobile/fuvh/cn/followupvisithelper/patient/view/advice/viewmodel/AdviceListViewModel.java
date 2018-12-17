package mobile.fuvh.cn.followupvisithelper.patient.view.advice.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.Arrays;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import cn.wowjoy.commonlibrary.bean.baseLiveData.LiveDataWrapper;
import cn.wowjoy.commonlibrary.rxbus.RxBus;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.constant.AppConstants;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemPopupKeyValueBinding;
import mobile.fuvh.cn.followupvisithelper.patient.bean.KeyValue;

/**
 * Created by sugar on 2018/11/30.
 */

public class AdviceListViewModel extends AndroidViewModel{
    public AdviceListViewModel(@NonNull Application application) {
        super(application);
    }


    /*****************************下拉popup*******************************/
    private ObservableArrayList<KeyValue.ResultsBean.ListBean> mWhoType = new ObservableArrayList<>();
    public CommonAdapter mWhoAdapter = new CommonAdapter<KeyValue.ResultsBean.ListBean, ItemPopupKeyValueBinding>(R.layout.item_popup_key_value, mWhoType, new CommonAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            KeyValue mKeyValue = new KeyValue();
            KeyValue.ResultsBean kr = new KeyValue.ResultsBean();
            kr.setList(Arrays.asList(mWhoType.get(position)));
            mKeyValue.setResults(kr);
            RxBus.getInstance().post(AppConstants.ADVICECHOOSE_W, LiveDataWrapper.success(mKeyValue));
        }
    }) {
    };

    private ObservableArrayList<KeyValue.ResultsBean.ListBean> mAdType = new ObservableArrayList<>();
    public CommonAdapter mAdAdapter = new CommonAdapter<KeyValue.ResultsBean.ListBean, ItemPopupKeyValueBinding>(R.layout.item_popup_key_value, mAdType, new CommonAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            KeyValue mKeyValue = new KeyValue();
            KeyValue.ResultsBean kr = new KeyValue.ResultsBean();
            kr.setList(Arrays.asList(mAdType.get(position)));
            mKeyValue.setResults(kr);
            RxBus.getInstance().post(AppConstants.ADVICECHOOSE_A, LiveDataWrapper.success(mKeyValue));
        }
    }) {
    };

    private ObservableArrayList<KeyValue.ResultsBean.ListBean> mItemType = new ObservableArrayList<>();
    public CommonAdapter mItemAdapter = new CommonAdapter<KeyValue.ResultsBean.ListBean, ItemPopupKeyValueBinding>(R.layout.item_popup_key_value, mItemType, new CommonAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            KeyValue mKeyValue = new KeyValue();
            KeyValue.ResultsBean kr = new KeyValue.ResultsBean();
            kr.setList(Arrays.asList(mItemType.get(position)));
            mKeyValue.setResults(kr);
            RxBus.getInstance().post(AppConstants.ADVICECHOOSE_I, LiveDataWrapper.success(mKeyValue));
        }
    }) {
    };

    private ObservableArrayList<KeyValue.ResultsBean.ListBean> mStatusType = new ObservableArrayList<>();
    public CommonAdapter mStatusAdapter = new CommonAdapter<KeyValue.ResultsBean.ListBean, ItemPopupKeyValueBinding>(R.layout.item_popup_key_value, mStatusType, new CommonAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            KeyValue mKeyValue = new KeyValue();
            KeyValue.ResultsBean kr = new KeyValue.ResultsBean();
            kr.setList(Arrays.asList(mStatusType.get(position)));
            mKeyValue.setResults(kr);
            RxBus.getInstance().post(AppConstants.ADVICECHOOSE_S, LiveDataWrapper.success(mKeyValue));
        }
    }) {
    };

    public void initPopupList() {
        mWhoType.clear();
        mWhoType.add(new KeyValue.ResultsBean.ListBean("0", "全部"));
        mWhoType.add(new KeyValue.ResultsBean.ListBean("1", "医生"));
        mWhoType.add(new KeyValue.ResultsBean.ListBean("2", "护士"));

        mAdType.clear();
        mAdType.add(new KeyValue.ResultsBean.ListBean("0", "全部"));
        mAdType.add(new KeyValue.ResultsBean.ListBean("1", "临时医嘱"));
        mAdType.add(new KeyValue.ResultsBean.ListBean("2", "长期医嘱"));

        mItemType.clear();
        mItemType.add(new KeyValue.ResultsBean.ListBean("0", "全部"));
        mItemType.add(new KeyValue.ResultsBean.ListBean("1", "药品"));
        mItemType.add(new KeyValue.ResultsBean.ListBean("2", "诊疗"));
        mItemType.add(new KeyValue.ResultsBean.ListBean("3", "文本"));
        mItemType.add(new KeyValue.ResultsBean.ListBean("4", "检验"));
        mItemType.add(new KeyValue.ResultsBean.ListBean("5", "检查"));

        mStatusType.clear();
        mStatusType.add(new KeyValue.ResultsBean.ListBean("0", "全部"));
        mStatusType.add(new KeyValue.ResultsBean.ListBean("9", "当天"));
        mStatusType.add(new KeyValue.ResultsBean.ListBean("1", "未核对"));
        mStatusType.add(new KeyValue.ResultsBean.ListBean("2", "已核对"));
        mStatusType.add(new KeyValue.ResultsBean.ListBean("3", "已执行"));
        mStatusType.add(new KeyValue.ResultsBean.ListBean("4", "已停止"));
        mStatusType.add(new KeyValue.ResultsBean.ListBean("5", "已撤销"));
    }

}
