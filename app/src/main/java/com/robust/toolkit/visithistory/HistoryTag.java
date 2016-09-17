package com.robust.toolkit.visithistory;

/**
 * Created by Administrator on 2016/9/17.
 */
public class HistoryTag<V extends Comparable<V>> {

    private Comparable<V> mTagValue;
    public HistoryTag(Comparable<V> v) {
        mTagValue = v;
    }

    public Comparable<V> getTagValue() {
        return mTagValue;
    }
}
