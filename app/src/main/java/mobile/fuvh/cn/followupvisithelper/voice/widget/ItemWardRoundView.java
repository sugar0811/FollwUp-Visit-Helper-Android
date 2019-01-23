package mobile.fuvh.cn.followupvisithelper.voice.widget;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

import cn.wowjoy.commonlibrary.adapter.CommonAdapter;
import cn.wowjoy.commonlibrary.utils.CommonUtils;
import cn.wowjoy.commonlibrary.utils.DateUtils;
import cn.wowjoy.commonlibrary.utils.RecorderUtil;
import cn.wowjoy.commonlibrary.utils.SPUtils;
import cn.wowjoy.commonlibrary.utils.photo.PhotoViewActivity;
import mobile.fuvh.cn.followupvisithelper.R;
import mobile.fuvh.cn.followupvisithelper.databinding.ItemPickCameraBinding;
import mobile.fuvh.cn.followupvisithelper.main.MainActivity;
import mobile.fuvh.cn.followupvisithelper.patient.view.pacs.PacsWebActivity;
import mobile.fuvh.cn.followupvisithelper.voice.bean.RecordBean;
import mobile.fuvh.cn.followupvisithelper.voice.view.record.view.list.view.PlaybackFragment;

/**
 *
 * @author sugar
 * @date 2019/1/12
 * 查房信息控件
 */

public class ItemWardRoundView extends IChatView{

    private RecorderUtil recorderUtil;
    private RecordBean recordBean;
    private HashMap<String,RecordBean> mRecordMap = new HashMap<>();
    private String recordChaFang ="chafang";
    private String recordTiZhen ="tizhen";
    private String recordYiJian ="yijian";
    private HashMap<String,ObservableArrayList> mRecordImgMap = new HashMap<>();
    private ObservableArrayList<String> mChaFangImgs = new ObservableArrayList<>();
    private ObservableArrayList<String> mTiZhenImgs = new ObservableArrayList<>();
    private ObservableArrayList<String> mYiJianImgs = new ObservableArrayList<>();
    private RecyclerView mRvChaFang;
    private RecyclerView mRvTiZhen;
    private RecyclerView mRvYiJian;

    public ItemWardRoundView(@NonNull Context context) {
        this(context,null);
    }

