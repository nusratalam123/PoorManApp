package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfterLogindonarHomePageActivity2 extends AppCompatActivity {
    TextView email,email1;
    Button viewAllPaybtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_logindonar_home_page2);

        email=findViewById(R.id.PersonLoginEmail);
//        user_btn=findViewById(R.id.user_btn);
        email1=findViewById(R.id.PersonLoginEmailTwo);
        viewAllPaybtn=findViewById(R.id.viewAllPayList);
        String Pemail= getIntent().getStringExtra("email");
        email.setText(Pemail);
        email1.setText(Pemail);
        viewAllPaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AfterLogindonarHomePageActivity2.this,donarViewAllpaylistActivity2.class);
                intent.putExtra("email",Pemail);
                startActivity(intent);
            }
        });
    }
}