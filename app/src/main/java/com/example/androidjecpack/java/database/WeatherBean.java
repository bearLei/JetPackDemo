package com.example.androidjecpack.java.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/15
 * desc   :
 * version: 1.0
 */
@Entity(tableName = "Weather_table")
public class WeatherBean {
    @PrimaryKey(autoGenerate = false)
    private String id;
    private String province;

    public WeatherBean() {
    }

    public WeatherBean(String id, String province) {
        this.id = id;
        this.province = province;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

}
