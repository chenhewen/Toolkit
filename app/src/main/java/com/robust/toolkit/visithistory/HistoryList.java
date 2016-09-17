package com.robust.toolkit.visithistory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

/**
 * Created by Administrator on 2016/9/17.
 */
public class HistoryList<E extends IHistory> extends ArrayList<E> {

    public HistoryList() {
        super();
    }

    public void addHistory(E history) {
        Object historyKey = history.getKey();

        Iterator<E> iterator = iterator();
        boolean findHistory = false;
        while (iterator.hasNext()) {
            E next = iterator.next();
            Object key = next.getKey();
            if (historyKey.equals(key)) {
                next.addValues(history.getValues());
                findHistory = true;
                break;
            }
        }

        if (!findHistory) {
            add(history);
        }
    }

    public E getHistory(E history) {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            E next = iterator.next();
            if (next.equals(history)) {
                return next;
            }
        }

        return null;
    }

    public void removeHistoryBefore(Comparable historyValue) {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            E next = iterator.next();
            Queue values = next.getValues();
            Iterator valueIterator = values.iterator();
            while (valueIterator.hasNext()) {
                Comparable nextValue = (Comparable) valueIterator.next();
                if (nextValue.compareTo(historyValue) < 0) {
                    valueIterator.remove();
                }
            }

            if (values.isEmpty()) {
                iterator.remove();
            }
        }
    }
}
