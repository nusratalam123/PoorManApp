package com.example.donationcollectingsystem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.Contacts;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MYViewHolder> {
    private Context context;
    private ArrayList name,mobile_number,bkash_number,distric,subDistric;
    DBHelper1 db;
    ArrayList<model> item=new ArrayList<>();
    Dialog Mydialogue;

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
       // holder.mobile_number.setText(String.valueOf(mobile_number.get(position)));
       // holder.bkash_number.setText(String.valueOf(bkash_number.get(position)));
        holder.distric.setText(String.valueOf(distric.get(position)));
       // holder.subDistric.setText(String.valueOf(subDistric.get(position)));

        Mydialogue =new Dialog(context);
        Mydialogue.setContentView(R.layout.dialogbox);


        holder.peoplelistCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView userName=Mydialogue.findViewById(R.id.userName);
                TextView  userMobileNumber=Mydialogue.findViewById(R.id.userMobileNumber);
                TextView userBkashNumber=Mydialogue.findViewById(R.id.userBkashNumber);
                TextView districName=Mydialogue.findViewById(R.id.userDistric);
                TextView subDistricName=Mydialogue.findViewById(R.id.userSubdistric);
                userName.setText(name.get(holder.getAdapterPosition()).toString());
                userMobileNumber.setText(mobile_number.get(holder.getAdapterPosition()).toString());
                userBkashNumber.setText(bkash_number.get(holder.getAdapterPosition()).toString());
                districName.setText(distric.get(holder.getAdapterPosition()).toString());
                subDistricName.setText(subDistric.get(holder.getAdapterPosition()).toString());
                Mydialogue.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class MYViewHolder extends RecyclerView.ViewHolder {
        TextView name,mobile_number,bkash_number,distric,subDistric;
        Button peoplelistCard;
       // Dialog dialog;
        public MYViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.userName);
           // mobile_number=itemView.findViewById(R.id.userMobileNumber);
           // bkash_number=itemView.findViewById(R.id.userBkashNumber);
            distric=itemView.findViewById(R.id.userDistric);
          //  subDistric=itemView.findViewById(R.id.userSubdistric);
            peoplelistCard=itemView.findViewById(R.id.moreInfo);
        }
    }
}
