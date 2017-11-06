package com.lvfq.library.utils;

import android.app.Activity;
import android.app.Dialog;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;

/**
 * LvV
 *
 * @author lvfq
 * @date 2017/4/9 下午3:09
 * @mainFunction :
 */

public class LvV {

    /**
     * 简化Activity里面的 findViewById
     *
     * @param activity
     * @param id
     * @return
     */
    public static <T extends View> T find(Activity activity, int id) {
        return (T) activity.findViewById(id);
    }

    /**
     * 简化Fragment中的findViewById
     *
     * @param view
     * @param id
     * @return
     */
    public static <T extends View> T find(View view, int id) {
        return (T) view.findViewById(id);
    }


    /**
     * 简化 Dialog 中的findViewById
     *
     * @param dialog
     * @param id
     * @param <T>
     * @return
     */
    public static <T extends View> T find(Dialog dialog, int id) {
        return (T) dialog.findViewById(id);
    }

    /**
     * 设置 View 的 OnClick 事件
     *
     * @param listener
     * @param views
     */
    public static void click(View.OnClickListener listener, View... views) {
        for (View view : views) {
            if (view != null) {
                view.setOnClickListener(listener);
            }
        }
    }

    /**
     * 是否显示明文密码
     *
     * @param editText
     * @param isShow
     */
    public static void showPassEdit(EditText editText, boolean isShow) {
        if (isShow) {
            // 明文
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else
            // 密文
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
}
