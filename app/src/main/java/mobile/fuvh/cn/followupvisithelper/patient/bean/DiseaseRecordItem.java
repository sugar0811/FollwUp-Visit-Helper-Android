package mobile.fuvh.cn.followupvisithelper.patient.bean;

import android.text.TextUtils;

/**
 *
 * @author sugar
 * @date 2018/12/4
 */

public class DiseaseRecordItem {

    private String recordTime;
    private String recordDoc;
    private String recordTitle;
    private int recordState;

    public DiseaseRecordItem() {
    }

    public DiseaseRecordItem(String recordTime, String recordDoc, String recordTitle, int recordState) {
        this.recordTime = recordTime;
        this.recordDoc = recordDoc;
        this.recordTitle = recordTitle;
        this.recordState = recordState;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getRecordDoc() {
        return recordDoc;
    }

    public void setRecordDoc(String recordDoc) {
        this.recordDoc = recordDoc;
    }

    public String getRecordTitle() {
        return recordTitle;
    }

    public String getStateStr(){
        if(recordState > 7){
            return "待确认";
        }
        return null;
    }
    public boolean isShowState(){
        return !TextUtils.isEmpty(getStateStr());
    }

    public String getContent(){
        return (TextUtils.isEmpty(recordDoc)?"":recordDoc) +(TextUtils.isEmpty(recordTime)?"":"  "+recordTime);
    }

    public void setRecordTitle(String recordTitle) {
        this.recordTitle = recordTitle;
    }

    public int getRecordState() {
        return recordState;
    }

    public void setRecordState(int recordState) {
        this.recordState = recordState;
    }
}
