package com.example.root.listviewexa1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDisp;
    ListView mylist;
    String [] name={"Mihir\n Chitnis","Naushad\nWarsi","Anubhav\nIssachar",
            "Mayuresh\nDarade","Yash\n Bichewar","Pallav\n Channa","Ashutosh",
            "Yogesh\n","Vishal","Tina","Bala","Mala","Kala","Sala"
    };
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDisp=(Button)findViewById(R.id.btnShowList);
        mylist=(ListView)findViewById(R.id.myList1);

        arrayAdapter=new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                name
        );
        mylist.setAdapter(arrayAdapter);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String item=(String)arrayAdapter.getItem(position);
                Toast.makeText(
                        MainActivity.this,
                        "Row selected with Item: "+item,
                        Toast.LENGTH_LONG
                ).show();

            }
        });

        btnDisp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mylist.setVisibility(View.VISIBLE);
            }
        });

    }
}
