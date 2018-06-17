package com.example.root.sensorexample1;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvSCount;
    ListView listView;
    SensorManager sm;
    List<Sensor> sensorList;

    ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSCount=(TextView)findViewById(R.id.tvSensorCount);
        listView=(ListView)findViewById(R.id.mylist);
        sm= (SensorManager) getSystemService(SENSOR_SERVICE);
        adapter=new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1
        );

        listView.setAdapter(adapter);

        sensorList=sm.getSensorList(Sensor.TYPE_ALL);

        for(Sensor item:sensorList){
            String name=item.getName();
            String vendor=item.getVendor();
            int version=item.getVersion();
            String info="Name: "+name+"\nVendor: "+vendor+"Version: "+version;
            adapter.add(info);
        }

        int count=adapter.getCount();
        tvSCount.setText("Sensor Count: "+count);
    }
}
