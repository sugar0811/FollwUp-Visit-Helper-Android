package mobile.fuvh.cn.followupvisithelper.patient.view.advice.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import cn.wowjoy.commonlibrary.utils.DensityUtil;
import cn.wowjoy.commonlibrary.widget.MPopupwindow;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.data.DataManager;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemAdviceBinding;
import mobile.fuvh.cn.followupvisithelper.databinding.PatientAdviceActivityBinding;
import mobile.fuvh.cn.followupvisithelper.patient.bean.DoctoraDviceListResponse;
import mobile.fuvh.cn.followupvisithelper.patient.view.advice.view.detail.AdviceDetailActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.advice.viewmodel.AdviceListViewModel;

/**
 *
 * @author sugar
 * @date 2018/11/30
 */

public class AdviceListActivity extends BaseTitleActivity<PatientAdviceActivityBinding,AdviceListViewModel>{


    private MPopupwindow mWhoPop;
    private MPopupwindow mAdTypePop;
    private MPopupwindow mItemTypePop;
    private MPopupwindow mStatusPop;

    public static void launch(Context context) {
        Intent intent = new Intent(context, AdviceListActivity.class);
        context.startActivity(intent);
    }

    private ObservableArrayList<DoctoraDviceListResponse.ResultsBean.ListBean> mAdvices = new ObservableArrayList<>();

    @Override
    protected void initData() {
        viewModel.initPopupList();
        mAdvices.clear();
        mAdvices.addAll(DataManager.getAdviceList());

    }
    public CommonAdapter mCommonAdapter = new CommonAdapter<DoctoraDviceListResponse.ResultsBean.ListBean, ItemAdviceBinding>(R.layout.item_advice, mAdvices, new CommonAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            DoctoraDviceListResponse.ResultsBean.ListBean listBean = mAdvices.get(position);
            if ("1".equals(listBean.getItem_type_code()) ||
                    "7".equals(listBean.getItem_type_code()) ||
                    "8".equals(listBean.getItem_type_code()) ||
                    "9".equals(listBean.getItem_type_code()) ||
                    "10".equals(listBean.getItem_type_code())) {//药品

                AdviceDetailActivity.launch(AdviceListActivity.this,mAdvices.get(position));
            }

        }
    }) {
        @Override
        public void convert(ItemAdviceBinding mDataBinding, DoctoraDviceListResponse.ResultsBean.ListBean listBean, int position) {
            if ("1".equals(listBean.getItem_type_code()) ||
                    "4".equals(listBean.getItem_type_code()) ||
                    "5".equals(listBean.getItem_type_code()) ||
                    "7".equals(listBean.getItem_type_code()) ||
                    "8".equals(listBean.getItem_type_code()) ||
                    "9".equals(listBean.getItem_type_code()) ||
                    "10".equals(listBean.getItem_type_code())) {
                mDataBinding.adContentTV.setTextColor(mDataBinding.adContentTV.getContext().getResources().getColor(R.color.C_222222));
                mDataBinding.adviceItemLL.setBackgroundResource(R.drawable.selector_white_item_clickable);
            } else {
                mDataBinding.adContentTV.setTextColor(mDataBinding.adContentTV.getContext().getResources().getColor(R.color.C_999999));
                mDataBinding.adviceItemLL.setBackgroundColor(mDataBinding.adviceItemLL.getContext().getResources().getColor(R.color.C_FFFFFF));
            }

            if (listBean.getDocadvise_state() == 3) {
                mDataBinding.adviceStateTV.setVisibility(View.VISIBLE);
                mDataBinding.adviceStateTV.setText("已执行");
                mDataBinding.adviceStateTV.setTextColor(mDataBinding.adviceStateTV.getContext().getResources().getColor(R.color.C_55B3F0));
                mDataBinding.adviceStateTV.setBackgroundResource(R.drawable.corners_dbf0fe);
            } else if (listBean.getDocadvise_state() == 2) {
                mDataBinding.adviceStateTV.setVisibility(View.VISIBLE);
                mDataBinding.adviceStateTV.setText("已核对");
                mDataBinding.adviceStateTV.setTextColor(mDataBinding.adviceStateTV.getContext().getResources().getColor(R.color.C_9CCF58));
                mDataBinding.adviceStateTV.setBackgroundResource(R.drawable.corners_e8f6d4);
            } else if (listBean.getDocadvise_state() == 1) {
                mDataBinding.adviceStateTV.setVisibility(View.VISIBLE);
                mDataBinding.adviceStateTV.setText("未核对");
                mDataBinding.adviceStateTV.setTextColor(mDataBinding.adviceStateTV.getContext().getResources().getColor(R.color.C_FEAA23));
                mDataBinding.adviceStateTV.setBackgroundResource(R.drawable.corners_feeddc);
            } else if (listBean.getDocadvise_state() == 4) {
                mDataBinding.adviceStateTV.setVisibility(View.VISIBLE);
                mDataBinding.adviceStateTV.setText("已停止");
                mDataBinding.adviceStateTV.setTextColor(mDataBinding.adviceStateTV.getContext().getResources().getColor(R.color.C_F68484));
                mDataBinding.adviceStateTV.setBackgroundResource(R.drawable.corners_ffe5e5);
            } else if (listBean.getDocadvise_state() == 5) {
                mDataBinding.adviceStateTV.setVisibility(View.VISIBLE);
                mDataBinding.adviceStateTV.setText("已撤销");
                mDataBinding.adviceStateTV.setTextColor(mDataBinding.adviceStateTV.getContext().getResources().getColor(R.color.C_F68484));
                mDataBinding.adviceStateTV.setBackgroundResource(R.drawable.corners_ffe5e5);
            } else {
                mDataBinding.adviceStateTV.setVisibility(View.GONE);
            }

            mDataBinding.subAdviceItemLL.removeAllViews();
            if (listBean.getChildren() != null && listBean.getChildren().size() > 0) {
                for (DoctoraDviceListResponse.ResultsBean.ListBean.ChildrenBean drlc : listBean.getChildren()) {
                    LinearLayout mSubView = (LinearLayout) LayoutInflater.from(mDataBinding.adviceItemLL.getContext()).inflate(R.layout.item_sub_advice, null);
                    ((TextView) mSubView.findViewById(R.id.adContentTV)).setText(drlc.getDocadvise_item_name());
//                    if ("1".equals(drlc.getMatching_drug()))
//                        mSubView.findViewById(R.id.jingTV).setVisibility(View.VISIBLE);
//                    else
//                        mSubView.findViewById(R.id.jingTV).setVisibility(View.GONE);
//                    if ("1".equals(drlc.getDanger_drug()))
//                        mSubView.findViewById(R.id.weiTV).setVisibility(View.VISIBLE);
//                    else
//                        mSubView.findViewById(R.id.weiTV).setVisibility(View.GONE);
//                    if ("1".equals(drlc.getMay_fall_drug()))
//                        mSubView.findViewById(R.id.dieTV).setVisibility(View.VISIBLE);
//                    else
//                        mSubView.findViewById(R.id.dieTV).setVisibility(View.GONE);
                    mDataBinding.subAdviceItemLL.addView(mSubView);
                }
            }
        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("医嘱管理");
        mWhoPop = new MPopupwindow(this, viewModel.mWhoAdapter, DensityUtil.getWidthPixels() / 4, DensityUtil.dip2px(135));
        mAdTypePop = new MPopupwindow(this, viewModel.mAdAdapter, DensityUtil.getWidthPixels() / 3, DensityUtil.dip2px(135));
        mItemTypePop = new MPopupwindow(this, viewModel.mItemAdapter, DensityUtil.getWidthPixels() / 3, DensityUtil.dip2px(255));
        mStatusPop = new MPopupwindow(this, viewModel.mStatusAdapter, DensityUtil.getWidthPixels() / 3, DensityUtil.dip2px(300));

        binding.adviceRV.setAdapter(mCommonAdapter);

        binding.whoLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWhoPop.show(binding.whoTV);
            }
        });
        binding.adTypeLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdTypePop.show(binding.adTypeTV);
            }
        });

        binding.itemTypeLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemTypePop.show(binding.itemTypeTV);
            }
        });

        binding.statusLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStatusPop.show(binding.statusTV);
            }
        });


