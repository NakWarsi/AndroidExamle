package com.example.iot.btex1;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.iot.btex1.R;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bluetoothAdapter;
    TextView tvStatus;
    ListView listView;
    ArrayAdapter<String>adapter;
    Set<BluetoothDevice>set;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.myList);
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        tvStatus=(TextView)findViewById(R.id.tvstatus);

        adapter=new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1
        );
        listView.setAdapter(adapter );

        intentFilter=new IntentFilter(BluetoothDevice.ACTION_FOUND);
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();

    }//oncread END
    BroadcastReceiver myBTReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
         String action=intent.getAction();
         if(BluetoothDevice.ACTION_FOUND.equals(action)){
             BluetoothDevice device=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
             String name=device.getName();
             String add=device.getAddress();
             String info="name :"+name+"\naddress :"+add;
             adapter.add(info);
         }
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==11){
            tvStatus.setText("Bluetooth is on");
        }
    }

    public void onBt(View view) {
        if (!bluetoothAdapter.isEnabled()) {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, 11);
        }
        else{
            tvStatus.setText("blooth is allready on");
        }
    }

    public void ofBT(View view) {
        if(bluetoothAdapter.isEnabled()) {
            bluetoothAdapter.disable();
            tvStatus.setText("No bluetooth is off");
        }
        else{
            tvStatus.setText("bluetooth is allready off");
        }
    }

    public void startScan(View view) {
        if(bluetoothAdapter.isDiscovering()){
            bluetoothAdapter.cancelDiscovery();
        }
        else{
            bluetoothAdapter.startDiscovery();
            tvStatus.setText("Status :strarted scanning");
            adapter.clear();
            registerReceiver(myBTReceiver,intentFilter);
        }

    }

    public void stopScan(View view) {
            unregisterReceiver(myBTReceiver);
            tvStatus.setText("Status :stoped scanning");
    }

    public void listBtdev(View view) {
        set=bluetoothAdapter.getBondedDevices();
        adapter.clear();
        for (BluetoothDevice item:set){
            String name=item.getName();
            String add=item.getAddress();

            String info="name :"+name+"\n Address :"+add;
            adapter.add(info);
        }
    }
}
