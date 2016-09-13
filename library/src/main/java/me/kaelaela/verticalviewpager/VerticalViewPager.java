package me.kaelaela.verticalviewpager;

/**
 * Copyright (C) 2015 Kaelaela
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import me.kaelaela.verticalviewpager.transforms.DefaultTransformer;

/**
 * <pre>
 * 优化的垂直的viewpager
 * <ul>
 *     <li>拦截系统ViewPager bug: java.lang.IllegalArgumentException: pointerIndex out of range {@link CatchExceptionViewPager} </li>
 *     <li>嵌套{@link android.support.v4.view.ViewPager}垂直滑动优化</li>
 * </ul>
 * Edited by isanwenyu on 2016/9/13.<p>
 * Copyright (c) 2016 isanwenyu@163.com. All rights reserved.
 * </pre>
 */
public class VerticalViewPager extends CatchExceptionViewPager {

    private float lastX;
    private float lastY;

    public VerticalViewPager(Context context) {
        this(context, null);
    }

    public VerticalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPageTransformer(false, new DefaultTransformer());
    }

    private MotionEvent swapTouchEvent(MotionEvent event) {
        float width = getWidth();
        float height = getHeight();

        float swappedX = (event.getY() / height) * width;
        float swappedY = (event.getX() / width) * height;

        event.setLocation(swappedX, swappedY);

        return event;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        boolean isVertical = false;
        boolean intercept = false;
        try {
            float x = event.getX();
            float y = event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    lastX = x;
                    lastY = y;
                    break;
                case MotionEvent.ACTION_MOVE:
                    float dx = x - lastX;
                    float dy = y - lastY;
                    if (Math.abs(dx) < Math.abs(dy)) {
                        isVertical = true;
                    }
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    lastX = lastY = 0;
                    break;

            }
            intercept = super.onInterceptTouchEvent(swapTouchEvent(event));
            //If not intercept, touch event should not be swapped.
            swapTouchEvent(event);
        } catch (IllegalArgumentException e) {
            //抓取滑动异常 do nothing
//            e.printStackTrace();
        }
//        LogUtil.i("VerticalViewPager:"+event.toString()+"isVertial:"+isVertical+"intercept:"+intercept);
        return intercept || isVertical;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(swapTouchEvent(ev));
    }

}
