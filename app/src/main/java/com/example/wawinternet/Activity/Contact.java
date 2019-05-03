package com.example.wawinternet.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.wawinternet.MyPager;
import com.example.wawinternet.R;

import me.relex.circleindicator.CircleIndicator;


public class Contact extends AppCompatActivity {
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private MyPager myPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        myPager = new MyPager(this);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(myPager);
        circleIndicator = findViewById(R.id.circle);
        circleIndicator.setViewPager(viewPager);

    }


}