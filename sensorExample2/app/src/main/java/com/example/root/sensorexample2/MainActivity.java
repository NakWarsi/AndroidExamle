package com.example.root.sensorexample2;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    TextView tvX;
    TextView tvY;
    TextView tvZ;
    SensorManager sm;
    Sensor accM;
    LinearLayout ll1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvX=(TextView)findViewById(R.id.tvX);
        tvY=(TextView)findViewById(R.id.tvY);
        tvZ=(TextView)findViewById(R.id.tvZ);

        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        accM=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        ll1=(LinearLayout)findViewById(R.id.myLayout);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(
                MainActivity.this,
                accM,
                SensorManager.SENSOR_DELAY_NORMAL
                );

    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener(MainActivity.this);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {


        float x=event.values[0];
        float y=event.values[1];
        float z=event.values[2];
        double result;
        double angle_x;
        double angle_y;
        float x2,y2,z2;

        x2 = (long)(x*x);
        y2 = (long)(y*y);
        z2 = (long)(z*z);

        //X Axis
        result=Math.sqrt(y2+z2);
        result=x/result;
        angle_x = Math.atan(result);

        //Y Axis
        result=Math.sqrt(x2+z2);
        result=y/result;
        angle_y= Math.atan(result);

        if(x<5 && x>0){
            ll1.setBackgroundColor(Color.GREEN);
        }
        else{
            ll1.setBackgroundColor(Color.RED);
        }
        tvX.setText("X: "+angle_x);
        tvY.setText("Y: "+angle_y);
        tvZ.setText("Z: "+z);


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
