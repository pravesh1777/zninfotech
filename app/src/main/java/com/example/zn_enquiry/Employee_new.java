package com.example.zn_enquiry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Employee_new extends AppCompatActivity {
    String gender;

    EditText e1, e2, e3, e4, e5, e6, e7, e8, e9,e10,e11,e12;
    RadioButton r1, r2;
    Spinner sp1;
    Button b1;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_new);
        e1 = findViewById(R.id.et1);
        e2 = findViewById(R.id.et2);
        e3 = findViewById(R.id.et3);
        e4 = findViewById(R.id.et4);
        e5 = findViewById(R.id.et5);
        e6 = findViewById(R.id.et6);
        e7 = findViewById(R.id.et7);
        e8 = findViewById(R.id.et8);
        e9 = findViewById(R.id.et9);
        e10 = findViewById(R.id.et10);
        e11 = findViewById(R.id.et11);
        e12 = findViewById(R.id.et12);
        sp1 = findViewById(R.id.sp1);
        b1 = findViewById(R.id.bt1);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r1.isChecked()) {
                    gender="male";

                }
                else {
                    gender="Female";
                }
                String url=myfile.myip+"Employee.php";
                JSONObject obj = new JSONObject();
                try {
                    obj.put("position", sp1.getSelectedItem());
                    obj.put("employeename", e1.getText().toString());
                    obj.put("mobileno", e3.getText().toString());
                    obj.put("gender", gender);
                    obj.put("email", e3.getText().toString());
                    obj.put("address", e4.getText().toString());
                    obj.put("adharnumber", e5.getText().toString());
                    obj.put("qualification", e6.getText().toString());
                    obj.put("experience", e7.getText().toString());
                    obj.put("achivement", e8.getText().toString());
                    obj.put("remark", e9.getText().toString());
                    obj.put("dob", e10.getText().toString());
                    obj.put("password", e11.getText().toString());
                    obj.put("date_of_joining", e12.getText().toString());
                } catch (Exception e) {}
                JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Employee_new.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                });
                requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(request);
        }
    });
}
}