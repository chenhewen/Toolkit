package com.robust.toolkit.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.Toast;

import com.robust.toolkit.R;

/**
 * Created by chenhewen on 16-6-10.
 */
public class RefreshActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refresh_activity_content_layout);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.content_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //memory may leak
                Toast.makeText(RefreshActivity.this, R.string.common_refresh, Toast.LENGTH_SHORT).show();
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }
}
