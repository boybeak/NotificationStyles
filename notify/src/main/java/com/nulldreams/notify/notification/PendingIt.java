package com.nulldreams.notify.notification;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

/**
 * Created by gaoyunfei on 2017/4/26.
 */

public class PendingIt {

    private NotificationCenter mCenter;
    private PendingIntent mPi;

    private int mReqCode, mFlags;
    private Bundle mOptions;

    public PendingIt(NotificationCenter center) {
        mCenter = center;
    }

    public PendingIt requestCode (int requestCode) {
        mReqCode = requestCode;
        return this;
    }

    public PendingIt flags (int flags) {
        mFlags = flags;
        return this;
    }

    public PendingIt options (Bundle options) {
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
}
