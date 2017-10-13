package com.ylx.rxjavaretrofitmvp.api.base;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/10/12  下午1:17
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class BaseApiRetrofit {

    private OkHttpClient mClient;

    public OkHttpClient getClient() {
        return mClient;
    }


    public BaseApiRetrofit() {
        mClient = new OkHttpClient.Builder()
                .addInterceptor(REWRITE_HEADER_CONTROL_INTERCEPTOR)
                .build();
    }

    Interceptor REWRITE_HEADER_CONTROL_INTERCEPTOR = chain ->{
        Request request = chain.request()
                .newBuilder()
                .addHeader("Content-Type", "application/json")
    //          .addHeader("Content-Type", "application/json; charset=utf-8")
//              .addHeader("Accept-Encoding", "gzip, deflate")
//              .addHeader("Connection", "keep-alive")
//              .addHeader("Accept", "*/*")
//              .addHeader("Cookie", "add cookies here")
                .build();
        return chain.proceed(request);
    };


}
