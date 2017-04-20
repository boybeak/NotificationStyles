package com.nulldreams.notify.notification;

import android.support.annotation.StringRes;
import android.support.v4.app.NotificationCompat;

/**
 * Created by boybe on 2017/4/20.
 */

public class BigText extends CommonStyle {

    private NotificationCompat.BigTextStyle style = null;

    public BigText() {
        style = new NotificationCompat.BigTextStyle();
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

    public BigText bigText (@StringRes int text) {
        return bigText(getCenter().getContext().getText(text));
    }

    public BigText bigContentTitle (@StringRes int title) {
        return bigContentTitle(getCenter().getContext().getText(title));
    }

    public BigText summaryText (@StringRes int summaryText) {
        return summaryText(getCenter().getContext().getText(summaryText));
    }
}
