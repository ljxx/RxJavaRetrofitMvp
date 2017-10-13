package com.ylx.rxjavaretrofitmvp.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ylx.rxjavaretrofitmvp.api.base.BaseApiRetrofit;
import com.ylx.rxjavaretrofitmvp.model.request.CheckPhoneRequest;
import com.ylx.rxjavaretrofitmvp.model.response.CheckPhoneResponse;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/10/12  下午1:16
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class ApiRetrofit extends BaseApiRetrofit {

    public MyApi mApi;

    private static ApiRetrofit mInstance;

    public static ApiRetrofit getInstance(){
        if(mInstance == null){
            synchronized (ApiRetrofit.class){
                if(mInstance == null){
                    mInstance = new ApiRetrofit();
                }
            }
        }
        return mInstance;
    }

    private ApiRetrofit() {
        super();
        Gson gson = new GsonBuilder().setLenient().create();

        //在构造方法中对Retrofit接口对初始化
        mApi = new Retrofit.Builder()
                .baseUrl(MyApi.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(MyApi.class);
    }

    /**
     * 将对象转换gson对象
     * @param obj 参数对象
     * @return RequestBody
     */
    private RequestBody getRequestBody(Object obj){
        String route = new Gson().toJson(obj);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), route);
        return body;
    }

    /**
     * 检查手机是否注册
     */
    public Observable<CheckPhoneResponse> checkPhoneAvailable(String region, String phone){
        return mApi.checkPhoneAvailable(getRequestBody(new CheckPhoneRequest(phone, region)));
    }


}
