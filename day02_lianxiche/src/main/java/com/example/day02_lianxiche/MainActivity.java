package com.example.day02_lianxiche;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.day02_lianxiche.adapter.AdapterFm;
import com.example.day02_lianxiche.fragment.AFragment;
import com.example.day02_lianxiche.fragment.BFragment;

import java.util.ArrayList;

//李艳雷  1812B
public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> fragments;
    private AdapterFm adapterFm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        fragments = new ArrayList<>();
        fragments.add(new AFragment());
        fragments.add(new BFragment());
        adapterFm = new AdapterFm(getSupportFragmentManager(), fragments);
        mVp.setAdapter(adapterFm);
        mTab.setupWithViewPager(mVp);

        mTab.getTabAt(0).setCustomView(R.layout.fma);
        mTab.getTabAt(1).setCustomView(R.layout.fmb);
    }
}
