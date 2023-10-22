package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class peopleLoginActivity2 extends AppCompatActivity {
    TextView peopleReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_login2);
        peopleReg=findViewById(R.id.people_register);
        peopleReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(peopleLoginActivity2.this, RegisterPageActivity2.class);
                startActivity(intent2);
            }
        });
    }
}