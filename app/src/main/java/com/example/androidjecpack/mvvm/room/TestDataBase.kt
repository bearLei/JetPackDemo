package com.example.androidjecpack.mvvm.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidjecpack.MyApplication

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/20
 * desc   :
 * version: 1.0
 */
@Database(entities = [TestBean::class], version = 1, exportSchema = false)
abstract class TestDataBase :RoomDatabase(){

    private object BaseDataHolder {
        val INSTANCE = Room
            .databaseBuilder(MyApplication.instance, TestDataBase::class.java, DB_NAME)
            .allowMainThreadQueries()
            .build()
    }

    companion object{
        private const val DB_NAME = "test_db"

        val instance : TestDataBase
        get() = BaseDataHolder.INSTANCE
    }


    abstract fun getTestDao():TestDao
}