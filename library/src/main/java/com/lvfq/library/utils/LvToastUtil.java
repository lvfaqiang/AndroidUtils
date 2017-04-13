package com.lvfq.library.utils;

import android.app.Activity;
import android.view.Gravity;
import android.widget.Toast;

/**
 * LvToastUtil
 *
 * @author lvfq
 * @date 2017/4/13 下午4:21
 * @mainFunction :
 */

public class LvToastUtil {

    /**
     * Toast提示框
     *
     * @param context
     * @param message
     */
    private static Toast toast = null;

    private static void showToast(final Activity context, final String message, final int gravity) {
        if (context != null) {
            context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (toast == null) {
                        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
                    } else {
                        toast.setText(message);
                    }
                    if (gravity != 0) {
                        toast.setGravity(gravity, 0, 0);
                    }
                    toast.show();
                }
            });
        }
    }

    /**
     * normal show toast
     *
     * @param context
     * @param message
     */
    public static void showToast(Activity context, String message) {
        showToast(context, message, 0);
    }

    /**
     * Displayed in the center of the screen
     *
     * @param activity
     * @param message
     */
    public static void showToastCenter(Activity activity, String message) {
        showToast(activity, message, Gravity.CENTER);
    }

}
