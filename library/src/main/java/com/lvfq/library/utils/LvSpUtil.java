package com.lvfq.library.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.lang.reflect.Type;
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
     * init configure
     *
     * @param spName
     */
    public static void init(String spName) {
        if (!TextUtils.isEmpty(SP_NAME)) {
            throw new RuntimeException("Please don't repeat calls LvSpUitl init method");
        }
        SP_NAME = spName;
    }

    private static SharedPreferences getSp(Context context) {
        if (TextUtils.isEmpty(SP_NAME)) {
            throw new RuntimeException("Please call LvSpUtil init method in your Application");
        }
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return sp;
    }

    /**
     * 获取boolean 数据
     *
     * @param context
     * @param key
     * @return 如果没有值，返回false
     */
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = getSp(context);
        return sp.getBoolean(key, false);
    }

    /**
     * 获取boolean 数据
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getBoolean(key, defValue);
    }

    /**
     * 存boolean缓存
     *
     * @param context
     * @param key
     * @param value
     */
    public static void setBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = getSp(context);
        Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    /**
     * 获取String 数据
     *
     * @param context
     * @param key
     * @return 如果没有值，返回null
     */
    public static String getString(Context context, String key) {
        SharedPreferences sp = getSp(context);
        return sp.getString(key, null);
    }

    /**
     * 获取String 数据
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getString(key, defValue);
    }

    /**
     * 存String缓存
     *
     * @param context
     * @param key
     * @param value
     */
    public static void setString(Context context, String key, String value) {
        SharedPreferences sp = getSp(context);
        Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    /**
     * 获取int 数据
     *
     * @param context
     * @param key
     * @return 如果没有值，返回-1
     */
    public static int getInt(Context context, String key) {
        SharedPreferences sp = getSp(context);
        return sp.getInt(key, -1);
    }

    /**
     * 获取int 数据
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getInt(key, defValue);
    }

    /**
     * 存int缓存
     *
     * @param context
     * @param key
     * @param value
     */
    public static void setInt(Context context, String key, int value) {
        SharedPreferences sp = getSp(context);
        Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.commit();
    }


    /**
     * 获取int 数据
     *
     * @param context
     * @param key
     * @return 如果没有值，返回-1
     */
    public static long getLong(Context context, String key) {
        SharedPreferences sp = getSp(context);
        return sp.getLong(key, -1);
    }

    /**
     * 获取int 数据
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static long getLong(Context context, String key, long defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getLong(key, defValue);
    }

    /**
     * 存int缓存
     *
     * @param context
     * @param key
     * @param value
     */
    public static void setLong(Context context, String key, long value) {
        SharedPreferences sp = getSp(context);
        Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static float getFloat(Context context, String key) {
        SharedPreferences sp = getSp(context);
        return sp.getFloat(key, 0);
    }

    /**
     * 获取int 数据
     *
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static float getFloat(Context context, String key, float defValue) {
        SharedPreferences sp = getSp(context);
        return sp.getFloat(key, defValue);
    }

    /**
     * 存int缓存
     *
     * @param context
     * @param key
     * @param value
     */
    public static void setFloat(Context context, String key, float value) {
        SharedPreferences sp = getSp(context);
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
     * @param context
     * @param list
     * @param key
     */
    @Deprecated
    public static void setListObj(Context context, List<?> list, String key) {
        Editor editor = getSp(context).edit();
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
     * @param context
     * @param key
     * @return
     */
    @Deprecated
    public static List getListObj(Context context, String key) {
        List<?> list = new ArrayList();
        String str = getSp(context).getString(key, "");
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
     * @param context
     * @param key
     */
    public static void remove(Context context, String key) {
        Editor editor = getSp(context).edit();
        editor.remove(key);
        editor.commit();
    }

    /**
     * 移除Sp文件里面的所有数据
     *
     * @param context
     */
    public static void clear(Context context) {
        Editor editor = getSp(context).edit();
        editor.clear();
        editor.commit();
    }

    /**
     * 保存对象（任意对象类型）可传 List, Map等。
     * @param context
     * @param key
     * @param t
     * @param <T>
     */
    public static <T> void setT(Context context, String key, T t) {
        Gson go = new Gson();
        String str = go.toJson(t);
        setString(context, key, str);
    }

    public static Object getObject(Context context, String key, Class clazz) {
        Object o = null;
        String str = getString(context, key, "");
        if (!TextUtils.isEmpty(str)) {
            Gson go = new Gson();
            o = go.fromJson(str, clazz);
        }
        return o;
    }

    /**
     * recommend to use getT
     *
     * @param context
     * @param key
     * @param type
     * @return
     */
    @Deprecated
    public static Object getObject(Context context, String key, Type type) {
        Object o = null;
        String str = getString(context, key, "");
        if (!TextUtils.isEmpty(str)) {
            Gson gson = new Gson();
            o = gson.fromJson(str, type);
        }
        return o;
    }

    /**
     * 获取保存的对象
     *
     * @param context context
     * @param key     key
     * @param t       对象类型
     * @param <T>
     * @return t
     */
    public static <T> T getT(Context context, String key, T t) {

        String str = getString(context, key, "");
        if (!TextUtils.isEmpty(str)) {
            Gson gson = new Gson();
            t = gson.fromJson(str, new TypeToken<T>() {
            }.getType());
        }
//        return o;
        return t;
    }
}
