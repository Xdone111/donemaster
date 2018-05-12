package com.zss.library.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;

import com.zss.library.fragment.BaseFragment;

import com.zss.library.R;
import com.zss.library.toolbar.CommonToolbar;

/**
 * ZFrameActivity
 * 用法如下：
 * String className = BaseFragment.class.getName();
 * Intent intent = new Intent(this, ZFrameActivity.class);
 * intent.putExtra(ZFrameActivity.CLASS_NAME, className);
 * startActivity(intent);
 * 
 * @author zm
 *
 */
public class ZFrameActivity extends BaseActivity {

	public static String CLASS_NAME = "CLASS_NAME";

	@Override
	public int getLayoutResId() {
		return R.layout.activity_zframe;
	}

	@Override
	public void initView() {
		super.initView();
		setStatusBarColor(R.color.status_color);
	}

	@Override
	public void initData(Bundle savedInstanceState) {
		super.initData(savedInstanceState);
		Intent intent = getIntent();
		String className = intent.getStringExtra(CLASS_NAME);
		Fragment fragment = Fragment.instantiate(getActivity(), className, getIntent().getExtras());
		addFragment(fragment);
	}

	@Override
	public void setTopBar() {
		super.setTopBar();
		CommonToolbar toolbar = getToolbar();
		toolbar.setTitle(getString(R.string.app_name));
		toolbar.setLeftImage(R.mipmap.btn_back);
		toolbar.setOnLeftListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
	}

	@Override
	public void onBackPressed() {
		BaseFragment curBase = getCurrentFragmnet();
		if (curBase != null && !curBase.onBackPressed()) {// Fragment未处理返回
			FragmentManager fm = getSupportFragmentManager();
			int count = fm.getBackStackEntryCount();
			if (count > 1) {
				backStackFragment();
			} else {
				finish();
			}
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

}
