package com.lvfq.androidutil;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lvfq.library.utils.LvSpUtil;


/**
 * SpUtil
 *
 * @author lvfq
 * @Github: https://github.com/lvfaqiang
 * @Blog: http://blog.csdn.net/lv_fq
 * @date 2017/9/4 下午10:13
 * @desc :
 */

public class SpUtil extends LvSpUtil {
    /**
     * 保存对象（所有类型）
     *
     * @param key
     * @param t
     * @param <T>
     */
    public static <T> void setT(String key, T t) {
        setString(key, new Gson().toJson(t));
    }


    /**
     * 获取保存的对象
     *
     * @param key
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T getT(String key, Class<T> tClass) {
        T t = null;
        String str = getString(key, "");
        if (!TextUtils.isEmpty(str)) {
            Gson go = new Gson();
            t = go.fromJson(str, tClass);
        }
        return t;
    }

    /**
     * 获取保存的对象,支持所有类型对象。
     * (主要获取集合的时候使用)
     *
     * @param key
     * @param type
     * @return
     */
    public static <T> T getT(String key, TypeToken<T> type) {
        T o = null;
        String str = getString(key, "");
        if (!TextUtils.isEmpty(str)) {
            Gson gson = new Gson();
            o = gson.fromJson(str, type.getType());
        }
        return o;
    }
}
