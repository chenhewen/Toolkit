package com.robust.toolkit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenhewen on 16-6-16.
 */
public class RecyclerViewActivity extends Activity implements RecyclerViewAdapter.OnMyItemClickListener {

    public static final String TAG = "RecyclerViewActivity";

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activty_content_layout);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerViewAdapter(myDatasetList);
        mAdapter.setOnMyItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private String[] myDataset = {"abc", "hahah", "dsf", "wqefaf", "dafafa", "abc", "hahah", "dsf", "wqefaf", "dafafa"};

    private List<String> myDatasetList = new ArrayList<String>(){
        {
            add("A0");
            add("A1");
            add("A2");
            add("A3");
            add("A4");
            add("A5");
            add("A6");
            add("A7");
            add("A8");
            add("A9");
            add("A10");
            add("A11");
            add("A12");
            add("A13");
            add("A14");
            add("A15");
            add("A16");
            add("A17");
            add("A18");
            add("A19");
            add("A20");

        }
    };

    @Override
    public void onMyItemClick(RecyclerViewAdapter.ViewHolder viewHolder, View view, int position) {
        Logger.t(TAG).d("position %s , content is %s", position, myDatasetList.get(position));
        mAdapter.notifyItemRemoved(position);
        mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());
        myDatasetList.remove(position);
    }
}
