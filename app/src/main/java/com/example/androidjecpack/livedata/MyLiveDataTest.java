package com.example.androidjecpack.livedata;

import android.util.Log;

import com.example.androidjecpack.livedata.mode.MyLiveData;
import com.example.androidjecpack.livedata.mode.MyObserver;

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/16
 * desc   :
 * version: 1.0
 */
public class MyLiveDataTest {
    public void testMyLiveData(){
        MyLiveData<String> myLiveData = new MyLiveData<>();
        myLiveData.addObServer(new MyObserver<String>() {
            @Override
            public void onChange(String s) {
                Log.d("test",s);
            }
        });

        myLiveData.setValue("hhhh");
    }
}