    public ItemWardRoundView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context,null,0);
    }

    public ItemWardRoundView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_ward_round_view, this);
        recorderUtil = new RecorderUtil();
        FrameLayout mFlRecord = findViewById(R.id.flRecord);
        FrameLayout mFlCamera = findViewById(R.id.flCamera);
        TextView mTvRecord = findViewById(R.id.tvRecord);
        TextView mTvRecordTiZhen = findViewById(R.id.tvRecordTiZhen);
        TextView mTvRecordYiJian = findViewById(R.id.tvRecordYiJian);
        LinearLayout mLlDetailMsg = findViewById(R.id.llDetailMsg);
        mRvChaFang = findViewById(R.id.rvChaFang);
        mRvTiZhen = findViewById(R.id.rvTiZhen);
        mRvYiJian = findViewById(R.id.rvYiJian);
        TextView mTvToggle = findViewById(R.id.tvExpand);
        mFlRecord.setOnClickListener((v)->{
            record(mTvRecord,recordChaFang,"查房沟通");
        });
        findViewById(R.id.flRecord_chati).setOnClickListener(v->{
            record(mTvRecordTiZhen,recordTiZhen,"查体体征");
        });
        findViewById(R.id.flRecord_yijian).setOnClickListener(v->{
            record(mTvRecordYiJian,recordYiJian,"治疗意见");
        });
        findViewById(R.id.ivCollect).setOnClickListener((v)->{
            v.setSelected(!v.isSelected());
        });
        goCarema(findViewById(R.id.flCamera),recordChaFang);
        goCarema(findViewById(R.id.flCamera_chati),recordTiZhen);
        goCarema(findViewById(R.id.flCamera_yijian),recordYiJian);

        mTvRecord.setOnClickListener((v)->{
            playRecord(v,recordChaFang);
        });

        mTvRecordTiZhen.setOnClickListener((v)->{
            playRecord(v,recordTiZhen);
        });
        mTvRecordYiJian.setOnClickListener((v)->{
            playRecord(v,recordYiJian);
        });
        findViewById(R.id.tvPacs).setOnClickListener((v)->{
            PacsWebActivity.launch(v.getContext(),"");
        });
        findViewById(R.id.tvExpand).setOnClickListener((v)->{
            if(mLlDetailMsg.getVisibility() == GONE){
                mLlDetailMsg.setVisibility(VISIBLE);
                mTvToggle.setText("收起");
                mTvToggle.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.top,0);

            }else{
                mLlDetailMsg.setVisibility(GONE);
                mTvToggle.setText("展开");
                mTvToggle.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.down_expand,0);
            }
        });
        initData();
    }

    private void initData() {
        mRecordImgMap.put(recordChaFang,mChaFangImgs);
        mRecordImgMap.put(recordTiZhen,mTiZhenImgs);
        mRecordImgMap.put(recordYiJian,mYiJianImgs);
        setRv(mRvChaFang,mChaFangImgs);
        setRv(mRvTiZhen,mTiZhenImgs);
        setRv(mRvYiJian,mYiJianImgs);
    }

    private void setRv(RecyclerView rv , ObservableArrayList<String> datas) {
        rv.setLayoutManager(getGrid3LayoutManager());
        rv.setAdapter(getImgAdapter(datas));
    }

    @NonNull
    private GridLayoutManager getGrid3LayoutManager() {
        return new GridLayoutManager(getContext(), 3);
    }

    @NonNull
    private CommonAdapter<String, ItemPickCameraBinding> getImgAdapter(ObservableArrayList<String> list) {
        CommonAdapter<String, ItemPickCameraBinding> commonAdapter = new CommonAdapter<String, ItemPickCameraBinding>(R.layout.item_pick_camera, list) {

        };
        commonAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if(list != null) {
                    PhotoViewActivity.launch(v.getContext(), list.get(position));
                }
            }
        });
        return commonAdapter;
    }

    public void dispatchImage(String key,String imagePath){
        ObservableArrayList<String> observableArrayList = mRecordImgMap.get(key);
        observableArrayList.add(imagePath);
    }

    private void goCarema(View view,String key){
        view.setOnClickListener((v)->{
            Context context = getContext();
            if(context instanceof MainActivity){
                MainActivity mainActivity = (MainActivity) context;
                mainActivity.goCamera(this,key);
            }
        });
    }
    private void playRecord(View v,String recordKey) {
        PlaybackFragment playbackFragment =
                new PlaybackFragment().newInstance(mRecordMap.get(recordKey));

        FragmentTransaction transaction = ((FragmentActivity) v.getContext())
                .getSupportFragmentManager()
                .beginTransaction();

        playbackFragment.show(transaction, "dialog_playback");
    }

    public void record(TextView mTvRecord,String recordKey,String recordName) {
        Context context = getContext();
        if(context instanceof MainActivity){
            MainActivity mainActivity = (MainActivity) context;
            mainActivity.recordStart(this,mTvRecord,recordKey,recordName);
        }

        if(recorderUtil.isRecording()) {
            long l = recorderUtil.stopRecording();
            String filePath = recorderUtil.getFilePath();
            if(null != filePath) {
                String fileName = filePath.substring(filePath.lastIndexOf("/")+1, filePath.length());
                SPUtils.putLong(fileName, l);
            }
            mTvRecord.setVisibility(VISIBLE);
            String s = DateUtils.toTime(l);
            mTvRecord.setText(s);
            recordBean = new RecordBean(recorderUtil.getFilePath(),recordName, s,s , (int) l);
            mRecordMap.put(recordKey,recordBean);
        }else{
            recorderUtil.startRecording();
        }
    }


    private void putLocalFileDuration() {
        long l = recorderUtil.stopRecording();
        String filePath = recorderUtil.getFilePath();
        if(null != filePath) {
            String fileName = filePath.substring(filePath.lastIndexOf("/")+1, filePath.length());
            SPUtils.putLong(fileName, l);
        }
    }

    @Override
    public String getTipText() {
        return CommonUtils.getString(R.string.chat_tip_chart);
    }
}
