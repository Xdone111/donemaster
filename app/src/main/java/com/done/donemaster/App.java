package com.done.donemaster;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;
import com.done.donemaster.editprofile.CustomProfile;
import com.tencent.TIMManager;
import com.tencent.TIMUserProfile;
import com.tencent.ilivesdk.ILiveSDK;
import com.tencent.livesdk.ILVLiveConfig;
import com.tencent.livesdk.ILVLiveManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XDONE on 2018/3/20.
 */

public class App extends Application {

    private static App app;
    private static Context appContext;
    private ILVLiveConfig mLiveConfig;

    private TIMUserProfile mSelfProfile;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
        appContext = getApplicationContext();
        //百度地图
        SDKInitializer.initialize(getApplicationContext());
//        //ILiveSDK.getInstance().initSdk(getApplicationContext(), 1400026811, 11334);
//        List<String> customInfos = new ArrayList<String>();
//        customInfos.add(CustomProfile.CUSTOM_GET);
//        customInfos.add(CustomProfile.CUSTOM_SEND);
//        customInfos.add(CustomProfile.CUSTOM_LEVEL);
//        customInfos.add(CustomProfile.CUSTOM_RENZHENG);
//        TIMManager.getInstance().initFriendshipSettings(CustomProfile.allBaseInfo, customInfos);
//
//        //初始化直播场景
//        mLiveConfig = new ILVLiveConfig();
//        ILVLiveManager.getInstance().init(mLiveConfig);


    }

    public static Context getContext() {
        return appContext;
    }

    public static App getApplication() {
        return app;
    }

//    public void setSelfProfile(TIMUserProfile userProfile) {
//        mSelfProfile = userProfile;
//    }
//
//    public TIMUserProfile getSelfProfile() {
//        return mSelfProfile;
//    }
//
//    public ILVLiveConfig getLiveConfig() {
//        return mLiveConfig;
//    }
}
