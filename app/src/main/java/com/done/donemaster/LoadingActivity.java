package com.done.donemaster;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.done.donemaster.fragment.me.LoginFragment;
import com.zss.library.activity.BaseActivity;
import com.zss.library.activity.ZFrameActivity;
import com.zss.library.toolbar.CommonToolbar;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by XDONE on 2018/3/20.
 */

public class LoadingActivity extends BaseActivity {
    private Handler mHadler = new Handler();
    private TextView tvSkip;
    private int recLen = 5;//跳过倒计时提示5秒
    Timer timer = new Timer();
    private Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CommonToolbar toolbar = getToolbar();
        toolbar.setVisibility(View.GONE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        timer.schedule(task, 1000, 1000);//等待时间一秒，停顿时间一秒

    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_loading;
    }

    @Override
    public void initView() {
        super.initView();
        tvSkip = findViewById(R.id.tvSkip);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);

        startPage();
        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goHome();
            }
        });

    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() { // UI thread
                @Override
                public void run() {
                    recLen--;
                    tvSkip.setText("跳过 " + recLen);
                    if (recLen < 0) {
                        timer.cancel();
                        tvSkip.setVisibility(View.GONE);//倒计时到0隐藏字体
                    }
                }
            });
        }
    };

    private void startPage() {
        mHadler.postDelayed(runnable = new Runnable() {
            @Override
            public void run() {
                goHome();
            }
        }, 5000);
    }

    private void goHome() {
//        Intent intent = new Intent(getActivity(), ZFrameActivity.class);
//        intent.putExtra(ZFrameActivity.CLASS_NAME, LoginFragment.class.getName());
//        startActivity(intent);

        Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
        startActivity(intent);

        if (runnable != null) {
            mHadler.removeCallbacks(runnable);
        }
        finish();
    }
}
