package com.example.androidjecpack.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/20
 * desc   :
 * version: 1.0
 */
class TestViewModelFcatory(private val resopitory: TestRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return super.create(modelClass)
    }
}