package cn.wowjoy.commonlibrary.adapter;

import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;

/**
 * Created by sugar on 2018/4/28.
 *
 *
 */

public class SectionAdapter<T,D extends ViewDataBinding> extends MultiItemCommonAdapter<T,D>{
    private static final int HEAD_TYPE = 101;
    private static final int NORMAL_TYPE = 102;
    private SectionSupport mSectionSupport;
    private int mRealPosition;
    public SectionAdapter(ObservableArrayList<T> datas, SectionSupport mMultiItemTypeSupport) {
        this(datas, mMultiItemTypeSupport,null);
    }

    public SectionAdapter(ObservableArrayList<T> datas, SectionSupport mMultiItemTypeSupport, OnItemClickListener listener) {
        super(datas, mMultiItemTypeSupport, listener);
        this.mSectionSupport = mMultiItemTypeSupport;
    }

    @Override
    public int getItemViewType(int position) {
        return mSectionSupport.getItemType(position,null);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() == 0 ? 0 :
                super.getItemCount() + (mSectionSupport.getHeaderLayout() != 0 ? 1 : 0);
    }

    public abstract static class SectionSupport<T> implements MultiItemTypeSupport<T>{
        @Override
        public int getItemType(int position, T o) {
            if(position == 0 && getHeaderLayout() != 0){
                return HEAD_TYPE;
            }
            return NORMAL_TYPE;
        }

        @Override
        public int getItemLayout(int type) {
            if(type == HEAD_TYPE){
              return  getHeaderLayout();
            }
            return getNormalLayout();
        }

        public abstract int getHeaderLayout();

        public abstract int getNormalLayout();

    }



    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
        if(mSectionSupport.getHeaderLayout() != 0){
            if(position == 0){
                return;
            }
            mRealPosition = position - 1;
            super.onBindViewHolder(holder, mRealPosition);
        }else{

            super.onBindViewHolder(holder, position);

        }

    }
}
