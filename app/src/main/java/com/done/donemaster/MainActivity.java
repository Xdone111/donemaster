package com.done.donemaster;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.done.donemaster.fragment.DemoFagment;
import com.done.donemaster.fragment.LiveFragment;
import com.done.donemaster.fragment.MainFragment;
import com.done.donemaster.fragment.MeFragment;
import com.zss.library.activity.BaseActivity;
import com.zss.library.tabhost.FragmentTabHost;
import com.zss.library.toolbar.CommonToolbar;
import com.zss.library.utils.CommonToastUtils;

public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener {
    private FragmentTabHost mTabHost;
    private View tab1, tab2, tab3, tab4;
    private CommonToolbar toolbar;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        super.initView();
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getSupportFragmentManager(), R.id.realtabcontent);
        toolbar = getToolbar();

        tab1 = getLayoutInflater(R.layout.layout_tab_item);
        TextView textTab = (TextView) tab1.findViewById(R.id.text_tab);
        textTab.setText("主页");
        tab2 = getLayoutInflater(R.layout.layout_tab_item);
        textTab = (TextView) tab2.findViewById(R.id.text_tab);
        textTab.setText("直播");
        tab3 = getLayoutInflater(R.layout.layout_tab_item);
        textTab = (TextView) tab3.findViewById(R.id.text_tab);
        textTab.setText("我的");
        tab4 = getLayoutInflater(R.layout.layout_tab_item);
        textTab = (TextView) tab4.findViewById(R.id.text_tab);
        textTab.setText("demo");

        ImageView imgTab1 = (ImageView) tab1.findViewById(R.id.img_tab);
        imgTab1.setImageResource(R.drawable.tab1);
        ImageView imgTab2 = (ImageView) tab2.findViewById(R.id.img_tab);
        imgTab2.setImageResource(R.drawable.tab2);
        ImageView imgTab3 = (ImageView) tab3.findViewById(R.id.img_tab);
        imgTab3.setImageResource(R.drawable.tab3);
        ImageView imgTab4 = (ImageView) tab4.findViewById(R.id.img_tab);
        imgTab4.setImageResource(R.drawable.tab4);

        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator(tab1), MainFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator(tab2), LiveFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator(tab3), MeFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("tab4").setIndicator(tab4), DemoFagment.class, null);
        mTabHost.setOnTabChangedListener(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
    }

    @Override
    public void setTopBar() {
        super.setTopBar();
        setTopTab1();
    }

    private void setTopTab1() {
        setStatusBarColor(R.color.colorBlue);
        TextView title = (TextView) getLayoutInflater(R.layout.layout_tab_main_title);
        title.setText("热播列表");
        toolbar.setMiddleView(title);
    }

    public void setTopTab2() {
        setStatusBarColor(R.color.colorBlue);
        TextView title = (TextView) getLayoutInflater(R.layout.layout_tab_main_title);
        title.setText("直播");
        toolbar.setMiddleView(title);
    }

    public void setTopTab3() {
        setStatusBarColor(R.color.colorBlue);
        TextView title = (TextView) getLayoutInflater(R.layout.layout_tab_main_title);
        toolbar.setMiddleView(title);
        title.setText("我的");

    }

    public void setTopTab4() {
        setStatusBarColor(R.color.colorBlue);
        TextView title = (TextView) getLayoutInflater(R.layout.layout_tab_main_title);
        title.setText("demo");
        toolbar.setMiddleView(title);
    }

    @Override
    public void onTabChanged(String tabId) {
        if (tabId.equals("tab1")) {
            setTopTab1();
        } else if (tabId.equals("tab2")) {
            setTopTab2();
        } else if (tabId.equals("tab3")) {
            setTopTab3();
        } else if (tabId.equals("tab4")) {
            setTopTab4();
        }
    }

    @Override
    public void onBackPressed() {
        CommonToastUtils.exitClient(this, true);
    }
}
