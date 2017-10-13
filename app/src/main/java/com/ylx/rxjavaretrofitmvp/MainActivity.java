package com.ylx.rxjavaretrofitmvp;

import com.ylx.rxjavaretrofitmvp.ui.base.BaseActivity;
import com.ylx.rxjavaretrofitmvp.ui.base.BasePresenter;

public class MainActivity extends BaseActivity {

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int provideContentViewId() {
        return R.layout.activity_main;
    }
}
