package com.nulldreams.notify.notification;

import android.support.annotation.StringRes;
import android.support.v4.app.NotificationCompat;

/**
 * Created by boybe on 2017/4/20.
 */

public class Inbox extends CommonStyle {

    private NotificationCompat.InboxStyle style;

    public Inbox() {
        style = new NotificationCompat.InboxStyle();
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

    public Inbox bigContentTitle (@StringRes int title) {
        return bigContentTitle(getCenter().getContext().getText(title));
    }

    public Inbox summaryText (@StringRes int summaryText) {
        return summaryText(getCenter().getContext().getText(summaryText));
    }

    public Inbox addLine (@StringRes int line) {
        return addLine(getCenter().getContext().getText(line));
    }

}
