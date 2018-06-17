package com.example.iot.serviceex1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyNewService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(
                getBaseContext(),
                "My Service Started:",
                Toast.LENGTH_LONG
        ).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(
                getBaseContext(),
                "My Service Stopped:",
                Toast.LENGTH_LONG
        ).show();

        super.onDestroy();
    }


}
