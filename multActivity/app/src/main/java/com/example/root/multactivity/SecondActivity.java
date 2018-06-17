package com.example.root.multactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
    Button btnback;
    TextView tvSecAct;
    TextView tvmarks2;
    Button verify2;
    float txtsize=40;
    float total;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_second);
        btnback=(Button)findViewById(R.id.btnback);
        verify2=(Button)findViewById(R.id.btnVerify2);
        tvSecAct=(TextView)findViewById(R.id.tvSecondAct);
        tvmarks2=(TextView)findViewById(R.id.tvDetails2);
        final Intent recIntent=getIntent();
        String i1=recIntent.getStringExtra("KEY_INFO");
        tvmarks2.setText(i1);

        Bundle recBundle=recIntent.getExtras();
        final float c=recBundle.getFloat("KEY_CM");
        final float java=recBundle.getFloat("KEY_JM");
        final float android=recBundle.getFloat("KEY_AM");
        String marks="C: "+c+" Java: "+java+" Android: "+android;
        tvmarks2.setText(marks);

        verify2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total=c+java+android;
                tvSecAct.setText("Total is"+total);
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent=new Intent(
//                        SecondActivity.this,
//                        FirstActivity.class
//                );
 //               startActivity(intent);
  //              SecondActivity.this.finish();

                Intent retIntent= new Intent();
                retIntent.putExtra("KEY_TOTAL",total);

                setResult(RESULT_OK,retIntent);
                SecondActivity.this.finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if (keyCode==KeyEvent.KEYCODE_VOLUME_UP) {
            Toast.makeText(
                    SecondActivity.this,
                    "Vol Up button has been pressed and textview size is increased",
                    Toast.LENGTH_LONG
            ).show();
            txtsize=txtsize+10;
            tvSecAct.setTextSize(txtsize);
            return true;
        }

        if (keyCode==KeyEvent.KEYCODE_BACK){
            Toast.makeText(
                    SecondActivity.this,
                    "Please press back button",
                    Toast.LENGTH_LONG
            ).show();

            return true;
        }
        if(keyCode==KeyEvent.KEYCODE_VOLUME_DOWN){

            Toast.makeText(
                    SecondActivity.this,
                    "You Pressed vol down",
                    Toast.LENGTH_LONG
            ).show();
            txtsize=txtsize-10;
            tvSecAct.setTextSize(txtsize);
            return true;
        }
        if (keyCode==KeyEvent.KEYCODE_POWER){
            Toast.makeText(
                    SecondActivity.this,
                    "You pressed power down",
                    Toast.LENGTH_LONG
            ).show();

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
