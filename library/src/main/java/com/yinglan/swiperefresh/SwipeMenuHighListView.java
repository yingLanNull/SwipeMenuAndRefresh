package com.yinglan.swiperefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class SwipeMenuHighListView extends SwipeMenuListView {

    private int DRAG_X_THROD = 0;

    public SwipeMenuHighListView(Context context) {
        super(context);
    }

    public SwipeMenuHighListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SwipeMenuHighListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    int downX, downY;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            switch (ev.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    downX = (int) ev.getX();
                    downY = (int) ev.getY();
                    break;

                case MotionEvent.ACTION_MOVE:

                    int dx = (int) Math.abs(ev.getX() - downX);
                    int dy = (int) Math.abs(ev.getY() - downY);
                    if (dx > dy && dx > DRAG_X_THROD) {
                        setParentInterceptTouchEvent(true);
                    } else if (dy > dx) {

                    }
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    setParentInterceptTouchEvent(false);

                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onTouchEvent(ev);
    }

    /*    这个函数很重要，请求禁止父容器拦截触摸事件  */
    public void setParentInterceptTouchEvent(boolean disallow) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(disallow);
        }
    }
}
