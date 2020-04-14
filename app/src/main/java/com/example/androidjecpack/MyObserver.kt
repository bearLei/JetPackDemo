package com.example.androidjecpack

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/3/5
 * desc   :
 * version: 1.0
 */
class MyObserver:LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun oncreate(){
        Log.d("lei","MyObserver:onCreate")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        Log.d("lei","MyObserver:onPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        Log.d("lei","MyObserver:onResume")
    }
}