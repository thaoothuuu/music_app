package com.example.music_app.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.music_app.R;
import com.example.music_app.adapter.MainViewPagerAdapter;
import com.example.music_app.fragment.fragment_Tim_kiem;
import com.example.music_app.fragment.fragment_Trang_chu;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new fragment_Trang_chu(),"Trang Chủ");
        mainViewPagerAdapter.addFragment(new fragment_Tim_kiem(), "Tìm Kiếm");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.iconhome);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontim);
    }

    private void anhxa() {
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
        
    }
}