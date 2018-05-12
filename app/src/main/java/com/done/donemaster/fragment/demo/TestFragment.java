package com.done.donemaster.fragment.demo;

import android.os.Bundle;

import com.done.donemaster.R;
import com.zss.library.fragment.BaseFragment;


/**
 * 此demo用来展示如何结合定位SDK实现定位，并使用MyLocationOverlay绘制定位位置 同时展示如何使用自定义图标绘制并点击时弹出泡泡
 */
public class TestFragment extends BaseFragment {

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_test;
    }

    @Override
    public void initView() {
        super.initView();
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
    }


    /**
     *  * 定义一个接口
     *  
     */
    public interface onListener {
        void OnListener(String code, String msg);
    }

    /**
     *  *定义一个变量储存数据
     *  
     */
    private onListener listener;

    /**
     *  *提供公共的方法,并且初始化接口类型的数据
     *  
     */
    public void setListener(onListener listener) {
        this.listener = listener;
    }
}