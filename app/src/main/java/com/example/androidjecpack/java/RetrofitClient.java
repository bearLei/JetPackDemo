package com.example.androidjecpack.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/14
 * desc   :
 * version: 1.0
 */
public class RetrofitClient {

    private static final int TIME_OUT = 10;

    private static final String BASE_URL = "http://v.juhe.cn/";

    private static volatile RetrofitClient mRetrofitClient;

    private Retrofit mRetrofit;


    private RetrofitClient() {
        Gson gson = new GsonBuilder().setLenient().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new ResponseInterceptor())
                .retryOnConnectionFailure(true)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static RetrofitClient getInstance() {

        if (null == mRetrofitClient) {
            synchronized (RetrofitClient.class) {
                if (null == mRetrofitClient) {
                    mRetrofitClient = new RetrofitClient();
                }
            }
        }
        return mRetrofitClient;
    }


    public <T> T getService(Class<T> tClass){
        return getInstance().mRetrofit.create(tClass);
    }
}
