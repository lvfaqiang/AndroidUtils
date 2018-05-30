package com.lvfq.library.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * NumberUtil
 *
 * @author lvfq
 * @date 2017/6/29 下午4:27
 * @mainFunction : 数字工具类
 */

public class NumberUtil {

    /**
     * 最多保留小数点后两位，自动舍0（四舍五入）
     *
     * @param number
     * @return
     */
    public static String maxKeepTwoDecimal(String number) {
        DecimalFormat df = new DecimalFormat("##.##");
        return df.format(new BigDecimal(number));
    }

    /**
     * 最多保留小数点后两位(超出部分截取)
     *
     * @param number
     * @return
     */
    public static String maxKeepTwoDecimalDown(String number) {
        DecimalFormat df = new DecimalFormat("##.##");
        return df.format(new BigDecimal(number).setScale(2, RoundingMode.DOWN));
    }

    /**
     * 始终保留小数点后两位（超出四舍五入）
     *
     * @param number
     * @return
     */
    public static String keepTwoDecimal(String number) {
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(new BigDecimal(number));
    }

    /**
     * 始终保留小数点后两位（超出部分截取）
     *
     * @param number
     * @return
     */
    public static String keepTwoDecimalDown(String number) {
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(new BigDecimal(number).setScale(2, RoundingMode.DOWN));
    }

    /**
     * 最多保存小数点后count位，自动舍0（超出四舍五入）
     *
     * @param number
     * @param count
     * @return
     */
    public static String maxKeepDecimal(String number, int count) {
        return optionDecimal(number, count, "#", -1);
    }

    /**
     * 最多保存小数点后count位，自动舍0（超出截取）
     *
     * @param number
     * @param count
     * @return
     */
    public static String maxKeepDecimalDown(String number, int count) {
        return optionDecimal(number, count, "#", BigDecimal.ROUND_DOWN);
    }

    /**
     * 保存小数点后count位（超出四舍五入）
     *
     * @param number
     * @param count
     * @return
     */
    public static String keepDecimal(String number, int count) {
        return optionDecimal(number, count, "0", -1);
    }

    /**
     * 保存小数点后count位（超出截取）
     *
     * @param number
     * @param count
     * @return
     */
    public static String keepDecimalDown(String number, int count) {
        return optionDecimal(number, count, "0", BigDecimal.ROUND_DOWN);
    }


    private static String optionDecimal(String number, int count, String symbol, int mode) {
        if (count == 0) {
            try {
                return String.valueOf(Integer.parseInt(number));
            } catch (Exception e) {
                return "0";
            }
        }
        StringBuilder stringBuilder = new StringBuilder("#0.");
        for (int i = 0; i < count; i++) {
            stringBuilder.append(symbol);
        }
        DecimalFormat df = new DecimalFormat(stringBuilder.toString());
        BigDecimal bigDecimal;
        if (mode != -1) {
            bigDecimal = new BigDecimal(number).setScale(count, mode);
        } else {
            bigDecimal = new BigDecimal(number);
        }
        return df.format(bigDecimal);
    }

}
