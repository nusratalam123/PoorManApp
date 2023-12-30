package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AllPeopledInformationActivity2 extends AppCompatActivity {
    DBHelper1 db;
    RecyclerView recyclerView;
    ArrayList<String> name,mobileNumber,bkashNumber,districName,subDistricName;
    MyAdapter adapter;
    TextView peoplename;
    private DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout homeimg,settingimg,doublepeopleimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_peopled_information2);
//        peoplename=findViewById(R.id.people_nick_name);
//        String Pname= getIntent().getStringExtra("name");
//        peoplename.setText(Pname);
        db=new DBHelper1(this);
        name= new ArrayList<>();
        mobileNumber= new ArrayList<>();
        bkashNumber= new ArrayList<>();
        districName= new ArrayList<>();
        subDistricName= new ArrayList<>();
        recyclerView=findViewById(R.id.recycleview);
        adapter=new MyAdapter(this,name,mobileNumber,bkashNumber,districName,subDistricName);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

        //drawer section
        drawerLayout = findViewById(R.id.people_drawer_layout1);
        menu=findViewById(R.id.menu);
        homeimg = findViewById(R.id.drawerHome);
        //homeimg = findViewById(R.id.DrawerhomeLogo);
        doublepeopleimg = findViewById(R.id.drawerProfile);
        settingimg = findViewById(R.id.drawerSetting);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });

        homeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
                // redirectActivity(afterLoginPeopleHomePageActivity2.this,peopleLoginActivity2.class);
            }
        });

        settingimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(AllPeopledInformationActivity2.this,peopleSettingActivity2.class);
            }
        });
    }

    private  void displayData(){
        Cursor cursor=db.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(AllPeopledInformationActivity2.this,"No Entry Exsist",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                mobileNumber.add(cursor.getString(1));
                bkashNumber.add(cursor.getString(2));
                districName.add(cursor.getString(3));
                subDistricName.add(cursor.getString(4));
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

