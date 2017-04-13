package com.lvfq.library.utils;

import android.app.Activity;
import android.view.View;

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

}
