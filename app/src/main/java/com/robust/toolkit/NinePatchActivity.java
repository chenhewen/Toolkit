package com.robust.toolkit;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NinePatchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Exception 一定要用九切图
        setContentView(R.layout.nine_patch_activity_content_layout);
        ImageView view = (ImageView) findViewById(R.id.image);
        final TransitionDrawable  drawable = (TransitionDrawable) view.getDrawable();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawable.startTransition(2000);
            }
        });


    }
}
