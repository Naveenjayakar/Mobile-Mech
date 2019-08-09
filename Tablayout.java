package com.sandbox.mobilemech;


import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Tablayout extends AppCompatActivity {

        Toolbar toolbar;
        TabLayout tabLayout;
        ViewPager viewPager;
        PageAdapter pageAdapter;
        TabItem tabstypes;
        TabItem tabbookings;
        TabItem tabhistory;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_service);


            toolbar = findViewById(R.id.toolbar);
            tabLayout = findViewById(R.id.tablayout);
            tabstypes = findViewById(R.id.tabstypes);
            tabbookings = findViewById(R.id.tabbookings);
            tabhistory = findViewById(R.id.tabhistory);
            viewPager = findViewById(R.id.viewPager);

            pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
            viewPager.setAdapter(pageAdapter);
            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));



            }


        }


