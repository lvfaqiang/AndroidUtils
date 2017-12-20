package com.lvfq.library.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.util.List;

/**
 * AppUtil
 *
 * @author lvfq
 * @Github: https://github.com/lvfaqiang
 * @Blog: http://blog.csdn.net/lv_fq
 * @date 2017/11/29 下午3:23
 * @desc :
 * 应用相关
 */

public class AppUtil {

    /**
     * 跳转拨号界面，手动拨号
     *
     * @param phoneNum
     */
    public static void callPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNum));
        LvUtils.getContext().startActivity(intent);
    }

    /**
     * 直接进行拨打电话
     *
     * @param phoneNum
     */
    public static void callPhoneAuto(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNum));
        LvUtils.getContext().startActivity(intent);
    }


    /**
     * 比较两个版本的大小
     *
     * @param version1
     * @param version2
     * @return 返回0和-1，-1表示小于后面的版本
     */
    public static int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
            return 0;
        }
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int index = 0;
        int minLen = Math.min(version1Array.length, version2Array.length);
        int diff = 0;
        while (index < minLen && (diff = Integer.parseInt(version1Array[index]) - Integer.parseInt(version2Array[index])) == 0) {
            index++;
        }
        if (diff == 0) {
            for (int i = index; i < version1Array.length; i++) {
                if (Integer.parseInt(version1Array[i]) > 0) {
                    return 1;
                }
            }
            for (int i = index; i < version2Array.length; i++) {
                if (Integer.parseInt(version2Array[i]) > 0) {
                    return -1;
                }
            }

            return 0;
        } else {
            return diff > 0 ? 1 : -1;
        }
    }

    /**
     * 获取应用图标
     *
     * @return
     */
    public static int getAppIcon() {
        return LvUtils.getContext().getApplicationInfo().icon;
    }

    /**
     * 获取应用名称
     *
     * @return
     */
    public static String getAppName() {
        try {
            return LvUtils.getContext().getPackageManager()
                    .getApplicationLabel(
                            LvUtils.getContext()
                                    .getApplicationInfo())
                    .toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取当前应用版本
     *
     * @return 当前应用版本号 "1.0.0"
     * @throws Exception
     */
    public static String getVersionName() {
        PackageManager pm = LvUtils.getContext().getPackageManager();
        String pn = LvUtils.getContext().getPackageName();
        PackageInfo packageInfo = null;
        try {
            packageInfo = pm.getPackageInfo(pn, 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 判断当前应用是否在前台
     *
     * @return true or false
     */
    public static boolean isAppRunningForeground() {
        ActivityManager manager = (ActivityManager) LvUtils.getContext().getSystemService(android.content.Context.ACTIVITY_SERVICE);
        if (manager != null) {
            try {
                List<ActivityManager.RunningTaskInfo> infos = manager.getRunningTasks(1);
                if (infos != null && infos.size() > 0) {
                    return infos.get(0).baseActivity.getPackageName().equalsIgnoreCase(LvUtils.getContext().getPackageName());
                }
            } catch (SecurityException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 判断服务是否在运行
     *
     * @param serviceName
     * @return true or false
     */
    public static boolean isServiceRunning(String serviceName) {
        ActivityManager am = (ActivityManager) LvUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        if (am != null) {
            List<ActivityManager.RunningServiceInfo> runningServiceInfos = am.getRunningServices(200);
            if (runningServiceInfos.size() <= 0) {
                return false;
            }
            for (ActivityManager.RunningServiceInfo serviceInfo : runningServiceInfos) {
                if (serviceInfo.service.getClassName().equals(serviceName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
