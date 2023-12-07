package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.donationcollectingsystem.databinding.ActivityPaymentPage2Binding;
import com.help5g.uddoktapaysdk.UddoktaPay;

import java.util.HashMap;
import java.util.Map;

public class PaymentPageActivity2 extends AppCompatActivity {
    ImageView HomeLogo,DonationPageLogo,PeopleLogo,SettingLogo;
    // Constants for payment
    private static final String API_KEY = "982d381360a69d419689740d9f2e26ce36fb7a50";
    private static final String CHECKOUT_URL = "https://sandbox.uddoktapay.com/api/checkout-v2";
    private static final String VERIFY_PAYMENT_URL = "https://sandbox.uddoktapay.com/api/verify-payment";
    private static final String REDIRECT_URL = "https://uddoktapay.com";
    private static final String CANCEL_URL = "https://uddoktapay.com";

    // Instance variables to store payment information
    private String storedFullName;
    private String storedEmail;
    private String storedAmount;
    private String storedInvoiceId;
    private String storedPaymentMethod;
    private String storedSenderNumber;
    private String storedTransactionId;
    private String storedDate;
    private String storedFee;
    private String storedChargedAmount;

    private String storedMetaKey1;
    private String storedMetaValue1;

    private String storedMetaKey2;
    private String storedMetaValue2;

    private String storedMetaKey3;
    private String storedMetaValue3;
    private ActivityPaymentPage2Binding binding;
    selfPaymentDatabase db;
    TextView pName,pDistric,pmobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_payment_page2);

        binding=ActivityPaymentPage2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        pName=findViewById(R.id.pUserName);
        String PayName=paymentPassInfo.name;
        pName.setText(PayName);
        pDistric=findViewById(R.id.pUserDistric);
        String Paydis=paymentPassInfo.distric;
        pDistric.setText(Paydis);
        pmobile=findViewById(R.id.pUserMobileNumber);
        String Paymobile=paymentPassInfo.mobile;
        pmobile.setText(Paymobile);
        db = new selfPaymentDatabase(this);


        //String Aname=(intent.getStringExtra("name"));
        //Toast.makeText(PaymentPageActivity2.this, "name"+stroename, Toast.LENGTH_SHORT).show();

        binding.homeLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PaymentPageActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });

        binding.peoplepageLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PaymentPageActivity2.this,peopleLoginActivity2.class);
                startActivity(intent);
            }
        });
        binding.donationPageLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PaymentPageActivity2.this,donarHomeActivity2.class);
                startActivity(intent);
            }
        });

        binding.settingsLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(PaymentPageActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
        binding.userPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.uilayout.setVisibility(View.GONE);
                binding.webLayout.setVisibility(View.VISIBLE);

                String uname=binding.userName.getText().toString();
                String uemail=binding.userEmail.getText().toString();
                String uamount=binding.userAmount.getText().toString();
                // Set your metadata values in the map
                Map<String, String> metadataMap = new HashMap<>();
                metadataMap.put("CustomMetaData1", "Meta Value 1");
                metadataMap.put("CustomMetaData2", "Meta Value 2");
                metadataMap.put("CustomMetaData3", "Meta Value 3");


                UddoktaPay.PaymentCallback paymentCallback = new UddoktaPay.PaymentCallback() {
                    @Override
                    public void onPaymentStatus(String status, String fullName, String email, String amount, String invoiceId,
                                                String paymentMethod, String PayMobile, String transactionId,
                                                String date, Map<String, String> metadataValues, String fee,String chargeAmount) {
                        Intent intent=new Intent();
                        // Callback method triggered when the payment status is received from the payment gateway.
                        // It provides information about the payment transaction.
                        storedFullName = binding.userName.getText().toString();
                        storedEmail = binding.userEmail.getText().toString();
                        storedAmount = binding.userAmount.getText().toString();
                        storedInvoiceId = invoiceId;
                        storedPaymentMethod = paymentMethod;
                        storedSenderNumber=binding.pUserMobileNumber.getText().toString() ;
                        storedTransactionId = transactionId;
                        storedDate = date;
                        storedFee = fee;
                        storedChargedAmount = chargeAmount;

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // Clear previous metadata values to avoid duplication
                                storedMetaKey1 = null;
                                storedMetaValue1 = null;
                                storedMetaKey2 = null;
                                storedMetaValue2 = null;
                                storedMetaKey3 = null;
                                storedMetaValue3 = null;

                                // Iterate through the metadata map and store the key-value pairs
                                for (Map.Entry<String, String> entry : metadataValues.entrySet()) {
                                    String metadataKey = entry.getKey();
                                    String metadataValue = entry.getValue();

                                    if ("CustomMetaData1".equals(metadataKey)) {
                                        storedMetaKey1 = metadataKey;
                                        storedMetaValue1 = metadataValue;
                                    } else if ("CustomMetaData2".equals(metadataKey)) {
                                        storedMetaKey2 = metadataKey;
                                        storedMetaValue2 = metadataValue;
                                    } else if ("CustomMetaData3".equals(metadataKey)) {
                                        storedMetaKey3 = metadataKey;
                                        storedMetaValue3 = metadataValue;
                                    }
                                }

                                // Update UI based on payment status
                                if ("COMPLETED".equals(status)) {

                                  //  Toast.makeText(PaymentPageActivity2.this, "name"+Aname, Toast.LENGTH_SHORT).show();
                                    Boolean insert = db.insertPaymentData(PayName,Paydis,Paymobile,storedFullName,storedEmail,storedAmount, storedTransactionId,storedDate,storedPaymentMethod);
                                    if(insert==true){
                                        Toast.makeText(PaymentPageActivity2.this, "Data Insert successfuly", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),peopleLoginActivity2.class);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(PaymentPageActivity2.this, "Data Insert failed", Toast.LENGTH_SHORT).show();
                                    }
                                    binding.uilayout.setVisibility(View.VISIBLE);
                                    binding.webLayout.setVisibility(View.GONE);




                                    binding.paymentResult.setText("payment status:"+"complete"+"\n"+"Name:"+storedFullName+"\n"+"Email:"+storedEmail+"\n"+"Amount:"+storedAmount);


                                } else if ("PENDING".equals(status)) {

                                    binding.uilayout.setVisibility(View.VISIBLE);
                                    binding.webLayout.setVisibility(View.GONE);
                                    binding.paymentResult.setText("payment status:"+"Pending"+"\n"+"Name:"+storedFullName+"\n"+"Email:"+storedEmail+"\n"+"Amount:"+storedAmount);
                                    // Handle payment pending case
                                } else if ("ERROR".equals(status)) {
                                    // Handle payment error case
                                    binding.uilayout.setVisibility(View.VISIBLE);
                                    binding.webLayout.setVisibility(View.GONE);
                                }
                            }
                        });
                    }
                };

                UddoktaPay uddoktapay = new UddoktaPay(binding.payWebView, paymentCallback);
                uddoktapay.loadPaymentForm(API_KEY, uname, uemail, uamount, CHECKOUT_URL, VERIFY_PAYMENT_URL, REDIRECT_URL, CANCEL_URL, metadataMap);

            }
        });

    }
}