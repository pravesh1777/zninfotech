package com.example.zn_enquiry;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Course_adp extends RecyclerView.Adapter<Course_adp.MyViewHolder> {
    JSONArray ar;
    Activity context;
    JSONObject obj;

    Course_adp(Activity context1, JSONArray ar1) {
        ar=ar1;
        context=context1;
    }
    @NonNull
    @Override
    public Course_adp.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.course_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Course_adp.MyViewHolder holder, int position) {
        try {
            obj=ar.getJSONObject(position);
            holder.e1.setText(obj.getString("Course_name"));
            holder.e2.setText(obj.getString("Fees"));
            holder.e3.setText(obj.getString("Duration"));
            holder.e4.setText(obj.getString("Description"));
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        return ar.length();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView e1,e2,e3,e4;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            e1=itemView.findViewById(R.id.et1);
            e2=itemView.findViewById(R.id.et2);
            e3=itemView.findViewById(R.id.et3);
            e4=itemView.findViewById(R.id.et4);

        }
    }
}
