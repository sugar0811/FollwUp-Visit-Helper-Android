package mobile.fuvh.cn.followupvisithelper.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import cn.wowjoy.commonlibrary.utils.ToastUtils;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.contact.viewmodel.ContactsViewModel;
import mobile.fuvh.cn.followupvisithelper.databinding.ContactsActivityBinding;

/**
 *
 * @author sugar
 * @date 2019/1/3
 */

public class ContactsActivity extends BaseTitleActivity<ContactsActivityBinding,ContactsViewModel>{

    private static String type;

    public static void launch(Context context){
        type = "";
        context.startActivity(new Intent(context,ContactsActivity.class));
    }
    public static void launchByShare(Context context){
        Intent intent = new Intent(context, ContactsActivity.class);
        type = "share";
        context.startActivity(intent);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("我的联系人");
        binding.setModel(viewModel);
//        viewModel.getAdapter().setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//                Log.e("onItemClick",type);
//
//            }
//        });
    }
    public void shareFinish(){
        if(!TextUtils.isEmpty(type)){
            ToastUtils.showShort(ContactsActivity.this,"分享成功");
            finish();
        }
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
