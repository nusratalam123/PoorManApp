package com.example.donationcollectingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class afterLoginPeopleHomePageActivity2 extends AppCompatActivity  {

    DBHelper1 db;
    RecyclerView recyclerView;
    ArrayList<String> name,mobileNumber,bkashNumber,districName,subDistricName;
    MyAdapter adapter;
    TextView peoplename;
    private DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout homeimg,settingimg,doublepeopleimg, donarPage, peoplePage,logout,profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login_people_home_page2);

        db=new DBHelper1(this);
        name= new ArrayList<>();
        mobileNumber= new ArrayList<>();
        bkashNumber= new ArrayList<>();
        districName= new ArrayList<>();
        subDistricName= new ArrayList<>();
        recyclerView=findViewById(R.id.helperPeoplerecycleview);
        adapter=new MyAdapter(this,name,mobileNumber,bkashNumber,districName,subDistricName);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();
        drawerLayout = findViewById(R.id.helperPeopleDrawer);
        menu=findViewById(R.id.menu);
        //homeimg = findViewById(R.id.DrawerhomeLogo);
        settingimg = findViewById(R.id.drawerSetting);
        homeimg = findViewById(R.id.drawerHome);
        //homeimg = findViewById(R.id.DrawerhomeLogo);
        profile = findViewById(R.id.drawerProfile);
        donarPage = findViewById(R.id.drawerDonar);
        peoplePage = findViewById(R.id.drawerPeoplePage);
        logout = findViewById(R.id.drawerlogout);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              openDrawer(drawerLayout);
            }
        });

        homeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  recreate();
               redirectActivity(afterLoginPeopleHomePageActivity2.this,MainActivity.class);
            }
        });

        settingimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //redirectActivity(afterLoginPeopleHomePageActivity2.this,peopleSettingActivity2.class);
                redirectActivity(afterLoginPeopleHomePageActivity2.this,SettingPageActivity2.class);
            }
        });

        donarPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //redirectActivity(afterLoginPeopleHomePageActivity2.this,peopleSettingActivity2.class);
                redirectActivity(afterLoginPeopleHomePageActivity2.this,donarHomeActivity2.class);
            }
        });

        peoplePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //redirectActivity(afterLoginPeopleHomePageActivity2.this,peopleSettingActivity2.class);
                redirectActivity(afterLoginPeopleHomePageActivity2.this, peopleLoginActivity2.class);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //redirectActivity(afterLoginPeopleHomePageActivity2.this,peopleSettingActivity2.class);
                redirectActivity(afterLoginPeopleHomePageActivity2.this, MainActivity.class);
            }
        });
    }

    private  void displayData(){
        Cursor cursor=db.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(afterLoginPeopleHomePageActivity2.this,"No Entry Exsist",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                mobileNumber.add(cursor.getString(1));
                bkashNumber.add(cursor.getString(3));
                districName.add(cursor.getString(4));
                subDistricName.add(cursor.getString(5));
            }
        }
    }


    public  static void openDrawer( DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void  closeDrawer( DrawerLayout drawerLayout) {
        if( drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public static void  redirectActivity( Activity activity, Class secondActivity) {
        Intent intent=new Intent(activity, secondActivity);
        activity.startActivity(intent);
        activity.finish();
    }
    protected  void onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }

}