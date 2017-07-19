package com.lvfq.androidutil;

import java.io.Serializable;
import java.util.List;

/**
 * FirstLevel
 *
 * @author lvfq
 * @date 2017/7/3 下午4:15
 * @mainFunction :
 */

public class FirstLevel implements Serializable {
    private String name;
    private List<TestItem> list;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TestItem> getList() {
        return list;
    }

    public void setList(List<TestItem> list) {
        this.list = list;
    }
}
