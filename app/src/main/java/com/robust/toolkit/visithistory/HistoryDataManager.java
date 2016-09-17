package com.robust.toolkit.visithistory;

import java.util.Iterator;
import java.util.Queue;

/**
 * Created by Administrator on 2016/9/17.
 */
public class HistoryDataManager {

    private HistoryList<BaseHistoryData<String, Long>> mDataBeanList = new HistoryList<BaseHistoryData<String, Long>>();

    public void add(BaseHistoryData<String, Long> dataBean) {
        mDataBeanList.addHistory(dataBean);
    }

    public BaseHistoryData<String, Long> get(BaseHistoryData<String, Long> dataBean) {
        return mDataBeanList.getHistory(dataBean).copy();
    }

    public BaseHistoryData<String, Long> get(BaseHistoryData<String, Long> dataBean, long millisFrom, long millisTo) {
        BaseHistoryData<String, Long> data = get(dataBean);
        Queue<Long> values = data.getValues();
        Iterator<Long> iterator = values.iterator();
        while (iterator.hasNext()) {
            Long next = iterator.next();
            if (next < millisFrom || next >= millisTo) {
                iterator.remove();
            }
        }

        return data;
    }

    public void delete(long millis) {
        mDataBeanList.removeHistoryBefore(millis);
    }
}
