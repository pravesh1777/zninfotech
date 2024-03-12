package com.example.zn_enquiry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Enquiry extends AppCompatActivity {
EditText name,mno,person,remark;

Spinner sp1;
Button b1;
RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        {
            name=findViewById(R.id.name);
            mno=findViewById(R.id.mno);
            person=findViewById(R.id.person);
            remark=findViewById(R.id.remark);
            sp1=findViewById(R.id.sp1);
            b1=findViewById(R.id.bt1);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url=myfile.myip+"ensignup.php";
                    JSONObject obj=new JSONObject();
                    try {
                        obj.put("name",name.getText().toString());
                        obj.put("mobileno",mno.getText().toString());
                        obj.put("course",sp1.getSelectedItem());
                        obj.put("noperson",person.getText().toString());
                        obj.put("remark",remark.getText().toString());
                    } catch (JSONException e) {}

                    JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(Enquiry.this, "Saved" , Toast.LENGTH_SHORT).show();
                        }

                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(Enquiry.this,error.toString(),Toast.LENGTH_LONG).show();
                        }
                    });
                    requestQueue= Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(request);

                }
            });

        }
    }
}