package com.robust.toolkit.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Administrator on 2016/7/26.
 */
public class ExceptionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test4(new ArrayList(10));
    }

    private void test() throws Exception {
        throw  new Exception("this is Exception");
    }

    private void test2() {
        throw new RuntimeException("this is runtime Exception");
    }

    private void test3() {
        throw new IllegalStateException("this is runtime Exception");
    }

    private void test4(Collection collection) {
        Object[] a = collection.toArray();
        if (a.getClass() != Object[].class) {
            Object[] newArray = new Object[a.length];
            System.arraycopy(a, 0, newArray, 0, a.length);
            a = newArray;
        }
    }
}
