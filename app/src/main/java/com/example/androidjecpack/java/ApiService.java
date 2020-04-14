package com.example.androidjecpack.java;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/14
 * desc   :
 * version: 1.0
 */
public interface ApiService {

    @GET("historyWeather/province")
    Observable<WeatherResponse> getWeather(@Query("key") String key);
}
