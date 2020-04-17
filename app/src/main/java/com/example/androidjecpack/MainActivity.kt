package com.example.androidjecpack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.*
import com.example.androidjecpack.java.mvp.MvpActivity
import com.example.androidjecpack.livedata.LiveDataActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val model: MyViewModel by viewModels {
        MyProviders()
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

    class MyProviders : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MyViewModel() as T
        }
    }
}
