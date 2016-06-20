package com.robust.toolkit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;

public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";
    private CardView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_content_layout);
        mCardView = (CardView) findViewById(R.id.card_view);
    }
}
