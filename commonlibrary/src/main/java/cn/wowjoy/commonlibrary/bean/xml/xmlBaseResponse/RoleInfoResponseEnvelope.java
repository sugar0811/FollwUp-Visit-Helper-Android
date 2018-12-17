package cn.wowjoy.commonlibrary.bean.xml.xmlBaseResponse;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import cn.wowjoy.commonlibrary.bean.BaseResponse;

/**
 * Created by sinyo on 2017/7/29.
 */
@Root(name = "soap:Envelope")
@NamespaceList({
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
        @Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd"),
        @Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap")
})
public class RoleInfoResponseEnvelope extends BaseResponse {
    @Element(name = "Body")
    public RoleInfoResponseBody body;

}
