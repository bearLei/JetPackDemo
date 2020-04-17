package com.example.androidjecpack.java.mvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidjecpack.R;
import com.example.androidjecpack.java.WeatherResponse;
import com.example.androidjecpack.java.database.WeatherBean;

import java.util.ArrayList;

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/14
 * desc   :
 * version: 1.0
 */
public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewModel>{

    private Context mContext;
    private ArrayList<WeatherBean> mData;

    public WeatherAdapter(Context mContext, ArrayList<WeatherBean> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public WeatherViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_weather_item,null,false);
        return new WeatherViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewModel holder, int position) {
        holder.setData(mData.get(position),position);
    }

    @Override
    public int getItemCount() {

        if (mData == null){
            return 0;
        }
        return mData.size();
    }

    public class WeatherViewModel extends RecyclerView.ViewHolder{
        private TextView mProvinceId,mProvinceName;

        public WeatherViewModel(@NonNull View itemView) {
            super(itemView);
            mProvinceId = itemView.findViewById(R.id.province_id);
            mProvinceName = itemView.findViewById(R.id.province_name);
        }

        public void setData(WeatherBean weatherBean,int position){
            if (null == weatherBean){
                return;
            }
            mProvinceId.setText(weatherBean.getId());
            mProvinceName.setText(weatherBean.getProvince());
        }
    }
}
