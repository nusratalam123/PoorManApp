package com.example.donationcollectingsystem;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class myAdapter1 extends RecyclerView.Adapter<myAdapter1.MyViewHolder> {

    private Context context;
    private ArrayList name,mobile_number,bkash_number,distric,subDistric;
    public myAdapter1(Context context , ArrayList name, ArrayList distric){
        this.context = context;
        this.name = name;
        this.distric = distric;
        this.subDistric=subDistric;

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
        //holder.subDistric.setText(String.valueOf(subDistric.get(position)));

        holder.payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(context, "Button clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, PaymentPageActivity2.class);
                intent.putExtra("text", name);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public void setAdapter(ArrayList<String> searchlist) {
        distric=searchlist;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,distric,subDistric;
        Button payBtn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.dUserName);
            distric=itemView.findViewById(R.id.dUserDistric);
           // subDistric=itemView.findViewById(R.id.dUsersubDistric);
            payBtn=itemView.findViewById(R.id.pay_btn);
            payBtn.setEnabled(true);

        }
    }
}
