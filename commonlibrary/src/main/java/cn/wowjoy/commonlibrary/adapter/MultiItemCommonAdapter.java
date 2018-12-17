package cn.wowjoy.commonlibrary.adapter;

import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

/**
 * Created by sugar on 2017/9/16.
 * 多种类型的适配器
 */

public abstract class MultiItemCommonAdapter<T, D extends ViewDataBinding> extends CommonAdapter<T, D> {

    MultiItemTypeSupport mMultiItemTypeSupport;

    public MultiItemCommonAdapter(ObservableArrayList<T> datas, MultiItemTypeSupport<T> mMultiItemTypeSupport) {
        this(datas, mMultiItemTypeSupport, null);
    }

    public MultiItemCommonAdapter(ObservableArrayList<T> datas, MultiItemTypeSupport<T> mMultiItemTypeSupport, OnItemClickListener listener) {
        super(0, datas, listener);
        this.mMultiItemTypeSupport = mMultiItemTypeSupport;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        return mMultiItemTypeSupport.getItemType(position, mDatas.get(position));
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseRecyclerViewHolder baseRecyclerViewHolder = new BaseRecyclerViewHolder(parent, mMultiItemTypeSupport.getItemLayout(viewType));
        if (mListener != null)
            baseRecyclerViewHolder.setOnItemClickListener(mListener);
        return baseRecyclerViewHolder;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
}


