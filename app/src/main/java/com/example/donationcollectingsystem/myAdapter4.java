package com.example.donationcollectingsystem;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter4 extends RecyclerView.Adapter<myAdapter4.MyViewHolder> {
    private Context context;
    private ArrayList email,banknumber,distric,thana;

    public myAdapter4(Context context, ArrayList email, ArrayList banknumber, ArrayList distric, ArrayList thana) {
        this.context = context;
        this.email = email;
        this.banknumber = banknumber;
        this.distric = distric;
        this.thana = thana;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.responselist,parent,false);
        return new myAdapter4.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.email.setText(String.valueOf(email.get(position)));
        holder.banknumber.setText(String.valueOf(distric.get(position)));
        holder.distric.setText(String.valueOf(banknumber.get(position)));
        holder.thana.setText(String.valueOf(thana.get(position)));
        holder.approveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,donarSendingMoneyListActivity2.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return email.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView email,banknumber,distric,thana;
        Button approveBtn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            email=itemView.findViewById(R.id.responseListEmail);
            banknumber=itemView.findViewById(R.id.responseListBankNumber);
            distric=itemView.findViewById(R.id.responseListdistrict);
            thana=itemView.findViewById(R.id.responseListThana);
            approveBtn=itemView.findViewById(R.id.approveBtn);
        }
    }
}
