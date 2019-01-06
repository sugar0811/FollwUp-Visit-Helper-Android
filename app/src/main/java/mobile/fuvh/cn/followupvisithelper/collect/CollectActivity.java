package mobile.fuvh.cn.followupvisithelper.collect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.collect.viewmodel.CollectViewModel;
import mobile.fuvh.cn.followupvisithelper.databinding.CollectActivityBinding;

/**
 *
 * @author sugar
 * @date 2019/1/3
 * 收藏页面
 */

public class CollectActivity extends BaseTitleActivity<CollectActivityBinding,CollectViewModel>{


    public static void launch(Context context){
        context.startActivity(new Intent(context,CollectActivity.class));
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("我的收藏");
        binding.setModel(viewModel);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.collect_activity;
    }

    @Override
    protected Class<CollectViewModel> getViewModelClass() {
        return CollectViewModel.class;
    }
}
