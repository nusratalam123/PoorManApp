package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class donarSendingMoneyInfoshowlistActivity2 extends AppCompatActivity {
    senderListDatabase db;
    RecyclerView recyclerView;
    private ArrayList name,email,mobile_number,bank_number,ammount,date,distric,thana;
    myadapter2 myadapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_sending_money_infoshowlist2);

        db=new senderListDatabase(this);
        name= new ArrayList<>();
        email= new ArrayList<>();
        mobile_number= new ArrayList<>();
        bank_number= new ArrayList<>();
        ammount= new ArrayList<>();
        date= new ArrayList<>();
        distric= new ArrayList<>();
        thana= new ArrayList<>();
        recyclerView=findViewById(R.id.Srecycleview);
        myadapter2 =new myadapter2(this,name,email,mobile_number,bank_number,ammount,date,distric,thana);
        recyclerView.setAdapter(myadapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        senderdisplayData();
    }

    private  void senderdisplayData(){
        Cursor cursor=db.sendergetdata();
        if(cursor.getCount()==0){
            Toast.makeText(donarSendingMoneyInfoshowlistActivity2.this,"No Entry Exsist",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                email.add(cursor.getString(1));
                mobile_number.add(cursor.getString(2));
                bank_number.add(cursor.getString(3));
                ammount.add(cursor.getString(4));
                date.add(cursor.getString(5));
                distric.add(cursor.getString(6));
                thana.add(cursor.getString(7));
            }
        }
    }
}