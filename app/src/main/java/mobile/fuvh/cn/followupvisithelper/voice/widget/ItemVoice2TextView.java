package mobile.fuvh.cn.followupvisithelper.voice.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import mobile.fuvh.cn.followupvisithelper.R;

/**
 *
 * @author sugar
 * @date 2018/12/11
 */

public class ItemVoice2TextView extends IChatView {

    private TextView tvContent;
    private LinearLayout llRoot;

    public ItemVoice2TextView(@NonNull Context context) {
        this(context,null);
    }

    public ItemVoice2TextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ItemVoice2TextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_text,this);
        tvContent = findViewById(R.id.tvContent);
        llRoot = findViewById(R.id.llRoot);
    }

    public void text(String str){
        tvContent.setText(str);
    }


    public void left(){
        tvContent.setBackgroundResource(R.drawable.corners_08e38c);
        llRoot.setGravity(Gravity.LEFT);
    }

    public void right(){
        llRoot.setGravity(Gravity.RIGHT);
    }

    @Override
    public String getTipText() {
        return tvContent.getText().toString();
    }
}
