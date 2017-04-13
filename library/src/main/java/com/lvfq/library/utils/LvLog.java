package com.lvfq.library.utils;

import android.util.Log;

/**
 * @author lvfq 日志管理
 * @version 2015-10-13 上午9:52:46
 */
public class LvLog {
    public static String TAG;
    public static boolean on;

    /**
     * init configure
     *
     * @param tag
     * @param isOpen
     */
    public static void init(String tag, boolean isOpen) {
        TAG = tag;
        on = isOpen;
    }

    /**
     * 开关
     */
    public static void setLogEnable(boolean flag) {
        on = flag;
    }

    public static void i(String msg) {
        if (on) {
            Log.i(TAG, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (on) {
            Log.i(tag, msg);
        }
    }

    public static void e(String msg) {
        if (on) {
            Log.e(TAG, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (on) {
            Log.e(tag, msg);
        }
    }

    public static void d(String msg) {
        if (on) {
            Log.d(TAG, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (on) {
            Log.d(tag, msg);
        }
    }

    public static void v(String msg) {
        if (on) {
            Log.d(TAG, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (on) {
            Log.d(tag, msg);
        }
    }
}
