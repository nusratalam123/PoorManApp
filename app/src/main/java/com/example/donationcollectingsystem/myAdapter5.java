package com.example.donationcollectingsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter5  extends RecyclerView.Adapter<myAdapter5.MyViewHolder> {

    private Context context;
    private ArrayList email,name,mobile,pass,Conpass;

    public myAdapter5(Context context, ArrayList name, ArrayList email, ArrayList mobile, ArrayList pass) {
        this.context = context;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.pass = pass;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.peoplelist2,parent,false);
        return new myAdapter5.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.email.setText(String.valueOf(email.get(position)));
        holder.mobileNumber.setText(String.valueOf(mobile.get(position)));
        holder.password.setText(String.valueOf(pass.get(position)));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,email,mobileNumber,password,confirmPass;
        public MyViewHolder(View itemView) {
            super(itemView);
            // name=itemView.findViewById(R.id.userName);
            //  email=itemView.findViewById(R.id.userDistric);
            name=itemView.findViewById(R.id.SpecialName);
            email=itemView.findViewById(R.id.SpecialEmail);
            mobileNumber=itemView.findViewById(R.id.SpecialMobile);
            password=itemView.findViewById(R.id.SpecialPass);
        }
    }

}
