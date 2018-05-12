package com.done.donemaster.utils;

import android.app.Activity;
import android.text.TextUtils;

import com.done.donemaster.App;
import com.zss.library.utils.CommonToastUtils;
import com.zss.library.utils.LogUtils;
import com.zss.library.utils.SharedPrefUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by XDONE
 */

public class Utils {

    public static void commonError(Activity activity, String result, String code, String msg) {
        if (TextUtils.isEmpty(code) && TextUtils.isEmpty(msg)) {
            LogUtils.i("xdone", "2222222");
            CommonToastUtils.showInCenterToast(activity, "请求网络超时");
        } else {
            CommonToastUtils.showInCenterToast(activity, msg + "(" + code + ")");
        }
    }

    public static SharedPrefUtils getSharedPrefCommonFile() {
        return new SharedPrefUtils(App.getApplication(), "common_file");
    }

    public static SharedPrefUtils getSharedPreDataFile() {
        return new SharedPrefUtils(App.getApplication(), "data_file");
    }


    public static String getTime(String s) {
        Long aLong = Long.valueOf(s);
        Date date = new Date(aLong * 1000);
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
