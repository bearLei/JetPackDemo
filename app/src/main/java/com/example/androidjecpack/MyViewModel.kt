package com.example.androidjecpack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/3/5
 * desc   :
 * version: 1.0
 */
class MyViewModel:ViewModel() {
    private val users:MutableLiveData<String> by lazy {
        MutableLiveData<String>().also{

        }
    }

    fun getUser():MutableLiveData<String>{
        return users
    }
}