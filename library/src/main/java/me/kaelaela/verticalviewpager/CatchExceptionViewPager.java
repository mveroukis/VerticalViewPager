package me.kaelaela.verticalviewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * <pre>
 * 拦截系统ViewPager bug: java.lang.IllegalArgumentException: pointerIndex out of range
 * Created by isanwenyu on 16/9/13.
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.<br>
 * </pre>
 */
public class CatchExceptionViewPager extends ViewPager {
    public CatchExceptionViewPager(Context context) {
        super(context);
    }

    public CatchExceptionViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            return super.onTouchEvent(ev);
        } catch (IllegalArgumentException e) {
            //抓取滑动异常 do nothing
//            e.printStackTrace();
            return false;
        }
    }
}
