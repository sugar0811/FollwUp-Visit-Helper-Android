package cn.wowjoy.commonlibrary.base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import cn.wowjoy.commonlibrary.R;
import cn.wowjoy.commonlibrary.bean.BaseResponse;
import cn.wowjoy.commonlibrary.bean.baseLiveData.LiveDataWrapper;
import cn.wowjoy.commonlibrary.databinding.ActivityBaseTitleBinding;
import cn.wowjoy.commonlibrary.rxbus.RxBus;
import cn.wowjoy.commonlibrary.utils.ToastUtils;
import cn.wowjoy.commonlibrary.widget.titlebar.TitleBar;

/**
 *
 * @author sugar
 * @date 2018/11/2
 */

public abstract class BaseTitleActivity<DB extends ViewDataBinding, VM extends ViewModel> extends RxAppCompatActivity {

    protected DB binding;
    protected VM viewModel;
    private ActivityBaseTitleBinding mTitleBinding;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBus.getInstance().register(this);
        mTitleBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_base_title, null, false);
        binding = DataBindingUtil.inflate(getLayoutInflater(),getLayoutId(),null,false);
        binding.setLifecycleOwner(this);

        if(isRefresh()){
            SwipeRefreshLayout swipeRefreshLayout = new SwipeRefreshLayout(this);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            swipeRefreshLayout.setLayoutParams(layoutParams);
            swipeRefreshLayout.setId(R.id.swipe_refresh);
            initSwipe(swipeRefreshLayout);
            swipeRefreshLayout.addView(binding.getRoot());
            mTitleBinding.flContainer.addView(swipeRefreshLayout);
        }else {

            mTitleBinding.flContainer.addView(binding.getRoot());

        }

        if (null != getViewModelClass()) {
            viewModel = ViewModelProviders.of(this).get(getViewModelClass());
        }

        getWindow().setContentView(mTitleBinding.getRoot());


        initView(savedInstanceState);
        initData();
    }

    protected boolean isRefresh() {
        return false;
    }

    protected void onRefresh(){

    }


    private void initSwipe(SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setColorSchemeResources(
                R.color.C_5777A6
        );
        swipeRefreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                BaseTitleActivity.this.onRefresh();
            }
        });
    }


    protected void hideFresh(){
        SwipeRefreshLayout swipeRefreshLayout = mTitleBinding.getRoot().findViewById(R.id.swipe_refresh);
        if (swipeRefreshLayout !=null && swipeRefreshLayout.isShown()) {
            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(false);

                }
            });
        }
    }

    @Override
    protected void onDestroy() {
        RxBus.getInstance().unRegister(this);
        viewModel = null;
        if (binding != null)
            binding.unbind();
        super.onDestroy();
    }

    /**
     * 数据初始化
     */
    protected abstract void initData();

    /**
     * 视图初始化
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);


    /**
     * 子布局ID
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 获取指定类型viewModel
     * @return
     */
    protected abstract Class<VM> getViewModelClass();

    /**
     * 获取titleBar
     * @return
     */
    protected TitleBar getTitleBar(){
        return mTitleBinding.tbTitle;
    }

    /**
     * 设置标题
     * @param strId
     */
    protected void title(int strId){
        mTitleBinding.tbTitle.setTitle(strId);
    }
    /**
     * 设置标题
     * @param str
     */
    protected void title(String str){
        mTitleBinding.tbTitle.setTitle(str);
    }

    /**
     * 标题栏设置返回
     * @param isLeftBack
     */
    protected void leftBack(boolean isLeftBack){
        if(isLeftBack){
            mTitleBinding.tbTitle.setLeftBack(this);
        }
    }

    protected void normalTitle(int strId){
        title(strId);
        leftBack(true);
    }

    protected void normalTitle(String str){
        title(str);
        leftBack(true);
    }

    protected void showTip(String str) {
        ToastUtils.showShort(BaseTitleActivity.this,str);
    }

    /**
     * 接收数据response
     * @param requestCode
     * @param baseConsumer
     * @param <T>
     */
    protected <T extends BaseResponse> void setRx(int requestCode, BaseConsumer<T> baseConsumer) {
        RxBus.getInstance().tObservable(requestCode, LiveDataWrapper.class)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(baseConsumer);
    }

}
