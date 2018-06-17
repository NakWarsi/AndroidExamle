package com.example.iot.hello1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etInput;
    Button btSubmit;
    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInput=(EditText)findViewById(R.id.etInput);
        btSubmit=(Button)findViewById(R.id.btSubmit);
        tvDisplay=(TextView)findViewById(R.id.tvDisplay);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input=etInput.getText().toString();
                tvDisplay.setText("DisplayText"+input);
            }
        });


    }
}
