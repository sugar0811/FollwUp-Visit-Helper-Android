package cn.wowjoy.commonlibrary.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;

import java.util.List;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;



public abstract class BaseListViewModel<T> extends AndroidViewModel{

    public BaseListViewModel(@NonNull Application application) {
        super(application);
    }

    protected CommonAdapter adapter;
    protected ObservableArrayList<T> mItems = new ObservableArrayList<>();

    /**子类提供Item 数据集合*/
    public ObservableArrayList<T> getItems(){
        return mItems;
    }

    /**子类提供数据*/
    public void setItems(List<T> items){
        mItems.clear();
        mItems.addAll(items);
    }

    /**子类提供Item 布局Id*/
    public abstract int getLayoutId();

    /**子类提供Item 点击事件*/
    public abstract CommonAdapter.OnItemClickListener getOnItemClickListener();

    /**默认Adapter*/
    public CommonAdapter getAdapter(){
        if(adapter == null){
            adapter = new CommonAdapter<T,ViewDataBinding>(getLayoutId(),getItems(),getOnItemClickListener()) {
                @Override
                public void convert(ViewDataBinding mDataBinding, T o, int position) {
                    super.convert(mDataBinding, o, position);
                    onConvert(mDataBinding,o,position);
                }
            };
        }
        return adapter;
    }

    public void clearItems(){
        mItems.clear();
    }

    public  void onConvert(ViewDataBinding mDataBinding, T o, int position){}
}
