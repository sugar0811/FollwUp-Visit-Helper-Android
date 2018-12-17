package mobile.fuvh.cn.followupvisithelper.patient.view.list.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.view.View;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemMsgBinding;
import mobile.fuvh.cn.followupvisithelper.msg.bean.MessageItem;
import mobile.fuvh.cn.followupvisithelper.patient.view.inpatientbasic.InPatientBasicActivity;

/**
 *
 * @author sugar
 * @date 2018/12/15
 */

public class PatientListViewModel extends AndroidViewModel{

    public PatientListViewModel(@NonNull Application application) {
        super(application);
        makeData();
    }

    private ObservableArrayList<MessageItem> msgs = new ObservableArrayList<>();


    public CommonAdapter getPatientAdapter(){
        return new CommonAdapter<MessageItem,ItemMsgBinding>(R.layout.item_patient, msgs, new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                InPatientBasicActivity.launch(v.getContext());
            }
        }) {

        };

    }


    private void makeData() {
        msgs.add(new MessageItem("刘建国","2B15床","慢性肾脏病"));
    }

}
