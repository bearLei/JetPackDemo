package com.example.androidjecpack.mvvm.base

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/20
 * desc   : 网络数据/数据库数据的返回基类
 * version: 1.0
 */
data class BaseResponse<T>(val code: Int? = 0, val message: String? = "", val data: T? = null)