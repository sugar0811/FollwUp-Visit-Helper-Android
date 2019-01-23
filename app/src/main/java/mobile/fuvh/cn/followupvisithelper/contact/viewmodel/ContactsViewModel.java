package mobile.fuvh.cn.followupvisithelper.contact.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import cn.wowjoy.commonlibrary.viewmodel.BaseListViewModel;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.bean.SimpleBean;
import mobile.fuvh.cn.followupvisithelper.contact.ContactsActivity;

/**
 *
 * @author sugar
 * @date 2019/1/3
 */

public class ContactsViewModel extends BaseListViewModel<SimpleBean>{

    public ContactsViewModel(@NonNull Application application)
    {
        super(application);
        List<SimpleBean> objects = new ArrayList<>();
        objects.add(new SimpleBean("刘卡为","呼吸科"));
        objects.add(new SimpleBean("潘鑫雨","骨科"));
        objects.add(new SimpleBean("李晓岩","妇产科"));
        objects.add(new SimpleBean("沈肎虚","肾脏病科"));
        setItems(objects);
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_contact;
    }

    @Override
    public CommonAdapter.OnItemClickListener getOnItemClickListener() {

        return new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if( v.getContext() instanceof ContactsActivity){
                    ContactsActivity context = (ContactsActivity) v.getContext();
                    context.shareFinish();
                }
            }
        };
    }
}
