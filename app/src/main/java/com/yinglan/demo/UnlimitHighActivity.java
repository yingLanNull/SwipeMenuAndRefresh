package com.yinglan.demo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ListView;

import com.yinglan.demo.adapter.ListLessAdapter;
import com.yinglan.demo.adapter.ListTextAdapter;
import com.yinglan.swiperefresh.PullToRefreshBase;
import com.yinglan.swiperefresh.PullToRefreshListView;
import com.yinglan.swiperefresh.SwipeMenu;
import com.yinglan.swiperefresh.SwipeMenuCreator;
import com.yinglan.swiperefresh.SwipeMenuHighListView;
import com.yinglan.swiperefresh.SwipeMenuItem;

/**
 * Created by yinglan
 */

public class UnlimitHighActivity extends AppCompatActivity {
    private com.yinglan.swiperefresh.PullToRefreshListView pulltorefreshpull;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);
        initView();
    }

    private void initView() {

        this.pulltorefreshpull = (PullToRefreshListView) findViewById(R.id.pull_to_refresh_pull);

        pulltorefreshpull.setAdapter(new ListTextAdapter(this));
        pulltorefreshpull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pulltorefreshpull.onRefreshComplete();
                    }
                }, 2000);
            }
        });

        View headerView = View.inflate(this, R.layout.header, null);

        ListLessAdapter lessAdapter = new ListLessAdapter(this);

        SwipeMenuHighListView swipeMenuHighListView = (SwipeMenuHighListView) headerView.findViewById(R.id.highsiwpe);
        swipeMenuHighListView.setAdapter(lessAdapter);
        swipeMenuHighListView.setMenuCreator(creator);
        swipeMenuHighListView.setOnMenuItemClickListener(lessAdapter);

        pulltorefreshpull.getRefreshableView().addHeaderView(headerView);
    }


    private SwipeMenuCreator creator = new SwipeMenuCreator() {

        @Override
        public void create(SwipeMenu menu) {
            // Create different menus depending on the view type
            switch (menu.getViewType()) {
                case 0:
                    createMenu1(menu);
                    break;
            }
        }

        private void createMenu1(SwipeMenu menu) {
            SwipeMenuItem openItem = new SwipeMenuItem(
                    getApplicationContext());
            // set item background
            openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                    0xCE)));
            // set item width
            openItem.setWidth(dp2px(90));
            // set item title
            openItem.setTitle("Open");
            // set item title fontsize
            openItem.setTitleSize(18);
            // set item title font color
            openItem.setTitleColor(Color.WHITE);
            // add to menu
            menu.addMenuItem(openItem);

            // create "delete" item
            SwipeMenuItem deleteItem = new SwipeMenuItem(
                    getApplicationContext());
            // set item background
            deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                    0x3F, 0x25)));
            // set item width
            deleteItem.setWidth(dp2px(90));
            // set a icon
            deleteItem.setIcon(R.drawable.ic_delete);
            // add to menu
            menu.addMenuItem(deleteItem);
        }

        private int dp2px(int dp) {
            return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                    getResources().getDisplayMetrics());
        }
    };
}