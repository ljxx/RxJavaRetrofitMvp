package com.ylx.rxjavaretrofitmvp.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * ========================================
 * <p/>
 * 版 权：蓝吉星讯 版权所有 （C） 2017
 * <p/>
 * 作 者：yanglixiang
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2017/10/12  下午2:52
 * <p/>
 * 描 述：自定义圆角对dialog
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class CustomDialog extends Dialog {
    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    /**
     * 宽高由布局文件中指定（但是最底层的宽度无效，可以多嵌套一层解决）
     */
    public CustomDialog(Context context, View layout, int style) {
        super(context, style);

        setContentView(layout);

        Window window = getWindow();

        WindowManager.LayoutParams params = window.getAttributes();

        params.gravity = Gravity.CENTER;

        window.setAttributes(params);
    }

    /**
     * 宽高由该方法的参数设置
     */
    protected CustomDialog(Context context, int width, int height, View layout, int style) {
        super(context, style);
        //设置布局内容
        setContentView(layout);
        //设置窗口属性
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        //设置宽度，高度，密度，对齐方式
        float density = getDensity(context);
        params.width = (int) (width * density);
        params.height = (int) (height * density);
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
    }

    /**
     * 获取显示密度
     */
    private float getDensity(Context context) {
        Resources res = context.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        return dm.density;
    }
}
