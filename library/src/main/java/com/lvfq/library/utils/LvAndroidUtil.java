package com.lvfq.library.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.telephony.TelephonyManager;

import java.io.File;

/**
 * LvAndroidUtil
 *
 * @author lvfq
 * @date 2017/7/18 下午2:29
 * @mainFunction :
 */

public class LvAndroidUtil {

    /**
     * 获取设备Id
     *
     * @return AndroidId
     */
    public static String getAndroidId() {
        TelephonyManager TelephonyMgr = (TelephonyManager) LvUtils.getContext().getSystemService(Activity.TELEPHONY_SERVICE);
        return TelephonyMgr.getDeviceId();
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
     * 安装 Apk 文件
     *
     * @param path       apk 路径
     * @param apkName    apk 名称
     * @param intentFlag 设置 Intent 跳转 Flag
     */
    public static void installApk(String path, String apkName, int intentFlag) {
        File apkfile = new File(path, apkName);
        if (!apkfile.exists()) {
            return;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (intentFlag != -1) {
            intent.setFlags(intentFlag);
        }
        intent.setDataAndType(Uri.parse("file://" + apkfile.toString()),
                "application/vnd.android.package-archive");
        LvUtils.getContext().startActivity(intent);
    }

    /**
     * 安装 Apk 文件
     *
     * @param path    apk 路径
     * @param apkName apk 名称
     */
    public static void installApk(String path, String apkName) {
        installApk(path, apkName, -1);
    }


}
