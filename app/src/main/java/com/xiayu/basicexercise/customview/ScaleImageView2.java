package com.xiayu.basicexercise.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/**
 * Created by 七喜 on 2017/6/26.
 */

public class ScaleImageView2 extends android.support.v7.widget.AppCompatImageButton {

    private static final String TAG = "ScaleImageView2";
    private ScaleGestureDetector mScaleGestureDetector;

    private View mView;

    private float mLastFactor = 1;
    private String textString = "nihaonihao";

    private float textSize = 30;

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
       /* mView.setScaleX(mLastFactor);
        mView.setScaleY(mLastFactor);*/
        mScaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureListener());
    }

    public void setLastFactor(float lastFactor) {
        mLastFactor = lastFactor;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (!textString.equals("")) {
            Paint paint = new Paint();
          /*  paint.setColor(0xff00);
            paint.setStrokeWidth(3);
            paint.setStyle(Paint.Style.FILL);*/
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(50);
            canvas.drawText(textString, canvas.getWidth()/2, canvas.getHeight()/2, paint);
        }


    }


    class ScaleGestureListener implements ScaleGestureDetector.OnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            Log.e(TAG, "onScale");
            mLastFactor = mLastFactor * detector.getScaleFactor();
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
