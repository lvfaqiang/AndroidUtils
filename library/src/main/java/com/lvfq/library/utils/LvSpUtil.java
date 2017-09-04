package com.lvfq.library.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;

/**
 * --------------------------------------------
 * 作 者 : lfq
 * 版 本 ： 1.0
 * 创建日期 ： 2015/7/14 10:15
 * 1.SharedPreferences工具类
 * 封装了对Sp数据存储的基本操作
 * -------------------------------------------
 */
public class LvSpUtil {
    private static String SP_NAME;
    private static SharedPreferences sp;

    /**
     * initSp configure
     *
     * @param spName
     */
    public static void initSp(String spName) {
        if (!TextUtils.isEmpty(SP_NAME)) {
            throw new RuntimeException("Please don't repeat calls LvSpUitl initSp method");
        }
        SP_NAME = spName;
    }

    private static SharedPreferences getSp() {
        if (TextUtils.isEmpty(SP_NAME)) {
            throw new RuntimeException("Please call LvSpUtil initSp method in your Application");
        }
        if (sp == null) {
            sp = LvUtils.getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return sp;
    }

    /**
     * 获取boolean 数据
     *
     * @param key
     * @return 如果没有值，返回false
     */
    public static boolean getBoolean(String key) {
        SharedPreferences sp = getSp();
        return sp.getBoolean(key, false);
    }

    /**
     * 获取boolean 数据
     *
     * @param key
     * @param defValue
     * @return
     */
    public static boolean getBoolean(String key, boolean defValue) {
        SharedPreferences sp = getSp();
        return sp.getBoolean(key, defValue);
    }

    /**
     * 存boolean缓存
     *
     * @param key
     * @param value
     */
    public static void setBoolean(String key, boolean value) {
        SharedPreferences sp = getSp();
        Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * 获取String 数据
     *
     * @param key
     * @return 如果没有值，返回null
     */
    public static String getString(String key) {
        SharedPreferences sp = getSp();
        return sp.getString(key, "");
    }

    /**
     * 获取String 数据
     *
     * @param key
     * @param defValue
     * @return
     */
    public static String getString(String key, String defValue) {
        SharedPreferences sp = getSp();
        return sp.getString(key, defValue);
    }

    /**
     * 存String缓存
     *
     * @param key
     * @param value
     */
    public static void setString(String key, String value) {
        SharedPreferences sp = getSp();
        Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 获取int 数据
     *
     * @param key
     * @return 如果没有值，返回-1
     */
    public static int getInt(String key) {
        SharedPreferences sp = getSp();
        return sp.getInt(key, -1);
    }

    /**
     * 获取int 数据
     *
     * @param key
     * @param defValue
     * @return
     */
    public static int getInt(String key, int defValue) {
        SharedPreferences sp = getSp();
        return sp.getInt(key, defValue);
    }

    /**
     * 存int缓存
     *
     * @param key
     * @param value
     */
    public static void setInt(String key, int value) {
        SharedPreferences sp = getSp();
        Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.commit();
    }


    /**
     * 获取int 数据
     *
     * @param key
     * @return 如果没有值，返回-1
     */
    public static long getLong(String key) {
        SharedPreferences sp = getSp();
        return sp.getLong(key, -1);
    }

    /**
     * 获取int 数据
     *
     * @param key
     * @param defValue
     * @return
     */
    public static long getLong(String key, long defValue) {
        SharedPreferences sp = getSp();
        return sp.getLong(key, defValue);
    }

    /**
     * 存int缓存
     *
     * @param key
     * @param value
     */
    public static void setLong(String key, long value) {
        SharedPreferences sp = getSp();
        Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static float getFloat(String key) {
        SharedPreferences sp = getSp();
        return sp.getFloat(key, 0);
    }

    /**
     * 获取int 数据
     *
     * @param key
     * @param defValue
     * @return
     */
    public static float getFloat(String key, float defValue) {
        SharedPreferences sp = getSp();
        return sp.getFloat(key, defValue);
    }

    /**
     * 存int缓存
     *
     * @param key
     * @param value
     */
    public static void setFloat(String key, float value) {
        SharedPreferences sp = getSp();
        Editor editor = sp.edit();
        editor.putFloat(key, value);
        editor.commit();
    }


    /**
     * 保存List对象集合
     * @param context
     * @param key
     * @param datas
     */
    /*public static void setListObj(Context context, String key, List<?> datas) {
        JSONArray mJsonArray = new JSONArray();
		for (int i = 0; i < datas.size(); i++) {
			Object bean = datas.get(i);
			mJsonArray.put(bean);
		}
		Editor editor = getSp(context).edit();
		editor.putString(key, mJsonArray.toString());
		editor.commit();
	}
	*/

    /**
     * 获取本地List持久化数据
     *
     * @return
     * @paramcontext
     * @paramkey
     *//*
    public static List<?> getListObj(Context context , String key ){
		List<Object> list = new ArrayList<>();
		String result = getSp(context).getString(key, "");
		try {
			JSONArray jsonArray = new JSONArray(result);
			for(int i = 0; i <jsonArray.length(); i++){
				Object bean = jsonArray.get(i);
				list.add(bean);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			ToastUtils.showMessage(context , "获取列表数据异常");
		}
		return list;
	}*/
    @Deprecated
    public static String setListString(List<?> list)
            throws IOException {
        // 实例化一个ByteArrayOutputStream对象，用来装载压缩后的字节文件。
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 然后将得到的字符数据装载到ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                byteArrayOutputStream);
        // writeObject 方法负责写入特定类的对象的状态，以便相应的 readObject 方法可以还原它
        objectOutputStream.writeObject(list);
        // 最后，用Base64.encode将字节文件转换成Base64编码保存在String中
        String SceneListString = new String(Base64.encode(
                byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
        // 关闭objectOutputStream
        objectOutputStream.close();
        return SceneListString;
    }

    @SuppressWarnings("unchecked")
    @Deprecated
    public static List<?> getListString(String string) throws StreamCorruptedException, IOException,
            ClassNotFoundException {
        byte[] mobileBytes = Base64.decode(string.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(mobileBytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        List<?> SceneList = (List<?>) objectInputStream.readObject();
        objectInputStream.close();
        return SceneList;
    }

    /**
     * 保存list 数据
     *
     * @param list
     * @param key
     */
    @Deprecated
    public static void setListObj(List<?> list, String key) {
        Editor editor = getSp().edit();
        try {
            String str = setListString(list);
            editor.putString(key, str);
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取保存的list对象
     *
     * @param key
     * @return
     */
    @Deprecated
    public static List getListObj(String key) {
        List<?> list = new ArrayList();
        String str = getSp().getString(key, "");
        try {
            list = getListString(str);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 移除某一个key所对应的值
     *
     * @param key
     */
    public static void remove(String key) {
        Editor editor = getSp().edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * 移除Sp文件里面的所有数据
     */
    public static void clear() {
        Editor editor = getSp().edit();
        editor.clear();
        editor.commit();
    }

}
