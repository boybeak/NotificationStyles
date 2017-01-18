package com.nulldreams.notificationstyles;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showBigText (View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        android.support.v4.app.NotificationCompat.BigTextStyle bigTextStyle = new android.support.v4.app.NotificationCompat.BigTextStyle(builder);

        bigTextStyle.bigText(BigTextData.BIG_TEXT);
        bigTextStyle.setBigContentTitle(BigTextData.BIG_TEXT_TITLE);
        bigTextStyle.setSummaryText(BigTextData.BIG_TEXT_SUMMARY);
        builder.setStyle(bigTextStyle);

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("BigText ContentTitle");
        builder.setContentText("BigText ContentText");
        builder.setTicker("BigText Ticker");

        showNotificationCompat(builder);
    }

    public void showBigPicture (View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        android.support.v4.app.NotificationCompat.BigPictureStyle bigPictureStyle = new android.support.v4.app.NotificationCompat.BigPictureStyle(builder);

        Bitmap iconBmp = BitmapFactory.decodeResource(getResources(), R.drawable.john);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.john_lennon, options);

        bigPictureStyle.setSummaryText(BigTextData.BIG_TEXT_SUMMARY);
        bigPictureStyle.bigLargeIcon(iconBmp);
        bigPictureStyle.bigPicture(picture);
        bigPictureStyle.setBigContentTitle("John Lennon");
        builder.setStyle(bigPictureStyle);

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("BigPicture ContentTitle");
        builder.setContentText("BigPicture ContentText");
        builder.setTicker("BigPicture Ticker");

        showNotificationCompat(builder);
    }

    public void showInboxStyle (View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        android.support.v4.app.NotificationCompat.InboxStyle inboxStyle = new android.support.v4.app.NotificationCompat.InboxStyle(builder);

        inboxStyle.setBigContentTitle("InboxStyle bigContentTitle");
        inboxStyle.setSummaryText("InboxStyle summaryText");
        inboxStyle.addLine("John lennon");
        inboxStyle.addLine("Imagine");
        inboxStyle.addLine("Imagine there's no heaven.");
        builder.setStyle(inboxStyle);

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Inbox ContentTitle");
        builder.setContentText("Inbox ContentText");
        builder.setTicker("Inbox Ticker");

        showNotificationCompat(builder);
    }

    public void showMessagingStyle (View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        android.support.v4.app.NotificationCompat.MessagingStyle messagingStyle = new android.support.v4.app.NotificationCompat.MessagingStyle("John Lennon");

        messagingStyle.addMessage("text 1", System.currentTimeMillis(), "sender 1");
        messagingStyle.addMessage("text 2", System.currentTimeMillis(), "sender 2");
        messagingStyle.setConversationTitle("conversionTitle");
        builder.setStyle(messagingStyle);

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Messaging ContentTitle");
        builder.setContentText("Messaging ContentText");
        builder.setTicker("Messaging Ticker");

        showNotificationCompat(builder);
    }

    public void showMediaStyle (View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        NotificationCompat.MediaStyle mediaStyle = new NotificationCompat.MediaStyle(builder);

        //mediaStyle.
        builder.setStyle(mediaStyle);

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Media ContentTitle");
        builder.setContentText("Media ContentText");
        builder.setTicker("Media Ticker");

        showNotificationCompat(builder);
    }

    private void showNotificationCompat (NotificationCompat.Builder builder) {
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, builder.build());
    }
}
