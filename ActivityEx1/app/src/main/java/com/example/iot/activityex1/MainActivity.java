package com.example.iot.activityex1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showBrowser(View view) {
        Uri uri = Uri.parse("http://nakwarsin.wordpress.com");
        Intent intent = new Intent(
                Intent.ACTION_VIEW,
                uri
        );
        startActivity(intent);
    }

    public void showMap(View view) {
        Uri uri = Uri.parse("geo:10,20");
        Intent intent = new Intent(
                Intent.ACTION_VIEW,
                uri
        );
        startActivity(intent);
    }

    public void dailNum(View view) {

        Uri uri = Uri.parse("tel:8840001392");
        Intent intent = new Intent(
                Intent.ACTION_DIAL,
                uri
        );
        startActivity(intent);
    }

    public void callNum(View view) {

        ActivityCompat.requestPermissions(
                MainActivity.this,
                new String[]{
                        Manifest.permission.CALL_PHONE
                },
                104
        );
        Uri uri = Uri.parse("tel:8840001394");
        Intent intent = new Intent(
                Intent.ACTION_CALL,
                uri
        );
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }
}
