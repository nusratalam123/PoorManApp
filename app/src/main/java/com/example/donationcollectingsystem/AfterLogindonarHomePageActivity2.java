package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AfterLogindonarHomePageActivity2 extends AppCompatActivity {
    TextView email,email1,dlogoutbtn;
    Button viewAllPaybtn;
    ImageView arrowbtn,donarPagearrow;

    selfPaymentDatabase db;
    RecyclerView recyclerView;
    ArrayList<String> name,ammount;
    dPayAlladapter adapter;
    TextView loginEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_logindonar_home_page2);

        email=findViewById(R.id.PersonLoginEmail);
        donarPagearrow=findViewById(R.id.donarPagearraow);
        dlogoutbtn=findViewById(R.id.DonarlogoutBtn);
//        user_btn=findViewById(R.id.user_btn);
        email1=findViewById(R.id.PersonLoginEmailTwo);
        viewAllPaybtn=findViewById(R.id.viewAllPayList);
        arrowbtn=findViewById(R.id.donarpayarrow);
        String Pemail= getIntent().getStringExtra("email");
        email.setText(Pemail);
        email1.setText(Pemail);

        db=new selfPaymentDatabase(this);
        name= new ArrayList<>();
        ammount= new ArrayList<>();
        recyclerView=findViewById(R.id.Dpayrecycleviewlist);
        adapter=new dPayAlladapter(this,name,ammount);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData(Pemail);
        donarPagearrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AfterLogindonarHomePageActivity2.this,donarHomeActivity2.class);
                intent.putExtra("email",Pemail);
                startActivity(intent);
            }
        });
        dlogoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AfterLogindonarHomePageActivity2.this,donarHomeActivity2.class);
                intent.putExtra("email",Pemail);
                startActivity(intent);
            }
        });
        arrowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AfterLogindonarHomePageActivity2.this,donarMainHomePageActivity2.class);
                intent.putExtra("email",Pemail);
                startActivity(intent);
            }
        });
        viewAllPaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AfterLogindonarHomePageActivity2.this,donarViewAllpaylistActivity2.class);
                intent.putExtra("email",Pemail);
                startActivity(intent);
            }
        });
    }

    private  void displayData(String pemail){
        String PEMAIL=pemail;
        //Toast.makeText(donarViewAllpaylistActivity2.this,PEMAIL+"No Entry Exsist",Toast.LENGTH_SHORT).show();

        Cursor cursor=db.getdata(PEMAIL.toString());
        if(cursor.getCount()==0){
            Toast.makeText(AfterLogindonarHomePageActivity2.this,"No Entry Exsist",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                name.add(cursor.getString(0));
                ammount.add(cursor.getString(5));
            }
        }
    }
}