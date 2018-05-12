package com.zss.library.https;

import android.app.Application;
import android.os.Looper;

import com.bumptech.glide.Glide;

import java.io.File;
import java.math.BigDecimal;

public class GlideCacheUtils {

    private static GlideCacheUtils instance;

    public static GlideCacheUtils getInstance() {
        if (null == instance) {
            instance = new GlideCacheUtils();
        }
        return instance;
    }

    // 获取Glide磁盘缓存大小
    public String getCacheSize(Application app) {
        try {
            File cacheDirectory = app.getExternalCacheDir();
            if (cacheDirectory == null) {
                return "";
            }
            return getFormatSize(getFolderSize(new File(cacheDirectory, "cache")));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // 清除图片磁盘缓存，调用Glide自带方法
    public void clearDiskCache(final Application app) { //在线程中执行
        new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.get(app).clearDiskCache();
            }
        }).start();
    }

    // 清除Glide内存缓存
    public boolean clearCacheMemory(Application app) { //在主线程执行
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                Glide.get(app).clearMemory();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    // 获取指定文件夹内所有文件大小的和
    private long getFolderSize(File file) throws Exception {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (File aFileList : fileList) {
                if (aFileList.isDirectory()) {
                    size = size + getFolderSize(aFileList);
                } else {
                    size = size + aFileList.length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    // 格式化单位
    private String getFormatSize(double size) {
        double kiloByte = size / 1024;
        if (kiloByte < 1) {
            return size + "Byte";
        }
        double megaByte = kiloByte / 1024;
        if (megaByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "KB";
        }
        double gigaByte = megaByte / 1024;
        if (gigaByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "MB";
        }
        double teraBytes = gigaByte / 1024;
        if (teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
    }

}