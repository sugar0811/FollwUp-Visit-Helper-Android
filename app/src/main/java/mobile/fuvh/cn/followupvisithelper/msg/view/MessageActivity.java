package mobile.fuvh.cn.followupvisithelper.msg.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import cn.wowjoy.commonlibrary.base.BaseTitleActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.VoiceMessageActivityBinding;
import mobile.fuvh.cn.followupvisithelper.msg.viewmodel.MessageViewModel;

/**
 *
 * @author sugar
 * @date 2018/12/15
 */

public class MessageActivity extends BaseTitleActivity<VoiceMessageActivityBinding,MessageViewModel>{


    public static void launch(Context context){
        context.startActivity(new Intent(context,MessageActivity.class));
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        normalTitle("待处理任务");
        binding.rvMessage.setAdapter(viewModel.getMsgAdapter());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.voice_message_activity;
    }

    @Override
    protected Class<MessageViewModel> getViewModelClass() {
        return MessageViewModel.class;
    }
}
