package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class donarMainHomePageActivity2 extends AppCompatActivity {
    Button admin_btn,distric_btn,user_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_main_home_page2);
        admin_btn=findViewById(R.id.admin_btn);
        distric_btn=findViewById(R.id.distric_btn);
        user_btn=findViewById(R.id.user_btn);
        admin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(donarMainHomePageActivity2.this, DonarAdminPayPageActivity2.class);
                startActivity(intent1);
            }
        });
        distric_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(donarMainHomePageActivity2.this, DonarDistricPayPageActivity2.class);
                startActivity(intent1);
            }
        });
        user_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(donarMainHomePageActivity2.this, DonarUserPayPageActivity2.class);
                startActivity(intent1);
            }
        });
    }
}