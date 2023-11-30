package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button people,donar,login,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        people=findViewById(R.id.people_btn);
        donar=findViewById(R.id.donar_btn);
       // login=findViewById(R.id.main_login);
       // register=findViewById(R.id.main_register);
        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MainActivity.this,peopleLoginActivity2.class);
                startActivity(intent1);
            }
        });
        donar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(MainActivity.this,donarHomeActivity2.class);
                startActivity(intent2);
            }
        });
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent3=new Intent(MainActivity.this,loginPageActivity2.class);
//                startActivity(intent3);
//            }
//        });
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent3=new Intent(MainActivity.this, RegisterPageActivity2.class);
//                startActivity(intent3);
//            }
//        });

    }
}