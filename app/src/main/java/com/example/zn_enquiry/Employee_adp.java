package com.example.zn_enquiry;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Employee_adp extends RecyclerView.Adapter<Employee_adp.MyViewHolder> {
    JSONArray ar;
    Activity context;
    JSONObject obj;

    Employee_adp(Activity context, JSONArray ar1) {
        ar = ar1;
        context = context;

    }

    @NonNull
    @Override
    public Employee_adp.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_view, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull Employee_adp.MyViewHolder holder, int position) {
        try {
            obj = ar.getJSONObject(position);
            holder.e14.setText(obj.getString("Position"));
            holder.e1.setText(obj.getString("Employee_name"));
            holder.e2.setText(obj.getString("Gender"));
            holder.e3.setText(obj.getString("Mobile_number"));
            holder.e4.setText(obj.getString("Email"));
            holder.e5.setText(obj.getString("Address"));
            holder.e6.setText(obj.getString("Adharnumber"));
            holder.e7.setText(obj.getString("Qualification"));
            holder.e8.setText(obj.getString("Experience"));
            holder.e9.setText(obj.getString("Achievement"));
            holder.e10.setText(obj.getString("Remark"));
            holder.e11.setText(obj.getString("Date_of_joning"));
            holder.e12.setText(obj.getString("Dob"));
            holder.e13.setText(obj.getString("Password"));
        } catch (Exception e) {

        }

    }

    @Override
    public int getItemCount() {
        return ar.length();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            e1 = itemView.findViewById(R.id.et1);
            e2 = itemView.findViewById(R.id.et2);
            e3 = itemView.findViewById(R.id.et3);
            e4 = itemView.findViewById(R.id.et4);
            e5 = itemView.findViewById(R.id.et5);
            e6 = itemView.findViewById(R.id.et6);
            e7 = itemView.findViewById(R.id.et7);
            e8 = itemView.findViewById(R.id.et8);
            e9 = itemView.findViewById(R.id.et9);
            e10 = itemView.findViewById(R.id.et10);
            e11 = itemView.findViewById(R.id.et11);
            e12 = itemView.findViewById(R.id.et12);
            e13 = itemView.findViewById(R.id.et13);
            e14 = itemView.findViewById(R.id.et14);

        }

    }
}
