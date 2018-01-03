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
     *
     * @param clazz  目标类
     * @param bundle 参数
     */
    public static void startActivity(Class clazz, Bundle bundle) {
        Intent intent = new Intent(LvUtils.getContext(), clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        Activity activity = AppManager.getAppManager().currentActivity();
        try {
            activity.startActivity(intent);
        } catch (Exception e) {
            throw new IllegalArgumentException("the number of the activity is zero in AppManager, you can use startActivity(FragmentActivity activity, Class clazz)");
        }
    }

    /**
     * Intent 跳转界面
     *
     * @param clazz 目标类
     */
    public static void startActivity(Class clazz) {
        startActivity(clazz, null);
    }
}
