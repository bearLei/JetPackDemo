package com.example.androidjecpack.livedata.mode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/16
 * desc   :
 * version: 1.0
 */
public class MyLiveData<T>{

    private ArrayList<MyObserver> observers = new ArrayList<>();

    /**
     * 添加观察者
     *
     * @param observer
     */
    public void addObServer(MyObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    /**
     * 移除观察者
     *
     * @param observer
     */
    public void removeObServer(MyObserver observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    /**
     * 通知各个观察者值的变换
     */
    public void setValue(T value) {
        for (MyObserver observer : observers) {
            observer.onChange(value);
        }
    }

}
