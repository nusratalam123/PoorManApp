package com.example.donationcollectingsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class donarAdapter extends RecyclerView.Adapter<donarAdapter.MyViewHolder> {
    private Context context;
    private ArrayList name,email,mobile_number,pass,confirm_pass;
    public donarAdapter(Context context, ArrayList name, ArrayList email, ArrayList mobileNumber, ArrayList pass, ArrayList confirmPass) {
        this.context = context;
        this.name = name;
        this.email = email;
        mobile_number = mobileNumber;
        this.pass = pass;
        confirm_pass = confirmPass;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vi= LayoutInflater.from(context).inflate(R.layout.donarloginlist,parent,false);
        return new MyViewHolder(vi);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.email.setText(String.valueOf(email.get(position)));
        holder.mobileNumber.setText(String.valueOf(mobile_number.get(position)));
        holder.password.setText(String.valueOf(pass.get(position)));
        holder.confirmPass.setText(String.valueOf(confirm_pass.get(position)));

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,email,mobileNumber,password,confirmPass;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.dListName);
            email=itemView.findViewById(R.id.dListEmail);
            mobileNumber=itemView.findViewById(R.id.dListMobileNumber);
            password=itemView.findViewById(R.id.dListpass);
            confirmPass=itemView.findViewById(R.id.dListConPass);
        }
    }
}
