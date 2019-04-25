package com.example.myframe.http.dialog;

import android.content.Context;

import com.kaopiz.kprogresshud.KProgressHUD;

/**
 * @ description: 加载对话框
 * @ author: Allen
 * @ date: 2018/7/26
 */
public class ProgressHUD {

    /**
     * 显示加载HUD 需要手动取消
     *
     * @param context 上下文
     * @return KProgressHUD
     */
    public static KProgressHUD show(Context context) {
        return KProgressHUD.create(context)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setCancellable(true)
                .setDimAmount(0.5f)
                .show();
    }

    /**
     * 显示带文字的加载HUD 需要手动取消
     *
     * @param context   上下文
     * @param tipString 提示文字
     * @return KProgressHUD
     */
    public static KProgressHUD show(Context context, String tipString) {
        return KProgressHUD.create(context)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel(tipString)
                .setCancellable(true)
                .setDimAmount(0.5f)
                .show();
    }
}
