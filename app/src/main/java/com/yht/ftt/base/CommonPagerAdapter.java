package com.yht.ftt.base;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class CommonPagerAdapter extends FragmentPagerAdapter {


    private ArrayList<Fragment> fragments;
    private List<String> titles;


    public CommonPagerAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> fragments, List titles) {
        super(fm);

        this.fragments = fragments;
        this.titles = titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size()==0?0:fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Nullable
    @Override
    public Parcelable saveState() {
        return null;
    }
}


