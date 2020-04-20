package com.example.androidjecpack.mvvm.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/20
 * desc   : 基础数据交互类
 * 提供2种能力
 * 1:协程内调用数据库能力
 * 2：协程内请求网络能力
 * version: 1.0
 */
abstract class BaseRepository <T>{

    /**
     * 请求本地数据库的入口
     */
    suspend fun launchLocal(call:suspend () ->Unit){
        withContext(Dispatchers.IO){
            call.invoke()
        }
    }

    /**
     * 请求远程网络数据的入口
     */
    suspend fun launchRemote(call: suspend () -> Unit){
        withContext(Dispatchers.IO){
            call.invoke()
        }
    }
}