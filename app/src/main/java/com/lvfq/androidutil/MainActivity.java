package com.lvfq.androidutil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.gson.reflect.TypeToken;
import com.lvfq.library.utils.LvDownloadDialog;
import com.lvfq.library.utils.LvLog;
import com.lvfq.library.utils.LvUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LvDownloadDialog dialog = new LvDownloadDialog(MainActivity.this, "http://android.minsutx.cn/Hostay.apk");
                dialog.setMustUpdate(true);
                dialog.show();
            }
        });

        LvUtils.init(this)
                .initSp("fileName")
                .initLog("lfq", true);

        List<TestItem> list = new ArrayList<>();
//        list.add("item1");
//        list.add("item2");

        List<TestItem> items = new ArrayList<>();
        items.add(new TestItem(1, "item1"));
        items.add(new TestItem(2, "item2"));
        items.add(new TestItem(3, "em3"));
        SpUtil.setT("items", items);

        SpUtil.setT("item", DataModel.getFirstLevel());

        FirstLevel item = SpUtil.getT("item", new TypeToken<FirstLevel>() {
        });
        list = SpUtil.getT("items", new TypeToken<List<TestItem>>() {
        });
        LvLog.i(item.getName());
        for (TestItem i : item.getList()) {
            LvLog.i(i.getId() + " , " + item.getName());
        }

        for (int i = 0; i < list.size(); i++) {
            TestItem ite = list.get(i);
            LvLog.i("list : " + ite.getId() + " , " + ite.getName());
        }

        Map<String, TestItem> map = new HashMap<>();
        map.put("key1", new TestItem(1, "value1"));
        map.put("key2", new TestItem(2, "value2"));
        SpUtil.setT("map", map);

        Map<String, TestItem> maps = SpUtil.getT("map", new TypeToken<Map<String, TestItem>>() {
        });
        for (Map.Entry<String, TestItem> en :
                maps.entrySet()) {
            LvLog.i("map : " + en.getKey() + " , " + en.getValue().getName());
        }

    }
}
