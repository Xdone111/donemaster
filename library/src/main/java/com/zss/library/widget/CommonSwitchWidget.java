package com.zss.library.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.zss.library.R;

/**
 * 公用选择组件
 * @author zm
 *
 */
public class CommonSwitchWidget extends CommonTextWidget {

	CheckBox checkBox;

	public CommonSwitchWidget(Context context) {
		super(context);
	}

	public CommonSwitchWidget(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void createView() {
		super.createView();
		checkBox = new CheckBox(getContext());
		checkBox.setButtonDrawable(R.drawable.switch_selector);
		setRightView(checkBox);
		setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isChecked()){
					setChecked(false);
				} else {
					setChecked(true);
				}
			}
		});
	}

	public boolean isChecked(){
		return checkBox.isChecked();
	}

	public void setChecked(boolean checked){
		checkBox.setChecked(checked);
	}

	public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener){
		checkBox.setOnCheckedChangeListener(listener);
	}



}
