package com.example.androidjecpack.java.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidjecpack.R;
import com.example.androidjecpack.java.database.WeatherBean;

import java.util.ArrayList;
import java.util.List;

/**
 * author : lei
 * e-mail : xiong.lei@ubtrobot.com
 * date   : 2020/4/14
 * desc   :
 * version: 1.0
 */
public class MvpActivity extends AppCompatActivity implements WeatherMvpView {

    private RecyclerView mRecyclerView;
    private Button mGetDataButton;
    private WeatherAdapter mAdapter;
    private ArrayList<WeatherBean> mData;
    private WeatherPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        mRecyclerView = findViewById(R.id.recycle_view);
        mGetDataButton = findViewById(R.id.getData);
        initPresenter();
        initRecycleView();
        setListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.release();//释放presenter
    }
    private void initPresenter(){
        mPresenter = new WeatherPresenter(this);//注册presenter
    }
    private void initRecycleView(){
        if (null == mData){
            mData = new ArrayList<>();
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new WeatherAdapter(this,mData);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setListener(){
        mGetDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.requestData();
            }
        });
    }

    @Override
    public void action01() {

    }

    @Override
    public void action02() {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void showData(List<WeatherBean> data) {
        mData.clear();
        mData.addAll(data);
        mAdapter.notifyDataSetChanged();
    }

    private void useLiveData(){
        MutableLiveData<String> liveData = new MutableLiveData<>();
        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {

            }
        });

        liveData.setValue("修改值");
    }

}
