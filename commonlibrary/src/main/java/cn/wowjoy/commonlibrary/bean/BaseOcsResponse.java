package cn.wowjoy.commonlibrary.bean;

public class BaseOcsResponse<T>  extends BaseResponse<T>{



    /**
     * code : 200
     * httpCode : OK
     * message : 请求成功！
     */
    private int code;
    private String httpCode;
    private String message;
    private T data;

    @Override
    public int  getCode() {
        return code;
    }
    @Override
    public void setCode(int code) {
        this.code = code;
    }

    public String getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(String httpCode) {
        this.httpCode = httpCode;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setResults(T results) {
      this.data = results;
    }
}
