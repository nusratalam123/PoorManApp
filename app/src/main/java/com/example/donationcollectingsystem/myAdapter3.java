package com.example.donationcollectingsystem;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter3 extends RecyclerView.Adapter<myAdapter3.MyViewholder>{
    private Context context;
    private ArrayList name,mobile_number,distric,senderName,senderEmail,tranjacId,ammount,date,method;

    public myAdapter3(Context context, ArrayList name, ArrayList mobileNumber, ArrayList distric, ArrayList senderName, ArrayList senderEmail, ArrayList tranjacId, ArrayList ammount, ArrayList date, ArrayList method) {
        this.context = context;
        this.name = name;
        mobile_number = mobileNumber;
        this.distric = distric;
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.tranjacId = tranjacId;
        this.ammount = ammount;
        this.date = date;
        this.method = method;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.seltpaymentlist,parent,false);
        return new myAdapter3.MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.distric.setText(String.valueOf(distric.get(position)));
        holder.mobile_number.setText(String.valueOf(mobile_number.get(position)));
        holder.senderName.setText(String.valueOf(senderName.get(position)));
        holder.senderEmail.setText(String.valueOf(senderEmail.get(position)));
        holder.tranjacId.setText(String.valueOf(tranjacId.get(position)));
        holder.ammount.setText(String.valueOf(ammount.get(position)));
        holder.date.setText(String.valueOf(date.get(position)));
        holder.method.setText(String.valueOf(method.get(position)));
        holder.sendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MobileSendSmsActivity2.class);
                intent.putExtra("mobile", mobile_number.get(holder.getAdapterPosition()).toString());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder{
        TextView name,mobile_number,distric,senderName,senderEmail,tranjacId,ammount,date,method;

        Button sendSms;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.afterPaymentStoredName);
            distric=itemView.findViewById(R.id.afterPaymentStoreddistrict);
            mobile_number=itemView.findViewById(R.id.afterPaymentMobile);
            senderName=itemView.findViewById(R.id.afterPaymentSenderName);
            senderEmail=itemView.findViewById(R.id.afterPaymentStoredEmail);
            tranjacId=itemView.findViewById(R.id.afterPaymentTransId);
            ammount=itemView.findViewById(R.id.afterPaymentAmount);
            date=itemView.findViewById(R.id.afterPaymentdate);
            method=itemView.findViewById(R.id.afterPaymentmethod);
            sendSms=itemView.findViewById(R.id.sendSms);
        }
    }
}
