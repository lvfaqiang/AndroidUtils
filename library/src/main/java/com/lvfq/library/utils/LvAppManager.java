package com.lvfq.library.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * LvAppManager
 *
 * @author lvfq
 * @date 2017/6/16 上午10:22
 * @mainFunction : Activity 管理类。
 */

public class LvAppManager {
    private static Stack<Activity> activityStack;
    private static LvAppManager instance;

    private LvAppManager() {
    }

    /**
     * 单一实例
     */
    public static LvAppManager getAppManager() {
        if (instance == null) {
            instance = new LvAppManager();
        }
        return instance;
    }

    /**
     * 获取存储Activity的列表。
     *
     * @return
     */
    public Stack<Activity> getActivityStack() {
        return activityStack;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        if (activityStack == null) {
            return null;
        }
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        if (activityStack == null) {
            return;
        }
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null && activityStack != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        if (activityStack == null) {
            return;
        }
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        if (activityStack == null) {
            return;
        }
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     *
     * @param isKill 是否调用 killProcess 彻底退出
     */
    public void AppExit(boolean isKill) {
        try {
            if (activityStack != null) {
                finishAllActivity();
            }
//            ActivityManager activityMgr = (ActivityManager) LvUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
//            activityMgr.restartPackage( LvUtils.getContext().getPackageName());
            if (isKill) {
                android.os.Process.killProcess(android.os.Process.myPid());
            }
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}