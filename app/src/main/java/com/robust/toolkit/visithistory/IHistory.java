package com.robust.toolkit.visithistory;

import java.util.Comparator;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2016/9/17.
 */
public interface IHistory<K, V extends Comparable<V>> {
    K getKey();

    void addValue(V v);

    void addValues(Queue<V> v);

    Queue <V> getValues();

}
