package com.xiayu.basicexercise.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.LinearLayout;

import com.xiayu.basicexercise.R;

public class VDHLayout extends LinearLayout {
    private ViewDragHelper mDragHelper;
    private View firstWish;

    private ScaleGestureDetector mScaleGestureDetector;

    private static final String TAG = "VDHLayout";

    public VDHLayout(Context context) {
        super(context);
    }

    public VDHLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mDragHelper = ViewDragHelper.create(this, 1.0f, new DragHelperCallback());

        mScaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureListener());
    }

    public VDHLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        firstWish = (View) this.findViewById(R.id.button);
        super.onFinishInflate();

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);

        if (ev.getPointerCount() > 1 ) {
            mDragHelper.cancel();
            Log.e(TAG, "cancel");
            return false;
        }
        boolean flag = mDragHelper.shouldInterceptTouchEvent(ev);
        Log.e(TAG,"onInterceptTouchEvent:"+flag);
        return flag;
    }




    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e(TAG, "onTouchEvent:"+ev.getAction());
        mDragHelper.processTouchEvent(ev);
        mScaleGestureDetector.onTouchEvent(ev);
        return true;
    }

     class DragHelperCallback extends ViewDragHelper.Callback {

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return true;
        }


        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            final int topBound = getPaddingTop();
            final int bottomBound = getHeight() - child.getMeasuredHeight();
            final int newTop = Math.min(Math.max(top, topBound), bottomBound);
            return newTop;
        }

         @Override
         public int clampViewPositionHorizontal(View child, int left, int dx) {
             Log.d("DragLayout", "clampViewPositionHorizontal " + left + "," + dx);
             final int leftBound = getPaddingLeft();
             final int rightBound = getWidth() - child.getMeasuredWidth();
             final int newLeft = Math.min(Math.max(left, leftBound), rightBound);
             return newLeft;
         }
         @Override
         public int getViewHorizontalDragRange(View child)
         {
             return getMeasuredWidth()-child.getMeasuredWidth();
         }
         @Override
         public int getViewVerticalDragRange(View child)
         {
             return getMeasuredHeight()-child.getMeasuredHeight();
         }
    }


    public class ScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener{

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            Log.e(TAG, "onScale");
            return false;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Log.e(TAG,"onScaleBegin");
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {

        }
    }

}