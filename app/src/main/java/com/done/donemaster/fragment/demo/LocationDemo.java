package com.done.donemaster.fragment.demo;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.clusterutil.MarkerManager;
import com.baidu.mapapi.clusterutil.clustering.Cluster;
import com.baidu.mapapi.clusterutil.clustering.ClusterItem;
import com.baidu.mapapi.clusterutil.clustering.ClusterManager;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.done.donemaster.R;
import com.done.donemaster.utils.GsonUtils;
import com.done.donemaster.utils.NetWorkUtils;
import com.done.entry.BusinessCatagoryEntry;
import com.google.gson.reflect.TypeToken;
import com.zss.library.fragment.BaseFragment;
import com.zss.library.utils.LogUtils;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 此demo用来展示如何结合定位SDK实现定位，并使用MyLocationOverlay绘制定位位置 同时展示如何使用自定义图标绘制并点击时弹出泡泡
 */
public class LocationDemo extends BaseFragment implements BaiduMap.OnMapLoadedCallback {

    private MapView mMapView;
    private BaiduMap mBaiduMap;
    public LocationClient mLocationClient;
    public BDLocationListener myListener = new MyLocationListener();
    private LatLng latLng;
    private ClusterManager<MyItem> mClusterManager;
    private MarkerManager mMarkerManager;
    private List<BusinessCatagoryEntry.DataBean> datas;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_marker_cluster_demo;
    }

    @Override
    public void initView() {
        super.initView();
        mMapView = (MapView) findViewById(R.id.bmapView);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        getData();
        //获取地图控件引用
        mBaiduMap = mMapView.getMap();
        //普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mBaiduMap.setMyLocationEnabled(true);

        //默认显示普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mBaiduMap.setMyLocationEnabled(true);
        mLocationClient = new LocationClient(getActivity());     //声明LocationClient类
        //配置定位SDK参数
        initLocation();
        mLocationClient.registerLocationListener(myListener);    //注册监听函数

        getBusinessCatagotyData("2d542fe67adbd2faa35a8dcef7603f4f", "1459", "1", "0");

        mMarkerManager = new MarkerManager(mBaiduMap);
        //聚合与渲染管理器
        mClusterManager = new ClusterManager<>(getActivity(), mBaiduMap, mMarkerManager);
        // ms = new MapStatus.Builder().target(new LatLng(24, 113)).zoom(15.0f).build();

        mBaiduMap = mMapView.getMap();
        mBaiduMap.setOnMapLoadedCallback(this);
        //mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(ms));
        // 定义点聚合管理类ClusterManager
        mClusterManager = new ClusterManager<MyItem>(getActivity(), mBaiduMap);
        // 添加Marker点
       // addMarkers();
        // 设置地图监听，当地图状态发生改变时，进行点聚合运算
        mBaiduMap.setOnMapStatusChangeListener(mClusterManager);
        // 设置maker点击时的响应
        mBaiduMap.setOnMarkerClickListener(mClusterManager);

        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                return mMarkerManager.onMarkerClick(marker);
            }
        });

        mClusterManager.setOnClusterClickListener(new ClusterManager.OnClusterClickListener<MyItem>() {
            @Override
            public boolean onClusterClick(Cluster<MyItem> cluster) {
                Toast.makeText(getActivity(),
                        "有" + cluster.getSize() + "个点", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
        mClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MyItem>() {
            @Override
            public boolean onClusterItemClick(MyItem item) {
                Toast.makeText(getActivity(),
                        "点击单个Item", Toast.LENGTH_SHORT).show();


                return false;
            }
        });



        //开启定位
        mLocationClient.start();
    }

    private void getBusinessCatagotyData(String token, String uid, String s1, String s2) {
        Map<String, String> parmas = new HashMap<>();
        Log.d("getBusinessCatagotyData", token + "====" + uid + "======" + s1 + "===========" + s2);
        parmas.put("token", token);
        parmas.put("uid", uid);
        parmas.put("coin_id", "0");
        parmas.put("category_id", "1");
        NetWorkUtils.postUrl(getActivity(), "http://api.ydchain.cc/api.php/merchants/business_catagory.html", parmas, new NetWorkUtils.IListener() {
            @Override
            public void onSuccess(String result, JSONObject resObj) {
                String data = resObj.optString("data");
                datas = GsonUtils.getListFromJSON(data, new TypeToken<ArrayList<BusinessCatagoryEntry.DataBean>>() {
                }.getType());
                LogUtils.i("====", datas.toString());
                addMarkers(datas);

            }


            @Override
            public void onError(String result, String code, String msg) {

            }
        });
    }


    public void getData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("app_id", "1");
        NetWorkUtils.postUrl(getActivity(), "http://dl.yxumall.com/admin.php/api/Init/upgrade", map, new NetWorkUtils.IListener() {
            @Override
            public void onSuccess(String result, JSONObject resObj) {

            }

            @Override
            public void onError(String result, String code, String msg) {

            }
        });

    }

    /**
     * 向地图添加Marker点
     *
     * @param datas
     */
    public void addMarkers(List<BusinessCatagoryEntry.DataBean> datas) {
        // 添加Marker点

        List<MyItem> items = new ArrayList<>();
        for (BusinessCatagoryEntry.DataBean data : datas) {
            // 位置
            Double dimension = Double.parseDouble(data.getDimension());
            Double longitude = Double.parseDouble(data.getLongitude());

            LatLng location = new LatLng(dimension, longitude);
            items.add(new MyItem(location));
        }
        mClusterManager.addItems(items);

    }


    //配置定位SDK参数
    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy
        );//可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
        option.setCoorType("bd09ll");//可选，默认gcj02，设置返回的定位结果坐标系
        int span = 1000;
        option.setScanSpan(span);//可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
        option.setIsNeedAddress(true);//可选，设置是否需要地址信息，默认不需要
        option.setOpenGps(true);//可选，默认false,设置是否使用gps
        option.setLocationNotify(true);//可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
        option.setIsNeedLocationDescribe(true);//可选，默认false，设置是否需要位置语义化结果，可以在BDLocation
        // .getLocationDescribe里得到，结果类似于“在北京天安门附近”
        option.setIsNeedLocationPoiList(true);//可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
        option.setIgnoreKillProcess(false);
        option.setOpenGps(true); // 打开gps

        //可选，默认true，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认不杀死
        option.SetIgnoreCacheException(false);//可选，默认false，设置是否收集CRASH信息，默认收集
        option.setEnableSimulateGps(false);//可选，默认false，设置是否需要过滤GPS仿真结果，默认需要
        mLocationClient.setLocOption(option);
    }

    @Override
    public void onMapLoaded() {

    }

    //实现BDLocationListener接口,BDLocationListener为结果监听接口，异步获取定位结果
    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            latLng = new LatLng(location.getLatitude(), location.getLongitude());
