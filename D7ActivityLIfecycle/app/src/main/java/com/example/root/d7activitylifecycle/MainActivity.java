package com.example.root.d7activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("ALC","in onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ALC","in onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ALC","in onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ALC","in onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ALC","in onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ALC","in onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ALC","in onDestroy()");
    }


}
