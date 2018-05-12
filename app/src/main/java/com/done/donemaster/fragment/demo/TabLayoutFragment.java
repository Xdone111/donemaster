package com.done.donemaster.fragment.demo;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.done.donemaster.R;
import com.zss.library.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XDONE on 2018/5/11.
 */

public class TabLayoutFragment extends BaseFragment {

    private TabLayout mTab;
    private ViewPager viewPager;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private List<String> listTitles;
    private List<TextView> listTextViews;


    @Override
    public int getLayoutResId() {
        return R.layout.tablayout_fragment;
    }

    @Override
    public void initView() {
        super.initView();
        mTab = (TabLayout) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);

        listTitles = new ArrayList<>();
        listTextViews = new ArrayList<>();

        listTitles.add("沪深");
        listTitles.add("板块");
        listTitles.add("指数");
        listTitles.add("港股");
        listTitles.add("新三板");
        listTitles.add("商品");
        listTitles.add("更多");
        for (int i = 0; i < listTitles.size(); i++) {
            ListviewFragment fragment = new ListviewFragment();
            mFragmentList.add(fragment);
        }
        //mTabLayout.setTabMode(TabLayout.SCROLL_AXIS_HORIZONTAL);//设置tab模式，当前为系统默认模式
        for (int i = 0; i < listTitles.size(); i++) {
            mTab.addTab(mTab.newTab().setText(listTitles.get(i)));//添加tab选项

        }

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public int getCount() {
                return mFragmentList.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return listTitles.get(position);
            }
        };

        viewPager.setAdapter(adapter);
        mTab.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
        mTab.setTabsFromPagerAdapter(adapter);//给Tabs设置适配器


//        for (int i = 0; i < adapter.getCount(); i++) {
//            TabLayout.Tab tab = mTab.getTabAt(i);//获得每一个tab
//            tab.setCustomView(R.layout.tab_item);//给每一个tab设置view
//            if (i == 0) {
//                // 设置第一个tab的TextView是被选择的样式
//               // updateTabTextView(tab, true);
//            }
//
//        }

        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //updateTabTextView(tab, true);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //updateTabTextView(tab, false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    private void updateTabTextView(TabLayout.Tab tab, boolean isSelect) {

        if (isSelect) {
            //选中加粗
            TextView textView = (TextView) tab.getCustomView().findViewById(R.id.tab_text);
            textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            textView.setTextSize(26);
            textView.setTextColor(getColor(R.color.colorBlue));
            textView.setText(tab.getText());
        } else {
            TextView tabUnSelect = (TextView) tab.getCustomView().findViewById(R.id.tab_text);
            tabUnSelect.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            tabUnSelect.setTextSize(20);
            tabUnSelect.setTextColor(getColor(R.color.colorGrey));
            tabUnSelect.setText(tab.getText());
        }
    }

}
