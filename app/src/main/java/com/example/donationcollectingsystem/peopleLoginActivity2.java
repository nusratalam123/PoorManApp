package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class peopleLoginActivity2 extends AppCompatActivity {
    EditText pmobile ,Ppass,pname;
    Button PeopleLogin;
    ImageView arrow;
    TextView peopleReg;
    DBHelper1 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_login2);
        arrow=findViewById(R.id.arraow);
        peopleReg=findViewById(R.id.people_register);
        pname = (EditText) findViewById(R.id.people_name);
        pmobile = (EditText) findViewById(R.id.people_login_number);
        Ppass = (EditText) findViewById(R.id.people_login_password);
        PeopleLogin=(Button) findViewById(R.id.people_login_btn);

        DB = new DBHelper1(this);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(peopleLoginActivity2.this, MainActivity.class);
                startActivity(intent2);
            }
        });

        PeopleLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Pname=pname.getText().toString();
                String Peoplemobile = pmobile.getText().toString();
                String peoplepas = Ppass.getText().toString();

                if(Pname.equals("")||Peoplemobile.equals("")||peoplepas.equals("")) {
                    Toast.makeText(peopleLoginActivity2.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkMobileandPass = DB.checkMobileandPass(Pname,Peoplemobile, peoplepas);
                    if(checkMobileandPass==true){
                        Toast.makeText(peopleLoginActivity2.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(peopleLoginActivity2.this, AllPeopledInformationActivity2.class);
                       //   Intent intent1=new Intent(peopleLoginActivity2.this, peopleHomeActivity2.class);
                       // Intent intent1=new Intent(peopleLoginActivity2.this, afterLoginPeopleHomePageActivity2.class);

                        intent1.putExtra("name",Pname);
                        startActivity(intent1);
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