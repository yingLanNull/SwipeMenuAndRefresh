# SwipeMenuAndRefresh_Library
## Abstract 摘要
集下拉刷新与侧滑删除于一身的库文件,类似于QQ聊天界面。解决了侧滑与下拉的事件冲突,向下兼容至8,并增加了swipmenu侧滑在特殊场景下scrollview及listview中的嵌套支持。

## Gif 动画
![1](https://github.com/yingLanNull/PullToRefreshSwipeMenu_Library/blob/master/show/demo.gif)

## Image 图片
![1](https://github.com/yingLanNull/PullToRefreshSwipeMenu_Library/blob/master/show/Screenshot1.png)
![2](https://github.com/yingLanNull/PullToRefreshSwipeMenu_Library/blob/master/show/Screenshot2.png)
![3](https://github.com/yingLanNull/PullToRefreshSwipeMenu_Library/blob/master/show/Screenshot3.png)
![4](https://github.com/yingLanNull/PullToRefreshSwipeMenu_Library/blob/master/show/Screenshot4.png)
![5](https://github.com/yingLanNull/PullToRefreshSwipeMenu_Library/blob/master/show/Screenshot5.png)
![6](https://github.com/yingLanNull/PullToRefreshSwipeMenu_Library/blob/master/show/Screenshot6.png)
![7](https://github.com/yingLanNull/PullToRefreshSwipeMenu_Library/blob/master/show/Screenshot7.png)

## Demo 下载体验
[Download Demo](https://github.com/yingLanNull/PullToRefreshSwipeMenu_Library/blob/master/show/app-debug.apk)

## Usage 使用方法
### Step 1
#### Gradle 配置
```
dependencies {
    compile 'com.yinglan.swiperefresh:library:1.0.0'
}
```

### Step 2

#### PullToRefreshSwipeListView 可侧滑及刷新
```
	    <com.yinglan.swiperefresh.PullToRefreshSwipeListView
	            xmlns:ptr="http://schemas.android.com/apk/res-auto"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:dividerHeight="0px"
                android:scrollbars="none"

                ptr:ptrAnimationStyle="flip"                            //动画方式
                ptr:ptrHeaderBackground="@android:color/darker_gray"    //下拉刷新背景色
                ptr:ptrHeaderTextColor="@android:color/white"           //刷新显示文字颜色
                ptr:ptrMode="both" />                                   //模式
```

#### SwipeMenuHighListView 特殊场景可在ScrollView中嵌套侧滑

```
    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.yinglan.swiperefresh.SwipeMenuHighListView
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

        </com.yinglan.swiperefresh.SwipeMenuHighListView>

    </ScrollView>
```
### More Usage 更多用法

[SwipeMenu](https://github.com/baoyongzhang/SwipeMenuListView/blob/master/README.md)

[PullToRefresh](https://github.com/chrisbanes/Android-PullToRefresh/blob/master/README.md)

## Thanks

本库在以下基础上进行了整合调整,增强稳定性,并添加了部分内容。

[Android-PullToRefresh](https://github.com/chrisbanes/Android-PullToRefresh)

[SwipeMenuListView](https://github.com/baoyongzhang/SwipeMenuListView)

## LICENSE 开源许可

    Apache License Version 2.0

