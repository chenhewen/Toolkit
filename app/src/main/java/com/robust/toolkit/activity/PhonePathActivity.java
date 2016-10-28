package com.robust.toolkit.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;

import com.orhanobut.logger.Logger;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by chenhewen on 16-7-12.
 */
public class PhonePathActivity extends Activity {

    public static final String TAG = "PhonePathActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*logIsExternalStorageEmulated();
        logExternalFilesDir();
        logFilesDir();
        logExternalStoragePublicDirectory();
        logExternalFilesDirPictures();
        logExternalCacheDir();*/
        //logExternalMediaDirs();
        write();
    }

    private void write() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File destFile = new File(externalStorageDirectory, "Android/data/com.baidu.BaiduMap/hello.txt");
//        File destFile = new File(externalStorageDirectory, "Android/data/com.baidu.BaiduMap/cache/hello.txt");
        try {
            boolean newFile = destFile.createNewFile();
            Logger.t(TAG).i("newFile = %s", newFile);
            FileUtils.write(destFile, "hello world");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private boolean logIsExternalStorageEmulated() {
        boolean externalStorageEmulated = Environment.isExternalStorageEmulated();
        boolean externalStorageRemovable = Environment.isExternalStorageRemovable();
        Logger.t(TAG).i("externalStorageEmulated = %s", externalStorageEmulated);
        Logger.t(TAG).i("externalStorageRemovable = %s", externalStorageRemovable);
        return true;
    }


    private void logExternalFilesDir() {
        File externalFilesDir = getApplicationContext().getExternalFilesDir(null);
        String absolutePath = "null";
        if (externalFilesDir != null) {
            absolutePath = externalFilesDir.getAbsolutePath();
        }
        Logger.t(TAG).i("externalFilesDir = %s", absolutePath);
        //output: /storage/emulated/0/Android/data/com.robust.toolkit/files
    }

    private void logFilesDir() {
        File fileDir = getApplicationContext().getFilesDir();
        Logger.t(TAG).i("fileDir = %s", fileDir.getAbsolutePath());
        //多用户(android 4.2) 6.0手机结果
        //output: /data/user/0/com.robust.toolkit/files
        //单用户 4.4手机结果
        //output: /data/data/com.robust.toolkit/files
    }

    private void logExternalFilesDirPictures() {
        File externalFilesDir = getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        String absolutePath = "null";
        if (externalFilesDir != null) {
            absolutePath = externalFilesDir.getAbsolutePath();
        }
        Logger.t(TAG).i("externalFilesDir = %s", absolutePath);
        //output: /storage/emulated/0/Android/data/com.robust.toolkit/files/Pictures
    }

    private void logExternalCacheDir() {
        File externalCacheDir = getApplicationContext().getExternalCacheDir();
        String absolutePath = "null";
        if (externalCacheDir != null) {
            absolutePath = externalCacheDir.getAbsolutePath();
        }
        Logger.t(TAG).i("externalCacheDir = %s", absolutePath);
        //output: /storage/emulated/0/Android/data/com.robust.toolkit/cache
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void logExternalMediaDirs() {
        File[] externalMediaDirs = getApplicationContext().getExternalMediaDirs();

        for (File externalMediaDir : externalMediaDirs) {
            Logger.t(TAG).i("externalMediaDir = %s", externalMediaDir.getAbsolutePath());
        }
        //output: /storage/emulated/0/Android/media/com.robust.toolkit
    }

    private void logExternalStoragePublicDirectory() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        Logger.t(TAG).i("externalStoragePublicDirectory = %s", externalStoragePublicDirectory.getAbsolutePath());
        //output: /storage/emulated/0/Pictures
    }

}
