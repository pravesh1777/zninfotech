package com.example.zn_enquiry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.RequestQueue;

public class Branch extends AppCompatActivity {
CardView cd1,iv1;
RequestQueue requestQueue;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);{

        cd1=findViewById(R.id.cd1);

        iv1=findViewById(R.id.iv1);
        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p=new Intent(getApplicationContext(), Branch_rc_view.class);
                startActivity(p);
            }
        });
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p=new Intent(getApplicationContext(), Branchinfo.class);
                startActivity(p);
            }
        });
        }
    }
}