package com.example.androidjecpack.mvvm

import com.example.androidjecpack.mvvm.room.TestDataBase

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/20
 * desc   :
 * version: 1.0
 */
object InjectorUtil {

    private fun getTestRepository(): TestRepository =
        TestRepository.getInstance(TestDataBase.instance.getTestDao())

    fun getTestFactory(): TestViewModelFcatory {
        val repository = getTestRepository()
        return TestViewModelFcatory(resopitory = repository)
    }
}