package com.example.androidjecpack.livedata

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.androidjecpack.R
import com.example.androidjecpack.java.lifecycle.MyPresenter
import com.example.androidjecpack.livedata.mode.MyLiveData
import com.example.androidjecpack.livedata.mode.MyObserver
import kotlinx.android.synthetic.main.activity_livedata.*

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/16
 * desc   :
 * version: 1.0
 */
class LiveDataActivity : AppCompatActivity() {

    private val viewModel: LiveDataViewModel by viewModels {
        LiveDataViewModel.LiveDataFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livedata)
        subscribeUi()
        setListener()
    }

    private fun subscribeUi() {
        //时间处理
        viewModel.currentTimeTransformed.observe(this, Observer {
            showSwapLiveData.text = it
        })

        //normal liveData
        viewModel.normalLiveData.observe(this, Observer {
            normal_live_data.text = it
        })

    }

    private fun setListener() {
        change_value.setOnClickListener {
//            val editText = edit_live_data.text.toString()
//            viewModel.normalLiveData.value = editText
            testLiveData()
        }
    }

    private fun testLiveData(){
       val testObj = MyLiveDataTest()
        testObj.testMyLiveData()
    }

}