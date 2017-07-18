package com.lvfq.library.utils;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

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

}
