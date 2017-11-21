package com.lvfq.library.utils;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * ToastUtil
 *
 * @author lvfq
 * @date 2017/4/13 下午4:21
 * @mainFunction :
 */

public class ToastUtil {

    /**
     * Toast提示框
     *
     * @param context
     * @param message
     */
    private static Toast toast = null;

    public static Toast getToast() {
        return toast;
    }

    /**
     * 取消当前提示
     */
    public static void cancel() {
        if (toast != null) {
            toast.cancel();
        }
    }

    /**
     * 显示系统 Toast
     *
     * @param context 作用域
     * @param message 显示信息
     * @param gravity 显示位置
     */
    public static void showToast(final Activity context, final String message, final int gravity, final int duration) {
        if (context != null) {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (toast == null) {
                        toast = Toast.makeText(context, message, duration);
                    } else {
                        toast.setText(message);
                    }
                    if (gravity != 0) {
                        toast.setGravity(gravity, 0, 0);
                    }
                    toast.show();
                }
            });
        }
    }

    /**
     * 显示自定义 Toast
     *
     * @param context 作用域
     * @param view    自定义视图
     * @param gravity 显示位置
     */
    public static void showToast(final Activity context, final View view, final int gravity, final int duration) {
        if (context != null) {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (toast == null) {
                        toast = new Toast(context);
                        toast.setView(view);
                        toast.setDuration(duration);
                    } else {
                        toast.setView(view);
                    }
                    if (gravity == 0) {
                        toast.setGravity(Gravity.CENTER, 0, 0);
                    } else {
                        toast.setGravity(gravity, 0, 0);
                    }
                    toast.show();
                }
            });
        }
    }

    /**
     * normal show toast
     *
     * @param context
     * @param message
     */
    public static void showToast(Activity context, String message) {
        showToast(context, message, 0, Toast.LENGTH_SHORT);
    }

    /**
     * normal show toast
     *
     * @param context
     * @param message
     */
    public static void showToast(Activity context, int gravity, String message) {
        showToast(context, message, gravity, Toast.LENGTH_SHORT);
    }

    /**
     * normal show toast
     *
     * @param context
     * @param message
     */
    public static void showToast(Activity context, String message, int duration) {
        showToast(context, message, 0, duration);
    }

    /**
     * Displayed in the center of the screen
     *
     * @param activity
     * @param message
     */
    public static void showToastCenter(Activity activity, String message) {
        showToast(activity, message, Gravity.CENTER);
    }

    /**
     * 显示自定义 Toast
     *
     * @param activity 作用域
     * @param view     自定义视图
     */
    public static void showToast(Activity activity, View view) {
        showToast(activity, view, 0, Toast.LENGTH_SHORT);
    }

    /**
     * 显示自定义 Toast
     *
     * @param activity 作用域
     * @param view     自定义视图
     */
    public static void showToast(Activity activity, int gravity, View view) {
        showToast(activity, view, gravity, Toast.LENGTH_SHORT);
    }

    /**
     * 显示自定义 Toast
     *
     * @param activity 作用域
     * @param view     自定义视图
     */
    public static void showToast(Activity activity, View view, int duration) {
        showToast(activity, view, 0, duration);
    }

}
