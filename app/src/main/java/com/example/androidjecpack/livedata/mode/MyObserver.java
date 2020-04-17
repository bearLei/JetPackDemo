package com.example.androidjecpack.livedata.mode;

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/16
 * desc   :
 * version: 1.0
 */
public interface MyObserver<T> {
    void onChange(T t);
}
