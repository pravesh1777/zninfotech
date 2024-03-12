package com.example.zn_enquiry;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class

Employee_profile extends AppCompatActivity {
    ImageView img1;
    Bitmap bmp;
    TextView tvcam,tvgal,t1,et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13;
    RequestQueue requestQueue;
    String mob="";

    void getprofile(String m){

        String url=myfile.myip+"getprofile.php";
        JSONObject obj=new JSONObject();
        try {
            obj.put("mno",m);
        }catch (Exception ex){}
      JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
          @Override
          public void onResponse(JSONObject response) {
              try {
                  et1.setText(response.getString("position"));
                  t1.setText(response.getString("name"));
                  et2.setText(response.getString("mobile"));
                  et3.setText(response.getString("email"));
                  et4.setText(response.getString("address"));
                  et5.setText(response.getString("adharnumber"));
                  et6.setText(response.getString("gender"));
                  et7.setText(response.getString("qualification"));
                  et8.setText(response.getString("experience"));
                  et9.setText(response.getString("achievement"));
                  et10.setText(response.getString("date_of_joning"));
                  et11.setText(response.getString("dob"));
                  et12.setText(response.getString("password"));
                  Picasso.get().load(response.getString("pic")).into(img1);

              } catch (JSONException e) {
                  throw new RuntimeException(e);
              }

          }
      }, new Response.ErrorListener() {
          @Override
          public void onErrorResponse(VolleyError error) {
              Toast.makeText(Employee_profile.this,error.toString(),Toast.LENGTH_SHORT).show();

          }
      });
        requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);

    }
BottomSheetDialog bottomSheetDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_profile);
        img1=findViewById(R.id.img1);
        t1=findViewById(R.id.t1);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        et4=findViewById(R.id.et4);
        et5=findViewById(R.id.et5);
        et6=findViewById(R.id.et6);
        et7=findViewById(R.id.et7);
        et8=findViewById(R.id.et8);
        et9=findViewById(R.id.et9);
        et10=findViewById(R.id.et10);
        et11=findViewById(R.id.et11);
        et12=findViewById(R.id.et12);
        et13=findViewById(R.id.et13);
        Intent ob=getIntent();
        mob=ob.getStringExtra("mob");
        getprofile(mob);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheetDialog=new BottomSheetDialog(Employee_profile.this);
                bottomSheetDialog.setContentView(R.layout.picoptions);
                tvcam=bottomSheetDialog.findViewById(R.id.tvcam);
                tvgal=bottomSheetDialog.findViewById(R.id.tvgal);
                tvcam.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent ob=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(ob,100);
                    }
                });
                tvgal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent ob=new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(ob,200);
                    }
                });
                bottomSheetDialog.show();
            }
        });
    }

    void uploadpic(String pic,String mobile){

        String Url =myfile.myip+"profilechange.php";
        JSONObject object=new JSONObject();
        try{
            object.put("mobile",mobile);
            object.put("pic",pic);
        }
        catch (Exception ex){}
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, Url, object, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Toast.makeText(getApplicationContext(), response.getString("msg"), Toast.LENGTH_SHORT).show();
                    getprofile(mobile);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue=Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonObjectRequest);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100)
        {
            bmp=(Bitmap)data.getExtras().get("data");
            ByteArrayOutputStream stream=new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.JPEG,70,stream);
            byte[] byte1=stream.toByteArray();
            String image1= Base64.encodeToString(byte1,0);
            uploadpic(image1,mob);
            //imageview.setImageBitmap(bmp);
        }
        else if(requestCode==200) {
            Uri imagepath=data.getData();
            try {
                bmp=MediaStore.Images.Media.getBitmap(getContentResolver(),imagepath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ByteArrayOutputStream stream=new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.JPEG,70,stream);
            byte[] byte1=stream.toByteArray();
            String image1= Base64.encodeToString(byte1,0);
            uploadpic(image1,mob);
        }

    }
}