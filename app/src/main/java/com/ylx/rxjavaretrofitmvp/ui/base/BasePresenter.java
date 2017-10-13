package com.ylx.rxjavaretrofitmvp.ui.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/10/12  下午2:27
 * <p/>
 * 描 述：对若view对若引用
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class BasePresenter<V> {

    /*================== 以下是网络请求接口 ==================*/
    public BaseActivity mContext;

    public BasePresenter(BaseActivity context){
        mContext = context;
    }

    protected Reference<V> mViewRef;

    public void attachView(V view){
        mViewRef = new WeakReference<V>(view);
    }

    public boolean isViewAttached(){
        return mViewRef != null && mViewRef.get() != null;
    }

    public void detachView(){
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public V getView(){
        return mViewRef != null ? mViewRef.get() : null;
    }



}
