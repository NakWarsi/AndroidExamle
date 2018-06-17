package com.example.root.brexample1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcast1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(
                context,
                "In mybroadcast rec1 caught event",
                Toast.LENGTH_LONG
        ).show();
    }
}
