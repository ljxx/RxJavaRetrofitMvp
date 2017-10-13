package com.ylx.rxjavaretrofitmvp.ui.activity;

import android.Manifest;
import android.content.Intent;

import com.ylx.rxjavaretrofitmvp.MainActivity;
import com.ylx.rxjavaretrofitmvp.R;
import com.ylx.rxjavaretrofitmvp.ui.base.BaseActivity;
import com.ylx.rxjavaretrofitmvp.ui.base.BasePresenter;

import kr.co.namee.permissiongen.PermissionGen;

public class SplashActivity extends BaseActivity {

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int provideContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    public void init() {
        super.init();
        PermissionGen.with(this)
                .addRequestCode(100)
                .permissions(
                        //电话通讯录
                        Manifest.permission.GET_ACCOUNTS,
                        Manifest.permission.READ_PHONE_STATE,
                        //位置
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        //相机、麦克风
                        Manifest.permission.RECORD_AUDIO,
                        Manifest.permission.WAKE_LOCK,
                        Manifest.permission.CAMERA,
                        //存储空间
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_SETTINGS
                )
                .request();

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        jumpToActivity(intent);
        finish();
    }
}
