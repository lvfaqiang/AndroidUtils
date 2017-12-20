package com.lvfq.library.impl;

/**
 * LogState
 *
 * @author lvfq
 * @Github: https://github.com/lvfaqiang
 * @Blog: http://blog.csdn.net/lv_fq
 * @date 2017/11/29 下午9:47
 * @desc :
 */

public interface LogState {
    void i(String tag, String message);
    void e(String tag, String message);
    void d(String tag, String message);
    void w(String tag, String message);
    void v(String tag, String message);
}
