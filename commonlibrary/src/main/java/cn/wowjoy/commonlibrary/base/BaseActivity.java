package cn.wowjoy.commonlibrary.base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.gyf.barlibrary.ImmersionBar;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import cn.wowjoy.commonlibrary.bean.BaseResponse;
import cn.wowjoy.commonlibrary.bean.baseLiveData.LiveDataWrapper;
import cn.wowjoy.commonlibrary.rxbus.RxBus;


public abstract class BaseActivity<DB extends ViewDataBinding, VM extends ViewModel> extends RxAppCompatActivity {

    protected DB binding;
    protected VM viewModel;
    public ImmersionBar mImmersionBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImmersionBar = ImmersionBar.with(this);
        RxBus.getInstance().register(this);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        binding.setLifecycleOwner(this);
        if (null == viewModel) {
            if (null == getViewModelClass())
                viewModel = null;
            else
                viewModel = ViewModelProviders.of(this).get(getViewModelClass());
        }
        init(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        if (mImmersionBar != null)
            mImmersionBar.destroy();
        RxBus.getInstance().unRegister(this);
        viewModel = null;
        if (binding != null)
            binding.unbind();
        super.onDestroy();
    }

    protected abstract void init(Bundle savedInstanceState);

    protected abstract int getLayoutId();

    protected abstract Class<VM> getViewModelClass();


    protected <T extends BaseResponse> void setRx(int requestCode, BaseConsumer<T> baseConsumer) {
        RxBus.getInstance().tObservable(requestCode, LiveDataWrapper.class)
                .compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(baseConsumer);
    }

}
