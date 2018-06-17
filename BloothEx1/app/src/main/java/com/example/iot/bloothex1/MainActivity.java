package com.example.iot.bloothex1;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
    }

    public void onBt(View view) {
        Intent intent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(intent,11);
    }

    public void ofBT(View view) {
    }

    public void startScan(View view) {
    }

    public void stopScan(View view) {
    }

    public void listBtdev(View view) {
    }
}
