package com.lsqboy.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.lsqboy.common_adapter.CommonAdapter;
import com.lsqboy.common_adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * CommonAdapter 简单使用教程
 * <p>
 * Created by lsqboy_lian on 16-11-21.
 * Email：g.lsqboy@gmail.com
 * Copyright (c) 2016,lsqboy.com All Rights Reserved.
 */
public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mStringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mListView = (ListView) findViewById(R.id.list_view);
        //common adapter 简单使用教程
        mListView.setAdapter(new CommonAdapter<String>(this, getData(), android.R.layout.simple_list_item_1) {
            @Override
            public void convert(ViewHolder helper, String model) {
                helper.setText(android.R.id.text1, model);
            }
        });
    }

    /**
     * 得到数据源
     *
     * @return 数据源
     */
    private List<String> getData() {
        mStringList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mStringList.add("string Item" + i);
        }
        return mStringList;
    }
}
