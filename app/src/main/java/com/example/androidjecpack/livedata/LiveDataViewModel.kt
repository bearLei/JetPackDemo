package com.example.androidjecpack.livedata

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/16
 * desc   :
 * version: 1.0
 */
class LiveDataViewModel(private val dataSource: DataSource) : ViewModel() {
    //时间戳
    private val currentTime = dataSource.getCurrentTime()
    //转换liveData

    //switchMap:将一个liveData转换成另外一个LiveData
    val currentTimeTransformed = currentTime.switchMap {
        liveData {
            emit(timeStampToTime(it))
        }
    }
    //map:將一個liveData的值进行转换
//    val currentTimeTransformed = currentTime.map {
//        timeStampToTime(it)
//    }

    private fun timeStampToTime(timestamp: Long): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        return sdf.format(Date(timestamp))
    }


    //normal test  普通使用liveData方式
     val normalLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }



    object LiveDataFactory : ViewModelProvider.Factory {
        private val dataSource = MyDataSource()
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return LiveDataViewModel(dataSource) as T
        }

    }

    companion object {
        private const val Tag = "LiveData"
    }
}