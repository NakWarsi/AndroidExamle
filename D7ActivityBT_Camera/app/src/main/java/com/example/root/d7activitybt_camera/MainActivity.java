package com.example.root.d7activitybt_camera;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener{

    Button btEnable,btBTDiscover,btCapImg;
    TextView tvstatus;
    ImageView myimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btEnable=(Button)findViewById(R.id.btnBTEnable);
        btBTDiscover=(Button)findViewById(R.id.btnBTDiscover);
        btCapImg=(Button)findViewById(R.id.btnCapture);
        tvstatus=(TextView)findViewById(R.id.tvStatus);
        myimg=(ImageView)findViewById(R.id.img1);
        btEnable.setOnClickListener(this);
        btBTDiscover.setOnClickListener(this);
        btCapImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id=v.getId();
        if(id==R.id.btnBTEnable)
        {
            Intent intent= new Intent(
                    BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent,11);

        }

        if(id==R.id.btnBTDiscover){

            Intent intent=new Intent(
                    BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);

                    startActivityForResult(intent,12);



        }

        if(id==R.id.btnCapture){

            Intent intent=new Intent(
                    MediaStore.ACTION_IMAGE_CAPTURE
            );

            startActivityForResult(intent,13);


        }

    }//end of onClick

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==11){
            tvstatus.setText("Status : Now BT is ON");
        }

        if(requestCode==12){
            tvstatus.setText("Status:BT is Discovering");
        }

        if(requestCode==13){

            Bitmap img=(Bitmap)data.getExtras().get("data");
            myimg.setImageBitmap(img);
        }
    }
}
