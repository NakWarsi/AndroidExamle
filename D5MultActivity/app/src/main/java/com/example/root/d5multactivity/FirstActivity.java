package com.example.root.d5multactivity;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    EditText Rollno;
    Button Details;
    Button Submit;
    Button Cancel;
    String FN,MN,LN;
    Dialog mydialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Rollno=(EditText)findViewById(R.id.etRollNo);
        Details=(Button)findViewById(R.id.btnDetails);
        Submit=(Button)findViewById(R.id.btnSubmit);

        Details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydialog= new Dialog(FirstActivity.this);
                mydialog.setContentView(R.layout.detailslayout);
                Submit=(Button)mydialog.findViewById(R.id.btnSubmit);
                Cancel=(Button)mydialog.findViewById(R.id.btncancel);

                final EditText etFN=(EditText)mydialog.findViewById(R.id.etFname);
                final EditText etMN=(EditText)mydialog.findViewById(R.id.etMname);
                final EditText etLN=(EditText)mydialog.findViewById(R.id.etLname);



                Submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FN=etFN.getText().toString();
                        MN=etMN.getText().toString();
                        LN=etLN.getText().toString();
                        TextView detailsdisp=(TextView)findViewById(R.id.tvfirst);
                        detailsdisp.setText(FN+" "+MN+" "+LN);
                        mydialog.dismiss();
                    }
                });

                Cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    mydialog.dismiss();
                    }
                });

                mydialog.show();
            }
        });

        Button submitoutside=(Button)findViewById(R.id.btnSubmitOutside);
        submitoutside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rno=Rollno.getText().toString();
                String info="Roll No: "+rno+"\nFirst Name: "+FN+"\nMiddle Name: "+MN+ "\nLast Name: "+LN;

                /*Toast.makeText(
                        FirstActivity.this,
                        info,
                        Toast.LENGTH_LONG
                ).show();*/
                Intent intent=new Intent(
                        FirstActivity.this,
                        SecondActivity.class
                );

                intent.putExtra("KEY_INFO",info);
                startActivity(intent);
            }
        });
    }//onCreate ends here



}
