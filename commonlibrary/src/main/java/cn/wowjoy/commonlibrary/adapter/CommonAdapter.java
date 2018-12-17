package cn.wowjoy.commonlibrary.adapter;

import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public abstract class CommonAdapter<T, D extends ViewDataBinding> extends RecyclerView.Adapter<BaseRecyclerViewHolder<T, D>> {

    protected int mLayoutId;
    protected ObservableArrayList<T> mDatas;
    protected OnItemClickListener mListener;
    protected ListChangedCallback mItemsChangeCallback;

    public CommonAdapter(int layoutId, ObservableArrayList<T> datas) {
        this(layoutId, datas, null);

    }

    public CommonAdapter(int layoutId, ObservableArrayList<T> datas, OnItemClickListener listener) {
        setHasStableIds(true);
        mLayoutId = layoutId;
        resetItems(datas);
        mListener = listener;
        mItemsChangeCallback = new ListChangedCallback();
    }



    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setItems(ObservableArrayList<T> list) {
        resetItems(list);
    }

    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        BaseRecyclerViewHolder baseRecyclerViewHolder = new BaseRecyclerViewHolder(parent, mLayoutId);
        if (mListener != null)
            baseRecyclerViewHolder.setOnItemClickListener(mListener);
        return baseRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
        if (mDatas.get(position) != null) {
            holder.onBaseBindViewHolder(mDatas.get(position), position);
            convert((D) holder.getmBinding(), mDatas.get(position), position) ;
        }
    }

    public void convert(D mDataBinding, T t, int position) {
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }


    public static abstract class OnItemClickListener {

        public abstract void onItemClick(View v, int position);

        public void onItemLongClick(View v, int position) {

        }
        public void onItemLongClick(int position, RecyclerView.ViewHolder viewHolder){}

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mDatas.addOnListChangedCallback(mItemsChangeCallback);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mDatas.removeOnListChangedCallback(mItemsChangeCallback);
    }


    //region 处理数据集变化
    protected void onChanged(ObservableArrayList<T> newItems) {
        resetItems(newItems);
        notifyDataSetChanged();
    }

    protected void onItemRangeChanged(ObservableArrayList<T> newItems, int positionStart, int itemCount) {
        resetItems(newItems);
        notifyItemRangeChanged(positionStart, itemCount);
    }

    protected void onItemRangeInserted(ObservableArrayList<T> newItems, int positionStart, int itemCount) {
        resetItems(newItems);
        notifyItemRangeInserted(positionStart, itemCount);
    }

    protected void onItemRangeMoved(ObservableArrayList<T> newItems) {
        resetItems(newItems);
        notifyDataSetChanged();
    }

    protected void onItemRangeRemoved(ObservableArrayList<T> newItems, int positionStart, int itemCount) {
        resetItems(newItems);
        notifyItemRangeRemoved(positionStart, itemCount);
    }

    protected void resetItems(ObservableArrayList<T> newItems) {
        this.mDatas = newItems;
    }
    //endregion

    class ListChangedCallback extends ObservableArrayList.OnListChangedCallback<ObservableArrayList<T>> {
        @Override
        public void onChanged(ObservableArrayList<T> newItems) {
            CommonAdapter.this.onChanged(newItems);
        }

        @Override
        public void onItemRangeChanged(ObservableArrayList<T> newItems, int i, int i1) {
            CommonAdapter.this.onItemRangeChanged(newItems, i, i1);
        }

        @Override
        public void onItemRangeInserted(ObservableArrayList<T> newItems, int i, int i1) {
            CommonAdapter.this.onItemRangeInserted(newItems, i, i1);
        }

        @Override
        public void onItemRangeMoved(ObservableArrayList<T> newItems, int i, int i1, int i2) {
            CommonAdapter.this.onItemRangeMoved(newItems);
        }

        @Override
        public void onItemRangeRemoved(ObservableArrayList<T> sender, int positionStart, int itemCount) {
            CommonAdapter.this.onItemRangeRemoved(sender, positionStart, itemCount);
        }
    }

}