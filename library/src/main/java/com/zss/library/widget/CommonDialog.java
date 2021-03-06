package com.zss.library.widget;

import com.zss.library.R;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.ActivityCompat;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/**
 * 公用对话框
 * 
 * @author zm
 *
 */
public class CommonDialog extends Dialog {

	private TextView common_tv_title;
	private TextView common_tv_context;
	private ImageView common_img_close;
	private Button common_btn_cancel;
	private Button common_btn_confirm;
	private View.OnClickListener onConfirmListener, onCancelListener, onCloseListener;

	public CommonDialog(Context context) {
		super(context, R.style.CommonDialog);
		setContentView(R.layout.common_dialog);
		setCanceledOnTouchOutside(true);
		initView();
	}

	public CommonDialog(Context context, CharSequence title, CharSequence content) {
		this(context);
		common_tv_title.setText(title);
		common_tv_context.setText(content);
	}

	public CommonDialog(Context context, int title, int content) {
		this(context, context.getString(title), context.getString(content));
	}

	private void initView() {
		common_tv_title = (TextView) findViewById(R.id.common_tv_title);
		common_tv_context = (TextView) findViewById(R.id.common_tv_content);
		common_img_close = (ImageView) findViewById(R.id.common_img_close);
		common_img_close.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (onCloseListener != null) {
					onCloseListener.onClick(v);
				}
				removeMiddleView();
				removeBottomView();
				dismiss();
			}
		});
		common_btn_cancel = (Button) findViewById(R.id.common_btn_cancel);
		common_btn_cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (onCancelListener != null) {
					onCancelListener.onClick(v);
				}
				removeMiddleView();
				removeBottomView();
				dismiss();
			}
		});
		common_btn_confirm = (Button) findViewById(R.id.common_btn_confirm);
		common_btn_confirm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (onConfirmListener != null) {
					onConfirmListener.onClick(v);
				}
				removeMiddleView();
				removeBottomView();
				dismiss();
			}
		});
		setOnDismissListener(new OnDismissListener() {
			@Override
			public void onDismiss(DialogInterface dialog) {
				removeMiddleView();
				removeBottomView();
			}
		});
	}

	@Override
	public void setTitle(CharSequence text) {
		common_tv_title.setText(text);
	}

	public void setContentText(CharSequence text) {
		common_tv_context.setText(text);
	}

	public void setOnClickCancelListener(CharSequence text, View.OnClickListener onCancelListener) {
		this.setOnClickCancelListener(onCancelListener);
		common_btn_cancel.setText(text);
	}

	public void setOnClickCancelListener(int textColor, View.OnClickListener onCancelListener) {
		this.setOnClickCancelListener(onCancelListener);
		common_btn_cancel.setTextColor(ActivityCompat.getColor(getContext(), textColor));
	}

	public void setOnClickCancelListener(CharSequence text, int textColor, View.OnClickListener onCancelListener) {
		this.setOnClickCancelListener(onCancelListener);
		common_btn_cancel.setText(text);
		common_btn_cancel.setTextColor(ActivityCompat.getColor(getContext(), textColor));
	}

	public void setOnClickCancelListener(View.OnClickListener onCancelListener) {
		findViewById(R.id.common_ll_bottom).setVisibility(View.VISIBLE);
		common_btn_cancel.setVisibility(View.VISIBLE);
		if(common_btn_confirm.getVisibility() == View.VISIBLE){
			common_btn_cancel.setBackgroundResource(R.drawable.dialog_bottom_left_selector);
			common_btn_confirm.setBackgroundResource(R.drawable.dialog_bottom_right_selector);
		}else{
			common_btn_cancel.setBackgroundResource(R.drawable.dialog_bottom_selector);
		}
		this.onCancelListener = onCancelListener;
	}

	public void setOnClickConfirmListener(CharSequence text, View.OnClickListener onConfirmListener) {
		this.setOnClickConfirmListener(onConfirmListener);
		common_btn_confirm.setText(text);
	}

	public void setOnClickConfirmListener(int textColor, View.OnClickListener onConfirmListener) {
		this.setOnClickConfirmListener(onConfirmListener);
		common_btn_confirm.setTextColor(ActivityCompat.getColor(getContext(), textColor));
	}

	public void setOnClickConfirmListener(CharSequence text, int textColor, View.OnClickListener onConfirmListener) {
		this.setOnClickConfirmListener(onConfirmListener);
		common_btn_confirm.setText(text);
		common_btn_confirm.setTextColor(textColor);
	}

	public void setOnClickConfirmListener(View.OnClickListener onConfirmListener) {
		findViewById(R.id.common_ll_bottom).setVisibility(View.VISIBLE);
		common_btn_confirm.setVisibility(View.VISIBLE);
		if(common_btn_cancel.getVisibility() == View.VISIBLE){
			common_btn_cancel.setBackgroundResource(R.drawable.dialog_bottom_left_selector);
			common_btn_confirm.setBackgroundResource(R.drawable.dialog_bottom_right_selector);
		}else{
			common_btn_confirm.setBackgroundResource(R.drawable.dialog_bottom_selector);
		}
		this.onConfirmListener = onConfirmListener;
	}

	public void setOnClickCloseListener(View.OnClickListener onCloseListener) {
		this.onCloseListener = onCloseListener;
	}

	public void setMiddleView(View v) {
		setView(R.id.common_ll_middle, v);
	}

	public void setMiddleView(int layoutResId) {
		setView(R.id.common_ll_middle, layoutResId);
	}

	public void setBootomView(View v) {
		findViewById(R.id.common_ll_bottom).setVisibility(View.VISIBLE);
		setBottomBgRes(R.drawable.dialog_bottom_selector);
		setView(R.id.common_ll_bottom, v);
	}

	public void setBootomView(int layoutResId) {
		findViewById(R.id.common_ll_bottom).setVisibility(View.VISIBLE);
		setBottomBgRes(R.drawable.dialog_bottom_selector);
		setView(R.id.common_ll_bottom, layoutResId);
	}

	private void setView(int rootId, View v) {
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		LinearLayout ll = (LinearLayout) findViewById(rootId);
		ll.setVisibility(View.VISIBLE);
		ll.removeAllViews();
		ll.addView(v, lp);
	}

	private void setView(int rootId, int layoutId) {
		LinearLayout ll = (LinearLayout) findViewById(rootId);
		ll.setVisibility(View.VISIBLE);
		ll.removeAllViews();
		getLayoutInflater().inflate(layoutId, ll);
	}

	private void removeMiddleView() {
		LinearLayout ll = (LinearLayout) findViewById(R.id.common_ll_middle);
		ll.removeAllViews();
	}

	private void removeBottomView() {
		LinearLayout ll = (LinearLayout) findViewById(R.id.common_ll_bottom);
		ll.removeAllViews();
	}

	public void setDisplayTopEnable(boolean enable){
		if(enable){
			findViewById(R.id.common_rl_top).setVisibility(View.VISIBLE);
		}else{
			findViewById(R.id.common_rl_top).setVisibility(View.GONE);
		}
	}

	public void setDisplayMiddleEnable(boolean enable){
		if(enable){
			findViewById(R.id.common_ll_middle).setVisibility(View.VISIBLE);
		}else{
			findViewById(R.id.common_ll_middle).setVisibility(View.GONE);
		}
	}

	public void setDisplayBottomEnable(boolean enable){
		if(enable){
			findViewById(R.id.common_ll_bottom).setVisibility(View.VISIBLE);
		}else{
			findViewById(R.id.common_ll_bottom).setVisibility(View.GONE);
		}
	}

	public void setTopBgRes(int resId){
		findViewById(R.id.common_rl_top).setBackgroundResource(resId);
	}

	public void setMiddleBgRes(int resId){
		findViewById(R.id.common_ll_middle).setBackgroundResource(resId);
	}

	public void setBottomBgRes(int resId){
		findViewById(R.id.common_ll_bottom).setBackgroundResource(resId);
	}

	public void show() {
		try {
			super.show();
		} catch (Exception e) {
		}
	}

	@Override
	public void dismiss() {
		try {
			super.dismiss();
		} catch (Exception e) {
		}
	}

}
