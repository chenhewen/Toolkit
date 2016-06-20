package com.robust.toolkit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.File;

/**
 * 外置存储空间中图片列表Adapter
 * Created by chenhewen on 16-6-20.
 */
public class ExternalImageSelectAdapter extends BaseAdapter {


    private Context mContext;
    private File[] mFiles;

    public ExternalImageSelectAdapter(Context context, File[] files) {
        mContext = context.getApplicationContext();
        mFiles = files;
    }

    @Override
    public int getCount() {
        return mFiles.length;
    }

    @Override
    public Object getItem(int position) {
        return mFiles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder = null;

        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.design_list_item_layout, parent, false);
            holder.mTextView = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.mTextView.setText(mFiles[position].getName());

        return convertView;
    }

    private class Holder {
        TextView mTextView;
    }
}
