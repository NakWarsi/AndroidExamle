package com.example.iot.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.iot.calculator.R;


public class Result extends Activity {

    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        final Intent recIntent=getIntent();
        back = (Button) findViewById(R.id.back);
        String i1=recIntent.getStringExtra("KEY_INFO");
        toString().toUpperCase();
        toString().length();

        back.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent(
                    Result.this,
                    com.example.iot.activity.MainActivity.class
            );
            Bundle mybundle = new Bundle();

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        Result.this,
                        com.example.iot.activity.MainActivity.class
                );
                toString().length();
                intent.putExtras(mybundle);
            }

        });
    }
}
