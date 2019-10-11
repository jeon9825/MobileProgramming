package cse.mobile.myviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    int mPosX, mPosY;
    Paint mPaint = new Paint();

    public MyView(Context context) {
        super(context);
        mPaint.setTextSize(20);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setTextSize(20);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setTextSize(20);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mPosX = (int)event.getX();
        mPosY = (int)event.getY();
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("Touch Event: (" + mPosX + ", " + mPosY + ")", mPosX, mPosY, mPaint);
    }
}
