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

public class Branch_Adp extends RecyclerView.Adapter<Branch_Adp.MyViewHolder> {
    JSONArray ar;
    Activity context;
    JSONObject obj;
    Branch_Adp(Activity context, JSONArray ar1)
    {
        ar=ar1;
        context=context;
    }

    @NonNull
    @Override
    public Branch_Adp.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.branch_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Branch_Adp.MyViewHolder holder, int position) {
        try {
            obj=ar.getJSONObject(position);
            holder.e1.setText(obj.getString("Name"));
            holder.e2.setText(obj.getString("Contactno"));
            holder.e3.setText(obj.getString("Address"));
            holder.e4.setText(obj.getString("Email"));
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
