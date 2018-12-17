package cn.wowjoy.commonlibrary.bean.xml.xmlBaseRequest;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 * Created by sinyo on 2017/7/27.
 */

public class RoleInfoBaseRequest {
//    @Element(name = "token", required = false)
//    public String TransId;

    @Attribute(name = "xmlns")
    public String NameAttribute;

    @Element(name = "content")
    public String content;

//    @Element(name = "retXml")
//    public String retXml;



}
