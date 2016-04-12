package com.example.paul.scrolllistview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 16/4/12.
 */
public class TestAdapter extends BaseAdapter {
    List<String> mList = new ArrayList<>();

    public TestAdapter(List<String> list) {
        mList = list;
    }

    public void setList(List<String> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        Log.e("HPG",position+"");
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview,null);

            holder.tv = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.tv.setText(mList.get(position));
        return convertView;
    }


    class Holder {
        TextView tv;
    }
}
