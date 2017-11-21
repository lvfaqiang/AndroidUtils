package com.lvfq.library.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.lvfq.library.popwin.BasePickerView;


/**
 * --------------------------------------------
 * Create By :  Lvfq
 * Date ： 2016/11/7 0007 下午 3:14
 * -------------------------------------------
 **/
public class BottomPopwin extends BasePickerView {
    private Context context;

    public BottomPopwin(Context context, int layoutId) {
        super(context);
        this.context = context;
        LayoutInflater.from(context).inflate(layoutId, contentContainer);
    }

    public View getContentView() {
        return contentContainer;
    }

}
