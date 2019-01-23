package mobile.fuvh.cn.followupvisithelper.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.view.View;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.collect.CollectActivity;
import mobile.fuvh.cn.followupvisithelper.contact.ContactsActivity;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemDrawerMenuBinding;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemTipMsgBinding;
import mobile.fuvh.cn.followupvisithelper.patient.view.list.view.PatientListActivity;
import mobile.fuvh.cn.followupvisithelper.setting.view.SettingActivity;
import mobile.fuvh.cn.followupvisithelper.voice.bean.DrawerMenuBean;
import mobile.fuvh.cn.followupvisithelper.voice.view.record.view.list.view.RecordListActivity;

/**
 *
 * @author sugar
 * @date 2018/11/30
 */

public class MainViewModel extends AndroidViewModel{

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public CommonAdapter getMenuAdapter() {
        return new CommonAdapter<DrawerMenuBean,ItemDrawerMenuBinding>(R.layout.item_drawer_menu, menuData(), new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                switch (position){
                    case 0:
                        PatientListActivity.launch(v.getContext());
                        break;
                    case 1:
                        ContactsActivity.launch(v.getContext());
                        break;
                    case 2:
                        RecordListActivity.launch(v.getContext());
                        break;
                    case 3:
                        CollectActivity.launch(v.getContext());
                        break;
                    case 4:
                        SettingActivity.launch(v.getContext());
                        break;
                    default:
                        break;
                }
            }
        }) {
        };
    }


    private ObservableArrayList<DrawerMenuBean> menuData() {
        ObservableArrayList<DrawerMenuBean> menus = new ObservableArrayList<>();
        menus.add(new DrawerMenuBean("我的病人",R.drawable.menu_patient));
        menus.add(new DrawerMenuBean("我的联系人",R.drawable.menu_contacts));
        menus.add(new DrawerMenuBean("录音记录",R.drawable.menu_recording));
        menus.add(new DrawerMenuBean("收藏",R.drawable.menu_collection));
        menus.add(new DrawerMenuBean("设置",R.drawable.menu_setting));
        return menus;
    }

    public CommonAdapter getTipMsgAdapter(){
        return new CommonAdapter<DrawerMenuBean,ItemTipMsgBinding>(R.layout.item_tip_msg,tipMsgData()) {
        };
    }

    private ObservableArrayList<DrawerMenuBean> tipMsgData() {
        ObservableArrayList<DrawerMenuBean> menus = new ObservableArrayList<>();
        menus.add(new DrawerMenuBean("开始查房",R.drawable.tip_disease));
        menus.add(new DrawerMenuBean("扫一扫",R.drawable.tip_follow_up));
        menus.add(new DrawerMenuBean("录音",R.drawable.tip_news));
//        menus.add(new DrawerMenuBean("查看刘建国的病例",R.drawable.tip_call));
        return menus;
    }

//    public CommonAdapter<DrawerMenuBean,ItemPopMenuBinding> getDeptAdapter() {
//        return new CommonAdapter<DrawerMenuBean, ItemPopMenuBinding>(R.layout.item_pop_menu, moreData()) {
//        };
//
//    }

//    private ObservableArrayList<DrawerMenuBean> moreData() {
//        ObservableArrayList<DrawerMenuBean> menus = new ObservableArrayList<>();
////        menus.add(new DrawerMenuBean("录音",R.drawable.more_record));
////        menus.add(new DrawerMenuBean("扫一扫",R.drawable.more_scan));
////        menus.add(new DrawerMenuBean("帮助",R.drawable.more_help));
//        return menus;
//    }

    public CommonAdapter getInputTipAdapter() {
        return new CommonAdapter(R.layout.item_hollow_tip,makeInputTipData()) {

        };
    }

    private ObservableArrayList makeInputTipData() {
        ObservableArrayList<String> strings = new ObservableArrayList<>();
        strings.add("病程记录");
        strings.add("白细胞");
        strings.add("病例详情");
        strings.add("医嘱详情");
        strings.add("查房");
        return strings;
    }
}
