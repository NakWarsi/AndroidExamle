package com.example.iot.serviceex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btStart,btStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btStart=(Button)findViewById(R.id.btnStartService);
        btStop=(Button)findViewById(R.id.btnStopService);

        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(
                        MainActivity.this,
                        MyNewService.class
                );
                startService(intent);

            }
        });

        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(
                        MainActivity.this,
                        MyNewService.class
                );
                stopService(intent);
            }
        });
    }
}
