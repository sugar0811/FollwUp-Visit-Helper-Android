package cn.wowjoy.commonlibrary.bean;

public class TypeVersion {


    /**
     * type : deposit_bank
     * version : 1
     */

    private String type;
    private String version;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public TypeVersion() {
    }

    public TypeVersion(String type, String version) {
        this.type = type;
        this.version = version;
    }
}
