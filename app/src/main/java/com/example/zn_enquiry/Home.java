package com.example.zn_enquiry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {
CardView cd2,cd3,cd4,cd6;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);{

            cd2=findViewById(R.id.cd2);
            cd3=findViewById(R.id.cd3);
            cd4=findViewById(R.id.cd4);
            cd6=findViewById(R.id.cd6);
            b1=findViewById(R.id.bt1);

            cd2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent p= new Intent(getApplicationContext(),ViewEnq.class);
                    startActivity(p);
                }
            });
            cd3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent p= new Intent(getApplicationContext(),Branch.class);
                    startActivity(p);
                }
            });
            cd4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent p= new Intent(getApplicationContext(),Course_rc_view.class);
                    startActivity(p);
                }
            });

            cd6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent p= new Intent(getApplicationContext(),Employee_rc_view.class);
                    startActivity(p);
                }
            });
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent p=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(p);
                    finish();
                    Toast.makeText(getApplicationContext(),"Logout Successfully",Toast.LENGTH_SHORT).show();
                }
            });


        }
        }
    }
