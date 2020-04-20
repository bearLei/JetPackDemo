package com.example.androidjecpack

import android.app.Application

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/20
 * desc   :
 * version: 1.0
 */
class MyApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object{
        @JvmStatic
        lateinit var instance: MyApplication
            private set

    }

}