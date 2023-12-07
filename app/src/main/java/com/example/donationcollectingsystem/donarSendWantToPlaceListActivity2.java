package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class donarSendWantToPlaceListActivity2 extends AppCompatActivity {

    responseDatabase db;
    ImageView HomeLogo,DonationPageLogo,PeopleLogo,SettingLogo;
    RecyclerView recyclerView;
    ArrayList<String> email,banknumber,distric,thana;;
    myAdapter4 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_send_want_to_place_list2);
        db=new responseDatabase(this);
        email= new ArrayList<>();
        banknumber= new ArrayList<>();
        distric= new ArrayList<>();
        thana= new ArrayList<>();
        recyclerView=findViewById(R.id.responseListrecycleview);
        adapter=new myAdapter4(this,email,banknumber,distric,thana);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        responsedisplayData();

    }

    private  void responsedisplayData(){
        Cursor cursor=db.responseListgetdata();
        if(cursor.getCount()==0){
            Toast.makeText(donarSendWantToPlaceListActivity2.this,"No Entry Exsist",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                email.add(cursor.getString(0));
                banknumber.add(cursor.getString(2));
                distric.add(cursor.getString(1));
                thana.add(cursor.getString(3));
                //subDistricName.add(cursor.getString(5));
            }
        }
    }
}