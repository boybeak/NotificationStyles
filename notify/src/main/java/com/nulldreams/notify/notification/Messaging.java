package com.nulldreams.notify.notification;

import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

/**
 * Created by boybe on 2017/4/20.
 */

public class Messaging extends CommonStyle {

    private NotificationCompat.MessagingStyle style = null;

    private Messaging(NotificationCenter center) {
        super(center);
    }

    Messaging (NotificationCenter center, CharSequence userDisplayName) {
        this (center);
        userDisplayName(userDisplayName);
    }

    @Override
    public NotificationCompat.Style getStyle() {
        return style;
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

    public Messaging addCompatExtras (Bundle bundle) {
        style.addCompatExtras(bundle);
        return this;
    }

    public Messaging conversationTitle (CharSequence conversationTitle) {
        style.setConversationTitle(conversationTitle);
        return this;
    }
}