//        setRx(AppConstants.ADVICECHOOSE_W, new BaseConsumer<KeyValue>() {
//            @Override
//            protected void onSuccess(KeyValue data) {
//                mWhoPop.dismiss();
//                mWhoVlaue = data.getData().getList().get(0).getKey();
//                binding.whoTV.setText(data.getData().getList().get(0).getValue());
//            }
//        });
//        setRx(AppConstants.ADVICECHOOSE_A, new BaseConsumer<KeyValue>() {
//            @Override
//            protected void onSuccess(KeyValue data) {
//                mAdTypePop.dismiss();
//                mAdVlaue = data.getData().getList().get(0).getKey();
//                binding.adTypeTV.setText(data.getData().getList().get(0).getValue());
//            }
//        });
//
//        setRx(AppConstants.ADVICECHOOSE_I, new BaseConsumer<KeyValue>() {
//            @Override
//            protected void onSuccess(KeyValue data) {
//                mItemTypePop.dismiss();
//                mItemValue = data.getData().getList().get(0).getKey();
//                binding.itemTypeTV.setText(data.getData().getList().get(0).getValue());
//            }
//        });
//
//        setRx(AppConstants.ADVICECHOOSE_S, new BaseConsumer<KeyValue>() {
//            @Override
//            protected void onSuccess(KeyValue data) {
//                mStatusPop.dismiss();
//                mStatusValue = data.getData().getList().get(0).getKey();
//                binding.statusTV.setText(data.getData().getList().get(0).getValue());
//            }
//        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.patient_advice_activity;
    }

    @Override
    protected Class<AdviceListViewModel> getViewModelClass() {
        return AdviceListViewModel.class;
    }
}
