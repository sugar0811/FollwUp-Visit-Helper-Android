package mobile.fuvh.cn.followupvisithelper.voice.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import cn.wowjoy.commonlibrary.utils.CommonUtils;
import cn.wowjoy.commonlibrary.utils.ImageUtils;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.contact.ContactsActivity;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemDiseaseDetailBinding;
import mobile.fuvh.cn.followupvisithelper.helper.AppDialogHelper;
import mobile.fuvh.cn.followupvisithelper.patient.view.pacs.PacsWebActivity;

/**
 * @author sugar
 * @date 2019/1/10
 */

public class ItemDiseaseDetailView extends IChatView implements View.OnClickListener {

    private ItemDiseaseDetailBinding mbinding;
    private TextView mTvToggle;
    private AnimationDrawable mChaFangAnimationDrawable;
    private static final String APP_ID = "wx0728b5b3d9930869";    //这个APP_ID就是注册APP的时候生成的
    private static final String APP_SECRET = "8e2de15741a8eb5d4c3165f5711dc921";
    public IWXAPI api;
    private Dialog mShareDialog;

    public ItemDiseaseDetailView(@NonNull Context context) {
        this(context, null);

    }

    public ItemDiseaseDetailView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemDiseaseDetailView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_disease_detail, this);
        LinearLayout mLlDetailMsg = findViewById(R.id.llDetailMsg);
        findViewById(R.id.tvPacs).setOnClickListener((v) -> {
            PacsWebActivity.launch(v.getContext(), "");
        });
        ImageView mIvCollect = findViewById(R.id.ivCollect);
        mTvToggle = findViewById(R.id.tvExpand);
        mIvCollect.setOnClickListener((v) -> {
            mIvCollect.setSelected(!mIvCollect.isSelected());
        });
        findViewById(R.id.ivShare).setOnClickListener((v) -> {
            mShareDialog = AppDialogHelper.showShareDialog(v.getContext(), this);
        });
        findViewById(R.id.tvExpand).setOnClickListener((v) -> {
            if (mLlDetailMsg.getVisibility() == GONE) {
                mLlDetailMsg.setVisibility(VISIBLE);
                mTvToggle.setText("收起");
                mTvToggle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.top, 0);
            } else {
                mLlDetailMsg.setVisibility(GONE);
                mTvToggle.setText("展开");
                mTvToggle.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down_expand, 0);
            }
        });
        registerWX();
    }

    private void registerWX() {
        api = WXAPIFactory.createWXAPI(getContext(), APP_ID, true);
        api.registerApp(APP_ID);
    }

    @Override
    public String getTipText() {
        return CommonUtils.getString(R.string.chat_tip_chart);
    }


    private void share() {
        WXWebpageObject wxWebpageObject = new WXWebpageObject();
        wxWebpageObject.webpageUrl = "http://47.100.16.211:8081/#/diseaseDetail";
        WXMediaMessage wxMediaMessage = new WXMediaMessage(wxWebpageObject);
        wxMediaMessage.title = "病程记录";
        wxMediaMessage.description = "男 44岁";
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.share_disease);
        wxMediaMessage.thumbData = ImageUtils.bmpToByteArray(bitmap, true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = wxMediaMessage;
        req.scene = SendMessageToWX.Req.WXSceneSession;
        boolean b = api.sendReq(req);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_wechat:
                share();
                if(mShareDialog != null){
                    mShareDialog.dismiss();
                }
                break;
            case R.id.llDoctor:
                ContactsActivity.launchByShare(v.getContext());
                if(mShareDialog != null){
                    mShareDialog.dismiss();
                }
                break;
            case R.id.tv_cancel:
                if(mShareDialog != null){
                    mShareDialog.dismiss();
                }
                break;
            default:

                break;
        }
    }
}
