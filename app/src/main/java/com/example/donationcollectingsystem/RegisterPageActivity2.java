package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterPageActivity2 extends AppCompatActivity {
     EditText name,mobile,bkash,national_id,pass,conPass;
     TextView loginTxt;
     Button peopleReg;
     DBHelper1 db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page2);
        loginTxt=findViewById(R.id.reg_login);
        name=findViewById(R.id.people_name);
        mobile=findViewById(R.id.peoplephonenumber);
        national_id=findViewById(R.id.people_national_id);
        bkash=findViewById(R.id.people_bkash_number);
        pass=findViewById(R.id.password);
        peopleReg=findViewById(R.id.registerbtn);
        conPass=findViewById(R.id.con_password);
        db = new DBHelper1(this);

        peopleReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pname = name.getText().toString();
                String Mobile = mobile.getText().toString();
                String nid = national_id.getText().toString();
                String Bkash = bkash.getText().toString();
                String pas = pass.getText().toString();
                String conpass = conPass.getText().toString();
                if(pname.equals("")||Mobile.equals("")||nid.equals("")||Bkash.equals("")||pas.equals("")||conpass.equals("")) {
                    Toast.makeText(RegisterPageActivity2.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }

                else{
                    if(pas.equals(conpass)){
                        Boolean checkmobile = db.checkmobile(Mobile);
                        if(checkmobile==false){
                            Boolean insert = db.insertData1(pname,Mobile,nid,Bkash, pas);
                            if(insert==true){
                                Toast.makeText(RegisterPageActivity2.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),peopleLoginActivity2.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(RegisterPageActivity2.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(RegisterPageActivity2.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterPageActivity2.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }


        });
        loginTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(RegisterPageActivity2.this, peopleLoginActivity2.class);
                startActivity(intent1);
            }
        });
    }
}