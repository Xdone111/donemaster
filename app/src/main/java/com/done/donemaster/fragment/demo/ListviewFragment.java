package com.done.donemaster.fragment.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.done.donemaster.R;
import com.zss.library.adapter.CommonAdapter;
import com.zss.library.adapter.ViewHolder;
import com.zss.library.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XDONE on 2018/5/11.
 */

public class ListviewFragment extends BaseFragment {

    private ListView listView;
    private CommonAdapter<String> commonAdapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_listview;
    }

    @Override
    public void initView() {
        super.initView();
        listView = (ListView) findViewById(R.id.listView);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        commonAdapter = new CommonAdapter<String>(getActivity(), R.layout.listview_demo_item) {
            @Override
            protected void convert(ViewHolder viewHolder, String item, int position) {
                TextView textView = viewHolder.findViewById(R.id.textView);
                textView.setText(item);
            }
        };
        getData();
        listView.setAdapter(commonAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    private void getData() {
        List<String> list1 = new ArrayList<>();
        list1.add("hhhh");
        List<String> list2 = new ArrayList<>();
        list2.add("hhhh");
        List<String> list3 = new ArrayList<>();
        list3.add("hhhh");
        List<String> list4 = new ArrayList<>();
        list4.add("hhhh");
        commonAdapter.addAll(list1);
        commonAdapter.addAll(list2);
        commonAdapter.addAll(list3);
        commonAdapter.addAll(list4);
    }
}
