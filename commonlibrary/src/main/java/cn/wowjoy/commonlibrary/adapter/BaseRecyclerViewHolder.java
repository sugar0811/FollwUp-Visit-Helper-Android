package cn.wowjoy.commonlibrary.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BaseRecyclerViewHolder<T ,D extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private D mBinding;
    private CommonAdapter.OnItemClickListener mListener;
    public BaseRecyclerViewHolder(ViewGroup viewGroup, int layoutId) {
        // 注意要依附 viewGroup，不然显示item不全!!
        super(DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), layoutId, viewGroup, false).getRoot());
        // 得到这个View绑定的Binding
        mBinding = DataBindingUtil.getBinding(this.itemView);
    }


    /**
     * 当数据改变时，binding会在下一帧去改变数据，如果我们需要立即改变，就去调用executePendingBindings方法。
     */
    void onBaseBindViewHolder(T object, final int position) {
        mBinding.setVariable(cn.wowjoy.commonlibrary.BR.item, object);
        this.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(null != mListener) {
                    mListener.onItemClick(view, position);
                }
            }
        });
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(null != mListener) {
                    mListener.onItemLongClick(v, position);
                    mListener.onItemLongClick(position,BaseRecyclerViewHolder.this);
                }
                return false;
            }
        });
        mBinding.executePendingBindings();
    }

    public void setOnItemClickListener(CommonAdapter.OnItemClickListener mListener) {
            this.mListener = mListener;
    }

    public D getmBinding(){

        return mBinding;
    }


}
