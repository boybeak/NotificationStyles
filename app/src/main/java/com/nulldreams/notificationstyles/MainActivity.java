package com.nulldreams.notificationstyles;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.nulldreams.notify.notification.NotificationCenter;
import com.nulldreams.notify.toast.ToastCenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showBigText (View view) {

        NotificationCenter.with(this)
                .smallIcon(R.mipmap.ic_launcher)
                .contentText("Messaging ContentText")
                .contentTitle("Messaging ContentTitle")
                .ticker("Messaging Ticker")
                .when(System.currentTimeMillis(), true)
                .withPendingIntent()
                .flags(PendingIntent.FLAG_CANCEL_CURRENT)
                .requestCode(100)
                .activityContent(new Intent(this, MainActivity.class))
                .withPendingIntent()
                .flags(0)
                .requestCode(200)
                .broadcastDelete(new Intent("com.nulldreams.notificationstyles.DELETE"))
                .asBigTextStyle()
                .bigContentTitle(BigTextData.BIG_TEXT_TITLE)
                .summaryText(BigTextData.BIG_TEXT_SUMMARY)
                .bigText(BigTextData.BIG_TEXT)
                .show(4);
    }

    public void showBigPicture (View view) {

        Bitmap iconBmp = BitmapFactory.decodeResource(getResources(), R.drawable.john);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.john_lennon, options);

        NotificationCenter.with(this)
                .smallIcon(R.mipmap.ic_launcher)
                .contentText("Messaging ContentText")
                .contentTitle("Messaging ContentTitle")
                .ticker("Messaging Ticker")
                .when(System.currentTimeMillis(), true)
                .withPendingIntent()
                .flags(PendingIntent.FLAG_CANCEL_CURRENT)
                .requestCode(100)
                .activityContent(new Intent(this, MainActivity.class))
                .withPendingIntent()
                .flags(0)
                .requestCode(200)
                .broadcastDelete(new Intent("com.nulldreams.notificationstyles.DELETE"))
                .asBigPictureStyle()
                .bigContentTitle("InboxStyle bigContentTitle")
                .summaryText("InboxStyle summaryText")
                .bigLargeIcon(iconBmp)
                .bigPicture(picture)
                .show(4);

    }

    public void showInboxStyle (View view) {
        NotificationCenter.with(this)
                .smallIcon(R.mipmap.ic_launcher)
                .contentText("Messaging ContentText")
                .contentTitle("Messaging ContentTitle")
                .ticker("Messaging Ticker")
                .when(System.currentTimeMillis(), true)
                .withPendingIntent()
                .flags(PendingIntent.FLAG_CANCEL_CURRENT)
                .requestCode(100)
                .activityContent(new Intent(this, MainActivity.class))
                .withPendingIntent()
                .flags(0)
                .requestCode(200)
                .broadcastDelete(new Intent("com.nulldreams.notificationstyles.DELETE"))
                .asInboxStyle()
                .bigContentTitle("InboxStyle bigContentTitle")
                .summaryText("InboxStyle summaryText")
                .addLine("John lennon")
                .addLine("Imagine")
                .addLine("Imagine there's no heaven.")
                .show(3);
    }

    public void showMessagingStyle (View view) {
        NotificationCenter.with(this)
                .smallIcon(R.mipmap.ic_launcher)
                .contentText("Messaging ContentText")
                .contentTitle("Messaging ContentTitle")
                .ticker("Messaging Ticker")
                .when(System.currentTimeMillis(), true)
                .withPendingIntent()
                .flags(PendingIntent.FLAG_CANCEL_CURRENT)
                .requestCode(100)
                .activityContent(new Intent(this, MainActivity.class))
                .withPendingIntent()
                .flags(0)
                .requestCode(200)
                .broadcastDelete(new Intent("com.nulldreams.notificationstyles.DELETE"))
                .asMessagingStyle("John Lennon")
                .addMessage("text 1", System.currentTimeMillis(), "sender 1")
                .addMessage("text 2", System.currentTimeMillis(), "sender 2")
                .conversationTitle("conversionTitle")
                .show(2);
    }

    public void showMediaStyle (View view) {
        /*NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        NotificationCompat.MediaStyle mediaStyle = new NotificationCompat.MediaStyle(builder);

        builder.setStyle(mediaStyle);

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Media ContentTitle");
        builder.setContentText("Media ContentText");
        builder.setTicker("Media Ticker");

        showNotificationCompat(builder);*/

        PendingIntent playPauseIt = getActionIntent(this, KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE);
        PendingIntent previousIt = getActionIntent(this, KeyEvent.KEYCODE_MEDIA_PREVIOUS);
        PendingIntent nextIt = getActionIntent(this, KeyEvent.KEYCODE_MEDIA_NEXT);

        NotificationCenter.with(this)
                .smallIcon(R.mipmap.ic_launcher)
                .contentText("Imagine")
                .contentTitle("John Lennon")
                .ticker("Messaging Ticker")
                .addAction(R.drawable.ic_skip_previous_white_24dp, R.string.previous, previousIt)
                .addAction(R.drawable.ic_play_white_24dp, R.string.play, playPauseIt)
                .addAction(R.drawable.ic_skip_next_white_24dp, R.string.next, nextIt)
                .when(System.currentTimeMillis(), true)
                .withPendingIntent()
                .flags(PendingIntent.FLAG_CANCEL_CURRENT)
                .requestCode(100)
                .activityContent(new Intent(this, MainActivity.class))
                .withPendingIntent()
                .flags(0)
                .requestCode(200)
                .broadcastDelete(new Intent("com.nulldreams.notificationstyles.DELETE"))
                .asMediaStyle()
                .showActionsInCompactView(0, 1, 2)
                .show(8);
    }

    public static PendingIntent getActionIntent (Context context, int mediaKeyEvent) {
        Intent it = new Intent(Intent.ACTION_MEDIA_BUTTON);
        it.setPackage(context.getPackageName());
        it.putExtra(Intent.EXTRA_KEY_EVENT, new KeyEvent(KeyEvent.ACTION_UP, mediaKeyEvent));
        return PendingIntent.getBroadcast(context, mediaKeyEvent, it, 0);
    }

    public void customStyle (View view) {
        NotificationCenter.with(this)
                .smallIcon(R.mipmap.ic_launcher)
                .contentText("customStyle ContentText")
                .contentTitle("customStyle ContentTitle")
                .ticker("customStyle Ticker")
                .when(System.currentTimeMillis(), true)
                .withPendingIntent()
                .flags(PendingIntent.FLAG_CANCEL_CURRENT)
                .requestCode(100)
                .activityContent(new Intent(this, MainActivity.class))
                .withPendingIntent()
                .flags(0)
                .requestCode(200)
                .broadcastDelete(new Intent("com.nulldreams.notificationstyles.DELETE"))
                .asStyle(new AsyncBigPicture())
                .remoteBigPicture("http://files.17173.com/forum/fz_tele-01/images/2013/09/21/184655g3ggu3u7rgxx7g35.jpg")
                .showWhenPictureReady(5);
    }

    private void showNotificationCompat (NotificationCompat.Builder builder) {
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, builder.build());
    }

    public void toast (View view) {
        ToastCenter.with(this).text(R.string.toast, "Alice").showShort();
    }
}
