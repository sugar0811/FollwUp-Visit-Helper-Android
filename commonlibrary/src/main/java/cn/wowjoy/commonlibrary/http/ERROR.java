package cn.wowjoy.commonlibrary.http;

/**
 * Created by Sherily on 2017/11/10.
 * Description:
 */

public class ERROR {
    /**
     *202
     */
    public static final int SERVE_NO_RESPONSE = 202;

    public static final int BAD_REQUEST = 400;
    /**
     * 404
     */
    public static final int NOT_FOUND = 404;

    /**
     * 401,token失效没有权限
     */
    public static final int UNAUTHORIZED = 401;
    /**
     * 服务器错误
     */
    public static final int INTERNAL_SERVER_ERROR = 500;
    /**
     * 未知错误
     */
    public static final int UNKNOWN = 1000;
    /**
     * 解析错误
     */
    public static final int PARSE_ERROR = 1001;
    /**
     * 网络错误
     */
    public static final int NETWORD_ERROR = 1002;
    /**
     * 协议出错
     */
    public static final int HTTP_ERROR = 1003;
    /**
     * NO RESPONSE BODY
     */
    public static final int NO_RESPONSE_BODY = 1004;

}
