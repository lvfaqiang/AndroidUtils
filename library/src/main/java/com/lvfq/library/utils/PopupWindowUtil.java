package com.lvfq.library.utils;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * PopupWindows
 *
 * @author FaQiang on 2018/5/8 上午9:14
 * @Github: <a href="https://github.com/lvfaqiang"/>
 * @Blog: <a href="http://blog.csdn.net/lv_fq"/>
 * @desc :
 * 用于快速创建 PopupWindow
 */
public class PopupWindowUtil {

    private Context context;
    private int layoutId;
    private int width = ViewGroup.LayoutParams.WRAP_CONTENT;
    private int height = ViewGroup.LayoutParams.WRAP_CONTENT;
    private boolean mOutsideTouchable = true;
    private boolean mTouchable = true;

    public PopupWindowUtil(Context context, int layoutId) {
        this.context = context;
        this.layoutId = layoutId;
    }

    public PopupWindowUtil setWidth(int width) {
        this.width = width;
        return this;
    }

    public PopupWindowUtil setHeight(int height) {
        this.height = height;
        return this;
    }

    public PopupWindowUtil setOutsideTouchable(boolean mOutsideTouchable) {
        this.mOutsideTouchable = mOutsideTouchable;
        return this;
    }

    public PopupWindowUtil setTouchable(boolean mTouchable) {
        this.mTouchable = mTouchable;
        return this;
    }

    public PopupWindow build() {
        PopupWindow popupWindow = new PopupWindow();
        View inflateView = LayoutInflater.from(context).inflate(layoutId, null);

        popupWindow.setContentView(inflateView);
        popupWindow.setWidth(width);
        popupWindow.setHeight(height);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(mOutsideTouchable);
        popupWindow.setTouchable(mTouchable);

        return popupWindow;
    }


}

