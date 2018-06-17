package com.example.root.multactivity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    Button btnGo2nd;
    Button btnexit;
    Button btnsubmit;
    TextView disptotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_first);
        btnGo2nd=(Button)findViewById(R.id.btnActivity2);
        disptotal=(TextView)findViewById(R.id.tv_FinalTotal);
        btnexit=(Button)findViewById(R.id.btnexit);
    btnGo2nd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent= new Intent(
                    FirstActivity.this,
                    SecondActivity.class
            );
            //startActivity(intent);
            startActivityForResult(intent,101);

        }
    });


    btnexit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //FirstActivity.this.finish();
            final Dialog dialog=new Dialog(FirstActivity.this);
            dialog.setContentView(R.layout.layout_dialog_exit);
            Button btyes=(Button) dialog.findViewById(R.id.btn_dialog_yes);
            Button btno=(Button)dialog.findViewById(R.id.btn_dialog_No);

            btyes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FirstActivity.this.finish();
                }
            });

            btno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialog.show();
        }
    });
//day 6
        final EditText age1=(EditText)findViewById(R.id.etage);
        final EditText details1=(EditText)findViewById(R.id.etDetails);
        final EditText cmarks=(EditText)findViewById(R.id.etC_marks);
        final EditText jmarks=(EditText)findViewById(R.id.etJ_marks);
        final EditText Amarks=(EditText)findViewById(R.id.etA_marks);


        btnsubmit=(Button)findViewById(R.id.btn_submit1st);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(
                        FirstActivity.this,
                        SecondActivity.class
                );
                String info="Age :"+age1+"C marks :"+cmarks+"Java marks :"+jmarks+"Amarks"+Amarks;
                Bundle mybundle= new Bundle();
                mybundle.putFloat("KEY_CM",Float.parseFloat(cmarks.getText().toString()));
                mybundle.putFloat("KEY_JM",Float.parseFloat(jmarks.getText().toString()));
                mybundle.putFloat("KEY_AM",Float.parseFloat(Amarks.getText().toString()));
                intent.putExtras(mybundle);
                intent.putExtra("Key_info",info);
//                startActivity(intent);
                startActivityForResult(intent,101);
            }
        });



    }//OnCreate Ends

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==101){

            float t=data.getFloatExtra("KEY_TOTAL",0);
            disptotal.setText("Total :"+t);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Toast.makeText(
                    FirstActivity.this,
                    "Back Button Disabled",
                    Toast.LENGTH_LONG
            ).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
