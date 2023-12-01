package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GovtInformationActivity2 extends AppCompatActivity {
     private TextView districtName,subName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt_information2);
        districtName=findViewById(R.id.show_dis_govt_page);
        subName=findViewById(R.id.show_sub_govt_page);
        String DisName= getIntent().getStringExtra("district");
        String ThaName= getIntent().getStringExtra("subsidise");

        districtName.setText(DisName);
        subName.setText(ThaName);

    }
}