package mobile.fuvh.cn.followupvisithelper.voice.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 * @author sugar
 * @date 2018/12/12
 */

public class RecordBean implements Parcelable {

    private String recordPath;
    private String recordName;
    private String recordDuration;
    private String recordTime;
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public RecordBean() {
    }

    public RecordBean(String recordPath, String recordName, String recordDuration, String recordTime, int length) {
        this.recordPath = recordPath;
        this.recordName = recordName;
        this.recordDuration = recordDuration;
        this.recordTime = recordTime;
        this.length = length;
    }

    public String getRecordPath() {
        return recordPath;
    }

    public String getRecordName() {
        return recordName;
    }

    public String getRecordDuration() {
        return recordDuration;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordPath(String recordPath) {
        this.recordPath = recordPath;
    }

    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    public void setRecordDuration(String recordDuration) {
        this.recordDuration = recordDuration;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.recordPath);
        dest.writeString(this.recordName);
        dest.writeString(this.recordDuration);
        dest.writeString(this.recordTime);
        dest.writeInt(this.length);
    }

    protected RecordBean(Parcel in) {
        this.recordPath = in.readString();
        this.recordName = in.readString();
        this.recordDuration = in.readString();
        this.recordTime = in.readString();
        this.length = in.readInt();
    }

    public static final Parcelable.Creator<RecordBean> CREATOR = new Parcelable.Creator<RecordBean>() {
        @Override
        public RecordBean createFromParcel(Parcel source) {
            return new RecordBean(source);
        }

        @Override
        public RecordBean[] newArray(int size) {
            return new RecordBean[size];
        }
    };
}
