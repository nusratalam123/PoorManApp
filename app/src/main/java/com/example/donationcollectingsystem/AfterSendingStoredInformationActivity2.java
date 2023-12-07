package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AfterSendingStoredInformationActivity2 extends AppCompatActivity {
    TextView peopleReg;
    selfPaymentDatabase db;
    ImageView HomeLogo,DonationPageLogo,PeopleLogo,SettingLogo;
    RecyclerView recyclerView;
    ArrayList<String> name,mobile_number,distric,senderName,senderEmail,tranjacId,ammount,date,method;
    myAdapter3 adapter;
    Button payBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sending_stored_information2);

        db=new selfPaymentDatabase(this);
        name= new ArrayList<>();
        mobile_number= new ArrayList<>();
        distric= new ArrayList<>();
        senderName= new ArrayList<>();
        senderEmail= new ArrayList<>();
        tranjacId= new ArrayList<>();
        ammount= new ArrayList<>();
        date= new ArrayList<>();
        method= new ArrayList<>();
        recyclerView=findViewById(R.id.afterStoredrecycleview);
        adapter=new myAdapter3(this,name,mobile_number,distric,senderName,senderEmail,tranjacId,ammount,date,method);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
    }

    private  void displayData(){
        Cursor cursor=db.getAfterStoredData();
        if(cursor.getCount()==0){
            Toast.makeText(AfterSendingStoredInformationActivity2.this,"No Entry Exsist",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                distric.add(cursor.getString(1));
                mobile_number.add(cursor.getString(2));
                senderName.add(cursor.getString(3));
                senderEmail.add(cursor.getString(4));
                tranjacId.add(cursor.getString(6));
                ammount.add(cursor.getString(5));
                date.add(cursor.getString(7));
                method.add(cursor.getString(8));

            }
        }
    }
}