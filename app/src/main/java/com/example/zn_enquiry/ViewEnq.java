package com.example.zn_enquiry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class ViewEnq extends AppCompatActivity {

    RecyclerView rec1;
    Button b1;
    EnqAdapter adp;
    RequestQueue requestQueue;
    void LoadEnquiry()
    {
        String url=myfile.myip+"getallenq.php";
        JsonArrayRequest request=new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                adp=new EnqAdapter(ViewEnq.this,response);
                rec1.setLayoutManager(new LinearLayoutManager(ViewEnq.this));
                rec1.setAdapter(adp);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_enq);
        rec1=findViewById(R.id.rec1);
        b1=findViewById(R.id.bt1);
        LoadEnquiry();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p=new Intent( getApplicationContext(), Enquiry.class);
                startActivity(p);             }
        });

    }
}