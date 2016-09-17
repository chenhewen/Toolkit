package com.robust.toolkit.visithistory;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Administrator on 2016/9/17.
 */
public class BaseHistoryData<K, V extends Comparable<V>> implements IHistory<K, V> {

    private K mToken;

    private Queue<V> mQueue = new PriorityQueue<V>();

    protected BaseHistoryData<K, V> copy() {
        BaseHistoryData<K, V> data = new BaseHistoryData<K, V>(mToken);
        Iterator<V> iterator = mQueue.iterator();
        while (iterator.hasNext()) {
            V next = iterator.next();
            data.addValue(next);
        }

        return data;
    }

    public BaseHistoryData(K token) {
        mToken = token;
    }

    public BaseHistoryData(K token, V value) {
        this(token);
        mQueue.add(value);
    }

    public K getToken() {
        return mToken;
    }

    public void addMillis(V millis) {
        mQueue.add(millis);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BaseHistoryData)) {
            return false;
        } else {
            BaseHistoryData hdb = (BaseHistoryData) o;
            Object token = hdb.getToken();

            if (getToken().equals(token)) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public K getKey() {
        return mToken;
    }

    @Override
    public void addValue(V millis) {
        mQueue.add(millis);
    }

    @Override
    public void addValues(Queue<V> millisList) {
        mQueue.addAll(millisList);
    }

    @Override
    public Queue<V> getValues() {
        return mQueue;
    }

}
