package cn.wowjoy.commonlibrary.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.wowjoy.commonlibrary.R;

public class DialogListAdapter extends RecyclerView.Adapter<DialogListAdapter.MyHolder> {

    private List<String> mData;
    private Activity mActivity;
    private OnItemClickListener mListener;

    public DialogListAdapter(Activity mActivity, List<String> mData) {
        this.mData = mData;
        this.mActivity = mActivity;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, String data);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mActivity).inflate(R.layout.dialog_pop_bottom_item, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.textView.setText(mData.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.onItemClick(holder.itemView, mData.get(position));
            }
        });
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public int getItemCount() {
        return null == mData ? 0 : mData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MyHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.dialog_bottom_list_item_tv);
        }
    }
}
