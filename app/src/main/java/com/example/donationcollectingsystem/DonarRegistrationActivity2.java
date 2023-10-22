package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DonarRegistrationActivity2 extends AppCompatActivity {
    EditText name,email,phone,pass,conpass;
    TextView donarLogin;
    Button donarReg;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_registration2);
        name=findViewById(R.id.donarname);
        email=findViewById(R.id.donarmail);
        phone=findViewById(R.id.donarnumber);
        pass=findViewById(R.id.donarpassword);
        conpass=findViewById(R.id.donarconpassword);
        donarReg=findViewById(R.id.donarregbtn);
        donarLogin=findViewById(R.id.donar_reg_login);

        db = new DBHelper(this);
        donarReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = name.getText().toString();
                String mail = email.getText().toString();
                String number = phone.getText().toString();
                String pas = pass.getText().toString();
                String repass = conpass.getText().toString();

                if(username.equals("")||mail.equals("")||number.equals("")||pas.equals("")||repass.equals("")) {
                    Toast.makeText(DonarRegistrationActivity2.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }

                else{
                    if(pas.equals(repass)){
                        Boolean checkcompanyemail = db.checkemail(mail);
                        if(checkcompanyemail==false){
                            Boolean insert = db.insertData(username,mail,number, pas);
                            if(insert==true){
                                Toast.makeText(DonarRegistrationActivity2.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(DonarRegistrationActivity2.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(DonarRegistrationActivity2.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(DonarRegistrationActivity2.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }

//                Intent intent2=new Intent(DonarRegistrationActivity2.this,donarHomeActivity2.class);
//                startActivity(intent2);
            }
        });

        donarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DonarRegistrationActivity2.this, donarHomeActivity2.class);
                startActivity(intent);
            }
        });
    }
}