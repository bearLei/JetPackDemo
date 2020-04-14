package com.example.androidjecpack.java.mvp;

import com.example.androidjecpack.java.ApiService;
import com.example.androidjecpack.java.RetrofitClient;
import com.example.androidjecpack.java.WeatherResponse;
import com.example.androidjecpack.java.mvp.base.BasePresenter;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/14
 * desc   :
 * version: 1.0
 */
public class WeatherPresenter extends BasePresenter<WeatherMvpView> {
    public WeatherPresenter(WeatherMvpView weatherMvpView) {
        super(weatherMvpView);
    }

    public void requestData(){
        RetrofitClient.getInstance().getService(ApiService.class).getWeather("8dab317e0fa74d7a3966197c79d8e6b3")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<WeatherResponse>() {
                    @Override
                    public void accept(WeatherResponse weatherResponse) throws Exception {
                        if (weatherResponse.getError_code()  != 0){
                            getView().showErrorView();
                        }else if (null != weatherResponse.getResult()&& weatherResponse.getResult().size() > 0){
                            getView().showData(weatherResponse.getResult());
                        }else {
                            getView().showEmptyView();
                        }
                    }
                });
    }
}
