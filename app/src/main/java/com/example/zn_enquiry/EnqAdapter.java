package com.example.zn_enquiry;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EnqAdapter extends RecyclerView.Adapter<EnqAdapter.MyViewHolder>
{
    JSONArray ar;
    Activity context;
    JSONObject obj;
    EnqAdapter(Activity context1, JSONArray ar1)
    {
        ar=ar1;
        context=context1;
    }

    @NonNull
    @Override
    public EnqAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.enqview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EnqAdapter.MyViewHolder holder, int position) {
        try {
            obj=ar.getJSONObject(position);
            holder.e1.setText(obj.getString("Name"));
            holder.e2.setText(obj.getString("Mobile"));
            holder.e3.setText(obj.getString("Course"));
            holder.e4.setText(obj.getString("Totper"));
            holder.e5.setText(obj.getString("Remark"));
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        return ar.length();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView e1,e2,e3,e4,e5;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            e1=itemView.findViewById(R.id.et1);
            e2=itemView.findViewById(R.id.et2);
            e3=itemView.findViewById(R.id.et3);
            e4=itemView.findViewById(R.id.et4);
            e5=itemView.findViewById(R.id.et5);
        }
    }
}
