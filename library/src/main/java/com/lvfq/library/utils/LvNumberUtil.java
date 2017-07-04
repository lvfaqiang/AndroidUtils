package com.lvfq.library.utils;

import java.text.DecimalFormat;

/**
 * LvNumberUtil
 *
 * @author lvfq
 * @date 2017/6/29 下午4:27
 * @mainFunction : 数字工具类
 */

public class LvNumberUtil {

    /**
     * 最多保留小数点后两位
     *
     * @param number
     * @return
     */
    public static String maxKeepTwoDecimalPlaces(double number) {
        DecimalFormat df = new DecimalFormat("##.##");
        return df.format(number);
    }

    /**
     * 始终保留小数点后两位
     *
     * @param number
     * @return
     */
    public static String keepTwoDecimalPlaces(double number) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(number);
    }

}
