package com.naomi.notification;

import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class DirectReplyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);

        if (remoteInput != null) {
            CharSequence replyText = remoteInput.getCharSequence("key_text_reply");
            Message answer = new Message(replyText, null);
            MainActivity.MESSAGES.add(answer);

            MainActivity.sendChannel1Notification(context);
        }
    }
}
