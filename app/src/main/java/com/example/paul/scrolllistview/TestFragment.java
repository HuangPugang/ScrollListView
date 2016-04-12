package com.example.paul.scrolllistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 16/4/12.
 */
public class TestFragment extends BaseFragment {
    ListView listView;
    List<String> list1 = new ArrayList<>();
    View rootView;
    TestAdapter adapter;
    // 标志位，标志已经初始化完成。
    private boolean isPrepared;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_test, null);
        isPrepared = true;
        lazyLoad();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    protected void lazyLoad() {
        if(!isPrepared || !isVisible) {
            return;
        }
        Log.e("HPG","layzy");

        listView = (ListView) rootView.findViewById(R.id.listView);
        for (int i = 0; i < 100; i++) {
            list1.add("apple" + i);
        }
        adapter = new TestAdapter(list1);
        listView.setAdapter(adapter);

        height = ViewUtil.setListViewHeightBasedOnChildren1(listView);
    }

    public static int height;
}
