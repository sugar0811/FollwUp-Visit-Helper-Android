package cn.wowjoy.commonlibrary.base;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.lang.reflect.Field;

import cn.wowjoy.commonlibrary.bean.BaseResponse;
import cn.wowjoy.commonlibrary.bean.baseLiveData.LiveDataWrapper;
import cn.wowjoy.commonlibrary.rxbus.RxBus;


public abstract class BaseFragment<DB extends ViewDataBinding, VM extends ViewModel> extends RxFragment {

    private boolean isInit = false;
    private boolean isStart = false;
    private Bundle savedInstanceState;
    public static final String INTENT_BOOLEAN_LAZYLOAD = "intent_boolean_lazyLoad";
    private boolean isLazyLoad = true;
    private View mRoot;

    private int isVisibleToUserState = VISIBLE_STATE_NOTSET;
    //未设置值
    private static final int VISIBLE_STATE_NOTSET = -1;
    //可见
    private static final int VISIBLE_STATE_VISIABLE = 1;
    //不可见
    private static final int VISIBLE_STATE_GONE = 0;

    protected DB binding;
    protected VM viewModel;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        binding.setLifecycleOwner(this);
        mRoot = binding.getRoot();
        Bundle bundle = getArguments();
        if (bundle != null) {
            isLazyLoad = bundle.getBoolean(INTENT_BOOLEAN_LAZYLOAD, isLazyLoad);
        }
        if (null == viewModel) {
            if (null == getViewModelClass())
                viewModel = null;
            else
                viewModel = ViewModelProviders.of(getActivity()).get(getViewModelClass());
        }
        boolean isVisibleToUser;
        if (isVisibleToUserState == VISIBLE_STATE_NOTSET) {
            isVisibleToUser = getUserVisibleHint();
        } else {
            isVisibleToUser = isVisibleToUserState == VISIBLE_STATE_VISIABLE;
        }

        if (isLazyLoad) {
            if (isVisibleToUser) {
                isInit = true;
                onCreateViewLazy(savedInstanceState);
            }
        } else {
            isInit = true;
            onCreateViewLazy(savedInstanceState);
        }

        if (null == mRoot)
            return super.onCreateView(inflater, container, savedInstanceState);
        return mRoot;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isVisibleToUserState = isVisibleToUser ? VISIBLE_STATE_VISIABLE : VISIBLE_STATE_GONE;
        if (isVisibleToUser && !isInit && mRoot != null) {
            isInit = true;
            onCreateViewLazy(savedInstanceState);
            onResumeLazy();
        }
        if (isInit && mRoot != null) {
            if (isVisibleToUser) {
                isStart = true;
                onStartLazy();
            } else {
                isStart = false;
                onStopLazy();
            }
        }
    }


    @Deprecated
    @Override
    public final void onStart() {
        super.onStart();
        if (isInit && !isStart && getUserVisibleHint()) {
            isStart = true;
            onStartLazy();
        }
    }

    @Deprecated
    @Override
    public final void onStop() {
        super.onStop();
        if (isInit && isStart && getUserVisibleHint()) {
            isStart = false;
            onStopLazy();
        }
    }

    @Override
    @Deprecated
    public final void onResume() {
        super.onResume();
        if (isInit) {
            onResumeLazy();
        }
    }

    @Override
    @Deprecated
    public final void onPause() {
        super.onPause();
        if (isInit) {
            onPauseLazy();
        }
    }

    @Override
    @Deprecated
    public final void onDestroyView() {
        super.onDestroyView();
        mRoot = null;
        viewModel = null;
        if (isInit) {
            onDestroyViewLazy();
        }
        isInit = false;
    }


    // http://stackoverflow.com/questions/15207305/getting-the-error-java-lang-illegalstateexception-activity-has-been-destroyed
    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    protected void onResumeLazy() {
    }

    protected void onStartLazy() {
    }

    protected void onStopLazy() {
    }

    protected void onPauseLazy() {
    }

    protected void onDestroyViewLazy() {
    }


    protected abstract void onCreateViewLazy(Bundle savedInstanceState);

    protected abstract int getLayoutId();

    protected abstract Class<VM> getViewModelClass();

    protected <T extends BaseResponse> void setRx(int requestCode, BaseConsumer<T> baseConsumer) {
        RxBus.getInstance().tObservable(requestCode, LiveDataWrapper.class)
                .compose(bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(baseConsumer);
    }

}