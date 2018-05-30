package com.lvfq.library.utils;

import org.junit.Test;

/**
 * NumberUtilTest
 *
 * @author FaQiang on 2018/5/15 下午3:32
 * @Github: <a href="https://github.com/lvfaqiang"/>
 * @Blog: <a href="http://blog.csdn.net/lv_fq"/>
 * @desc :
 */
public class NumberUtilTest {

    @Test
    public void maxKeepTwoDecimal() {
        String result0 = NumberUtil.maxKeepTwoDecimal("5.0");
        String result1 = NumberUtil.maxKeepTwoDecimal("5.1");
        String result2 = NumberUtil.maxKeepTwoDecimal("5.10");
        String result3 = NumberUtil.maxKeepTwoDecimal("0.102");
        String result4 = NumberUtil.maxKeepTwoDecimal("5.109");

        System.out.println(result0);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);

    }

    @Test
    public void maxKeepTwoDecimalDown() {
        String result0 = NumberUtil.maxKeepTwoDecimalDown("5.0");
        String result1 = NumberUtil.maxKeepTwoDecimalDown("5.09");
        String result2 = NumberUtil.maxKeepTwoDecimalDown("5.10");
        String result3 = NumberUtil.maxKeepTwoDecimalDown("0.102");
        String result4 = NumberUtil.maxKeepTwoDecimalDown("5.109");

        System.out.println(result0);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    @Test
    public void keepTwoDecimal() {
        String result0 = NumberUtil.keepTwoDecimal("5.0");
        String result1 = NumberUtil.keepTwoDecimal("5.09");
        String result2 = NumberUtil.keepTwoDecimal("5.10");
        String result3 = NumberUtil.keepTwoDecimal("5.102");
        String result4 = NumberUtil.keepTwoDecimal("0.109");

        System.out.println(result0);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    @Test
    public void keepTwoDecimalDown() {
        String result0 = NumberUtil.keepTwoDecimalDown("5.0");
        String result1 = NumberUtil.keepTwoDecimalDown("5.09");
        String result2 = NumberUtil.keepTwoDecimalDown("5.10");
        String result3 = NumberUtil.keepTwoDecimalDown("5.102");
        String result4 = NumberUtil.keepTwoDecimalDown("0.109");

        System.out.println(result0);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    @Test
    public void maxKeepDeimal() {
        String result0 = NumberUtil.maxKeepDecimal("5.0", 2);
        String result1 = NumberUtil.maxKeepDecimal("5.09", 1);
        String result2 = NumberUtil.maxKeepDecimal("5.10", 2);
        String result3 = NumberUtil.maxKeepDecimal("5.102", 0);
        String result4 = NumberUtil.maxKeepDecimal("5.109", 2);

        System.out.println(result0);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    @Test
    public void maxKeepDecimalDown() {
        String result0 = NumberUtil.maxKeepDecimalDown("5.0", 2);
        String result1 = NumberUtil.maxKeepDecimalDown("5.09", 1);  // 5
        String result2 = NumberUtil.maxKeepDecimalDown("5.10", 2);
        String result3 = NumberUtil.maxKeepDecimalDown("5.102", 0);
        String result4 = NumberUtil.maxKeepDecimalDown("5.109", 2);

        System.out.println(result0);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    @Test
    public void keepDecimal() {
        String result0 = NumberUtil.keepDecimal("5.0", 2);
        String result1 = NumberUtil.keepDecimal("5.09", 1);
        String result2 = NumberUtil.keepDecimal("5.10", 2);
        String result3 = NumberUtil.keepDecimal("5.102", 4);
        String result4 = NumberUtil.keepDecimal("5.109", 2);

        System.out.println(result0);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    @Test
    public void keepDecimalDown() {
        String result0 = NumberUtil.keepDecimalDown("5.0", 2);
        String result1 = NumberUtil.keepDecimalDown("5.09", 1);
        String result2 = NumberUtil.keepDecimalDown("5.10", 2);
        String result3 = NumberUtil.keepDecimalDown("0.102", 4);
        String result4 = NumberUtil.keepDecimalDown("5.109", 2);

        System.out.println(result0);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }
}