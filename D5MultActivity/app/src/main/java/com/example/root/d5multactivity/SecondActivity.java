package com.example.root.d5multactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

public class SecondActivity extends Activity {
    TextView tvDetial2A;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);

        tvDetial2A=(TextView)findViewById(R.id.tvdetail2act);

        Intent recIntent=getIntent();
        String i1=recIntent.getStringExtra("KEY_INFO");
        tvDetial2A.setText(i1);
    }
}
