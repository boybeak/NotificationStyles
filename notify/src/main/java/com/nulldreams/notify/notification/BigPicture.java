package com.nulldreams.notify.notification;

import android.graphics.Bitmap;
import android.support.v4.app.NotificationCompat;

/**
 * Created by boybe on 2017/4/20.
 */

public class BigPicture extends CommonStyle {

    private NotificationCompat.BigPictureStyle style;

    BigPicture(NotificationCenter center) {
        super(center);
        style = new NotificationCompat.BigPictureStyle(center.getBuilder());
    }

    public BigPicture summaryText (CharSequence summaryText) {
        style.setSummaryText(summaryText);
        return this;
    }

    public BigPicture bigContentTitle (CharSequence title) {
        style.setBigContentTitle(title);
        return this;
    }

    public BigPicture bigLargeIcon (Bitmap icon) {
        style.bigLargeIcon(icon);
        return this;
    }

    public BigPicture bigPicture (Bitmap picture) {
        style.bigPicture(picture);
        return this;
    }

    @Override
    public NotificationCompat.Style getStyle() {
        return style;
    }
}
