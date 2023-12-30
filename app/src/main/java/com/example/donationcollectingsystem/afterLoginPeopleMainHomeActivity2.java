package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class afterLoginPeopleMainHomeActivity2 extends AppCompatActivity {
    ImageView parrowimg;
    TextView peopleLoginname,peoplelogoutBtb,peopleLoginnameTwo;

    ImageView surroundingPeoplebtn;
    Button peopleAchieveMoneyList;

    selfPaymentDatabase db;
    RecyclerView recyclerView;
    ArrayList<String> name,ammount;
    historyAdapter adapter;
    TextView loginEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login_people_main_home2);
        parrowimg=findViewById(R.id.helperPeoplePagearraow);
        peopleLoginname=findViewById(R.id.helperPeopleLoginName);
        peopleLoginnameTwo=findViewById(R.id.helperPeopleLoginNameTwo);
        String Pname= getIntent().getStringExtra("name");
        peopleLoginname.setText(Pname);
        peopleLoginnameTwo.setText(Pname);

        peoplelogoutBtb=findViewById(R.id.helperPeoplelogoutBtn);
        surroundingPeoplebtn=findViewById(R.id.surroundingAllpeople);
        peopleAchieveMoneyList=findViewById(R.id.viewAllReceiveMoneyhistoryList);

//adapter sector
        db=new selfPaymentDatabase(this);
        name= new ArrayList<>();
        ammount= new ArrayList<>();
        recyclerView=findViewById(R.id.moneyRecieveHistoryrecycleviewlist);
        adapter=new historyAdapter(this,name,ammount);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData(Pname);

        parrowimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(afterLoginPeopleMainHomeActivity2.this, peopleLoginActivity2.class);
                startActivity(intent2);
            }
        });

        peoplelogoutBtb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(afterLoginPeopleMainHomeActivity2.this, peopleLoginActivity2.class);
                startActivity(intent2);
            }
        });
        surroundingPeoplebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(afterLoginPeopleMainHomeActivity2.this, afterLoginPeopleHomePageActivity2.class);
                startActivity(intent2);
            }
        });

        peopleAchieveMoneyList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(afterLoginPeopleMainHomeActivity2.this, helperPeoplereceiveMoneyHistoryActivity2.class);
                intent2.putExtra("name",Pname);

                startActivity(intent2);
            }
        });


    }

    private  void displayData(String pname){
        String Pname=pname;
        //Toast.makeText(donarViewAllpaylistActivity2.this,PEMAIL+"No Entry Exsist",Toast.LENGTH_SHORT).show();

        Cursor cursor=db.historygetdata(Pname.toString());
        if(cursor.getCount()==0){
            Toast.makeText(afterLoginPeopleMainHomeActivity2.this,"No Entry Exsist",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(3));
                ammount.add(cursor.getString(5));
            }
        }
    }
}