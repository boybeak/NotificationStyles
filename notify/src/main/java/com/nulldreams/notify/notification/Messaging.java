package com.nulldreams.notify.notification;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.NotificationCompat;

/**
 * Created by boybe on 2017/4/20.
 */

public class Messaging extends CommonStyle {

    private NotificationCompat.MessagingStyle style = null;

    public Messaging (CharSequence userDisplayName) {
        userDisplayName(userDisplayName);
    }

    public Messaging (@StringRes int userDisplayName) {
        userDisplayName(userDisplayName);
    }

    @Override
    public NotificationCompat.Style getStyle() {
        return style;
    }

    public Messaging userDisplayName(@StringRes int userDisplayName) {
        return userDisplayName(getCenter().getContext().getText(userDisplayName));
    }

    public Messaging userDisplayName(CharSequence userDisplayName) {
        style = new NotificationCompat.MessagingStyle(userDisplayName);
        return this;
    }

    public Messaging addMessage (NotificationCompat.MessagingStyle.Message message) {
        style.addMessage(message);
        return this;
    }

    public Messaging addMessage (CharSequence text, long timestamp, CharSequence sender) {
        style.addMessage(text, timestamp, sender);
        return this;
    }

    public Messaging addMessage (@StringRes int textRes, long timestamp, @StringRes int senderRes) {
        Context context = getCenter().getContext();
        return addMessage(
                context.getText(textRes),
                timestamp,
                context.getText(senderRes)
        );
    }

    public Messaging addCompatExtras (Bundle bundle) {
        style.addCompatExtras(bundle);
        return this;
    }

    public Messaging conversationTitle (CharSequence conversationTitle) {
        style.setConversationTitle(conversationTitle);
        return this;
    }

    public Messaging conversationTitle (@StringRes int conversationTitleRes) {
        return conversationTitle(getCenter().getContext().getText(conversationTitleRes));
    }
}
