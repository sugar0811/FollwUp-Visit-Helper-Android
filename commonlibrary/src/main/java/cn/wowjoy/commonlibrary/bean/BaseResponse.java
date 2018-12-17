package cn.wowjoy.commonlibrary.bean;

public class BaseResponse<T> {
    private int state;
    private String msg;
    private T results;

    public void setCode(int code) {
        this.state = code;
    }

    public int getCode() {
        return state;
    }


    public T getData() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public String getMessage() {
        return msg;
    }

    public static boolean isSuccess(BaseResponse resp) {
        return resp.getCode() == 200 || resp.getCode() == 0;
    }

}