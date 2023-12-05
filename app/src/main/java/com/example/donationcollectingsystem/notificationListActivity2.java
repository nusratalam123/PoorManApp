package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class notificationListActivity2 extends AppCompatActivity {
    EditText email,content,subject;
    Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_list2);
        email=findViewById(R.id.nEmail);
        subject=findViewById(R.id.nSub);
        content=findViewById(R.id.nContent);
        send=findViewById(R.id.send);
        String sEmail= getIntent().getStringExtra("email");
        email.setText(sEmail);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sub=subject.getText().toString();
                String text=content.getText().toString();
                if(sEmail.equals("")&&sub.equals("")&&text.equals("")){
                    Toast.makeText(notificationListActivity2.this, "ALl field must be required", Toast.LENGTH_SHORT).show();
                }
                else {
                    sendEmail(sEmail, sub, text);
//                    Intent intent=new Intent(notificationListActivity2.this,donarSendingMoneyInfoshowlistActivity2.class);
//                    startActivity(intent);
                }
            }
        });
    }

    public void sendEmail(String to_email,String subject,String content){
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{to_email});
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,content);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Chosse email to sender"));
    }
}