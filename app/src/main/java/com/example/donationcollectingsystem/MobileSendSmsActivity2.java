package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MobileSendSmsActivity2 extends AppCompatActivity {
    EditText mobile,text;
    Button sendSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_send_sms2);
        mobile=findViewById(R.id.SMSnumber);
        String mobileNumber=getIntent().getStringExtra("mobile").toString();
        mobile.setText(mobileNumber);

        Toast.makeText(MobileSendSmsActivity2.this, "Mobile Number"+mobileNumber, Toast.LENGTH_SHORT).show();

        text=findViewById(R.id.SMStext);
        sendSms=findViewById(R.id.SMSbtn);

        sendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(ContextCompat.checkSelfPermission(MobileSendSmsActivity2.this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED)
              {
                  sendSMS();
              }
              else{
                  ActivityCompat.requestPermissions(MobileSendSmsActivity2.this,new String[]{Manifest.permission.SEND_SMS},
                          100);
              }

            }
        });
    }

    public  void  onRequestPermissionResult(int requestCode,String[] permission,int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permission,grantResults);

        if(requestCode==100 &&grantResults.length>0 &&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            sendSMS();
        }
        else {
            Toast.makeText(MobileSendSmsActivity2.this, "Permission Failed", Toast.LENGTH_SHORT).show();

        }

    }
        private void sendSMS() {
            String mobileNum=mobile.getText().toString().trim();
            String sendText=text.getText().toString().trim();
            if(!mobileNum.equals("")&&!sendText.equals("")){
                SmsManager smsManager= SmsManager.getDefault();
                smsManager.sendTextMessage(mobileNum,null,sendText,null,null);
                Toast.makeText(MobileSendSmsActivity2.this, "Message is sent successfully", Toast.LENGTH_SHORT).show();
            }

           else {
                Toast.makeText(MobileSendSmsActivity2.this, "Message is sent failed", Toast.LENGTH_SHORT).show();
            }

        }

}

