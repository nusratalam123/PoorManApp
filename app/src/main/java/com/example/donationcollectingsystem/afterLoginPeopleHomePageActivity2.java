package com.example.donationcollectingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class afterLoginPeopleHomePageActivity2 extends AppCompatActivity  {
    private DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout homeimg,settingimg,doublepeopleimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login_people_home_page2);
        drawerLayout = findViewById(R.id.drawer_layout);
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
                redirectActivity(afterLoginPeopleHomePageActivity2.this,peopleSettingActivity2.class);
            }
        });
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