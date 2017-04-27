package com.nulldreams.notificationstyles;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.nulldreams.notify.toast.ToastCenter;

/**
 * Created by boybe on 2017/4/27.
 */

public class DeleteReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ToastCenter.with(context).text(intent.getAction()).showShort();
    }
}
