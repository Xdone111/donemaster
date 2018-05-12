package com.zss.library.widget;

import com.zss.library.R;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 公用锁屏。
 * 
 * @author zm
 * 
 */
public class CommonProgressDialog extends Dialog {

	private TextView lock_tips;
	private ImageView pbar;
	private ObjectAnimator anim;

	public CommonProgressDialog(Context context) {
		super(context, R.style.CommonDialog);
		setContentView(R.layout.common_progess);
		setCanceledOnTouchOutside(false);
		initView();
	}

	private void initView() {
		lock_tips = (TextView) findViewById(R.id.common_tv_tips);
		pbar = (ImageView) findViewById(R.id.progressbar);
		anim = ObjectAnimator.ofFloat(pbar, "rotation", 0, 359);
		anim.setInterpolator(new LinearInterpolator());
		anim.setRepeatCount(ObjectAnimator.INFINITE);
		anim.setDuration(1000);
	}

	public void setTitle(CharSequence text) {
		if (TextUtils.isEmpty(text)) {
			lock_tips.setVisibility(View.GONE);
		} else {
			lock_tips.setVisibility(View.VISIBLE);
			lock_tips.setText(text);
		}

	}

	public void show() {
		try {
			super.show();
			anim.start();
		} catch (Exception e) {
		}
	}

	public void dismiss() {
		try {
			super.dismiss();
			anim.cancel();
		} catch (Exception e) {
		}
	}

}
