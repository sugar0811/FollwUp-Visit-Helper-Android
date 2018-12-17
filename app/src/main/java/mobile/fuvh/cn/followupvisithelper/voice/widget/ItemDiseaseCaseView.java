package mobile.fuvh.cn.followupvisithelper.voice.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import cn.wowjoy.commonlibrary.utils.CommonUtils;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.patient.view.inpatientbasic.InPatientBasicActivity;

/**
 *
 * @author sugar
 * @date 2018/12/13
 */

public class ItemDiseaseCaseView extends IChatView {

    public ItemDiseaseCaseView(@NonNull Context context) {
        this(context,null);
    }

    public ItemDiseaseCaseView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ItemDiseaseCaseView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_disease_case,this);
        setOnClickListener((v)->{
            InPatientBasicActivity.launch(v.getContext());
        });
    }

    @Override
    public String getTipText() {
        return CommonUtils.getString(R.string.chat_tip_case);
    }
}
