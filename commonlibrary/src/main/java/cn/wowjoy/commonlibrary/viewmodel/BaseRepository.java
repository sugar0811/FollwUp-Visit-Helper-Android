package cn.wowjoy.commonlibrary.viewmodel;

import com.google.gson.JsonObject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import okhttp3.MediaType;
import okhttp3.RequestBody;


public  class BaseRepository {
    private CompositeDisposable mCompositeDisposable;

    private void onCreate() {
        this.mCompositeDisposable = new CompositeDisposable();
    }

    // 可以终止网络请求
    public void onDestroy() {
        if (null != mCompositeDisposable) {
            this.mCompositeDisposable.clear();
            this.mCompositeDisposable = null;
        }
    }


    protected void addDisposable(Disposable disposable) {
        if (null != mCompositeDisposable) {
            mCompositeDisposable.add(disposable);
        }
    }

    protected RequestBody jsonBodyFormat(JsonObject jsonObject){
        if(null != jsonObject) {

            return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
        }
        return null;
    }
}
