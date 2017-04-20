package com.nulldreams.notificationstyles;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
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
                .asMessagingStyle("John Lennon")
                .addMessage("text 1", System.currentTimeMillis(), "sender 1")
                .addMessage("text 2", System.currentTimeMillis(), "sender 2")
                .conversationTitle("conversionTitle")
                .show(2);
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

    public void customStyle (View view) {
        NotificationCenter.with(this)
                .smallIcon(R.mipmap.ic_launcher)
                .contentText("customStyle ContentText")
                .contentTitle("customStyle ContentTitle")
                .ticker("customStyle Ticker")
                .when(System.currentTimeMillis(), true)
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
