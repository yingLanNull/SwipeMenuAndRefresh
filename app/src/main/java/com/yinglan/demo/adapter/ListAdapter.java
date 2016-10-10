package com.yinglan.demo.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yinglan.demo.R;
import com.yinglan.swiperefresh.BaseSwipListAdapter;
import com.yinglan.swiperefresh.SwipeMenu;
import com.yinglan.swiperefresh.SwipeMenuListView;

import java.util.List;

/**
 * Created by yinglan
 */

public class ListAdapter extends BaseAdapter implements SwipeMenuListView.OnMenuItemClickListener {

    private List<ApplicationInfo> mAppList;
    private Context mContext;

    public ListAdapter(Context context) {
        mContext = context;
        mAppList = context.getPackageManager().getInstalledApplications(0);
    }

    @Override
    public int getCount() {
        return mAppList.size() / 3;
    }

    @Override
    public ApplicationInfo getItem(int position) {
        return mAppList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_app, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ApplicationInfo item = getItem(position);
        holder.iv_icon.setImageDrawable(item.loadIcon(mContext.getPackageManager()));
        holder.tv_name.setText(item.loadLabel(mContext.getPackageManager()));
        return convertView;
    }

    @Override
    public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
        switch (index) {
            case 0:
                Toast.makeText(mContext,"click~",Toast.LENGTH_SHORT).show();
                break;
            case 1:
                mAppList.remove(position);
                notifyDataSetChanged();
                Toast.makeText(mContext,"delete~",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(mContext,"click~",Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

    class ViewHolder {
        ImageView iv_icon;
        TextView tv_name;

        public ViewHolder(View view) {
            iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
            tv_name = (TextView) view.findViewById(R.id.tv_name);
        }
    }
}
