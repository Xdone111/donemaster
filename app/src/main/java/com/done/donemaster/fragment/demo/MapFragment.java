package com.done.donemaster.fragment.demo;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.mapapi.clusterutil.MarkerManager;
import com.baidu.mapapi.clusterutil.clustering.Cluster;
import com.baidu.mapapi.clusterutil.clustering.ClusterItem;
import com.baidu.mapapi.clusterutil.clustering.ClusterManager;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.model.LatLng;
import com.done.donemaster.R;
import com.zss.library.fragment.BaseFragment;
import com.zss.library.toolbar.CommonToolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XDONE on 2018/3/31.
 */

public class MapFragment extends BaseFragment implements BaiduMap.OnMapLoadedCallback {
    MapView mMapView;
    BaiduMap mBaiduMap;
    MapStatus ms;
    private ClusterManager<MyItem> mClusterManager;
    private MarkerManager mMarkerManager;
    private BDLocationListener myListener = new MyLocationListener();
    private double currentLatitude, currentLongitude;
    private LatLng currentLL;


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_map;
    }

    @Override
    public void initView() {
        super.initView();
        mMapView = (MapView) findViewById(R.id.bmapView);
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        super.initData(savedInstanceState);
        mMapView = (MapView) findViewById(R.id.bmapView);

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
        addMarkers();
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
    }

    /**
     * 向地图添加Marker点
     */
    public void addMarkers() {
        // 添加Marker点

        LatLng llA = new LatLng(24.963175, 113.400244);
        LatLng llB = new LatLng(24.942821, 113.369199);
        LatLng llC = new LatLng(24.939723, 113.425541);
        LatLng llD = new LatLng(24.906965, 113.401394);
        LatLng llE = new LatLng(24.956965, 113.331394);
        LatLng llF = new LatLng(24.886965, 113.441394);
        LatLng llG = new LatLng(24.996965, 113.411394);


        LatLng llH = new LatLng(30.996965, 113.411394);
        LatLng llI = new LatLng(30.909837, 113.234568);
        LatLng llJ = new LatLng(30.917853, 113.578738);
        LatLng llK = new LatLng(30.989793, 113.837872);
        LatLng llL = new LatLng(30.987368, 113.549838);
        LatLng llM = new LatLng(30.968728, 113.497868);

        List<MyItem> items = new ArrayList<MyItem>();
        items.add(new MyItem(llA));
        items.add(new MyItem(llB));
        items.add(new MyItem(llC));
        items.add(new MyItem(llD));
        items.add(new MyItem(llE));
        items.add(new MyItem(llF));
        items.add(new MyItem(llG));
        items.add(new MyItem(llH));
        items.add(new MyItem(llI));
        items.add(new MyItem(llJ));
        items.add(new MyItem(llK));
        items.add(new MyItem(llL));
        items.add(new MyItem(llM));



        mClusterManager.addItems(items);

    }


    class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            currentLatitude = bdLocation.getLatitude();
            currentLongitude = bdLocation.getLongitude();
            currentLL = new LatLng(currentLatitude, currentLongitude);
        }
    }

    @Override
    public void onMapLoaded() {
        // TODO Auto-generated method stub
        ms = new MapStatus.Builder().target(new LatLng(24.963175, 113.400244)).zoom(13.0f).build();
        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(ms));
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
    public void setTopBar() {
        super.setTopBar();
        CommonToolbar toolbar = getToolbar();
        toolbar.setTitle("百度地图");
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
