package com.example.androidjecpack.livedata

import androidx.lifecycle.LiveData

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/16
 * desc   :
 * version: 1.0
 */
interface DataSource {
    fun getCurrentTime():LiveData<Long>
}