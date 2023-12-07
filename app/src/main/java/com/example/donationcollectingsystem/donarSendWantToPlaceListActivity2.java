package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class donarSendWantToPlaceListActivity2 extends AppCompatActivity {
    EditText bankAc;
    Button okbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_send_want_to_place_list2);
        bankAc=findViewById(R.id.bankAcNumber);
        okbtn=findViewById(R.id.okbtn);

    }
}