package com.zss.library.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 公用ViewHolder
 * 
 * @author zm
 *
 */
public class ViewHolder {

	private final SparseArray<View> views;

	private View convertView;

	private int layoutId;

	public ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
		this.layoutId = layoutId;
		this.views = new SparseArray<View>();
		convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
		convertView.setTag(this);
		// AutoUtils.autoSize(convertView);
	}

	public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId) {
		return get(context, convertView, parent, layoutId, -1);
	}

	static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
		if (convertView == null || convertView.getTag().equals("NoData")) {
			return new ViewHolder(context, parent, layoutId, position);
		}
		ViewHolder viewHelper = (ViewHolder) convertView.getTag();
		if (viewHelper.layoutId != layoutId) {
			return new ViewHolder(context, parent, layoutId, position);
		}
		return viewHelper;
	}

	public <T extends View> T findViewById(int viewId) {
		return findView(viewId);
	}

	@SuppressWarnings("unchecked")
	private <T extends View> T findView(int viewId) {
		View view = views.get(viewId);
		if (view == null) {
			view = convertView.findViewById(viewId);
			views.put(viewId, view);
		}
		return (T) view;
	}

	public View getView() {
		return convertView;
	}

}
