package com.example.donationcollectingsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button people,donar,login,register;

    ViewPager mSLideViewPager;
    LinearLayout mDotLayout;
    Button backbtn, nextbtn, skipbtn;

    TextView[] dots;
    viewPageAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        people=findViewById(R.id.people_btn);
        donar=findViewById(R.id.donar_btn);
       // login=findViewById(R.id.main_login);
       // register=findViewById(R.id.main_register);
        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MainActivity.this,peopleLoginActivity2.class);
                startActivity(intent1);
            }
        });
        donar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(MainActivity.this,donarHomeActivity2.class);
                startActivity(intent2);
            }
        });
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent3=new Intent(MainActivity.this,loginPageActivity2.class);
//                startActivity(intent3);
//            }
//        });
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent3=new Intent(MainActivity.this, RegisterPageActivity2.class);
//                startActivity(intent3);
//            }
//        });

        backbtn = findViewById(R.id.backbtn);
        nextbtn = findViewById(R.id.nextbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getitem(0) > 0){

                    mSLideViewPager.setCurrentItem(getitem(-1),true);

                }

            }
        });

//        nextbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (getitem(0) < 3)
//                    mSLideViewPager.setCurrentItem(getitem(1),true);
//                else {
//
//                    Intent i = new Intent(MainActivity.this,mainScreenActivity2.class);
//                    startActivity(i);
//                    finish();
//
//                }
//
//            }
//        });
        mSLideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.indicator_layout);

        viewPagerAdapter = new viewPageAdapter(this);

        mSLideViewPager.setAdapter(viewPagerAdapter);

        setUpindicator(0);
        mSLideViewPager.addOnPageChangeListener(viewListener);

    }

    public void setUpindicator(int position){

        dots = new TextView[4];
        mDotLayout.removeAllViews();

        for (int i = 0 ; i < dots.length ; i++){

            dots[i] = new TextView(this);
            // dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));
            mDotLayout.addView(dots[i]);

        }

        dots[position].setTextColor(getResources().getColor(R.color.active,getApplicationContext().getTheme()));

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            setUpindicator(position);

            if (position > 0){

                backbtn.setVisibility(View.VISIBLE);

            }else {

                backbtn.setVisibility(View.INVISIBLE);

            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private int getitem(int i){

        return mSLideViewPager.getCurrentItem() + i;
    }
}