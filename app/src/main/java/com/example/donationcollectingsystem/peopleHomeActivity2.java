package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.Locale;

public class peopleHomeActivity2 extends AppCompatActivity {
     TextView peopleReg;
     DBHelper1 db;
     ImageView HomeLogo,DonationPageLogo,PeopleLogo,SettingLogo;
    RecyclerView recyclerView;
    ArrayList<String> name,mobileNumber,bkashNumber,districName,subDistricName;
    myAdapter1 adapter;
    TextView peoplename;
    SearchView searchView;
    Button payBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_home2);
        HomeLogo=(ImageView) findViewById(R.id.homeLogo);
        PeopleLogo=(ImageView) findViewById(R.id.peoplepageLogo);
        DonationPageLogo=(ImageView) findViewById(R.id.donationPageLogo);
        SettingLogo=(ImageView) findViewById(R.id.settingsLogo);
        //adapter data
        db=new DBHelper1(this);
        name= new ArrayList<>();
        districName= new ArrayList<>();
        subDistricName= new ArrayList<>();
        ArrayList<String> fliterlist=new ArrayList<>();
        recyclerView=findViewById(R.id.Drecycleview);
        adapter=new myAdapter1(this,name,districName);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
        searchView=findViewById(R.id.seachLogo);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> searchlist=new ArrayList<>();
                for(String  people:districName){
                    if(people.toLowerCase().contains(newText.toLowerCase())){
                        searchlist.add(people);
                        Toast.makeText(peopleHomeActivity2.this,"There exist",Toast.LENGTH_SHORT).show();

                    }
                }
                adapter.setAdapter(searchlist);
                return true;
            }
        });

        HomeLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(peopleHomeActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
        PeopleLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(peopleHomeActivity2.this,peopleLoginActivity2.class);
                startActivity(intent);
            }
        });
        DonationPageLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(peopleHomeActivity2.this,donarHomeActivity2.class);
                startActivity(intent);
            }
        });
        SettingLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(peopleHomeActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private  void displayData(){
        Cursor cursor=db.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(peopleHomeActivity2.this,"No Entry Exsist",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                //mobileNumber.add(cursor.getString(1));
               // bkashNumber.add(cursor.getString(2));
                districName.add(cursor.getString(4));
                //subDistricName.add(cursor.getString(5));
            }
        }
    }
}