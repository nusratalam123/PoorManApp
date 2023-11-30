package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllPeopledInformationActivity2 extends AppCompatActivity {
    DBHelper1 db;
    RecyclerView recyclerView;
    ArrayList<String> name,mobileNumber,bkashNumber,districName,subDistricName;
    MyAdapter adapter;
    TextView peoplename;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_peopled_information2);
        peoplename=findViewById(R.id.people_nick_name);
        String Pname= getIntent().getStringExtra("name");
        peoplename.setText(Pname);
        db=new DBHelper1(this);
        name= new ArrayList<>();
        mobileNumber= new ArrayList<>();
        bkashNumber= new ArrayList<>();
        districName= new ArrayList<>();
        subDistricName= new ArrayList<>();
        recyclerView=findViewById(R.id.recycleview);
        adapter=new MyAdapter(this,name,mobileNumber,bkashNumber,districName,subDistricName);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private  void displayData(){
        Cursor cursor=db.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(AllPeopledInformationActivity2.this,"No Entry Exsist",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                mobileNumber.add(cursor.getString(1));
                bkashNumber.add(cursor.getString(2));
                districName.add(cursor.getString(3));
                subDistricName.add(cursor.getString(4));
            }
        }
    }
}