package com.example.androidjecpack.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.lang.Exception


/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/7
 * desc   : 设计基类的思路
 * 1:让每个ViewModel都持有1个LiveData数据--->支持泛型
 * 2:提供加载本地数据的能力
 * 3:提供加载远程数据的能力
 * 4:提供错误的统一处理
 * version: 1.0
 */
abstract class BaseViewModel<T> : ViewModel() {


    private val error by lazy {
        MutableLiveData<Int>()
    }

    private val finally by lazy {
        MutableLiveData<Int>()
    }
    abstract val liveData: LiveData<T>


    /**
     * 加载本地数据
     */
    fun launchLocal(block: suspend CoroutineScope.() -> Unit) =
        viewModelScope.launch {
            try {
                block()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    /**
     * 加载网络数据
     */
    fun launchRemote(
        block: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.() -> Unit = {},
        finallyBlock: suspend CoroutineScope.() -> Unit = {}
    ) = viewModelScope.launch(Dispatchers.IO) {
        try {
            block()
        } catch (e: Exception) {
            catchBlock()
            e.printStackTrace()
        }finally {
            finallyBlock()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}