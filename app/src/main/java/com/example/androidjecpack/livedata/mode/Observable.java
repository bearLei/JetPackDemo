package com.example.androidjecpack.livedata.mode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/16
 * desc   :
 * version: 1.0
 */
public class Observable {
    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer){
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }

    public void notifyChange(){
        for (Observer observer:observers) {
            observer.onNotifyDataChange();
        }
    }
}
