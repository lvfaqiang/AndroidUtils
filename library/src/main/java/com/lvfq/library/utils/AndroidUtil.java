package com.lvfq.library.utils;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;

import java.io.File;
import java.util.List;

/**
 * AndroidUtil
 *
 * @author lvfq
 * @date 2017/7/18 下午2:29
 * @mainFunction :
 * 设备相关
 */

public class AndroidUtil {

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
     * 安装 Apk 文件
     *
     * @param path    apk 路径
     * @param apkName apk 名称
     */
    public static void installApk(String path, String apkName) {
        installApk(path, apkName, -1);
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
     * 是否安装了某应用
     *
     * @param packageName
     * @return
     */
    public static boolean isInstallApp(String packageName) {
        List<PackageInfo> packages = LvUtils.getContext().getPackageManager().getInstalledPackages(0);
        if (packages != null && packages.size() > 0) {
            for (PackageInfo info : packages) {
                if (packageName.equals(info.packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

}
