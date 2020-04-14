package com.example.androidjecpack.java.mvp;

import com.example.androidjecpack.java.WeatherResponse;
import com.example.androidjecpack.java.mvp.base.IBaseView;

import java.util.List;

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/14
 * desc   :
 * version: 1.0
 */
public interface WeatherMvpView extends IBaseView {

    void action01();
    void action02();

    void showData(List<WeatherResponse.WeatherBean> data);
}
