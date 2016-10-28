package com.robust.toolkit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.robust.toolkit.activity.ActionBarActivity;

public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";
    private CardView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_content_layout);
        View image = findViewById(R.id.image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entryIntent = ActionBarActivity.getEntryIntent(MainActivity.this, null);
                startActivity(entryIntent);
            }
        });
    }
}
