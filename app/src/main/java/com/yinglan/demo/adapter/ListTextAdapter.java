package com.yinglan.demo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yinglan.demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinglan
 */

public class ListTextAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> list = new ArrayList<>();

    public ListTextAdapter(Context context) {
        this.mContext = context;
        for (int i = 0; i < 40; i++) {
            list.add("测试数据" + i);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (null == view) {
            view = View.inflate(mContext, R.layout.item_list_app2, null);
            new ViewHolder(view);
        }
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.tv_name.setText(getItem(i).toString());

        return view;
    }

    class ViewHolder {
        TextView tv_name;

        public ViewHolder(View view) {
            tv_name = (TextView) view.findViewById(R.id.text1);
            view.setTag(this);
        }
    }
}
