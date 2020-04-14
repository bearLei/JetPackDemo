package com.example.androidjecpack.java.mvp.base;

import java.lang.ref.WeakReference;



public abstract class BasePresenter<V>{

    private WeakReference<V> mViewRef;

    public BasePresenter(V v) {
        attachView(v);
    }

    private void attachView(V view) {
        mViewRef = new WeakReference<>(view);
    }

    private void detachView() {
        if(mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public V getView() {
        if(mViewRef != null) {
            return mViewRef.get();
        }
        return null;
    }

    public void release() {
        detachView();
    }

}
