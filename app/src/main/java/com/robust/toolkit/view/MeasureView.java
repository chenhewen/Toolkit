package com.robust.toolkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * Created by chenhewen on 16-7-21.
 */
public class MeasureView extends View {

    private static final String TAG = "MeasureView";

    public MeasureView(Context context) {
        super(context);
    }

    public MeasureView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);
        Logger.t(TAG).d("widthMeasureSpec = %s, heightMeasureSpec = %s", MeasureSpec.toString(widthMeasureSpec), MeasureSpec.toString(heightMeasureSpec));
        Logger.t(TAG).d("w = %s, h = %s, minW = %s, minH = %S, ", getWidth(), getHeight(), getMinimumWidth(), getMinimumHeight());

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //setMeasuredDimension(getSuggestedMinimumWidth(), specSize);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
