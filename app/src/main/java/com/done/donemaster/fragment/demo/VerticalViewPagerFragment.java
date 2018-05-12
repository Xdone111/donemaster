package com.done.donemaster.fragment.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.done.donemaster.R;
import com.done.donemaster.view.VerticalViewPager;
import com.zss.library.fragment.BaseFragment;
import com.zss.library.toolbar.CommonToolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XDONE on 2018/5/9.
 */

public class VerticalViewPagerFragment extends BaseFragment {

    private VerticalViewPager verticalViewPager;

    List<View> viewList = new ArrayList<View>();

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_vertival_viewpager;
    }

    @Override
    public void initView() {
        super.initView();

        verticalViewPager = (VerticalViewPager) findViewById(R.id.vertical_viewpager);

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);

        for (int i = 0; i < 7; i++) {
            View view = getLayoutInflater().inflate(R.layout.pager, null);
            ImageView img = (ImageView) view.findViewById(R.id.pager);
            img.setImageResource(R.mipmap.ic_launcher);
            TextView down = view.findViewById(R.id.down);
            down.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            viewList.add(view);
        }
        verticalViewPager.setViewList(viewList);

        verticalViewPager.setOnVerticalPageChangeListener(new VerticalViewPager.OnVerticalPageChangeListener() {

            @Override
            public void onVerticalPageSelected(int position) {
                System.out.println("pager=" + position);
            }
        });
    }


    @Override
    public void setTopBar() {
        super.setTopBar();
        CommonToolbar toolbar = getToolbar();
        toolbar.setTitle("VerticalViewPagerFragment");
    }
}
