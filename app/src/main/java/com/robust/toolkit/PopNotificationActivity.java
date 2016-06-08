package com.robust.toolkit;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * 能够弹出通知的activity
 * Created by chenhewen on 16-6-7.
 */
public class PopNotificationActivity extends Activity implements View.OnClickListener{

    public static final String TAG = "PopNotificationActivity";

    private CheckBox mAutoCancel;

    private View mBigTextStyleBtn;
    private CheckBox mSlideDelete;
    private CheckBox mOngoing;
    private NotificationTransitBroadcast mNotificationTransitBroadcast;
    private View mBigImageStyleBtn;
    private View mInboxStyleBtn;
    private int mInboxStyleCount;
    private View mAnotherMsgBtn;
    private Notification.InboxStyle mInboxStyle;
    private CheckBox mVibrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNotificationTransitBroadcast = new NotificationTransitBroadcast();
        registerReceiver(mNotificationTransitBroadcast, NotificationTransitBroadcast.getFilter());

        setContentView(R.layout.pop_notification_activity_content_layout);
        mBigTextStyleBtn = findViewById(R.id.big_text_btn);
        mBigImageStyleBtn = findViewById(R.id.big_image_btn);
        mInboxStyleBtn = findViewById(R.id.in_box_btn);
        mAnotherMsgBtn = findViewById(R.id.in_box_another_msg);
        mAnotherMsgBtn.setOnClickListener(this);
        mBigTextStyleBtn.setOnClickListener(this);
        mBigImageStyleBtn.setOnClickListener(this);
        mInboxStyleBtn.setOnClickListener(this);
        mAutoCancel = (CheckBox) findViewById(R.id.auto_cancel);
        mAutoCancel.setChecked(true);
        mVibrate = (CheckBox) findViewById(R.id.vibrate);
        //mSlideDelete = (CheckBox) findViewById(R.id.slide_delete);
        mOngoing = (CheckBox) findViewById(R.id.ongoing);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mNotificationTransitBroadcast);
    }


    @Override
    public void onClick(View v) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setAutoCancel(mAutoCancel.isChecked());
        builder.setOngoing(mOngoing.isChecked());
        builder.setSmallIcon(R.drawable.ic_face_white_48dp);
        builder.setTicker(getText(R.string.ticker_text));
        builder.setContentTitle(getText(R.string.content_title));
        builder.setContentText(getText(R.string.context_text));
        builder.setSubText(getText(R.string.sub_text));
        builder.setContentInfo(getText(R.string.content_info));
        builder.setContentIntent(PendingIntent.getActivity(this, 0, EndActivity.getEntryIntent(this, ""), PendingIntent.FLAG_UPDATE_CURRENT));
        builder.addAction(R.drawable.ic_content_copy_white_18dp, getText(R.string.common_copy), PendingIntent.getActivity(this, 0, EndActivity.getEntryIntent(this, ""), PendingIntent.FLAG_UPDATE_CURRENT));
        builder.addAction(R.drawable.ic_content_paste_white_18dp, getText(R.string.common_paste), PendingIntent.getActivity(this, 0, EndActivity.getEntryIntent(this, ""), PendingIntent.FLAG_UPDATE_CURRENT));
        builder.setVibrate(new long[]{500, mVibrate.isChecked() ? 500 : 0});

        if (mBigTextStyleBtn.equals(v)) {
            builder.setStyle(new Notification.BigTextStyle()
                    .bigText(getText(R.string.long_text)).setBigContentTitle(getText(R.string.content_big_title)));
        } else if (mBigImageStyleBtn.equals(v)) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.notificaiton_big_pic);
            builder.setStyle(new Notification.BigPictureStyle().bigLargeIcon(bitmap).bigPicture(bitmap));
        } else if (mInboxStyleBtn.equals(v)) {
            mInboxStyleCount = 1;
            mInboxStyle = new Notification.InboxStyle();
            builder.setStyle(mInboxStyle.addLine(getString(R.string.pop_in_box_msg_count, mInboxStyleCount)));
        } else if (mAnotherMsgBtn.equals(v)) {
            if (mInboxStyle == null) {
                Toast.makeText(this.getApplicationContext(), getText(R.string.click_first_button), Toast.LENGTH_SHORT).show();
                return;
            }
            mInboxStyleCount++;
            builder.setStyle(mInboxStyle.addLine(getString(R.string.pop_in_box_msg_count, mInboxStyleCount)));
        }

        Notification notification = builder.build();

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(0, notification);
    }
}
