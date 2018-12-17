package mobile.fuvh.cn.followupvisithelper.voice.bean;

/**
 *
 * @author sugar
 * @date 2018/12/11
 */

public class DrawerMenuBean {

    String menuName;

    int menuIcon;

    public DrawerMenuBean() {
    }

    public DrawerMenuBean(String menuName, int menuIcon) {
        this.menuName = menuName;
        this.menuIcon = menuIcon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(int menuIcon) {
        this.menuIcon = menuIcon;
    }
}
