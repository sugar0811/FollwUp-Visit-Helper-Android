package cn.wowjoy.commonlibrary.base;


import cn.wowjoy.commonlibrary.bean.BaseResponse;
import cn.wowjoy.commonlibrary.bean.CommonListResponse;
import cn.wowjoy.commonlibrary.bean.baseLiveData.LiveDataWrapper;
import cn.wowjoy.commonlibrary.bean.xml.xmlBaseResponse.RoleInfoResponseEnvelope;
import cn.wowjoy.commonlibrary.utils.DebugUtil;
import cn.wowjoy.commonlibrary.widget.statelayout.StateLayout;
import io.reactivex.functions.Consumer;

/**
 *
 */

public abstract class BaseConsumer<T extends BaseResponse> implements Consumer<LiveDataWrapper<T>> {

    private static final String TAG = "BaseObserver";

    protected StateLayout mStateLayout;

    public void setStateLayout(StateLayout mStateLayout) {
        this.mStateLayout = mStateLayout;
    }

    public BaseConsumer() {
    }

    public BaseConsumer(StateLayout mStateLayout) {
        this.mStateLayout = mStateLayout;
    }

    @Override
    public void accept(LiveDataWrapper<T> tLiveDataWrapper) throws Exception {
        switch (tLiveDataWrapper.status) {
            case LOADING:
                DebugUtil.debug(TAG, "加载中");
                if (null != mStateLayout) {
                    mStateLayout.showLoadingView();
                }
                onStart();
                break;
            case ERROR:
                DebugUtil.debug(TAG, "失败");
                if (null != mStateLayout) {
                    mStateLayout.showErrorView();
                    if(tLiveDataWrapper.error != null){
                        mStateLayout.showErrorView(tLiveDataWrapper.error.getMessage());
                    }
                }
                onError(tLiveDataWrapper.error);
                break;
            case SUCCESS:
                DebugUtil.debug(TAG, "成功");
                if(null != tLiveDataWrapper.data && tLiveDataWrapper.data instanceof RoleInfoResponseEnvelope){
//                    if (null != mStateLayout) {
//                        mStateLayout.showContentView();
//                    }
//                    T data = tLiveDataWrapper.data;
                    onSuccess(tLiveDataWrapper.data);
                }else {
                    if (null != tLiveDataWrapper.data && null != tLiveDataWrapper.data.getData()) {
                        if (null != mStateLayout) {
                            mStateLayout.showContentView();
                        }
                        T data = tLiveDataWrapper.data;
                        if (data instanceof CommonListResponse) {
                            CommonListResponse listResponse = (CommonListResponse) data;
                            if (listResponse.getData().getList() == null || listResponse.getData().getList().isEmpty()) {
                                if (null != mStateLayout) {
                                    mStateLayout.showEmptyView();
                                }
                            }
                        }
                        onSuccess(tLiveDataWrapper.data);
                    } else {
                        if (null != mStateLayout) {
                            mStateLayout.showEmptyView();
                        }
                        onSuccessResultNull();
                    }
                }
                break;
            default:
                break;
        }
    }

    protected void onStart() {}
    protected void onError(Throwable error){}
    protected void onSuccessResultNull() {}
    protected abstract void onSuccess(T data);

}
