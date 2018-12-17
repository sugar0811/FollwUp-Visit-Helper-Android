package cn.wowjoy.commonlibrary.bean;

import java.util.List;

/**
 * @author sugar
 */
public class BaseListResponse<T> extends CommonListResponse<BaseListResponse.ListResponseData<T>>{


   public static class ListResponseData<T> extends CommonListData{

       public List<T> list;

       @Override
       public List<T> getList() {
           return list;
       }

       public void setList(List<T> list) {
           this.list = list;
       }
   }

    @Override
    public ListResponseData<T> getData() {
        return super.getData();
    }
}