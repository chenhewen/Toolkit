package com.robust.toolkit.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.orhanobut.logger.Logger;
import com.robust.toolkit.R;

import java.io.File;
/**
 * Sample that shows how private files can be easily shared.
 */
public class FileProviderActivity extends Activity {

    public static final String TAG = "FileProviderActivity";

    private ImageView mImage;
    private Button mBtn;
    File mImageDir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_provider_activity_content_provider);
        mImage = (ImageView) findViewById(R.id.image);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onShareFileClick(mImage);
            }
        });

        mImageDir = new File(ToolkitConstant.TOOLKIT_EXTERNAL_IMAGE_DIR_NAME);
        boolean exists = mImageDir.exists();
        if (!exists) {
            mImageDir.mkdirs();
            Logger.t(TAG).d("create dir = %s", mImageDir.getAbsolutePath());
        }

        Logger.t(TAG).d("dir exists = %s", exists);


    }
    public void onShareFileClick(View view) {
        final File file = new File(mImageDir, "private.png");
        final Uri uri = FileProvider.getUriForFile(this, ToolkitConstant.AUTHORITY, file);
        Logger.t(TAG).d(uri.toString()); //output: content://com.robust.toolkit.fileprovider/external_images/private.png


    }
}
