package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    private DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout homeimg,settingimg,doublepeopleimg,dddonarPage,ddlogout,ddpeople;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_home2);

        //adapter data
        db=new DBHelper1(this);
        name= new ArrayList<>();
        districName= new ArrayList<>();
        subDistricName= new ArrayList<>();
        mobileNumber= new ArrayList<>();
        ArrayList<String> fliterlist=new ArrayList<>();
        recyclerView=findViewById(R.id.Drecycleview);
        adapter=new myAdapter1(this,name,districName,mobileNumber);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
       // searchView=findViewById(R.id.seachLogo);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                ArrayList<String> searchlist=new ArrayList<>();
//                for(String  people:districName){
//                    if(people.toLowerCase().contains(newText.toLowerCase())){
//                        searchlist.add(people);
//                        Toast.makeText(peopleHomeActivity2.this,"There exist",Toast.LENGTH_SHORT).show();
//
//                    }
//                }
//                adapter.setAdapter(searchlist);
//                return true;
//            }
//        });

        drawerLayout = findViewById(R.id.drawer_layout);
        menu=findViewById(R.id.menu);
        homeimg = findViewById(R.id.ddrawerHome);
        //homeimg = findViewById(R.id.DrawerhomeLogo);
        doublepeopleimg = findViewById(R.id.ddrawerProfile);
        settingimg = findViewById(R.id.ddrawerSetting);
        dddonarPage = findViewById(R.id.ddrawerDonar);
        ddpeople = findViewById(R.id.ddrawerPeople);
        ddlogout = findViewById(R.id.ddrawerLogout);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });

        homeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   recreate();
                 redirectActivity(peopleHomeActivity2.this,MainActivity.class);
            }
        });

        settingimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(peopleHomeActivity2.this,SettingPageActivity2.class);
            }
        });
        dddonarPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(peopleHomeActivity2.this,donarHomeActivity2.class);
            }
        });
        ddpeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(peopleHomeActivity2.this, peopleLoginActivity2.class);
            }
        });
        ddlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(peopleHomeActivity2.this,MainActivity.class);
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
                mobileNumber.add(cursor.getString(1));
                // bkashNumber.add(cursor.getString(2));
                districName.add(cursor.getString(4));
                //subDistricName.add(cursor.getString(5));
            }
        }
    }
  //drawer
    public  static void openDrawer( DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void  closeDrawer( DrawerLayout drawerLayout) {
        if( drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public static void  redirectActivity(Activity activity, Class secondActivity) {
        Intent intent=new Intent(activity, secondActivity);
        activity.startActivity(intent);
        activity.finish();
    }
    protected  void onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }
}