package com.example.zn_enquiry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.health.connect.datatypes.units.Length;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class new_course extends AppCompatActivity {
    Button b1;
    EditText et1, et2, et3, et4;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_course);
        {
            et1 = findViewById(R.id.et1);
            et2 = findViewById(R.id.et2);
            et3 = findViewById(R.id.et3);
            et4 = findViewById(R.id.et4);
            b1 = findViewById(R.id.bt1);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url=myfile.myip+"course.php";
                    JSONObject obj = new JSONObject();
                    try {
                        obj.put("coursename", et1.getText().toString());
                        obj.put("fees", et2.getText().toString());
                        obj.put("duration", et3.getText().toString());
                        obj.put("description", et4.getText().toString());
                    } catch (Exception e) {
                    }
                    JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
                        }
                    });
                    requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(request);
                }

            });
        }
    }
}
