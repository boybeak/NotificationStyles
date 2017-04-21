package com.nulldreams.notify.toast;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by boybe on 2017/4/20.
 */

public class ToastCenter {

    public static ToastCenter with (Context context) {
        return new ToastCenter(context.getApplicationContext());
    }

    private Context mContext;

    private CharSequence mText;

    private int mGravity = Gravity.BOTTOM, xOffset, yOffset, horizontalMargin, verticalMargin;

    private View mView;

    private ToastCenter (Context context) {
        mContext = context;
        yOffset = (int)(64 * context.getResources().getDisplayMetrics().density);
    }

    public ToastCenter text (@StringRes int textRes, Object ... args) {
        mText = mContext.getString(textRes, args);
        return this;
    }

    public ToastCenter text (@StringRes int textRes) {
        mText = mContext.getText(textRes);
        return this;
    }

    public ToastCenter text (CharSequence text) {
        this.mText = text;
        return this;
    }

    public ToastCenter gravity (int gravity, int xOffset, int yOffset) {
        this.mGravity = gravity;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        return this;
    }

    public ToastCenter view (View view) {
        mView = view;
        return this;
    }

    public ToastCenter margin (int horizontalMargin, int verticalMargin) {
        this.horizontalMargin = horizontalMargin;
        this.verticalMargin = verticalMargin;
        return this;
    }

    private Toast show (int duration) {
        Toast toast = Toast.makeText(mContext, mText, duration);
        toast.setGravity(mGravity, xOffset, yOffset);
        toast.setMargin(horizontalMargin, verticalMargin);
        if (mView != null) {
            toast.setView(mView);
        }
        toast.show();
        return toast;
    }

    public Toast showLong () {
        return show(Toast.LENGTH_LONG);
    }

    public Toast showShort () {
        return show(Toast.LENGTH_SHORT);
    }
}
