package com.lvfq.library.utils;

import android.content.Context;

/**
 * LvUtils
 *
 * @author lvfq
 * @date 2017/6/19 上午9:58
 * @mainFunction :
 */

public class LvUtils {

    private static LvUtils util;
    private Context context;

    public synchronized static LvUtils init(Context context) {
        if (util == null) {
            synchronized (LvUtils.class) {
                util = new LvUtils(context);
            }
        }
        return util;
    }

    /**
     * 初始化工具类中使用的 Context
     *
     * @param context
     */
    public LvUtils(Context context) {
        this.context = context;
    }

    public static Context getContext() {
        if (LvEmptyUtil.isNotNull(util) && LvEmptyUtil.isNotNull(util.context)) {
            return util.context;
        }
        throw new NullPointerException("u should init first - > LvUtils.init(Context) in your Application");
    }

    /**
     * 初始化 sharedpreference
     *
     * @param spName sp 本地文件名称
     * @return
     */
    public LvUtils initSp(String spName) {
        LvSpUtil.initSp(spName);
        return this;
    }

    /**
     * 初始化 Log
     *
     * @param tag
     * @param isOpen
     * @return
     */
    public LvUtils initLog(String tag, boolean isOpen) {
        LvLog.initLog(tag, isOpen);
        return this;
    }

}
