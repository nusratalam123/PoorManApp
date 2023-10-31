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
    EditText dname,demail,dphone,dpass,dconpass;
    TextView donarLogin;
    Button donarReg;
    DBHelper donardb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_registration2);
        dname=findViewById(R.id.donarname);
        demail=findViewById(R.id.donarmail);
        dphone=findViewById(R.id.donarnumber);
        dpass=findViewById(R.id.donarpassword);
        dconpass=findViewById(R.id.donarconpassword);
        donarReg=findViewById(R.id.donarregbtn);
        donarLogin=findViewById(R.id.donar_reg_login);

        donardb = new DBHelper(this);
        donarReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = dname.getText().toString();
                String mail = demail.getText().toString();
                String number = dphone.getText().toString();
                String pas = dpass.getText().toString();
                String repass = dconpass.getText().toString();

                if(username.equals("")||mail.equals("")||number.equals("")||pas.equals("")||repass.equals("")) {
                    Toast.makeText(DonarRegistrationActivity2.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }

                else{
                    if(pas.equals(repass)){
                        Boolean checkcompanyemail = donardb.checkmail(mail);
                        if(checkcompanyemail==false){
                            Boolean insert = donardb.insertData(username,mail,number, pas);
                            if(insert==true){
                                Toast.makeText(DonarRegistrationActivity2.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),donarHomeActivity2.class);
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