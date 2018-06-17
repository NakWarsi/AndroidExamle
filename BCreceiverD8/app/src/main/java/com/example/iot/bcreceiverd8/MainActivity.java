package com.example.iot.bcreceiverd8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btsendbc;
    String action="myaction3";
    IntentFilter intentfilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btsendbc=(Button)findViewById(R.id.button);
        intentfilter=new IntentFilter(action);

        btsendbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(action);
                sendBroadcast(intent);
            }
        });

    }// on create

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReciever,intentfilter);

    }

    BroadcastReceiver myReciever=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(
                    context,
                    "broadcast reciever is open",
                    Toast.LENGTH_LONG
            ).show();
        }
    };
}
