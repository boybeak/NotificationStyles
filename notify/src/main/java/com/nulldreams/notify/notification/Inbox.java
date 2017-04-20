package com.nulldreams.notify.notification;

import android.support.v4.app.NotificationCompat;

/**
 * Created by boybe on 2017/4/20.
 */

public class Inbox extends CommonStyle {

    private NotificationCompat.InboxStyle style;

    public Inbox(NotificationCenter center) {
        super(center);
        style = new NotificationCompat.InboxStyle(center.getBuilder());
    }

    @Override
    public NotificationCompat.Style getStyle() {
        return style;
    }

    public Inbox bigContentTitle (CharSequence title) {
        style.setBigContentTitle(title);
        return this;
    }

    public Inbox summaryText (CharSequence summaryText) {
        style.setSummaryText(summaryText);
        return this;
    }

    public Inbox addLine (CharSequence line) {
        style.addLine(line);
        return this;
    }

}
