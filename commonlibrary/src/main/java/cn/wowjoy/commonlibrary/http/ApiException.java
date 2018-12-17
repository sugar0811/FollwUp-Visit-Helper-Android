package cn.wowjoy.commonlibrary.http;

/**
 * Created by Sherily on 2017/11/10.
 * Description:
 */

public class ApiException extends Exception {
    private int code;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public ApiException(Throwable cause, int code) {
        super(cause);
        this.code = code;
    }
}
