package com.nulldreams.notify.notification;

import android.content.Context;
import android.support.v7.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.RemoteViews;

/**
 * Created by boybe on 2017/4/20.
 */

public class NotificationCenter {

    private static final String TAG = NotificationCenter.class.getSimpleName();

    public static NotificationCenter with (Context context) {
        return new NotificationCenter(context);
    }

    private Context mContext;

    private NotificationCompat.Builder mBuilder = null;
    NotificationManagerCompat mNotifyManCompat = null;
    protected NotificationCenter (Context context) {
        mContext = context;
        mBuilder = new NotificationCompat.Builder(mContext);
        mNotifyManCompat = NotificationManagerCompat.from(mContext);
    }

    public NotificationCompat.Builder getBuilder () {
        return mBuilder;
    }

    public NotificationCenter ticker (CharSequence ticker, RemoteViews views) {
        mBuilder.setTicker(ticker, views);
        return this;
    }
    public NotificationCenter ticker (CharSequence ticker) {
        return ticker(ticker, null);
    }

    public NotificationCenter contentText (CharSequence text) {
        mBuilder.setContentText(text);
        return this;
    }

    public NotificationCenter contentTitle (CharSequence title) {
        mBuilder.setContentTitle(title);
        return this;
    }

    public NotificationCenter when (long when) {
        return when(when, false);
    }

    public NotificationCenter when (long when, boolean showWhen) {
        mBuilder.setWhen(when);
        mBuilder.setShowWhen(showWhen);
        return this;
    }

    public NotificationCenter smallIcon (int smallIcon) {
        mBuilder.setSmallIcon(smallIcon);
        return this;
    }

    public NotificationCenter smallIcon (int smallIcon, int level) {
        mBuilder.setSmallIcon(smallIcon, level);
        return this;
    }

    public Messaging asMessagingStyle (CharSequence userDisplayName) {
        return new Messaging(this, userDisplayName);
    }

    public Inbox asInboxStyle () {
        return new Inbox(this);
    }

    public BigPicture asBigPictureStyle () {
        return new BigPicture(this);
    }

    public BigText asBigTextStyle () {
        return new BigText(this);
    }

    public void show (int id) {
        mNotifyManCompat.notify(id, mBuilder.build());
    }

    public void show (String tag, int id) {
        mNotifyManCompat.notify(tag, id, mBuilder.build());
    }

    public void cancel (int id) {
        mNotifyManCompat.cancel(id);
    }

    public void cancel (String tag, int id) {
        mNotifyManCompat.cancel(tag, id);
    }

    public void cancelAll () {
        mNotifyManCompat.cancelAll();
    }

}
