package com.nulldreams.notify.notification;

import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.media.session.MediaSessionCompat;

/**
 * Created by boybe on 2017/4/21.
 */

public class Media extends CommonStyle {

    private android.support.v7.app.NotificationCompat.MediaStyle style = null;

    public Media () {
        style = new android.support.v7.app.NotificationCompat.MediaStyle();
    }

    public Media cancelButtonIntent (PendingIntent pi) {
        style.setCancelButtonIntent(pi);
        return this;
    }

    public Media showCancelButton (boolean show) {
        style.setShowCancelButton(show);
        return this;
    }

    public Media mediaSession (MediaSessionCompat.Token token) {
        style.setMediaSession(token);
        return this;
    }

    public Media showActionsInCompactView (int ... actions) {
        style.setShowActionsInCompactView(actions);
        return this;
    }

    @Override
    public NotificationCompat.Style getStyle() {
        return style;
    }
}
