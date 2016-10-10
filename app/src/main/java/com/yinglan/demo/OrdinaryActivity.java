package com.yinglan.demo;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.Toast;

import com.yinglan.demo.adapter.ListAdapter;
import com.yinglan.swiperefresh.PullToRefreshBase;
import com.yinglan.swiperefresh.PullToRefreshSwipeListView;
import com.yinglan.swiperefresh.SwipeMenu;
import com.yinglan.swiperefresh.SwipeMenuCreator;
import com.yinglan.swiperefresh.SwipeMenuItem;
import com.yinglan.swiperefresh.SwipeMenuListView;

/**
 * Created by yinglan
 */
public class OrdinaryActivity extends AppCompatActivity {

    private PullToRefreshSwipeListView mPullRefreshListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initView();
    }

    private void initView() {

        mPullRefreshListView = (PullToRefreshSwipeListView) findViewById(R.id.pull_to_refresh_list);
        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<SwipeMenuListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<SwipeMenuListView> refreshView) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OrdinaryActivity.this, "ok", Toast.LENGTH_SHORT).show();
                        mPullRefreshListView.onRefreshComplete();
                    }
                }, 2000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<SwipeMenuListView> refreshView) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(OrdinaryActivity.this, "ok", Toast.LENGTH_SHORT).show();
                        mPullRefreshListView.onRefreshComplete();
                    }
                }, 2000);
            }
        });

        ListAdapter adapter = new ListAdapter(this);

        mPullRefreshListView.setAdapter(adapter);
        mPullRefreshListView.getRefreshableView().setOnMenuItemClickListener(adapter);
        mPullRefreshListView.getRefreshableView().setMenuCreator(creator);
    }


    private SwipeMenuCreator creator = new SwipeMenuCreator() {

        @Override
        public void create(SwipeMenu menu) {
            // Create different menus depending on the view type
            switch (menu.getViewType()) {
                case 0:
                    createMenu1(menu);
                    break;
                case 1:
                    createMenu2(menu);
                    break;
                case 2:
                    createMenu3(menu);
                    break;
            }
        }

        private void createMenu1(SwipeMenu menu) {
            SwipeMenuItem item1 = new SwipeMenuItem(
                    OrdinaryActivity.this);
            item1.setBackground(new ColorDrawable(Color.rgb(0xE5, 0x18,
                    0x5E)));
            item1.setWidth(dp2px(90));
            item1.setIcon(R.drawable.ic_action_favorite);
            menu.addMenuItem(item1);
            SwipeMenuItem item2 = new SwipeMenuItem(
                    getApplicationContext());
            item2.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                    0xCE)));
            item2.setWidth(dp2px(90));
            item2.setIcon(R.drawable.ic_action_good);
            menu.addMenuItem(item2);
        }

        private void createMenu2(SwipeMenu menu) {
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

            SwipeMenuItem item1 = new SwipeMenuItem(
                    OrdinaryActivity.this);
            item1.setBackground(new ColorDrawable(Color.rgb(0xE5, 0xE0,
                    0x3F)));
            item1.setWidth(dp2px(90));
            item1.setIcon(R.drawable.ic_action_important);
            menu.addMenuItem(item1);
        }

        private void createMenu3(SwipeMenu menu) {
            SwipeMenuItem item1 = new SwipeMenuItem(
                    OrdinaryActivity.this);
            item1.setBackground(new ColorDrawable(Color.rgb(0x30, 0xB1,
                    0xF5)));
            item1.setWidth(dp2px(90));
            item1.setIcon(R.drawable.ic_action_about);
            menu.addMenuItem(item1);
            SwipeMenuItem item2 = new SwipeMenuItem(
                    getApplicationContext());
            item2.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                    0xCE)));
            item2.setWidth(dp2px(90));
            item2.setIcon(R.drawable.ic_action_share);
            menu.addMenuItem(item2);
        }
    };

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }
}
