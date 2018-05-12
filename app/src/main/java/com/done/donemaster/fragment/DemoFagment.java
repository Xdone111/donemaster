package com.done.donemaster.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.done.donemaster.R;
import com.done.donemaster.fragment.demo.CardViewFragment;
import com.done.donemaster.fragment.demo.ListviewFragment;
import com.done.donemaster.fragment.demo.LocationDemo;
import com.done.donemaster.fragment.demo.MapFragment;
import com.done.donemaster.fragment.demo.PlayFragment;
import com.done.donemaster.fragment.demo.SearcherFragment;
import com.done.donemaster.fragment.demo.TabLayoutFragment;
import com.done.donemaster.fragment.demo.VerticalViewPagerFragment;
import com.zss.library.activity.ZFrameActivity;
import com.zss.library.fragment.BaseFragment;
import com.zss.library.widget.CommonTextWidget;

/**
 * Created by XDONE on 2018/3/20.
 */

public class DemoFagment extends BaseFragment implements View.OnClickListener {
    private CommonTextWidget widget1, widget2, widget3, widget4,
            widget5, widget6, widget7,widget8,widget9;
    private Intent intent;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_demo;
    }

    @Override
    public void initView() {
        super.initView();
        widget1 = (CommonTextWidget) findViewById(R.id.widget1);
        widget2 = (CommonTextWidget) findViewById(R.id.widget2);
        widget3 = (CommonTextWidget) findViewById(R.id.widget3);
        widget4 = (CommonTextWidget) findViewById(R.id.widget4);
        widget5 = (CommonTextWidget) findViewById(R.id.widget5);
        widget6 = (CommonTextWidget) findViewById(R.id.widget6);
        widget7 = (CommonTextWidget) findViewById(R.id.widget7);
        widget8 = (CommonTextWidget) findViewById(R.id.widget8);
        widget9 = (CommonTextWidget) findViewById(R.id.widget9);


    }

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        widget1.setLeftText("MapFragment");
        widget2.setLeftText("LocationDemo");
        widget3.setLeftText("SearcherFragment");
        widget4.setLeftText("VerticalViewPagerFragment");
        widget5.setLeftText("PlayFragment");
        widget6.setLeftText("CardViewFragment");
        widget7.setLeftText("ListviewFragment");
        widget8.setLeftText("TabLayoutFragment");
        widget9.setLeftText("Test");


        widget1.setOnClickListener(this);
        widget2.setOnClickListener(this);
        widget3.setOnClickListener(this);
        widget4.setOnClickListener(this);
        widget5.setOnClickListener(this);
        widget6.setOnClickListener(this);
        widget7.setOnClickListener(this);
        widget8.setOnClickListener(this);
        widget9.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        intent = new Intent(getActivity(), ZFrameActivity.class);
        switch (view.getId()) {
            case R.id.widget1:
                intent.putExtra(ZFrameActivity.CLASS_NAME, MapFragment.class.getName());
                break;
            case R.id.widget2:
                intent.putExtra(ZFrameActivity.CLASS_NAME, LocationDemo.class.getName());
                break;
            case R.id.widget3:
                intent.putExtra(ZFrameActivity.CLASS_NAME, SearcherFragment.class.getName());
                break;
            case R.id.widget4:
                intent.putExtra(ZFrameActivity.CLASS_NAME, VerticalViewPagerFragment.class.getName());
                break;
            case R.id.widget5:
                intent.putExtra(ZFrameActivity.CLASS_NAME, PlayFragment.class.getName());
                break;
            case R.id.widget6:
                intent.putExtra(ZFrameActivity.CLASS_NAME, CardViewFragment.class.getName());
                break;
            case R.id.widget7:
                intent.putExtra(ZFrameActivity.CLASS_NAME, ListviewFragment.class.getName());
                break;
            case R.id.widget8:
                intent.putExtra(ZFrameActivity.CLASS_NAME, TabLayoutFragment.class.getName());
                break;
            case R.id.widget9:
                intent.putExtra(ZFrameActivity.CLASS_NAME, ListviewFragment.class.getName());
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }

    }
}
