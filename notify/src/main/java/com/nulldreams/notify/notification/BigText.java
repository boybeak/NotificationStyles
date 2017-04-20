package com.nulldreams.notify.notification;

import android.support.v4.app.NotificationCompat;

/**
 * Created by boybe on 2017/4/20.
 */

public class BigText extends CommonStyle {

    private NotificationCompat.BigTextStyle style = null;

    BigText(NotificationCenter center) {
        super(center);
        style = new NotificationCompat.BigTextStyle(center.getBuilder());
    }

    @Override
    public NotificationCompat.Style getStyle() {
        return style;
    }

    public BigText bigText (CharSequence text) {
        style.bigText(text);
        return this;
    }

    public BigText bigContentTitle (CharSequence title) {
        style.setBigContentTitle(title);
        return this;
    }

    public BigText summaryText (CharSequence summaryText) {
        style.setSummaryText(summaryText);
        return this;
    }
}
