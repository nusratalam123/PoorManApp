package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class peopleLoginActivity2 extends AppCompatActivity {
    EditText pmobile ,Ppass;
    Button PeopleLogin;
    TextView peopleReg;
    DBHelper1 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_login2);
        peopleReg=findViewById(R.id.people_register);
        pmobile = (EditText) findViewById(R.id.people_login_number);
        Ppass = (EditText) findViewById(R.id.people_login_password);
        PeopleLogin=(Button) findViewById(R.id.people_login_btn);

        DB = new DBHelper1(this);

        PeopleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Peoplemobile = pmobile.getText().toString();
                String peoplepas = Ppass.getText().toString();

                if(Peoplemobile.equals("")||peoplepas.equals("")) {
                    Toast.makeText(peopleLoginActivity2.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkMobileandPass = DB.checkMobileandPass(Peoplemobile, peoplepas);
                    if(checkMobileandPass==true){
                        Toast.makeText(peopleLoginActivity2.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(),peopleHomeActivity2.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(peopleLoginActivity2.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        peopleReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(peopleLoginActivity2.this, RegisterPageActivity2.class);
                startActivity(intent2);
            }
        });
    }

}