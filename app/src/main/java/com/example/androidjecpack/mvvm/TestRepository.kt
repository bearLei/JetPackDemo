package com.example.androidjecpack.mvvm

import androidx.lifecycle.MutableLiveData
import com.example.androidjecpack.mvvm.base.BaseRepository
import com.example.androidjecpack.mvvm.room.TestBean
import com.example.androidjecpack.mvvm.room.TestDao
/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/20
 * desc   : 测试Repository
 * version: 1.0
 */
class TestRepository private constructor(private val testDao: TestDao) : BaseRepository<TestDao>() {

    val allData: MutableLiveData<List<TestBean>> by lazy {
        MutableLiveData<List<TestBean>>()
    }

    suspend fun getLocal() = launchLocal{
        allData.value = testDao.query().value
    }

    suspend fun getRemote() = launchRemote{
        //网络请求
    }


    companion object {
        @Volatile
        private var instance: TestRepository? = null

        fun getInstance(dao: TestDao) = instance ?: synchronized(TestRepository::javaClass) {
            instance ?: TestRepository(dao).also {
                instance = it
            }
        }
    }
}