package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class donarSendingMoneyListActivity2 extends AppCompatActivity {
    EditText senderName,senderEmail,senderNumber,senderbank,sendingAmmount,date,senderdistric,senderthana;
    Button sendbtn;
    senderListDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_sending_money_list2);
        senderName=findViewById(R.id.senderName);
        senderEmail=findViewById(R.id.senderEmail);
        senderNumber=findViewById(R.id.senderNumber);
        senderbank=findViewById(R.id.senderBankNumber);
        sendingAmmount=findViewById(R.id.amountMoney);
        date=findViewById(R.id.date);
        senderdistric=findViewById(R.id.senderdistric);
        senderthana=findViewById(R.id.senderThana);

        sendbtn=findViewById(R.id.send);
        db = new senderListDatabase(this);

        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname = senderName.getText().toString();
                String semail = senderEmail.getText().toString();
                String snumber = senderNumber.getText().toString();
                String sbank = senderbank.getText().toString();
                String sammount=sendingAmmount.getText().toString();
                String sdate=date.getText().toString();
                String sdistric=senderdistric.getText().toString();
                String sthana=senderthana.getText().toString();
                if(sname.equals("")||semail.equals("")||snumber.equals("")||sbank.equals("")||sammount.equals("")||sdate.equals("")||sdistric.equals("")||sthana.equals("")) {
                    Toast.makeText(donarSendingMoneyListActivity2.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }

                else{
                            Boolean insert = db.insertDatalist(sname,semail,snumber,sbank,sammount,sdate, sdistric,sthana);
                            if(insert==true){
                                Toast.makeText(donarSendingMoneyListActivity2.this, "Data send successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),peopleLoginActivity2.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(donarSendingMoneyListActivity2.this, "Data send failed", Toast.LENGTH_SHORT).show();
                            }
                }

            }
        });
    }
}