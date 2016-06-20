package com.robust.toolkit;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.orhanobut.logger.Logger;

import java.io.File;

/**
 * 外置存储空间中图片列表
 * Created by chenhewen on 16-6-20.
 */
public class ExternalImageSelectActivity extends Activity implements AdapterView.OnItemClickListener {

    public static final String TAG = "ExternalImageSelectActivity";

    private ListView mListView;

    private ExternalImageSelectAdapter mAdapter;
    private File[] mFiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Logger.t(TAG).d(intent.toString());

        setContentView(R.layout.external_image_select_activity_content_layout);
        mListView = (ListView) findViewById(R.id.listView);
        mFiles = prepareFiles();
        mAdapter = new ExternalImageSelectAdapter(this, mFiles);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    private File[] prepareFiles() {
        File dir = new File(ToolkitConstant.TOOLKIT_EXTERNAL_IMAGE_DIR_NAME);
        return dir.listFiles();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final Uri uri = FileProvider.getUriForFile(this, ToolkitConstant.AUTHORITY, mFiles[position]);
        Logger.t(TAG).d("item click uri = %s", uri);

        Intent requestIntent = new Intent();

        if (uri != null) {
            // Grant temporary read permission to the content URI
            requestIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            requestIntent.setDataAndType(uri, getContentResolver().getType(uri));
            // Set the result
            setResult(Activity.RESULT_OK, requestIntent);
        } else {
            requestIntent.setDataAndType(null, "");
            setResult(RESULT_CANCELED, requestIntent);
        }

        if (Intent.ACTION_MAIN.equals(getIntent().getAction())) {
            //如果是主程序进来
            final Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("image/png");
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            startActivity(intent);
        } else if (Intent.ACTION_PICK.equals(getIntent().getAction())) {
            // 其他应用唤起
            finish();
        }
    }
}
