package com.example.zn_enquiry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class Course_rc_view extends AppCompatActivity {
    RecyclerView rec1;
    Course_adp adp;
    ImageView iv1;
    RequestQueue requestQueue;

    void LoadCourse() {
        String url=myfile.myip+"getcourse.php";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                adp = new Course_adp(Course_rc_view.this, response);
                rec1.setLayoutManager(new LinearLayoutManager(Course_rc_view.this));
                rec1.setAdapter(adp);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_rc_view);
        rec1 = findViewById(R.id.rec1);
        iv1=findViewById(R.id.iv1);
        LoadCourse();
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p=new Intent( getApplicationContext(),new_course.class);
                startActivity(p);
            }
        });

    }
}