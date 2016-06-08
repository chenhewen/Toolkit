package com.robust.toolkit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by chenhewen on 16-6-8.
 */
public class EndActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_activity_content_layout);
    }

    public static Intent getEntryIntent(Context context, String entry) {
        Intent intent = new Intent();
        intent.setClass(context.getApplicationContext(), EndActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        return intent;
    }
}
