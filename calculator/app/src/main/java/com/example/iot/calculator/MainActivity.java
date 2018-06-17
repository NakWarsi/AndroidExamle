package com.example.iot.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iot.calculator.R;

import javax.xml.transform.Result;


public class MainActivity extends AppCompatActivity {

    Button btShow;
    Button btHide;
    Button btList;
    TextView TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btShow = (Button) findViewById(R.id.btShow);
        btHide = (Button) findViewById(R.id.btHide);



        String l=recIntent.getStringExtra("KEY_INFO");
        TextView.setText(l);

        btShow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this,
                        Result.class
                );
                Bundle mybundle = new Bundle();
                intent.putExtras(mybundle);
                intent.putExtra("Key_info",toString());
                startActivityForResult(intent, 101);
            }

        });


        btHide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this,
                        Result.class
                );
                Bundle mybundle = new Bundle();
                intent.putExtras(mybundle);
                intent.putExtra("Key_info",toString());
                startActivityForResult(intent, 102);
            }

        });

        btList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this,
                        Result.class
                );
                Bundle mybundle = new Bundle();
                intent.putExtras(mybundle);
                intent.putExtra("Key_info", toString();
                startActivityForResult(intent, 103);
            }

        });

    }
}
