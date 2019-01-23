package cn.wowjoy.commonlibrary.utils;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import cn.wowjoy.commonlibrary.BuildConfig;
import cn.wowjoy.commonlibrary.app.Constans;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * 网络工具类
 */

public class HttpUtils {
    private Gson gson;
    private static final String OAUTH = "oauth";
    private static final String GATEWAY = "gateway";
    private static HttpUtils instance;
    private Object mUpdateServer;
    private Object mOauthServer;
    private Object mPacsServer;
    private Object mGetWayServer;
    private Object mDownloadServer;
     private Object mTestService;
    private Object mWebServer;
     private Object mOutpatinetService;
    public static HttpUtils getInstance() {
        if (instance == null) {
            synchronized (HttpUtils.class) {
                if (instance == null) {
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    /***
     * 根据不同的状态(测试、生产、oauth、gateway等)生成baseUrl
     * 为适应有多个HttpClient的情况所以使用泛型
     * @param t
     * @param <T>
     * @return
     */
    public <T> T getUpdateServer(Class<T> t) {
        if (null == mUpdateServer) {
            synchronized (HttpUtils.class) {
                if (null == mUpdateServer) {
                    mUpdateServer = getBuilder(BuildConfig.UPDATE_HOST).build().create(t);
                }
            }
        }
        return (T) mUpdateServer;
    }

    public <T> T getDownloadServer(Class<T> t, String url) {
        if (null == mDownloadServer) {
            synchronized (HttpUtils.class) {
                if (null == mDownloadServer) {
                    mDownloadServer = getBuilder(url).build().create(t);
                }
            }
        }

        return (T) mDownloadServer;
    }
    public <T> T getTestServer(Class<T> t) {
        if (null == mTestService) {
            synchronized (HttpUtils.class) {
                if (null == mTestService) {
                    mTestService = getBuilder("https://test-gateway.rubikstack.com/doctor-assistant/").build().create(t);
                }
            }
        }

        return (T) mTestService;
    }
    public <T> T getOauthServer(Class<T> t) {
        if (null == mOauthServer) {
            synchronized (HttpUtils.class) {
                if (null == mOauthServer) {
                    mOauthServer = getBuilder(BuildConfig.LOGIN_HOST).build().create(t);
                }
            }
        }
        return (T) mOauthServer;
    }

    public <T> T getPacsServer(Class<T> t) {
        if (null == mPacsServer) {
            synchronized (HttpUtils.class) {
                if (null == mPacsServer) {
                    mPacsServer = getBuilder(BuildConfig.PACS_HOST).build().create(t);
                }
            }
        }
        return (T) mPacsServer;
    }

    public <T> T getOutpatinetService(Class<T> t) {
        if (null == mOutpatinetService) {
            synchronized (HttpUtils.class) {
                if (null == mOutpatinetService) {
                    mOutpatinetService = getBuilder(BuildConfig.OUTPATIENT_HOST).build().create(t);
                }
            }
        }
        return (T) mOutpatinetService;
    }
    public <T> T getGateWayServer(Class<T> t) {
        if (null == mGetWayServer) {
            synchronized (HttpUtils.class) {
                if (null == mGetWayServer) {
                    mGetWayServer = getBuilder(BuildConfig.API_HOST).build().create(t);
                }
            }
        }

        return (T) mGetWayServer;
    }
    public <T> T getWebServer(Class<T> t) {
        if (null == mWebServer) {
            synchronized (HttpUtils.class) {
                if (null == mWebServer) {
                    mWebServer = getWebBuilder(BuildConfig.WEB_HOST).create(t);
                }
            }
        }

        return (T) mWebServer;
    }
    private Retrofit getWebBuilder(String apiUrl) {
        Retrofit builder =  new Retrofit.Builder()
                .baseUrl(apiUrl)
                .client(getOkHttpClientWEB())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return builder;
    }
    private OkHttpClient getOkHttpClientWEB() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        //设置超时时间
        clientBuilder.connectTimeout(30, TimeUnit.SECONDS);
        clientBuilder.writeTimeout(30, TimeUnit.SECONDS);
        clientBuilder.readTimeout(30, TimeUnit.SECONDS);
        clientBuilder.retryOnConnectionFailure(false);

        Interceptor mTokenInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Log.e("Request", originalRequest.url().toString());
                Request authorised = originalRequest.newBuilder()
//                        .header("Content-Type", "text/xml;charset=UTF-8")//添加请求头
//                        .method(originalRequest.method(), originalRequest.body())
                        .build();
                return chain.proceed(authorised);
            }
        };
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);



        clientBuilder.addNetworkInterceptor(mTokenInterceptor);
        return clientBuilder
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }
    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
        okBuilder.readTimeout(30, TimeUnit.SECONDS);
        okBuilder.connectTimeout(30, TimeUnit.SECONDS);
        okBuilder.writeTimeout(30, TimeUnit.SECONDS);
        okBuilder.protocols(Collections.singletonList(Protocol.HTTP_1_1));
        okBuilder.addInterceptor(new HttpHeadInterceptor());
        okBuilder.addInterceptor(getInterceptor());
        return okBuilder.build();

    }

    private HttpLoggingInterceptor getInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY); // 测试
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE); // 打包
        }
        return interceptor;
    }

    private Retrofit.Builder getBuilder(String apiUrl) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(getOkHttpClient());
        builder.baseUrl(apiUrl);//设置远程地址
        builder.addConverterFactory(GsonConverterFactory.create(getGson()));
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        return builder;
    }
    private Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder().create();
        }
        return gson;
    }

    private class HttpHeadInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder builder = request.newBuilder();
            builder.header("Content-Type", "application/json;charset=UTF-8");
            builder.addHeader("Connection", "close");
            builder.header("User-Agent", Build.VERSION.SDK_INT + ";" + Build.BRAND + " " + Build.MODEL + ";" + SysUtils.getVersionName());
            if (TextUtils.isEmpty(request.header("Authorization"))) {
                builder.addHeader("Authorization", "bearer " + SPUtils.getString(Constans.GATEWAY_TOKEN, ""));
            }
            return chain.proceed(builder.build());
        }
    }

    private OkHttpClient.Builder getUnsafeOkHttpClient() {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
