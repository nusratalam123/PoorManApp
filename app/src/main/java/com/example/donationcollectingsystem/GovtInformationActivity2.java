package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GovtInformationActivity2 extends AppCompatActivity {
     private TextView districtName,thanaName,bankAc;
     Button okbtn;
     responseDatabase db;

    private DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout homeimg,settingimg,doublepeopleimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt_information2);
        districtName=findViewById(R.id.show_dis_govt_page);
        thanaName=findViewById(R.id.showThanaName);
        bankAc=findViewById(R.id.bankAcNumber);
        okbtn=findViewById(R.id.okbtn);
       // String ThaName= getIntent().getStringExtra("thana").toString();
        String DisName=govtdata.distric;
        String ThaName= govtdata.Thana;
        String Demail=govtdata.email;
        //String dname=dataPass.name;
       // String dnumber=dataPass.number;
        districtName.setText(DisName);
        thanaName.setText(ThaName.toString());
        db = new responseDatabase(this);
        Toast.makeText(GovtInformationActivity2.this, "sub distric"+ThaName+"email"+Demail, Toast.LENGTH_SHORT).show();

        okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String rname = dataPass.name.toString();
               // String remail = dataPass.email.toString();
               // String rnumber = dataPass.number.toString();
                String rbank = bankAc.getText().toString();
                String rdistric=districtName.getText().toString();
                String rthana=thanaName.getText().toString();
                Toast.makeText(GovtInformationActivity2.this, "sub distric"+rbank+"email"+rdistric+rthana+Demail, Toast.LENGTH_SHORT).show();

                if(Demail.equals("")||rbank.equals("")||rdistric.equals("")||rthana.equals("")) {
                    Toast.makeText(GovtInformationActivity2.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }

                else{
                    Boolean insert = db.insertresponselist(Demail,rbank, rdistric,rthana);
                    if(insert==true){
                        Toast.makeText(GovtInformationActivity2.this, "Data send successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),peopleLoginActivity2.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(GovtInformationActivity2.this, "Data send failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


        drawerLayout = findViewById(R.id.govtDrawer);
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
                redirectActivity(GovtInformationActivity2.this,peopleSettingActivity2.class);
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