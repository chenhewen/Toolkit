package com.robust.toolkit.activity;

import android.app.Activity;
import android.os.Bundle;

import com.orhanobut.logger.Logger;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * Created by chenhewen on 16-7-19.
 */
public class ComparatorWithValueNullActivity extends Activity {

    public static final String TAG = "ComparatorWithValueNullActivity";

    public static final People[] PEOPLE = new People[] {
        new People("chen"), new People("An"), new People(null), new People("che"),
            new People("zhang"), new People("1234"), new People(null)
    };

    private static class People {

        public String mName;

        public People(String name) {
            mName = name;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<People> peoples = Arrays.asList(PEOPLE);
        Collections.sort(peoples, new ComparatorBatterConsumpeMostFirst());
        log(peoples);
    }

    private void log(List<People> list) {
        for (People people : list) {
            if (people.mName != null) {
                Logger.t(TAG).d(people.mName);
            } else {
                Logger.t(TAG).d("null");
            }

        }
    }

    private class ComparatorBatterConsumpeMostFirst implements Comparator<People> {

        String mLanguage = System.getProperty("user.language", "en");
        String mRegion = System.getProperty("user.region", "US");

        @Override
        public int compare(People lhs, People rhs) {

            Collator myCollator = Collator.getInstance(new Locale(mLanguage, mRegion));

            String name1 = lhs.mName;
            String name2 = rhs.mName;

            if (name1 == null && name2 == null) {
                return 0;
            } else if (name1 == null) {
                return 1;
            } else if (name2 == null) {
                return -1;
            }

            if (myCollator.compare(name1, name2) < 0) {
                return -1;
            } else if (myCollator.compare(name1, name2) > 0) {
                return 1;
            } else {
                return 0;
            }
        }

    }
}
