package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class donar_distric_home_pageActivity2 extends AppCompatActivity {
    Button dhaka,khulna,rajshahi,barisal,chittagong,mymensingh,rangpur,sylhet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_distric_home_page2);
        dhaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(donar_distric_home_pageActivity2.this, DonarDistricPayPageActivity2.class);
                startActivity(intent2);
            }
        });
        khulna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(donar_distric_home_pageActivity2.this,DonarRegistrationActivity2.class);
                startActivity(intent2);
            }
        });
        chittagong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(donar_distric_home_pageActivity2.this,DonarRegistrationActivity2.class);
                startActivity(intent2);
            }
        });
        rajshahi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(donar_distric_home_pageActivity2.this,DonarRegistrationActivity2.class);
                startActivity(intent2);
            }
        });
        barisal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(donar_distric_home_pageActivity2.this,DonarRegistrationActivity2.class);
                startActivity(intent2);
            }
        });
        rangpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(donar_distric_home_pageActivity2.this,DonarRegistrationActivity2.class);
                startActivity(intent2);
            }
        });
        mymensingh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(donar_distric_home_pageActivity2.this,DonarRegistrationActivity2.class);
                startActivity(intent2);
            }
        });
        sylhet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(donar_distric_home_pageActivity2.this,DonarRegistrationActivity2.class);
                startActivity(intent2);
            }
        });
    }
}