package com.robust.toolkit.visithistory;

/**
 * Created by Administrator on 2016/9/17.
 */
public class HistoryManager {

    private HistoryDataManager mHistoryDataManager = new HistoryDataManager();

    public void visit(String token) {
        mHistoryDataManager.add(new BaseHistoryData<String, Long>(token, System.currentTimeMillis()));
    }

    public int getVisitCount(String token) {
        return getVisitCount(token, 0, System.currentTimeMillis());
    }

    public int getVisitCount(String token, long millisFrom) {
        return getVisitCount(token, millisFrom, System.currentTimeMillis());
    }

    public int getVisitCount(String token, long millisFrom, long millisTo) {
        BaseHistoryData<String, Long> historyData = mHistoryDataManager.get(new BaseHistoryData<String, Long>(token), millisFrom, millisTo);
        return historyData.getValues().size();
    }
}
