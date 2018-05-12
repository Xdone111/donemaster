package com.zss.library.toolbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zss.library.R;
import com.zss.library.activity.BaseActivity;


/**
 * 自定义公用ActionBar
 * @author zm
 * 
 */
public class CommonToolbar extends LinearLayout {

	private ImageView mLeftImage;
	private TextView mTitle;
	private TextView mRightText;
	private ImageView mRightImage;
	private RelativeLayout root_view;

	public enum RightType {
		TYPE_TEXT, TYPE_IMAGE
	}

	private RightType mRightType = RightType.TYPE_TEXT;

	public CommonToolbar(Context context) {
		super(context);
		initView();
	}

	public CommonToolbar(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView();

		TypedArray mTypedArray = context.obtainStyledAttributes(attrs,
				R.styleable.CommonToolbar);

		// 获取自定义属性和默认值
		CharSequence titleText = mTypedArray
				.getText(R.styleable.CommonToolbar_title_text);

		Drawable leftImage = mTypedArray
				.getDrawable(R.styleable.CommonToolbar_left_image);

		CharSequence rightText = mTypedArray
				.getText(R.styleable.CommonToolbar_right_text);

		Drawable rightImage = mTypedArray
				.getDrawable(R.styleable.CommonToolbar_right_image);

		int style = mTypedArray.getInt(R.styleable.CommonToolbar_right_type, -1);

		setTitle(titleText);
		switch (style) {
		case 0:
			setRightType(RightType.TYPE_TEXT);
			setRightShow(true);
			setRightText(rightText);
			break;
		case 1:
			setRightType(RightType.TYPE_IMAGE);
			setRightShow(true);
			break;
		default:
			setRightShow(false);
			break;
		}

		if (leftImage != null) {
			mLeftImage.setImageDrawable(leftImage);
		}
		if (rightImage != null) {
			mRightImage.setImageDrawable(rightImage);
		}
		
		mTypedArray.recycle();
	}

	private void initView() {
		final Context context = getContext();
		inflate(context, R.layout.common_tool_bar, this);
		mTitle = (TextView) findViewById(R.id.common_tv_title);
		mLeftImage = (ImageView) findViewById(R.id.common_img_left);
		mRightText = (TextView) findViewById(R.id.common_tv_right);
		mRightImage = (ImageView) findViewById(R.id.common_img_right);
		root_view = (RelativeLayout) findViewById(R.id.root_view);
		if (context instanceof Activity) {
			setOnLeftListener(new OnClickListener() {
				@Override
				public void onClick(View view) {
					((Activity) context).finish();
				}
			});
		}
	}

	public void setLeftImage(int resId) {
		mLeftImage.setVisibility(View.VISIBLE);
		mLeftImage.setImageResource(resId);
	}

	public void setLeftImage(Drawable backImage) {
		mLeftImage.setVisibility(View.VISIBLE);
		mLeftImage.setImageDrawable(backImage);
	}

	public void setRightType(RightType type) {
		mRightType = type;
	}

	public void setMiddleView(View v) {
		setView(R.id.common_ll_middle, v);
	}

	public void setMiddleView(int layoutResId) {
		setView(R.id.common_ll_middle, layoutResId);
	}

	public void setLeftView(View v) {
		setView(R.id.common_ll_left, v);
	}

	public void setLeftView(int layoutResId) {
		setView(R.id.common_ll_left, layoutResId);
	}

	public void setRightView(View v) {
		setView(R.id.common_ll_right, v);
	}

	public void setRightView(int layoutResId) {
		setView(R.id.common_ll_right, layoutResId);
	}

	private void setView(int rootId, View v) {
		LinearLayout ll = (LinearLayout) findViewById(rootId);
		ll.removeAllViews();
		ll.addView(v);

	}

	private void setView(int rootId, int layoutId) {
		LinearLayout ll = (LinearLayout) findViewById(rootId);
		ll.removeAllViews();
		inflate(getContext(), layoutId, ll);
	}

	public View getRightButton() {
		switch (mRightType) {
		case TYPE_TEXT:
			return mRightText;
		case TYPE_IMAGE:
			return mRightImage;
		}
		return null;
	}

	public void setTitle(CharSequence title) {
		mTitle.setText(title);
	}

	public void setTitle(int title) {
		mTitle.setText(title);
	}

	public void setTitleColor(int color) {
		mTitle.setTextColor(color);
	}

	public void setRightShow(boolean isShow) {
		mRightImage.setVisibility(View.GONE);
		mRightText.setVisibility(View.GONE);
		if (isShow) {
			switch (mRightType) {
			case TYPE_TEXT:
				mRightText.setVisibility(View.VISIBLE);
				break;
			case TYPE_IMAGE:
				mRightImage.setVisibility(View.VISIBLE);
				break;
			}
		}
	}

	public void setLeftShow(boolean isShow) {
		findViewById(R.id.common_ll_left).setVisibility(isShow ? View.VISIBLE : View.GONE);
	}

	public void setOnLeftListener(OnClickListener l) {
		findViewById(R.id.common_ll_left).setOnClickListener(l);
	}

	public void setOnRightListener(OnClickListener l) {
		switch (mRightType) {
			case TYPE_TEXT:
				mRightText.setOnClickListener(l);
				break;
			case TYPE_IMAGE:
				mRightImage.setOnClickListener(l);
				break;
		}
	}
	

	public int getLeftButtonId() {
		return getLeftView().getId();
	}

	public int getRightButtonId() {
		View v = getRightButton();
		return v != null ? v.getId() : 0;
	}

	public void clearActionBar() {
		setVisibility(View.VISIBLE);
		setRightShow(false);
		setOnRightListener(null);
		setLeftImage(R.mipmap.btn_back);
		setTitleColor(BaseActivity.getColor(getContext(), R.color.white));
	}
	
	public void setRightText(int resId) {
		setRightType(RightType.TYPE_TEXT);
		setRightShow(true);
		mRightText.setText(resId);
	}

	public void setRightText(CharSequence title) {
		setRightType(RightType.TYPE_TEXT);
		setRightShow(true);
		mRightText.setText(title);
	}

	public void setRightImage(int resId) {
		setRightType(RightType.TYPE_IMAGE);
		setRightShow(true);
		mRightImage.setImageResource(resId);
	}

	public void setRightTextBgColor(int color) {
		mRightText.setBackgroundColor(color);
	}

	public void setRightTextColor(int color) {
		mRightText.setTextColor(color);
	}

	public void setBgColor(int color) {
		root_view.setBackgroundColor(color);
	}

	public void setBgRes(int res) {
		root_view.setBackgroundResource(res);
	}

	public void setRightEnabled(Boolean isEnabled) {
		mRightText.setEnabled(isEnabled);
	}

	private ImageView getLeftView() {
		return mLeftImage;
	}

	public View getRightView(){
		if (mRightType == RightType.TYPE_TEXT) {
			return mRightText;
		} else {
			return mRightImage;
		}
	}
}
