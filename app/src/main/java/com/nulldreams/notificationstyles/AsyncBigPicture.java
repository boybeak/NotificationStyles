package com.nulldreams.notificationstyles;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.StringRes;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.nulldreams.notify.notification.BigPicture;

/**
 * Created by gaoyunfei on 2017/4/20.
 */

public class AsyncBigPicture extends BigPicture {

    private static final String TAG = AsyncBigPicture.class.getSimpleName();

    private String url;

    public AsyncBigPicture remoteBigPicture (String url) {
        this.url = url;
        return this;
    }

    @Override
    public AsyncBigPicture summaryText(CharSequence summaryText) {
        super.summaryText(summaryText);
        return this;
    }

    @Override
    public BigPicture summaryText(@StringRes int summaryText) {
        super.summaryText(summaryText);
        return this;
    }

    public void showWhenPictureReady (final int id) {
        Glide.with(getCenter().getContext()).load(url)
                .asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                Log.v(TAG, "showWhenPictureReady onResourceReady");
                bigPicture(resource).show(id);
            }

            @Override
            public void onLoadFailed(Exception e, Drawable errorDrawable) {
                super.onLoadFailed(e, errorDrawable);
                Log.v(TAG, "showWhenPictureReady onLoadFailed " + e.getMessage());
            }
        });
    }

    public void showWhenPictureReady (final String tag, final int id) {
        Glide.with(getCenter().getContext()).load(url)
                .asBitmap().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                bigPicture(resource).show(tag, id);
            }
        });
    }
}
