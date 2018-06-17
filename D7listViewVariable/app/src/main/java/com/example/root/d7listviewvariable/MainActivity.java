package com.example.root.d7listviewvariable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btAdd;
    EditText etName;
    ListView listView;
    ArrayList<String>nameList;
    ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btAdd=(Button)findViewById(R.id.button);
        etName=(EditText)findViewById(R.id.etName);
        listView=(ListView)findViewById(R.id.mylist);

        nameList= new ArrayList<String>();
        adapter=new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                nameList
        );

        listView.setAdapter(adapter);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=etName.getText().toString();
                nameList.add(name);
                adapter.notifyDataSetChanged();
                etName.setText("");
            }
        });

    }
}
