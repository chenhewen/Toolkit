package com.robust.toolkit;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.orhanobut.logger.Logger;

/**
 * Created by chenhewen on 16-6-7.
 */
public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_content_layout);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float density = displayMetrics.density;
        int densityDpi = displayMetrics.densityDpi;
        float dimension = getResources().getDimension(R.dimen.tell_load_from_values_file_dir);

        Logger.t(TAG).d("density=%s, densityDpi=%s, dimension=%s", density, densityDpi, dimension);
        Logger.t(TAG).d("getDisplayMetrics=%s", getResources().getDisplayMetrics().toString());

    }
}
