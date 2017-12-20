package com.lvfq.library.utils;

import com.lvfq.library.impl.LogOff;
import com.lvfq.library.impl.LogOn;
import com.lvfq.library.impl.LogState;

/**
 * @author lvfq 日志管理
 * @version 2015-10-13 上午9:52:46
 */
public class LvLog {
    private static String TAG = "LvUtils";   // default value
    private static LogState logState = new LogOn();    // default open

    /**
     * initSp configure
     *
     * @param tag
     * @param isOpen
     */
    public static void initLog(String tag, boolean isOpen) {
        TAG = tag;
        setLogEnable(isOpen);
    }

    /**
     * 开关
     */
    public static void setLogEnable(boolean flag) {
        if (flag) {
            logState = new LogOn();
        } else {
            logState = new LogOff();
        }
    }

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void i(String tag, String msg) {
        logState.i(tag, msg);
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        logState.e(tag, msg);
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        logState.d(tag, msg);
    }

    public static void v(String msg) {
        v(TAG, msg);
    }

    public static void v(String tag, String msg) {
        logState.v(tag, msg);
    }

    public static void w(String tag, String msg) {
        logState.w(tag, msg);
    }

    public static void w(String msg) {
        w(TAG, msg);
    }
}
