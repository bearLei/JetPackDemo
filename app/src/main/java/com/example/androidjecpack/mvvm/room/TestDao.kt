package com.example.androidjecpack.mvvm.room

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/20
 * desc   :
 * version: 1.0
 */
@Dao
interface TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bean:TestBean)

    @Delete
    suspend fun delete(bean:TestBean)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(bean:TestBean)

    @Query("SELECT * FROM"+"test_table")
    suspend fun query():LiveData<List<TestBean>>
}