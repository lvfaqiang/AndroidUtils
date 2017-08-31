package com.lvfq.library.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.lvfq.library.R;

/**
 * LvDialogUtil
 *
 * @author lvfq
 * @date 2017/4/13 下午4:36
 * @mainFunction : 创建Dialog工具类。
 */

public class LvDialogUtil {
    /**
     * create Dialog
     *
     * @param context
     * @param view    布局视图
     * @param scale   宽度比例
     * @return
     */
    public static Dialog createDialog(Context context, View view, float scale) {
        return createDialog(context, view, scale, -1);
    }

    /**
     * create Dialog
     *
     * @param context
     * @param view    布局视图
     * @param scale   宽度比例
     * @param gravity 显示位置    Gravity.LEFT | Gravity.TOP
     * @return
     */
    public static Dialog createDialog(Context context, View view, float scale, int gravity) {

        final Dialog dialog = new Dialog(context, R.style.style_loading_light_dialog);
        dialog.setContentView(view);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

        Window window = dialog.getWindow();
        if (gravity != -1) {
            window.setGravity(gravity);
        }

        Display dm = ((Activity) context).getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = (int) (dm.getWidth() * scale);
        dialog.getWindow().setAttributes(lp);
        dialog.show();

        return dialog;
    }
}
