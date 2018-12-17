package cn.wowjoy.commonlibrary.adapter;

/**
 * Created by suagr on 2017/9/16.
 *
 */

public interface MultiItemTypeSupport<T> {

     int getItemType(int position, T t);
     int getItemLayout(int type);


}
