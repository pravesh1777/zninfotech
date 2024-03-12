package com.example.zn_enquiry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1;
    RequestQueue requestQueue;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.et1);
        e2 = findViewById(R.id.et2);
        b1 = findViewById(R.id.bt1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url=myfile.myip+"login.php";
                JSONObject obj = new JSONObject();
                try {
                    obj.put("mno", e1.getText().toString());
                    obj.put("pass", e2.getText().toString());

                }catch (Exception ex){}

                JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            if(response.getString("msg").equals("Valid User"))
                            {
                                if(response.getString("type").equals("Admin"))
                                {
                                    Intent ob=new Intent(getApplicationContext(),Home.class);
                                    ob.putExtra("mob",e1.getText().toString());
                                    startActivity(ob);
                                }
                                else{
                                    Intent ob=new Intent(getApplicationContext(),Employee_profile.class);
                                    ob.putExtra("mob",e1.getText().toString());
                                    startActivity(ob);
                                }

                            }
                            else {
                                Toast.makeText(MainActivity.this, response.getString("msg"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

                    }
                });
                requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(request);

            }
        });

            }
        }
