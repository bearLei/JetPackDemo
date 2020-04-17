package com.example.androidjecpack.livedata

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.delay

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/16
 * desc   :
 * version: 1.0
 */
class MyDataSource : DataSource {
    companion object{
        private const val Tag = "LiveData"
    }
    override fun getCurrentTime(): LiveData<Long> =
        liveData {
            while (true) {
                Log.d(Tag,"发送时间:${System.currentTimeMillis()}--当前线程:+${Thread.currentThread().name}")
                emit(System.currentTimeMillis())
                delay(1000)
            }
        }
}