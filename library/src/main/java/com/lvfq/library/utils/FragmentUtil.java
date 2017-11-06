package com.lvfq.library.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * FragmentUtil
 *
 * @author lvfq
 * @Github: https://github.com/lvfaqiang
 * @Blog: http://blog.csdn.net/lv_fq
 * @date 2017/11/1 上午10:32
 * @desc : 用法： 主要用在 BaseActivity/BaseFragment 中，初始化之后，可用来进行控制界面多个Fragment 切换
 */

public class FragmentUtil {

    public FragmentUtil(FragmentManager manager) {
        this.manager = manager;
    }

    private Fragment curFragment;
    private FragmentManager manager;

    /**
     * 显示 Fragment
     *
     * @param fragment
     * @param id
     */
    public void showFragment(Fragment fragment, int id) {
        FragmentTransaction ft = manager.beginTransaction();
        if (curFragment != null) {
            ft.hide(curFragment);
        }
        if (fragment.isAdded()) {
            ft.show(fragment);
        } else {
            ft.add(id, fragment).show(fragment);
        }
        ft.commit();
        curFragment = fragment;
    }

    /**
     * 替换 Fragment
     *
     * @param fragment
     * @param id
     */
    public void replaceFragment(Fragment fragment, int id) {
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(id, fragment);
        ft.commit();
    }
}
