package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class donarHomeActivity2 extends AppCompatActivity {
    EditText donaremail, password;
    Button btnlogin;
    DBHelper DB;
    TextView donarRegisterTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_home2);
        donaremail = (EditText) findViewById(R.id.donar_signin_email);
        password = (EditText) findViewById(R.id.donar_signin_password);
        btnlogin=(Button) findViewById(R.id.donar_Signin_btn);
        donarRegisterTxt=findViewById(R.id.donar_register);
        DB = new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String companyemail = donaremail.getText().toString();
                String pass = password.getText().toString();

                if(companyemail.equals("")||pass.equals(""))
                    Toast.makeText(donarHomeActivity2.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkMailandPass(companyemail, pass);
                    if(checkuserpass==true){
                        if(donaremail.getText().toString().equals("govt123@gmail.com")&&password.getText().toString().equals("g123")){
                            Intent intent  = new Intent(getApplicationContext(), adminHomeActivity2.class);
                            intent.putExtra("email",companyemail);
                            startActivity(intent);
                            Toast.makeText(donarHomeActivity2.this, "admin Sign in successfull", Toast.LENGTH_SHORT).show();
                        }
                        else{
                        Intent intent  = new Intent(getApplicationContext(), donarMainHomePageActivity2.class);
                        intent.putExtra("email",companyemail);
                        startActivity(intent);
                        Toast.makeText(donarHomeActivity2.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(donarHomeActivity2.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        donarRegisterTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(donarHomeActivity2.this,DonarRegistrationActivity2.class);
                startActivity(intent2);
            }
        });
    }
}