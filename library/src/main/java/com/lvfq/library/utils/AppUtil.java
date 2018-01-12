package com.lvfq.library.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.io.File;
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


    /**
     * 在 FragmentActivity 中调用系统拍照
     *
     * @param activity    当前 FragmentActivity
     * @param requestCode 请求码，用于在 FragmentActivity 的 onActivityResult 中接收， super.onActivityResult... 可删可不删
     * @param filePath    文件路径，用于自定义图片保存的地方
     * @return 返回照片路径
     */
    public static String startToCamera(FragmentActivity activity, int requestCode, String filePath) {
        return startToCamera(activity, null, requestCode, filePath);
    }

    /**
     * 在 FragmentActivity 中调用系统拍照
     *
     * @param activity    当前 FragmentActivity
     * @param requestCode 请求码，用于在 FragmentActivity 的 onActivityResult 中接收， super.onActivityResult... 可删可不删
     * @return 返回照片路径(默认为当前应用的缓存路径)
     */
    public static String startToCamera(FragmentActivity activity, int requestCode) {
        String filePath = LvUtils.getContext().getExternalCacheDir() + File.separator + System.currentTimeMillis() + ".png";
        return startToCamera(activity, requestCode, filePath);
    }

    /**
     * 在 Fragment 中调用系统拍照
     *
     * @param fragment    当前 Fragment
     * @param requestCode 请求码，用于在 Fragment 的 onActivityResult 中接收，注意不要删除 super.onActivityResult... 此行代码
     * @param filePath    文件路径，用于自定义图片保存的地方
     * @return 返回照片路径
     */
    public static String startToCamera(Fragment fragment, int requestCode, String filePath) {
        return startToCamera(null, fragment, requestCode, filePath);
    }

    /**
     * 在 Fragment 中调用系统拍照
     *
     * @param fragment    当前 Fragment
     * @param requestCode 请求码，用于在 Fragment 的 onActivityResult 中接收，注意不要删除 super.onActivityResult... 此行代码
     * @return 返回照片路径(默认为当前应用的缓存路径)
     */
    public static String startToCamera(Fragment fragment, int requestCode) {
        String filePath = LvUtils.getContext().getExternalCacheDir() + File.separator + System.currentTimeMillis() + ".png";
        return startToCamera(fragment, requestCode, filePath);
    }

    /**
     * 调用系统相机进行拍照
     *
     * @param activity    当前调用的 Activity
     * @param fragment    当前调用的 Fragment
     * @param requestCode 用于回调的请求码
     * @param filePath    图片保存路径
     * @return 返回文件路径
     */
    private static String startToCamera(FragmentActivity activity, Fragment fragment, int requestCode, String filePath) {
        if (activity == null && fragment == null) {
            throw new IllegalArgumentException("activity or fragment must be have one");
        }
        Uri uri = Uri.fromFile(new File(filePath));
        Bundle bundle = new Bundle();
        bundle.putParcelable(MediaStore.EXTRA_OUTPUT, uri);

        if (null != activity) {
            IntentUtil.startAction(activity, MediaStore.ACTION_IMAGE_CAPTURE, bundle, requestCode);
        } else {
            IntentUtil.startAction(fragment, MediaStore.ACTION_IMAGE_CAPTURE, bundle, requestCode);
        }
        return uri.getEncodedPath();
    }
}
