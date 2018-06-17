package com.example.iot.contentproex1;

import android.Manifest;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView myVideoList;
    ArrayAdapter<String>adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myVideoList=(ListView)findViewById(R.id.tvVideoList);

        ActivityCompat.requestPermissions(
                MainActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                101
        );

        adapter=new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1
        );

        myVideoList.setAdapter(adapter);
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        ContentResolver resolver=getContentResolver();
        Cursor cursor=resolver.query(uri,null,null,null,null);


        for(int i=0;i < cursor.getColumnCount();i++)
        {
            String name=cursor.getColumnName(i);
            adapter.add(name);
        }

        adapter.clear();
        String[] req_colName={"_id","_data","_display_name"};

        Cursor cursor1=resolver.query(uri,
                req_colName,
                null,
                null,
                "_display_name"
                );
        while (cursor1.moveToNext()){
            String id=cursor1.getString(0);
            String data=cursor1.getString(1);
            String name=cursor1.getString(2);

            String info=id+"\n"+data+"\n"+name;
            adapter.add(info);
        }
    }



}
