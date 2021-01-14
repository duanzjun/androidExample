package com.android.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class ColorTextView extends AppCompatTextView {
    private int mViewWidth;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mMatrix;
    private int mTranslate;

    public ColorTextView(Context context) {
        super(context);
    }

    public ColorTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // TODO Auto-generated method stub
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
        }
        if (mViewWidth > 0) {
            mPaint = getPaint();
            mLinearGradient = new LinearGradient(
                    0,
                    0,
                    mViewWidth,
                    0,
                    new int[]{Color.BLUE, Color.BLACK, Color.RED, Color.YELLOW},
                    null, Shader.TileMode.MIRROR);
            mPaint.setShader(mLinearGradient);
            mMatrix = new Matrix();
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        if (mMatrix != null) {
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mMatrix);
            postInvalidateDelayed(100);
        }
    }
}
