package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminDonarListActivity2 extends AppCompatActivity {
    DBHelper db;
    RecyclerView recyclerView;
    private ArrayList name,email,mobile,pass,Conpass;
    myAdapter5 myAdapter5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_donar_list2);

        db=new DBHelper(this);
        name= new ArrayList<>();
        email= new ArrayList<>();
        mobile= new ArrayList<>();
        pass= new ArrayList<>();
        recyclerView=findViewById(R.id.DErecycleview);
        myAdapter5 =new myAdapter5(this,name,email,mobile,pass);
        recyclerView.setAdapter(myAdapter5);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private  void displayData(){
        Cursor cursor=db.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(AdminDonarListActivity2.this,"No Entry Exsist",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                email.add(cursor.getString(1));
                mobile.add(cursor.getString(2));
                pass.add(cursor.getString(3));
            }
        }
    }
}