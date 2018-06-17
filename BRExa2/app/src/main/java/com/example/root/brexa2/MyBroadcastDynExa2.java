package com.example.root.brexa2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastDynExa2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(
                context,
                "BroadcastExample 2 Dynamic Receive",
                Toast.LENGTH_LONG
        ).show();
    }
}
