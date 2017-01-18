package com.nulldreams.notificationstyles;

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

    private void showNotificationCompat (NotificationCompat.Builder builder) {
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(1, builder.build());
    }
}
