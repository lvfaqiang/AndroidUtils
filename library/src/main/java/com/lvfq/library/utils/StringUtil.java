package com.lvfq.library.utils;

/**
 * StringUtil
 *
 * @author lvfq
 * @Github: https://github.com/lvfaqiang
 * @Blog: http://blog.csdn.net/lv_fq
 * @date 2017/11/13 下午12:44
 * @desc :
 * 处理字符串相关方法
 */

public class StringUtil {

    /**
     * 删除当前字符串 string 中 最后一次出现的字符 charStr.
     *
     * @param string
     * @param charStr
     * @return
     */
    public static String removeEnd(String string, String charStr) {
        int lastIndex = string.lastIndexOf(charStr);
        String s1 = string.substring(0, lastIndex);
        String s2 = string.substring(lastIndex + charStr.length(), string.length());
        return s1 + s2;
    }


}
