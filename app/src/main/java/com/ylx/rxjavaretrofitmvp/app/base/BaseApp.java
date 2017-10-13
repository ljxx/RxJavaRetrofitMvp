package com.ylx.rxjavaretrofitmvp.app.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import java.util.LinkedList;
import java.util.List;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/10/12  下午1:19
 * <p/>
 * 描 述：
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class BaseApp extends Application {

    public static List<Activity> activities = new LinkedList<>();

    //运用于整个应用对属性值，合理利用资源，减少资源浪费
    private static Context mContext; //上下文对象
    private static Thread mMainThread; //主线程
    private static long mMainThreadId; //主线程id
    private static Looper mMainLooper; //循环队列
    private static Handler mHandler; //主线程handler

    @Override
    public void onCreate() {
        super.onCreate();
        //为全局属性赋值
        mContext = getApplicationContext();
        mMainThread = Thread.currentThread();
        mMainThreadId = android.os.Process.myTid();
        mHandler = new Handler();
    }

    /**
     * 完全推出
     * 一般用于退出程序
     */
    public static void exit(){
        for(Activity activity : activities){
            activity.finish();
        }
    }

    /**
     * 重启当前应用
     */
    public static void restart(){
        Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mContext.startActivity(intent);
    }

    public static List<Activity> getActivities() {
        return activities;
    }

    public static void setActivities(List<Activity> activities) {
        BaseApp.activities = activities;
    }

    public static Context getmContext() {
        return mContext;
    }

    public static void setmContext(Context mContext) {
        BaseApp.mContext = mContext;
    }

    public static Thread getmMainThread() {
        return mMainThread;
    }

    public static void setmMainThread(Thread mMainThread) {
        BaseApp.mMainThread = mMainThread;
    }

    public static long getmMainThreadId() {
        return mMainThreadId;
    }

    public static void setmMainThreadId(long mMainThreadId) {
        BaseApp.mMainThreadId = mMainThreadId;
    }

    public static Looper getmMainLooper() {
        return mMainLooper;
    }

    public static void setmMainLooper(Looper mMainLooper) {
        BaseApp.mMainLooper = mMainLooper;
    }

    public static Handler getmHandler() {
        return mHandler;
    }

    public static void setmHandler(Handler mHandler) {
        BaseApp.mHandler = mHandler;
    }
}
