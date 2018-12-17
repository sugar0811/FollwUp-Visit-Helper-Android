package cn.wowjoy.commonlibrary.bean.baseLiveData;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


/**
 * Created by Sherily on 2017/12/19.
 * Description:
 */

public class LiveDataWrapper<T> {

    @NonNull
    public final Status status;
    @Nullable
    public final T data;
    @Nullable public final Throwable error;
    private LiveDataWrapper(@NonNull Status status, @Nullable T data, @Nullable Throwable error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static <T> LiveDataWrapper<T> success(@NonNull T data) {
        return new LiveDataWrapper<>(Status.SUCCESS, data, null);
    }

    public static <T> LiveDataWrapper<T> error(Throwable error, @Nullable T data) {
        return new LiveDataWrapper<>(Status.ERROR, data, error);
    }

    public static <T> LiveDataWrapper<T> loading(@Nullable T data) {
        return new LiveDataWrapper<>(Status.LOADING, data, null);
    }
}
