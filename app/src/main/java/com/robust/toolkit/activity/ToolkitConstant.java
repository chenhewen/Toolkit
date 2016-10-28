package com.robust.toolkit.activity;

import android.os.Environment;

import java.io.File;

/**
 * Created by chenhewen on 16-6-20.
 */
public class ToolkitConstant {

    public static final String AUTHORITY = "com.robust.toolkit.fileprovider";

    public static final String TOOLKIT_PKG_NAME = "com.robust.toolkit";

    public static final String TOOLKIT_EXTERNAL_DIR_NAME = Environment.getExternalStorageDirectory() + File.separator + TOOLKIT_PKG_NAME;

    public static final String TOOLKIT_EXTERNAL_IMAGE_DIR_NAME = TOOLKIT_EXTERNAL_DIR_NAME + File.separator + "images";

}
