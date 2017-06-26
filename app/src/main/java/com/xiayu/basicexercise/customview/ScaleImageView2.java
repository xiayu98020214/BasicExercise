package com.xiayu.basicexercise.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * Created by 七喜 on 2017/6/26.
 */

public class ScaleImageView2 extends android.support.v7.widget.AppCompatImageView {

    private static final String TAG = "ScaleImageView2";
    private ScaleGestureDetector mScaleGestureDetector;

    private View mView;

    public ScaleImageView2(Context context) {
        this(context, null);
    }

    public ScaleImageView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScaleImageView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

/*    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure() called with: widthMeasureSpec = [" + MeasureSpec.getSize(widthMeasureSpec) + "], heightMeasureSpec = [" + MeasureSpec.getSize(heightMeasureSpec) + "]");
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //返回给ScaleGestureDetector来处理
        return mScaleGestureDetector.onTouchEvent(event);
    }


    private void init(Context context) {
        super.setScaleType(ScaleType.MATRIX);
        mView = this;
        mScaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureListener());
    }


    class ScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener {

        float mLastFactor=1;
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            Log.e(TAG, "onScale");
            mLastFactor=mLastFactor*detector.getScaleFactor();
            mView.setScaleX(mLastFactor);
            mView.setScaleY(mLastFactor);
            //AnimatorUtils.scale(ScaleImageView2.this,detector.getScaleFactor(),detector.getScaleFactor());
            return false;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            Log.e(TAG, "onScaleBegin");
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {

        }
    }

}
