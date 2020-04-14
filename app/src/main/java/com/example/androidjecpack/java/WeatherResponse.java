package com.example.androidjecpack.java;

import java.util.List;

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/14
 * desc   :
 * version: 1.0
 */
public class WeatherResponse {
    private int error_code;
    private String reason;
    private List<WeatherBean> result;

    public WeatherResponse() {
    }

    public WeatherResponse(int error_code, String reason, List<WeatherBean> result) {
        this.error_code = error_code;
        this.reason = reason;
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<WeatherBean> getResult() {
        return result;
    }

    public void setResult(List<WeatherBean> result) {
        this.result = result;
    }

    public class WeatherBean{
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
}
