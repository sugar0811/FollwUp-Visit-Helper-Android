package cn.wowjoy.commonlibrary.http;

import com.google.gson.JsonParseException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.json.JSONException;

import java.io.EOFException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;


/**
 * Created by Sherily on 2017/11/10.
 * Description:handle exception
 */

public class ExceptionEgine {
    //对应HTTP的状态码
    private static final int SERVE_NO_RESPONSE = 202;
    private static final int BAD_REQUEST = 400;
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static ApiException handleException(Throwable e){
        ApiException ex;

        if (e instanceof HttpException){             //HTTP错误
            HttpException httpException = (HttpException) e;
            ex = new ApiException(e, ERROR.HTTP_ERROR);
            switch(httpException.code()){
                case BAD_REQUEST:
                    ex = new ApiException(e, ERROR.BAD_REQUEST);
                    ex.setMessage("网络请求错误");
                    break;
                case NOT_FOUND:
                    ex = new ApiException(e, ERROR.NOT_FOUND);
                    ex.setMessage("抱歉，您访问的页面没有找到");
                    break;
                case INTERNAL_SERVER_ERROR:
                    ex = new ApiException(e, ERROR.INTERNAL_SERVER_ERROR);
                    ex.setMessage("未知错误，请重新尝试");
                    break;
                case UNAUTHORIZED:
                    ex = new ApiException(e,ERROR.UNAUTHORIZED);
                    ex.setMessage("请重新登录");
                    break;
                case FORBIDDEN:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex = new ApiException(e, ERROR.NETWORD_ERROR);
                    ex.setMessage("网络错误"); //均视为网络错误
                    break;
            }
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException){
            ex = new ApiException(e, ERROR.PARSE_ERROR);
            ex.setMessage("解析错误");           //均视为解析错误
            return ex;
        }else if(e instanceof ConnectException){
            ex = new ApiException(e, ERROR.NETWORD_ERROR);
            ex.setMessage("网络断开，请检查网络");  //均视为网络错误
            return ex;
        } else if(e instanceof SocketTimeoutException){
            ex = new ApiException(e, ERROR.NETWORD_ERROR);
            ex.setMessage("网络不给力，连接超时，请重试");  //均视为网络错误
            return ex;
        } else if (e instanceof EOFException){
            ex = new ApiException(e, ERROR.NO_RESPONSE_BODY);
            ex.setMessage("服务器开了个小差~");          //未知错误
            return ex;
        }else if(e instanceof UnknownHostException){
            ex = new ApiException(e, ERROR.NETWORD_ERROR);
            ex.setMessage("网络异常,请检查网络设置");
            return ex;
        }else {
            ex = new ApiException(e, ERROR.UNKNOWN);
            ex.setMessage(e.getMessage());          //未知错误
            return ex;
        }
    }
}
