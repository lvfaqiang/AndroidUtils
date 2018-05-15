package com.lvfq.library.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * IntentUtil
 *
 * @author lvfq
 * @Github: https://github.com/lvfaqiang
 * @Blog: http://blog.csdn.net/lv_fq
 * @date 2017/12/20 下午2:28
 * @desc :
 */

public class IntentUtil {


/**
 *
 *    -----------------------------------------------通过指定目标 Class 来进行 Intent 跳转------------
 *
 *
 *
 */

    /**
     * 跳转页面，用于 Activity 中调用
     *
     * @param activity    当前 Activity
     * @param clazz       目标类
     * @param bundle      参数
     * @param requestCode 请求码,用于在 Activity 的onActivityResult 中接受
     */
    public static void startActivity(FragmentActivity activity, Class clazz, Bundle bundle, int requestCode) {

        Intent intent = new Intent(activity, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 跳转页面，用于 Activity 中调用
     *
     * @param activity    当前Activity
     * @param clazz       目标类
     * @param requestCode 请求码,用于在 Activity 的onActivityResult 中接受
     */
    public static void startActivity(FragmentActivity activity, Class clazz, int requestCode) {
        startActivity(activity, clazz, null, requestCode);
    }

    /**
     * 跳转页面，用于 Activity 中调用
     *
     * @param activity 当前Activity
     * @param clazz    目标类
     */
    public static void startActivity(FragmentActivity activity, Class clazz) {
        startActivity(activity, clazz, -1);
    }


    /**
     * 跳转页面，用于 Fragment 中调用
     *
     * @param fragment    当前 Fragment
     * @param clazz       目标类
     * @param bundle      参数
     * @param requestCode 请求码,用于在 Fragment 的onActivityResult 中接受
     */
    public static void startActivity(Fragment fragment, Class clazz, Bundle bundle, int requestCode) {
        Intent intent = new Intent(fragment.getContext(), clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        fragment.startActivityForResult(intent, requestCode);
    }


    /**
     * 跳转页面，用于 Fragment 中调用
     *
     * @param fragment    当前 Fragment
     * @param clazz       目标类
     * @param requestCode 请求码，用于在 Fragment 的onActivityResult 中接受
     */
    public static void startActivity(Fragment fragment, Class clazz, int requestCode) {
        startActivity(fragment, clazz, null, requestCode);
    }

    /**
     * 跳转页面，用于 Fragment 中调用
     *
     * @param fragment 当前 Fragment
     * @param clazz    目标类
     */
    public static void startActivity(Fragment fragment, Class clazz) {
        startActivity(fragment, clazz, -1);
    }


    /**
     * Intent 跳转界面
     * 默认获取 AppManager 中的上层的 Activity 作为跳转类。
     *
     * @param clazz  目标类
     * @param bundle 参数
     */
    public static void startActivity(Class clazz, Bundle bundle, int requestCode) {
        Activity activity = AppManager.getAppManager().currentActivity();
        if (activity == null) {
            throw new IllegalArgumentException("the number of the activity is zero in AppManager, you can use startActivity(FragmentActivity activity, Class clazz)");
        }
        Intent intent = new Intent(activity, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * Intent 跳转界面
     * {@link #startActivity(Class, Bundle, int)}
     *
     * @param clazz 目标类
     */
    public static void startActivity(Class clazz) {
        startActivity(clazz, null);
    }

    /**
     * Intent 跳转
     * {@link #startActivity(Class, Bundle, int)}
     *
     * @param clazz  目标类
     * @param bundle 携带数据
     */
    public static void startActivity(Class clazz, Bundle bundle) {
        startActivity(clazz, bundle, -1);
    }

    /**
     * Intent 跳转
     * {@link #startActivity(Class, Bundle, int)}
     *
     * @param clazz       目标类
     * @param requestCode 请求码
     */
    public static void startActivity(Class clazz, int requestCode) {
        startActivity(clazz, null, requestCode);
    }


/**
 *
 *
 *
 *  -----------------------------------------------通过指定 Intent 的 Action 参数 来匹配相关 Intent 跳转 ，可执行一些系统级别的 Intent 调用------------
 *
 *
 *
 *
 *
 */


    /**
     * 通过 Intent 的 Action 来进行跳转，
     *
     * @param activity    当前跳转的 FragmentActivity，用于接收 requestCode
     * @param action      传入 Intent 的 Action
     * @param bundle      携带的参数
     * @param requestCode 请求码
     */
    public static void startAction(FragmentActivity activity, String action, Bundle bundle, int requestCode) {
        Intent intent = new Intent(action);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        try {
            activity.startActivityForResult(intent, requestCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 相关介绍请查看 {@link #startAction(FragmentActivity, String, Bundle, int)}
     */
    public static void startAction(FragmentActivity activity, String action, Bundle bundle) {
        startAction(activity, action, bundle, -1);
    }

    /**
     * 相关介绍请查看 {@link #startAction(FragmentActivity, String, Bundle, int)}
     */
    public static void startAction(FragmentActivity activity, String action, int requestCode) {
        startAction(activity, action, null, requestCode);
    }

    /**
     * 相关介绍请查看 {@link #startAction(FragmentActivity, String, Bundle, int)}
     */
    public static void startAction(FragmentActivity activity, String action) {
        startAction(activity, action, null, -1);
    }

    /**
     * 通过 Intent 的 Action 来进行跳转，
     *
     * @param fragment    当前跳转的 Fragment，用于接收 requestCode
     * @param action      传入 Intent 的 Action
     * @param bundle      携带的参数
     * @param requestCode 请求码
     */
    public static void startAction(Fragment fragment, String action, Bundle bundle, int requestCode) {
        Intent intent = new Intent(action);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        try {
            fragment.startActivityForResult(intent, requestCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 相关介绍请查看 {@link #startAction(Fragment, String, Bundle, int)}
     */
    public static void startAction(Fragment fragment, String action, Bundle bundle) {
        startAction(fragment, action, bundle, -1);
    }

    /**
     * 相关介绍请查看 {@link #startAction(Fragment, String, Bundle, int)}
     */
    public static void startAction(Fragment fragment, String action, int requestCode) {
        startAction(fragment, action, null, requestCode);
    }

    /**
     * 相关介绍请查看 {@link #startAction(Fragment, String, Bundle, int)}
     */
    public static void startAction(Fragment fragment, String action) {
        startAction(fragment, action, null, -1);
    }

    /**
     * 通过 Action 跳转
     * 默认获取当前 Activity 栈中的最新 Activity 去执行跳转
     *
     * @param action Intent 的 action 参数
     */
    public static void startAction(String action) {
        Activity activity = AppManager.getAppManager().currentActivity();
        if (activity == null) {
            throw new IllegalArgumentException("the number of the activity is zero in AppManager, you can use startActivity(FragmentActivity activity, Class clazz)");
        }
        // 判断当前 Activity 是否是 FragmentActivity 的父类
        if (activity.getClass().isAssignableFrom(FragmentActivity.class)) {
            startAction((FragmentActivity) activity, action);
        }
    }


/**
 *
 *
 *
 *
 *
 *                        --------------------------------- 扩展的一些可能常用的方法 --------------------
 *
 *
 *
 *
 *
 *
 */


}
