package com.nulldreams.notify.notification;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

/**
 * Created by gaoyunfei on 2017/4/26.
 */

public class PiIt {

    private NotificationCenter mCenter;
    private PendingIntent mPi;

    private int mReqCode, mFlags;
    private Bundle mOptions;

    public PiIt (NotificationCenter center) {
        mCenter = center;
    }

    public PiIt requestCode (int requestCode) {
        mReqCode = requestCode;
        return this;
    }

    public PiIt flags (int flags) {
        mFlags = flags;
        return this;
    }

    public PiIt options (Bundle options) {
        mOptions = options;
        return this;
    }

    public NotificationCenter activityContent (Intent it) {
        if (mOptions != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mPi = PendingIntent.getActivity(mCenter.getContext(), mReqCode, it, mFlags, mOptions);
        } else {
            mPi = PendingIntent.getActivity(mCenter.getContext(), mReqCode, it, mFlags);
        }
        mCenter.contentIntent(mPi);
        return mCenter;
    }

    public NotificationCenter serviceContent (Intent it) {
        mPi = PendingIntent.getService(mCenter.getContext(), mReqCode, it, mFlags);
        mCenter.contentIntent(mPi);
        return mCenter;
    }

    public NotificationCenter broadcastContent (Intent it) {
        mPi = PendingIntent.getBroadcast(mCenter.getContext(), mReqCode, it, mFlags);
        mCenter.contentIntent(mPi);
        return mCenter;
    }

    public NotificationCenter activitiesContent (Intent[] its) {
        if (mOptions != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mPi = PendingIntent.getActivities(mCenter.getContext(), mReqCode, its, mFlags, mOptions);
        } else {
            mPi = PendingIntent.getActivities(mCenter.getContext(), mReqCode, its, mFlags);
        }
        mCenter.contentIntent(mPi);
        return mCenter;
    }

    public NotificationCenter activityDelete (Intent it) {
        if (mOptions != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mPi = PendingIntent.getActivity(mCenter.getContext(), mReqCode, it, mFlags, mOptions);
        } else {
            mPi = PendingIntent.getActivity(mCenter.getContext(), mReqCode, it, mFlags);
        }
        mCenter.deleteIntent(mPi);
        return mCenter;
    }

    public NotificationCenter serviceDelete (Intent it) {
        mPi = PendingIntent.getService(mCenter.getContext(), mReqCode, it, mFlags);
        mCenter.deleteIntent(mPi);
        return mCenter;
    }

    public NotificationCenter broadcastDelete (Intent it) {
        mPi = PendingIntent.getBroadcast(mCenter.getContext(), mReqCode, it, mFlags);
        mCenter.deleteIntent(mPi);
        return mCenter;
    }

    public NotificationCenter activitiesDelete (Intent[] its) {
        if (mOptions != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mPi = PendingIntent.getActivities(mCenter.getContext(), mReqCode, its, mFlags, mOptions);
        } else {
            mPi = PendingIntent.getActivities(mCenter.getContext(), mReqCode, its, mFlags);
        }
        mCenter.deleteIntent(mPi);
        return mCenter;
    }

    /*public NotificationCenter activitiesContent () {
        mPi = PendingIntent.getActivities(mCenter.getContext(), mReqCode, )
    }*/

    /*public Messaging asMessagingStyle (CharSequence userDisplayName) {
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
        t.setCenter(mCenter);
        return t;
    }

    public void show (int id) {
        mCenter.show(id);
    }

    public void show (String tag, int id) {
        mCenter.show(tag, id);
    }*/
}
