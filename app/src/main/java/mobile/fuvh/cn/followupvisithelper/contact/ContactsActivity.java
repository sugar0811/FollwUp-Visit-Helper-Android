package mobile.fuvh.cn.followupvisithelper.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.contact.viewmodel.ContactsViewModel;
import mobile.fuvh.cn.followupvisithelper.databinding.ContactsActivityBinding;

/**
 *
 * @author sugar
 * @date 2019/1/3
 */

public class ContactsActivity extends BaseTitleActivity<ContactsActivityBinding,ContactsViewModel>{

    public static void launch(Context context){
        context.startActivity(new Intent(context,ContactsActivity.class));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("我的联系人");
        binding.setModel(viewModel);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.contacts_activity;
    }

    @Override
    protected Class<ContactsViewModel> getViewModelClass() {
        return ContactsViewModel.class;
    }
}
