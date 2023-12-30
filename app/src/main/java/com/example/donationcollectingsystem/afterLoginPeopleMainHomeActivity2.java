package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class afterLoginPeopleMainHomeActivity2 extends AppCompatActivity {
    ImageView parrowimg;
    TextView peopleLoginname,peoplelogoutBtb,peopleLoginnameTwo;

    ImageView surroundingPeoplebtn;
    Button peopleAchieveMoneyList;

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


    }
}