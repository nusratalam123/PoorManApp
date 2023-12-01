package com.example.donationcollectingsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter1 extends RecyclerView.Adapter<myAdapter1.MyViewHolder> {

    private Context context;
    private ArrayList name,mobile_number,bkash_number,distric,subDistric;
    public myAdapter1(Context context ,ArrayList name,ArrayList distric){
        this.context = context;
        this.name = name;
        this.distric = distric;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.donarpeoplelist,parent,false);

        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.distric.setText(String.valueOf(distric.get(position)));

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,distric,subDistric;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.dUserName);
            distric=itemView.findViewById(R.id.dUserDistric);

        }
    }
}
