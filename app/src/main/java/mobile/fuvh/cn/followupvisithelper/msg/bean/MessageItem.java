package mobile.fuvh.cn.followupvisithelper.msg.bean;

/**
 *
 * @author sugar
 * @date 2018/12/15
 */

public class MessageItem {


    private String name;
    private String number;
    private String time;
    private boolean isHaste;

    public boolean isHaste() {
        return isHaste;
    }

    public MessageItem(String name, String number, String time, boolean isHaste) {
        this.name = name;
        this.number = number;
        this.time = time;
        this.isHaste = isHaste;
    }

    public void setHaste(boolean haste) {
        isHaste = haste;
    }

    public MessageItem() {
    }

    public MessageItem(String name, String number, String time) {
        this.name = name;
        this.number = number;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
