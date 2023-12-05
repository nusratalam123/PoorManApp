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

public class myadapter2 extends RecyclerView.Adapter<myadapter2.MyViewholder> {
    private Context context;
    private ArrayList name,email,mobile_number,bank_number,ammount,date,distric,thana;

    public myadapter2(Context context, ArrayList name, ArrayList email, ArrayList mobile_number, ArrayList bank_number, ArrayList ammount, ArrayList date, ArrayList distric, ArrayList thana) {
        this.context = context;
        this.name = name;
        this.email = email;
        this.mobile_number = mobile_number;
        this.bank_number = bank_number;
        this.ammount = ammount;
        this.date = date;
        this.distric = distric;
        this.thana = thana;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.senderinfolist,parent,false);
        return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.email.setText(String.valueOf(email.get(position)));
        holder.mobileNumber.setText(String.valueOf(mobile_number.get(position)));
        holder.bankNumber.setText(String.valueOf(bank_number.get(position)));
        holder.Ammount.setText(String.valueOf(ammount.get(position)));
        holder.date.setText(String.valueOf(date.get(position)));
        holder.distric.setText(String.valueOf(distric.get(position)));
        holder.thana.setText(String.valueOf(thana.get(position)));
        holder.sendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, notificationListActivity2.class);
                intent.putExtra("email", email.get(holder.getAdapterPosition()).toString());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }
    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView name,email,mobileNumber,bankNumber,Ammount,date,distric,thana;
        Button sendMail;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.sShowListName);
            email=itemView.findViewById(R.id.sShowListEmail);
            mobileNumber=itemView.findViewById(R.id.sShowListMobileNumber);
            bankNumber=itemView.findViewById(R.id.sShowListBankNumber);
            Ammount=itemView.findViewById(R.id.sShowListAmmount);
            date=itemView.findViewById(R.id.sShowListDate);
            distric=itemView.findViewById(R.id.sShowListDistric);
            thana=itemView.findViewById(R.id.sShowListThana);
            sendMail=itemView.findViewById(R.id.sendMail);

        }
    }
}
