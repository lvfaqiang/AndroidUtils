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


    private static final int DURATION_DEF = Toast.LENGTH_SHORT;

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
     * @param message 显示信息
     * @param gravity 显示位置
     */
    public static void showToast(final String message, final int gravity, final int duration) {
        final Activity context = AppManager.getAppManager().currentActivity();
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
     * @param values 最少一个，最多三个  [layoutId , gravity , duration]
     */
    public static void showToast(int... values) {
        if (values.length <= 0) {
            return;
        }
        int layoutId = values[0];
        int gravity = 0;
        int duration = DURATION_DEF;
        if (values.length > 2) {
            gravity = values[1];
            duration = values[2];
        } else if (values.length == 2) {
            gravity = values[1];
        }

        View view = View.inflate(LvUtils.getContext(), layoutId, null);
        showToast(view, gravity, duration);
    }

    /**
     * 显示自定义 Toast
     *
     * @param view    自定义视图
     * @param gravity 显示位置
     */
    public static void showToast(final View view, final int gravity, final int duration) {
        final Activity context = AppManager.getAppManager().currentActivity();
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
     * @param message
     */
    public static void showToast(String message) {
        showToast(message, 0);
    }

    /**
     * normal show toast
     *
     * @param message
     */
    public static void showToast(int gravity, String message) {
        showToast(message, gravity, DURATION_DEF);
    }

    /**
     * normal show toast
     *
     * @param message
     */
    public static void showToast(String message, int duration) {
        showToast(message, 0, duration);
    }

    /**
     * Displayed in the center of the screen
     *
     * @param message
     */
    public static void showToastCenter(String message) {
        showToast(message, Gravity.CENTER);
    }

    /**
     * 显示自定义 Toast
     *
     * @param view 自定义视图
     */
    public static void showToast(View view) {
        showToast(view, 0, DURATION_DEF);
    }

    /**
     * 显示自定义 Toast
     *
     * @param layoutId 自定义布局
     */
    public static void showToast(int layoutId) {
        showToast(layoutId, 0, DURATION_DEF);
    }

    /**
     * 显示自定义 Toast
     *
     * @param view 自定义视图
     */
    public static void showToast(int gravity, View view) {
        showToast(view, gravity, DURATION_DEF);
    }

    /**
     * 显示自定义 Toast
     *
     * @param view 自定义视图
     */
    public static void showToast(View view, int duration) {
        showToast(view, 0, duration);
    }


}
