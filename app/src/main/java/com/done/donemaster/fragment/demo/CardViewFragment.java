package com.done.donemaster.fragment.demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.done.donemaster.R;
import com.done.donemaster.fragment.demo.cardview.CardFragmentPagerAdapter;
import com.done.donemaster.fragment.demo.cardview.ShadowTransformer;
import com.zss.library.fragment.BaseFragment;

/**
 * Created by XDONE on 2018/5/10.
 */

public class CardViewFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private Button mButton;
    private ViewPager mViewPager;

    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_cardview;
    }

    @Override
    public void initView() {
        super.initView();
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mButton = (Button) findViewById(R.id.cardTypeBtn);
        mButton.setOnClickListener(this);
        ((CheckBox) findViewById(R.id.checkBox)).setOnCheckedChangeListener(this);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getActivity().getSupportFragmentManager(),
                dpToPixels(2, getActivity()));

        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);
        mViewPager.setOffscreenPageLimit(3);
    }

    @Override
    public void onClick(View view) {
        mViewPager.setAdapter(mFragmentCardAdapter);
        mViewPager.setPageTransformer(false, mFragmentCardShadowTransformer);

    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        mFragmentCardShadowTransformer.enableScaling(b);
    }
}
