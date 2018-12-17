package mobile.fuvh.cn.followupvisithelper.voice.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 *
 * @author sugar
 * @date 2018/12/14
 */

public abstract class IChatView extends FrameLayout{

    public IChatView(@NonNull Context context) {
        super(context);
    }

    public IChatView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public IChatView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 语音提示文字
     * @return
     */
   public abstract String getTipText();

}