//            // 构造定位数据
//            MyLocationData locData = new MyLocationData.Builder()
//                    .accuracy(location.getRadius())
//                    // 此处设置开发者获取到的方向信息，顺时针0-360
//                    .direction(100).latitude(location.getLatitude())
//                    .longitude(location.getLongitude()).build();
//            // 设置定位数据
//            mBaiduMap.setMyLocationData(locData);
//            // 当不需要定位图层时关闭定位图层
//            mBaiduMap.setMyLocationEnabled(false);
            OverlayOptions ooA = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory
                    .fromResource(R.mipmap.ic_launcher))
                    .zIndex(4).draggable(true);
            mBaiduMap.addOverlay(ooA);
            MapStatusUpdate u = MapStatusUpdateFactory.newLatLngZoom(latLng, 17.0f);
            mBaiduMap.animateMapStatus(u);
        }
    }


    /**
     * 每个Marker点，包含Marker点坐标以及图标
     */
    public class MyItem implements ClusterItem {
        private final LatLng mPosition;

        public MyItem(LatLng latLng) {
            mPosition = latLng;
        }

        @Override
        public LatLng getPosition() {
            return mPosition;
        }

        @Override
        public BitmapDescriptor getBitmapDescriptor() {
            return BitmapDescriptorFactory
                    .fromResource(R.mipmap.icon_gcoding);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

}