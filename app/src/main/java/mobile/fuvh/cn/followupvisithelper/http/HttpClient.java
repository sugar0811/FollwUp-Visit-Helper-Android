package mobile.fuvh.cn.followupvisithelper.http;

import android.annotation.SuppressLint;

import cn.wowjoy.commonlibrary.bean.BaseResponse;
import cn.wowjoy.commonlibrary.utils.HttpUtils;
import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by sugar on 2019/1/15.
 */

public interface HttpClient {
    @SuppressLint("NewApi")
    static HttpClient getPacsService() {
        return HttpUtils.getInstance().getPacsServer(HttpClient.class);
    }

    //已完成就诊病人列表
    @POST("v1/exams/3/permit")
    Observable<BaseResponse> postPacsState();
}
