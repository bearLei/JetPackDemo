package com.example.androidjecpack.mvvm.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/20
 * desc   :
 * version: 1.0
 */
@Entity(tableName = "test_table")
data class TestBean(
    @PrimaryKey(autoGenerate = false)
    val id:Int?=0,
    val name:String?=""
)