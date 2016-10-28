package com.robust.toolkit.activity;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;

import com.orhanobut.logger.Logger;
import com.robust.toolkit.R;

/**
 * Created by chenhewen on 16-7-11.
 */
public class AnimationActivity extends Activity {

    public static final String TAG = "AnimationActivity";

    int mLength = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_activity_content_latout);
        final ViewGroup contentLayout = (ViewGroup) findViewById(R.id.content_layout);

        Animation animation = new ScaleAnimation(0, 1, 0, 1);
        animation.setDuration(1000);
        final LayoutAnimationController controller = new LayoutAnimationController(animation);

        contentLayout.setLayoutAnimation(controller);
        contentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果视图没刷新, 那么这句话就没什么用
                contentLayout.startLayoutAnimation();
                contentLayout.setTranslationX(mLength += 100);
                logLocation(contentLayout);
            }
        });
        contentLayout.post(new Runnable() {
            @Override
            public void run() {
                logLocation(contentLayout);
            }
        });
    }

    private void logLocation(View v) {
        Logger.t(TAG).d("getLeft = %s, getTranslationX = %s, getX = %s",
                v.getLeft(),
                v.getTranslationX(),
                v.getX());
    }


}
