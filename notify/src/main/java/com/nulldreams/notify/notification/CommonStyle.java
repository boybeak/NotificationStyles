package com.nulldreams.notify.notification;

import android.support.v4.app.NotificationCompat;

/**
 * Created by boybe on 2017/4/20.
 */

public abstract class CommonStyle {

    private NotificationCenter mCenter;

    public void setCenter (NotificationCenter center) {
        mCenter = center;
    }

    public NotificationCenter getCenter () {
        return mCenter;
    }

    public abstract NotificationCompat.Style getStyle ();

    public final void show (int id) {
        mCenter.getBuilder().setStyle(getStyle());
        mCenter.show(id);
    }

    public final void show (String tag, int id) {
        mCenter.getBuilder().setStyle(getStyle());
        mCenter.show(tag, id);
    }
}
