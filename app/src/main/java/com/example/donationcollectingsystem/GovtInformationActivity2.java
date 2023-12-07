package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GovtInformationActivity2 extends AppCompatActivity {
     private TextView districtName,thanaName,bankAc;
     Button okbtn;
     responseDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt_information2);
        districtName=findViewById(R.id.show_dis_govt_page);
        thanaName=findViewById(R.id.showThanaName);
        bankAc=findViewById(R.id.bankAcNumber);
        okbtn=findViewById(R.id.okbtn);
       // String ThaName= getIntent().getStringExtra("thana").toString();
        String DisName=dataPass.distric;
        String ThaName= dataPass.Thana;
        String Demail=dataPass.email;
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


    }
}