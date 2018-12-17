package mobile.fuvh.cn.followupvisithelper.msg.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemMsgBinding;
import mobile.fuvh.cn.followupvisithelper.msg.bean.MessageItem;

/**
 *
 * @author sugar
 * @date 2018/12/15
 */

public class MessageViewModel extends AndroidViewModel{

    ObservableArrayList<MessageItem> msgs = new ObservableArrayList<>();

    public MessageViewModel(@NonNull Application application) {
        super(application);
        makeData();
    }


    public CommonAdapter getMsgAdapter(){
        return new CommonAdapter<MessageItem,ItemMsgBinding>(R.layout.item_msg,msgs) {

        };

    }


    private void makeData() {
       msgs.add(new MessageItem("1501","刘建国","2018-09-11 13:00"));
       msgs.add(new MessageItem("1502","李星","2018-09-12 15:00"));
       msgs.add(new MessageItem("1503","胡火","2018-08-11 13:00"));
    }


}
