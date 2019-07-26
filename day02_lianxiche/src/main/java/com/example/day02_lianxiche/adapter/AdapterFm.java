package com.example.day02_lianxiche.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class AdapterFm extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public AdapterFm(final FragmentManager fm) {
        super(fm);
    }

    public AdapterFm(final FragmentManager supportFragmentManager, final ArrayList<Fragment> fragments) {
        super(supportFragmentManager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(final int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
