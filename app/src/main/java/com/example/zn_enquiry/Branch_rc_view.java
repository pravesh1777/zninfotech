package com.example.zn_enquiry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class Branch_rc_view extends AppCompatActivity {
RecyclerView rec1;
Branch_Adp adp;
RequestQueue requestQueue;
void LoadBranch() {
    //String url="https://pravesh172002.000webhostapp.com/getbranch.php";
    String url=myfile.myip+"getbranch.php";
    JsonArrayRequest request=new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            adp = new Branch_Adp(Branch_rc_view.this, response);
            rec1.setLayoutManager(new LinearLayoutManager(Branch_rc_view.this));
            rec1.setAdapter(adp);

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {;
        }
    });
    requestQueue= Volley.newRequestQueue(getApplicationContext());
    requestQueue.add(request);
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_detail);
        rec1=findViewById(R.id.rec1);
        LoadBranch();

    }
}