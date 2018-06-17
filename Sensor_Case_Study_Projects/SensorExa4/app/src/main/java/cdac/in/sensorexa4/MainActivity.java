package cdac.in.sensorexa4;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity  {
    SensorManager sensorManager;
    Sensor sensorProximity;
    PowerManager mPowerManager;
    PowerManager.WakeLock mWakeLock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);

        mPowerManager=(PowerManager) getSystemService(POWER_SERVICE);

        sensorProximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(sensorProximity==null){
            Log.e("SensorExa4","Proximity Sensor not avialable");
            finish();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    //    sensorManager.registerListener(this,sensorProximity,SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(listenerProximity,sensorProximity,2*1000*1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(listenerProximity);
    }

    SensorEventListener listenerProximity = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.values[0] < sensorProximity.getMaximumRange()) {
                // Detected something nearby
                getWindow().getDecorView().setBackgroundColor(Color.RED);
                turnOffScreen();
            } else {
                // Nothing is nearby
                getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                turnOnScreen();
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    public void turnOnScreen(){
        // turn on screen
        Log.v("ProximityActivity", "ON!");
        mWakeLock = mPowerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK |
                PowerManager.ACQUIRE_CAUSES_WAKEUP, "tag");
        mWakeLock.acquire();
    }

    @TargetApi(21) //Suppress lint error for PROXIMITY_SCREEN_OFF_WAKE_LOCK
    public void turnOffScreen(){
        // turn off screen
        Log.v("ProximityActivity", "OFF!");
        mWakeLock = mPowerManager.newWakeLock(PowerManager.PROXIMITY_SCREEN_OFF_WAKE_LOCK, "tag");
        mWakeLock.acquire();
    }



}
