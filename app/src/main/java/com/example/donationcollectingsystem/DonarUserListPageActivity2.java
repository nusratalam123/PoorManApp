package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class DonarUserListPageActivity2 extends AppCompatActivity {
    DBHelper db;
    RecyclerView recyclerView;
    private ArrayList name,email,mobile_number,bank_number,ammount,date,distric,thana,pass,conPass;
    donarAdapter myadapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_sending_money_infoshowlist2);

        db=new DBHelper(this);
        name= new ArrayList<>();
        email= new ArrayList<>();
        mobile_number= new ArrayList<>();

        pass= new ArrayList<>();
        conPass= new ArrayList<>();
        recyclerView=findViewById(R.id.donarLoginCard);
        myadapter2 =new donarAdapter(this,name,email,mobile_number,pass,conPass);
        recyclerView.setAdapter(myadapter2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DonardisplayData();
    }

    private  void DonardisplayData(){
        Cursor cursor=db.Donargetdata();
        if(cursor.getCount()==0){
            Toast.makeText(DonarUserListPageActivity2.this,"No Entry Exsist",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                email.add(cursor.getString(1));
                mobile_number.add(cursor.getString(2));
                pass.add(cursor.getString(3));
                conPass.add(cursor.getString(4));
            }
        }
    }
}