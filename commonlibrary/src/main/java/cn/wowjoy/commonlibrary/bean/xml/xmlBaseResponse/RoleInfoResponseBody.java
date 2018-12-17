package cn.wowjoy.commonlibrary.bean.xml.xmlBaseResponse;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by sinyo on 2017/7/29.
 */

@Root(name = "Body")
public class RoleInfoResponseBody {

//    @Attribute(name = "xmlns")
//    public String NameAttribute;

    @Element(name = "Etrack_ProcInterfaceResponse")
    public RoleInfoResponse roleInfoResponse;

}