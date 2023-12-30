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

public class helperPeoplereceiveMoneyHistoryActivity2 extends AppCompatActivity {
    selfPaymentDatabase db;
    RecyclerView recyclerView;
    ArrayList<String> name,ammount;
    historyAdapter adapter;
    TextView loginEmail;
    private DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout homeimg,settingimg,doublepeopleimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helper_peoplereceive_money_history2);

        String Pname= getIntent().getStringExtra("name");
        //loginEmail=findViewById(R.id.alllistheaderEmail);
        // loginEmail.setText(Pemail);
        db=new selfPaymentDatabase(this);
        name= new ArrayList<>();
        ammount= new ArrayList<>();
        recyclerView=findViewById(R.id.historyrecycleview);
        adapter=new historyAdapter(this,name,ammount);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData(Pname);

        drawerLayout = findViewById(R.id.drawer_layout);
        menu=findViewById(R.id.menu);
        homeimg = findViewById(R.id.ddrawerHome);
        //homeimg = findViewById(R.id.DrawerhomeLogo);
        doublepeopleimg = findViewById(R.id.ddrawerProfile);
        settingimg = findViewById(R.id.ddrawerSetting);
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
                redirectActivity(helperPeoplereceiveMoneyHistoryActivity2.this,peopleSettingActivity2.class);
            }
        });

    }
    //display Part
    private  void displayData(String pname){
        String Pname=pname;
        //Toast.makeText(donarViewAllpaylistActivity2.this,PEMAIL+"No Entry Exsist",Toast.LENGTH_SHORT).show();

        Cursor cursor=db.historygetdata(Pname.toString());
        if(cursor.getCount()==0){
            Toast.makeText(helperPeoplereceiveMoneyHistoryActivity2.this,"No Entry Exsist",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(3));
                ammount.add(cursor.getString(5));
            }
        }
    }
  //drawer part
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