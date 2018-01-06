package com.lvfq.library.utils;

public class DPUtil {
    /**
     * dp 转 px 值
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param dpValue dp 值
     * @return px 值
     */
    public static int dip2px(float dpValue) {
        final float scale = LvUtils.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px 转 dp
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param pxValue px 值
     * @return dp 值
     */
    public static int px2dip(float pxValue) {
        final float scale = LvUtils.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * sp 转 px
     *
     * @param spValue sp 值
     * @return px 值
     */
    public static int sp2px(final float spValue) {
        final float fontScale = LvUtils.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px 转 sp
     *
     * @param pxValue px 值
     * @return sp 值
     */
    public static int px2sp(final float pxValue) {
        final float fontScale = LvUtils.getContext().getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatusBarHeight() {
        int result = 0;
        int resourceId = LvUtils.getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = LvUtils.getContext().getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
