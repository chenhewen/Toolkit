package com.robust.toolkit.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.robust.toolkit.R;

/**
 * Created by chenhewen on 16-7-22.
 */
public class ViewRootActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.view_root_activity_content_layout);
        View view = LayoutInflater.from(this).inflate(R.layout.view_root_activity_content_layout, null);

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        wm.addView(view, new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_PHONE));
    }
}
