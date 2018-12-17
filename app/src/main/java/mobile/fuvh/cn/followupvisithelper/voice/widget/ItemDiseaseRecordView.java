package mobile.fuvh.cn.followupvisithelper.voice.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import cn.wowjoy.commonlibrary.utils.CommonUtils;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.patient.view.diaseaserecord.view.DiseaseRecordActivity;

/**
 *
 * @author sugar
 * @date 2018/12/13
 * 病程记录卡片
 */

public class ItemDiseaseRecordView extends IChatView {

    public ItemDiseaseRecordView(@NonNull Context context) {
        this(context,null);
    }

    public ItemDiseaseRecordView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ItemDiseaseRecordView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_disease_record_card,this);
        listener();
    }

    private void listener() {
        setOnClickListener((v)->{
            DiseaseRecordActivity.launch(v.getContext());
        });
    }

    @Override
    public String getTipText() {
        return CommonUtils.getString(R.string.chat_tip_chart);
    }
}
