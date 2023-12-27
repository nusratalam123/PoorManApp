package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class donarViewAllpaylistActivity2 extends AppCompatActivity {
    selfPaymentDatabase db;
    RecyclerView recyclerView;
    ArrayList<String> name,ammount;
    dPayAlladapter adapter;
    TextView loginEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_view_allpaylist2);
        String Pemail= getIntent().getStringExtra("email");
        loginEmail=findViewById(R.id.alllistheaderEmail);
        loginEmail.setText(Pemail);
        db=new selfPaymentDatabase(this);
        name= new ArrayList<>();
        ammount= new ArrayList<>();
        recyclerView=findViewById(R.id.Dpayrecycleview);
        adapter=new dPayAlladapter(this,name,ammount);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData(Pemail);

    }
    private  void displayData(String pemail){
       String PEMAIL=pemail;
        //Toast.makeText(donarViewAllpaylistActivity2.this,PEMAIL+"No Entry Exsist",Toast.LENGTH_SHORT).show();

        Cursor cursor=db.getdata(PEMAIL.toString());
        if(cursor.getCount()==0){
            Toast.makeText(donarViewAllpaylistActivity2.this,"No Entry Exsist",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                ammount.add(cursor.getString(5));
            }
        }
    }
}