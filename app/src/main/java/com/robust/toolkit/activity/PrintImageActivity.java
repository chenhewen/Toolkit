package com.robust.toolkit.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.print.PrintHelper;

import com.robust.toolkit.R;

/**
 * Created by chenhewen on 16-7-19.
 */
public class PrintImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doPhotoPrint();
    }

    private void doPhotoPrint() {
        PrintHelper photoPrinter = new PrintHelper(this);
        photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.customactivityoncrash_error_image);
        photoPrinter.printBitmap("droids.jpg - test print", bitmap);
    }
}
