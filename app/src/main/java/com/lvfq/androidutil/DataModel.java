package com.lvfq.androidutil;

import java.util.ArrayList;
import java.util.List;

/**
 * DataModel
 *
 * @author lvfq
 * @date 2017/7/3 下午4:16
 * @mainFunction :
 */

public class DataModel {

    public static FirstLevel getFirstLevel() {
        FirstLevel firstLevel = new FirstLevel();
        firstLevel.setName("firstLevel");
        List<TestItem> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(new TestItem(i + 1, "FirstLevel_item_" + i));
        }
        firstLevel.setList(list);

        return firstLevel;
    }

}
