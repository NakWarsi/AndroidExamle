package com.example.root.brexa2;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnBC;
    String action="myaction2";
    IntentFilter intentFilter;
    MyBroadcastDynExa2 reciver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBC=(Button)findViewById(R.id.btnBC);
        intentFilter=new IntentFilter(action);
        reciver=new MyBroadcastDynExa2();

        btnBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent();
                intent.setAction(action);
                sendBroadcast(intent);
            }
        });
    }//onCreate ends

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(reciver,intentFilter);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(reciver);

    }
}
