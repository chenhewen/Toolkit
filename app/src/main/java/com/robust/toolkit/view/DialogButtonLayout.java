package com.robust.toolkit.view;

import android.app.AlarmManager;
import android.content.Context;
import android.location.LocationManager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.orhanobut.logger.Logger;

/**
 * Created by chenhewen on 16-8-3.
 */
public class DialogButtonLayout extends LinearLayout {

    public static final String TAG = "DialogButtonLayout";

    public DialogButtonLayout(Context context) {
        super(context);
        init();
    }

    public DialogButtonLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DialogButtonLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(LinearLayout.HORIZONTAL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

        adjust();

    }

    private boolean adjusted;

    private void adjust() {

        if (adjusted) {
            return;
        }
        adjusted = true;

        int widthFreeRoom = 0;

        int parentContentWidth = getWidth() - getPaddingLeft() - getPaddingRight();
        widthFreeRoom = parentContentWidth;
        Logger.t(TAG).d("parentContentWidth = %s", parentContentWidth);


        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int childWidth = childAt.getWidth();
            widthFreeRoom -= childWidth;
            Logger.t(TAG).d("childWidth = %s", childWidth);
        }

        if (widthFreeRoom <= 0) {
            setOrientation(LinearLayout.VERTICAL);
            setGravity(Gravity.RIGHT);
            requestLayout();
        }
    }
}
