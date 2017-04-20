package com.nulldreams.notify.notification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.app.NotificationCompat;

import java.io.File;

/**
 * Created by boybe on 2017/4/20.
 */

public class BigPicture extends CommonStyle {

    private NotificationCompat.BigPictureStyle style;

    public BigPicture() {
        style = new NotificationCompat.BigPictureStyle();
    }

    public BigPicture summaryText (CharSequence summaryText) {
        style.setSummaryText(summaryText);
        return this;
    }

    public BigPicture bigContentTitle (CharSequence title) {
        style.setBigContentTitle(title);
        return this;
    }

    public BigPicture bigContentTitle (@StringRes int title) {
        return bigContentTitle(getCenter().getContext().getText(title));
    }

    public BigPicture summaryText (@StringRes int summaryText) {
        return summaryText(getCenter().getContext().getText(summaryText));
    }

    public BigPicture bigLargeIcon (File iconFile) {
        return bigLargeIcon(iconFile.getAbsoluteFile());
    }

    public BigPicture bigLargeIcon (String iconFile) {
        return bigLargeIcon(BitmapFactory.decodeFile(iconFile));
    }

    public BigPicture bigLargeIcon (@DrawableRes int iconRes) {
        return bigLargeIcon(BitmapFactory.decodeResource(
                getCenter().getContext().getResources(), iconRes
        ));
    }

    public BigPicture bigLargeIcon (Bitmap icon) {
        style.bigLargeIcon(icon);
        return this;
    }

    public BigPicture bigPicture (File pictureFile) {
        return bigPicture(pictureFile.getAbsoluteFile());
    }

    public BigPicture bigPicture (String pictureFile) {
        return bigPicture(BitmapFactory.decodeFile(pictureFile));
    }

    public BigPicture bigPicture (@DrawableRes int pictureRes) {
        return bigPicture(BitmapFactory.decodeResource(
                getCenter().getContext().getResources(), pictureRes
        ));
    }

    public BigPicture bigPicture (Bitmap picture) {
        style.bigPicture(picture);
        return this;
    }

    @Override
    public NotificationCompat.Style getStyle() {
        return style;
    }
}
