package com.example.passenger.Fragments.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class CircolazioneRealTimeFragmentPagerAdapter extends FragmentPagerAdapter {

    public ArrayList<Fragment> getFragmentsArrayList() {
        return fragmentsArrayList;
    }

    public ArrayList<String> getFragmentTitles() {
        return fragmentTitles;
    }

    private final ArrayList<Fragment> fragmentsArrayList = new ArrayList<>();
    private final ArrayList<String> fragmentTitles = new ArrayList<>();
    public CircolazioneRealTimeFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public CircolazioneRealTimeFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentsArrayList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsArrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitles.get(position);
    }

    public void addFragment(Fragment fragment, String fragmentTitle)
    {
        fragmentsArrayList.add(fragment);
        fragmentTitles.add(fragmentTitle);
    }
}
