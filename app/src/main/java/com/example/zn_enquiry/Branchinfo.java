package com.example.zn_enquiry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Branchinfo extends AppCompatActivity {
 EditText e1,e2,e3,e4;
 Button b1;
 RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branchinfo);
        e1=findViewById(R.id.name);
        e2=findViewById(R.id.mno);
        e3=findViewById(R.id.address);
        e4=findViewById(R.id.email);
        b1=findViewById(R.id.bt1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=myfile.myip+"branch.php";
                JSONObject obj= new JSONObject();
                try {
                    obj.put("name",e1.getText().toString());
                    obj.put("contactno",e2.getText().toString());
                    obj.put("address",e3.getText().toString());
                    obj.put("email",e4.getText().toString());
                } catch (JSONException e) {}
                JsonObjectRequest request= new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(Branchinfo.this, "msg", Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Branchinfo.this,error.toString(),Toast.LENGTH_SHORT).show();

                    }
                });
                requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(request);
                }
        });

    }
}