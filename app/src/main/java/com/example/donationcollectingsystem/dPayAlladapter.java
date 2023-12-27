package com.example.donationcollectingsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class dPayAlladapter extends RecyclerView.Adapter<dPayAlladapter.MYViewHolder> {
    private Context context;
    private ArrayList name,ammount;
    public dPayAlladapter(Context context, ArrayList name, ArrayList ammount) {
        this.context = context;
        this.name = name;
        this.ammount = ammount;
    }


    @NonNull
    @Override
    public MYViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.allpaylistmyself,parent,false);
        return new dPayAlladapter.MYViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MYViewHolder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.ammount.setText(String.valueOf(ammount.get(position)));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MYViewHolder extends RecyclerView.ViewHolder {
        TextView name,ammount;

        public MYViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.allpaylistStoreName);
            ammount=itemView.findViewById(R.id.allpaylistStoreMoney);

        }
    }
}
