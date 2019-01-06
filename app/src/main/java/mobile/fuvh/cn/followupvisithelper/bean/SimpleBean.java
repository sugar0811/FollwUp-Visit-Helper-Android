package mobile.fuvh.cn.followupvisithelper.bean;

/**
 *
 * @author sugar
 * @date 2019/1/4
 */

public class SimpleBean {

    private String simpleField1;
    private String simpleField2;

    public SimpleBean() {

    }

    public SimpleBean(String simpleField1, String simpleField2) {
        this.simpleField1 = simpleField1;
        this.simpleField2 = simpleField2;
    }

    public String getSimpleField1() {
        return simpleField1;
    }

    public void setSimpleField1(String simpleField1) {
        this.simpleField1 = simpleField1;
    }

    public String getSimpleField2() {
        return simpleField2;
    }

    public void setSimpleField2(String simpleField2) {
        this.simpleField2 = simpleField2;
    }
}
