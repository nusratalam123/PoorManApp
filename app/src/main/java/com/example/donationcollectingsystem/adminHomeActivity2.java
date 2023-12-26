package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminHomeActivity2 extends AppCompatActivity {
    Button donar,people,sendWantToPlace,sendingMoney,notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home2);
        donar=findViewById(R.id.donar_section);
        people=findViewById(R.id.people_section);
        sendWantToPlace=findViewById(R.id.donarSendMoneyList);
        sendingMoney=findViewById(R.id.donarSendingMoneyList);
        notification=findViewById(R.id.donarSendNotification);

        donar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(adminHomeActivity2.this,AdminDonarListActivity2.class);
                startActivity(intent);
            }
        });
        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(adminHomeActivity2.this,AllPeopledInformationActivity2.class);
                startActivity(intent);
            }
        });
        sendWantToPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(adminHomeActivity2.this,donarSendWantToPlaceListActivity2.class);
                startActivity(intent);

//                Intent intent =new Intent(adminHomeActivity2.this,donarSendingMoneyListActivity2.class);
//                startActivity(intent);
            }
        });
        sendingMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(adminHomeActivity2.this,donarSendingMoneyInfoshowlistActivity2.class);
                startActivity(intent);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(adminHomeActivity2.this,AfterSendingStoredInformationActivity2.class);
                startActivity(intent);
            }
        });


    }
}