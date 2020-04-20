package com.example.androidjecpack.mvvm

import androidx.lifecycle.MutableLiveData
import com.example.androidjecpack.mvvm.base.BaseViewModel
import com.example.androidjecpack.mvvm.room.TestBean

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/3/5
 * desc   :
 * version: 1.0
 */
class TestViewModel(private val repository:TestRepository): BaseViewModel() {


    private val allData:MutableLiveData<List<TestBean>> by lazy {
        MutableLiveData<List<TestBean>>()
    }

    fun queryLocal() = launchLocal {
        repository.getLocal()
    }

    fun queryRemote() = launchRemote({
        repository.getRemote()
    },{
        //异常
    },{
        //finally
    })

    fun getAll():MutableLiveData<List<TestBean>>{
        return allData
    }
}