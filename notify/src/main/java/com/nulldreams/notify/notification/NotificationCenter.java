package com.nulldreams.notify.notification;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.RemoteViews;

import java.io.File;

/**
 * Created by boybe on 2017/4/20.
 */

public class NotificationCenter {

    private static final String TAG = NotificationCenter.class.getSimpleName();

    public static NotificationCenter with (Context context) {
        return new NotificationCenter(context.getApplicationContext());
    }

    private Context mContext;

    private NotificationCompat.Builder mBuilder = null;
    private NotificationManagerCompat mNotifyManCompat = null;

    protected NotificationCenter (Context context) {
        mContext = context;
        mBuilder = new NotificationCompat.Builder(mContext);
        mNotifyManCompat = NotificationManagerCompat.from(mContext);
    }

    public Context getContext () {
        return mContext;
    }

    public NotificationCompat.Builder getBuilder () {
        return mBuilder;
    }

    public NotificationCenter ticker (@StringRes int ticker, RemoteViews views) {
        return ticker(mContext.getText(ticker), views);
    }

    public NotificationCenter ticker (CharSequence ticker, RemoteViews views) {
        mBuilder.setTicker(ticker, views);
        return this;
    }

    public NotificationCenter ticker (@StringRes int ticker) {
        return ticker(mContext.getText(ticker));
    }

    public NotificationCenter ticker (CharSequence ticker) {
        return ticker(ticker, null);
    }

    public NotificationCenter contentText (@StringRes int text) {
        return contentText(mContext.getText(text));
    }

    public NotificationCenter contentText (CharSequence text) {
        mBuilder.setContentText(text);
        return this;
    }

    public NotificationCenter contentTitle (@StringRes int title) {
        return contentTitle(title);
    }

    public NotificationCenter contentTitle (CharSequence title) {
        mBuilder.setContentTitle(title);
        return this;
    }

    public NotificationCenter contentInfo (@StringRes int info) {
        return contentInfo(mContext.getText(info));
    }

    public NotificationCenter contentInfo (CharSequence info) {
        mBuilder.setContentInfo(info);
        return this;
    }

    public NotificationCenter contentIntent (PendingIntent pendingIntent) {
        mBuilder.setContentIntent(pendingIntent);
        return this;
    }

    public PiIt withPendingIntent () {
        return new PiIt(this);
    }

    public NotificationCenter deleteIntent (PendingIntent deleteIntent) {
        mBuilder.setDeleteIntent(deleteIntent);
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

    public NotificationCenter visibility (@NotificationCompat.NotificationVisibility int visibility) {
        mBuilder.setVisibility(visibility);
        return this;
    }

    /**
     * Accent color (an ARGB integer like the constants in Color) to be applied by the standard Style templates when presenting this notification.
     * The current template design constructs a colorful header image by overlaying the icon image (stenciled in white) atop a field of this color.
     * Alpha components are ignored.
     * @param argb
     * @return
     */
    public NotificationCenter color (int argb) {
        mBuilder.setColor(argb);
        return this;
    }

    public NotificationCenter lights (int argb, int onMs, int offMs) {
        mBuilder.setLights(argb, onMs, offMs);
        return this;
    }

    public NotificationCenter vibrate (long[] pattern) {
        mBuilder.setVibrate(pattern);
        return this;
    }

    public NotificationCenter sound (File file) {
        mBuilder.setSound(Uri.fromFile(file));
        return this;
    }

    public NotificationCenter sound (File file, int streamType) {
        mBuilder.setSound(Uri.fromFile(file), streamType);
        return this;
    }

    public NotificationCenter sound (Uri uri) {
        mBuilder.setSound(uri);
        return this;
    }

    public NotificationCenter sound (Uri uri, int streamType) {
        mBuilder.setSound(uri, streamType);
        return this;
    }

    public NotificationCenter autoCancel (boolean autoCancel) {
        mBuilder.setAutoCancel(autoCancel);
        return this;
    }

    public NotificationCenter ongoing (boolean ongoing) {
        mBuilder.setOngoing(ongoing);
        return this;
    }

    public NotificationCenter onlyAlarmOnce (boolean once) {
        mBuilder.setOnlyAlertOnce(once);
        return this;
    }

    /**
     * Set whether or not this notification is only relevant to the current device.
     * Some notifications can be bridged to other devices for remote display.
     * This hint can be set to recommend this notification not be bridged.
     * @param localOnly
     * @return
     */
    public NotificationCenter localOnly (boolean localOnly) {
        mBuilder.setLocalOnly(localOnly);
        return this;
    }

    public NotificationCenter customContentView (RemoteViews contentViews) {
        mBuilder.setCustomContentView(contentViews);
        return this;
    }

    public NotificationCenter customBigView (RemoteViews bigContentViews) {
        mBuilder.setCustomBigContentView(bigContentViews);
        return this;
    }

    public NotificationCenter addAction (android.support.v4.app.NotificationCompat.Action action) {
        mBuilder.addAction(action);
        return this;
    }

    public NotificationCenter addAction (@DrawableRes int icon, CharSequence title, PendingIntent pi) {
        mBuilder.addAction(icon, title, pi);
        return this;
    }

    public NotificationCenter addAction (@DrawableRes int icon, @StringRes int titleRes, PendingIntent pi) {
        mBuilder.addAction(icon, mContext.getText(titleRes), pi);
        return this;
    }

    /**
     * Supply custom RemoteViews to use instead of the platform template in the heads up dialog.
     * This will override the heads-up layout that would otherwise be constructed by this Builder object.
     * No-op on versions prior to LOLLIPOP.
     * @return
     */
    public NotificationCenter customHeadsUpContentView (RemoteViews headsUpContentView) {
        mBuilder.setCustomHeadsUpContentView(headsUpContentView);
        return this;
    }

    public Messaging asMessagingStyle (CharSequence userDisplayName) {
        return asStyle(new Messaging(userDisplayName));
    }

    public Messaging asMessagingStyle (@StringRes int userDisplayName) {
        return asStyle(new Messaging(userDisplayName));
    }

    public Inbox asInboxStyle () {
        return asStyle(new Inbox());
    }

    public BigPicture asBigPictureStyle () {
        return asStyle(new BigPicture());
    }

    public BigText asBigTextStyle () {
        return asStyle(new BigText());
    }

    public Media asMediaStyle () {
        return asStyle(new Media());
    }

    public <T extends CommonStyle> T asStyle (T t) {
        t.setCenter(this);
        return t;
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
