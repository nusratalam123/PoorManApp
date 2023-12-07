package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class donarMainHomePageActivity2 extends AppCompatActivity {
    private String selectDis,selectSubdis;
    TextView tvDisSpinner,tvSubDisSpinner;
    Spinner  DisSpinner,SubDisSpinner;
    ArrayAdapter<CharSequence> disAdepter,subDisAdapter;
    Button govt_btn,self_btn,user_btn;

    TextView donaremail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donar_main_home_page2);
        DisSpinner=findViewById(R.id.spinner_distric);
//        user_btn=findViewById(R.id.user_btn);
        donaremail=findViewById(R.id.donar_email);
        String email= getIntent().getStringExtra("email");
        donaremail.setText(email);
        disAdepter=ArrayAdapter.createFromResource(this,R.array.array_bd_distric,R.layout.spinner_layout);
        disAdepter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        DisSpinner.setAdapter(disAdepter);


        DisSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SubDisSpinner = findViewById(R.id.spinner_subdistric);
                selectDis = DisSpinner.getSelectedItem().toString();      //Obtain the selected State

                int parentID = parent.getId();
                if (parentID == R.id.spinner_distric){
                    switch (selectDis){
                        case "Select Your District": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_default_districts, R.layout.spinner_layout);
                            break;
                        case "Barguna": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_Barguna_districts, R.layout.spinner_layout);
                            break;
                        case "Barishal": subDisAdapter= ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_barishal_districts, R.layout.spinner_layout);
                            break;
                        case "Bhola": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_bhola_districts, R.layout.spinner_layout);
                            break;
                        case "Jhalokathi": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_jhalokathi_districts, R.layout.spinner_layout);
                            break;
                        case "Patuakhali": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.array_patuakhali_districts, R.layout.spinner_layout);
                            break;
                        case "Pirojpur": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Pirojpur, R.layout.spinner_layout);
                            break;
                        case "Bbaria": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Bbaria, R.layout.spinner_layout);
                            break;
                        case "Bandarban": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Bandarban, R.layout.spinner_layout);
                            break;
                        case "Chandpur": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Chandpur, R.layout.spinner_layout);
                            break;
                        case "Chattogram": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Chattogram, R.layout.spinner_layout);
                            break;
                        case "CoxsBazar": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.CoxsBazar, R.layout.spinner_layout);
                            break;
                        case "Cumilla": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Cumilla, R.layout.spinner_layout);
                            break;
                        case "Feni": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Feni, R.layout.spinner_layout);
                            break;
                        case "Khagrachari": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Khagrachari, R.layout.spinner_layout);
                            break;
                        case "Laxmipur": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Laxmipur, R.layout.spinner_layout);
                            break;
                        case "Noakhali": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Noakhali, R.layout.spinner_layout);
                            break;
                        case "Rangamati": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Rangamati, R.layout.spinner_layout);
                            break;
                        case "Dhaka": subDisAdapter  = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Dhaka, R.layout.spinner_layout);
                            break;
                        case "Faridpur": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Faridpur, R.layout.spinner_layout);
                            break;
                        case "Gazipur": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Gazipur, R.layout.spinner_layout);
                            break;
                        case "Gopalganj": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Gopalganj, R.layout.spinner_layout);
                            break;
                        case "Kishoreganj": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Kishoreganj, R.layout.spinner_layout);
                            break;
                        case "Madaripur": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Madaripur, R.layout.spinner_layout);
                            break;
                        case "Manikganj": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Manikganj, R.layout.spinner_layout);
                            break;
                        case "Munshiganj": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Munshiganj, R.layout.spinner_layout);
                            break;
                        case "Narayanganj": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Narayanganj, R.layout.spinner_layout);
                            break;
                        case "Narshingdi": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Narshingdi, R.layout.spinner_layout);
                            break;
                        case "Rajbari": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Rajbari, R.layout.spinner_layout);
                            break;
                        case "Shariatpur": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Shariatpur, R.layout.spinner_layout);
                            break;
                        case "Tangail": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Tangail, R.layout.spinner_layout);
                            break;
                        case "Bagerhat": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Bagerhat, R.layout.spinner_layout);
                            break;
                        case "Chuadanga": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Chuadanga, R.layout.spinner_layout);
                            break;
                        case "Jashore": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Jashore, R.layout.spinner_layout);
                            break;
                        case "Jhenaidah": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Jhenaidah, R.layout.spinner_layout);
                            break;
                        case "Khulna": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Khulna, R.layout.spinner_layout);
                            break;
                        case "Kushtia": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Kushtia, R.layout.spinner_layout);
                            break;
                        case "Magura": subDisAdapter = ArrayAdapter.createFromResource(parent.getContext(),
                                R.array.Magura, R.layout.spinner_layout);
                            break;
                        default:  break;
                    }
                    subDisAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);     // Specify the layout to use when the list of choices appears
                    SubDisSpinner.setAdapter(subDisAdapter);
                    SubDisSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            selectSubdis = SubDisSpinner.getSelectedItem().toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
                                     //To display the selected State and District
        govt_btn= findViewById(R.id.govtment_btn);
        self_btn= findViewById(R.id.selfPeople_btn);
        tvDisSpinner = findViewById(R.id.textview_distric);
        tvSubDisSpinner = findViewById(R.id.textview_subdistric);

//        govt_btn.setOnClickListener(v -> {
//            if (selectDis.equals("Select Your State")) {
//                Toast.makeText(donarMainHomePageActivity2.this, "Please select your state from the list", Toast.LENGTH_LONG).show();
//                tvDisSpinner.setError("District is required!");      //To set error on TextView
//                tvDisSpinner.requestFocus();
//            } else if (selectSubdis.equals("Select Your District")) {
//                Toast.makeText(donarMainHomePageActivity2.this, "Please select your district from the list", Toast.LENGTH_LONG).show();
//                tvSubDisSpinner.setError("District is required!");
//                tvSubDisSpinner.requestFocus();
//                tvDisSpinner.setError(null);                      //To reove error from stateSpinner
//            } else {
//                tvDisSpinner.setError(null);
//                tvSubDisSpinner.setError(null);
//                Toast.makeText(donarMainHomePageActivity2.this, "Selected State: "+selectDis+"\nSelected District: "+selectSubdis, Toast.LENGTH_LONG).show();
//            }
//        });



        govt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataPass.distric=selectDis.toString();
                dataPass.Thana=SubDisSpinner.getSelectedItem().toString();
                dataPass.email=email.toString();

                Toast.makeText(donarMainHomePageActivity2.this, "Selected State: "+selectDis+"\nSelected District: "+selectSubdis, Toast.LENGTH_LONG).show();
                Intent intent1=new Intent(donarMainHomePageActivity2.this, GovtInformationActivity2.class);
                //intent1.putExtra("district",selectDis);
                intent1.putExtra("thana",selectSubdis.toString()) ;
                startActivity(intent1);
            }
        });
        self_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(donarMainHomePageActivity2.this,peopleHomeActivity2.class);
                startActivity(intent);
            }
        });
    }
}