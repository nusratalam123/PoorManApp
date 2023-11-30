package com.example.donationcollectingsystem;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MYViewHolder> {
    private Context context;
    private ArrayList name,mobile_number,bkash_number,distric,subDistric;

    public MyAdapter(Context context, ArrayList name, ArrayList mobile_number, ArrayList bkash_number, ArrayList distric, ArrayList subDistric) {
        this.context = context;
        this.name = name;
        this.mobile_number = mobile_number;
        this.bkash_number = bkash_number;
        this.distric = distric;
        this.subDistric = subDistric;
    }

    @NonNull
    @Override

    public MYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.peoplelist,parent,false);

        return new MYViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MYViewHolder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.mobile_number.setText(String.valueOf(mobile_number.get(position)));
        holder.bkash_number.setText(String.valueOf(bkash_number.get(position)));
        holder.distric.setText(String.valueOf(distric.get(position)));
        holder.subDistric.setText(String.valueOf(subDistric.get(position)));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MYViewHolder extends RecyclerView.ViewHolder {
        TextView name,mobile_number,bkash_number,distric,subDistric;
        public MYViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.userName);
            mobile_number=itemView.findViewById(R.id.userMobileNumber);
            bkash_number=itemView.findViewById(R.id.userBkashNumber);
            distric=itemView.findViewById(R.id.userDistric);
            subDistric=itemView.findViewById(R.id.userSubdistric);
        }
    }
}
