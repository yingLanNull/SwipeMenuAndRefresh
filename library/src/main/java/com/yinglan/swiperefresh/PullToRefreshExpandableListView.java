/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.yinglan.swiperefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;

import com.yinglan.swiperefresh.internal.EmptyViewMethodAccessor;

public class PullToRefreshExpandableListView extends PullToRefreshAdapterViewBase<ExpandableListView> {

    public PullToRefreshExpandableListView(Context context) {
        super(context);
    }

    public PullToRefreshExpandableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullToRefreshExpandableListView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshExpandableListView(Context context, Mode mode, AnimationStyle style) {
        super(context, mode, style);
    }

    @Override
    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    @Override
    protected ExpandableListView createRefreshableView(Context context, AttributeSet attrs) {
        final ExpandableListView lv;
        lv = new InternalExpandableListView(context, attrs);

        // Set it to this so it can be used in ListActivity/ListFragment
        lv.setId(android.R.id.list);
        return lv;
    }

    class InternalExpandableListView extends ExpandableListView implements EmptyViewMethodAccessor {

        public InternalExpandableListView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        @Override
        public void setEmptyView(View emptyView) {
            PullToRefreshExpandableListView.this.setEmptyView(emptyView);
        }

        @Override
        public void setEmptyViewInternal(View emptyView) {
            super.setEmptyView(emptyView);
        }
    }
}
