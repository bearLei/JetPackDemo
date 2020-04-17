package com.example.androidjecpack.java.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/15
 * desc   :
 * version: 1.0
 */
@Dao
public interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertWeather(WeatherBean weatherBean);

    @Update
    public void updateWeather(WeatherBean weatherBean);

    @Delete
    public void deleteWeather(WeatherBean weatherBean);

    @Query("SELECT * FROM Weather_table")
    public List<WeatherBean> getAllWeather();


    //rxjava
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Maybe<Integer> insertRxWeather(WeatherBean weatherBean);

    @Delete
    public Single<Integer> deleteRxWeather(WeatherBean weatherBean);

    @Query("SELECT * FROM Weather_table")
    public Flowable<WeatherBean> getRxAllWeather();
}
