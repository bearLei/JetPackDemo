package com.example.androidjecpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.*
import com.example.androidjecpack.java.mvp.MvpActivity
import com.example.androidjecpack.livedata.LiveDataActivity
import com.example.androidjecpack.mvvm.InjectorUtil
import com.example.androidjecpack.mvvm.TestViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val model: TestViewModel by viewModels {
        InjectorUtil.getTestFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mvp.setOnClickListener {
            startActivity(Intent(this, MvpActivity::class.java))
        }
        livedata.setOnClickListener {
            startActivity(Intent(this,LiveDataActivity::class.java))
        }
        lifecycle.addObserver(MyObserver())
    }

}
