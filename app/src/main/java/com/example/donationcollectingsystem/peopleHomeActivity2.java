package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class peopleHomeActivity2 extends AppCompatActivity {
     TextView peopleReg;
     DBHelper1 db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_home2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}