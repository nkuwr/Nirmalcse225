package com.example.tour;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.navigation.NavigationView;


public class TourGuidePagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 4;
    NavigationView nvDrawer;
    private String[] tabTitles = new String[]{
            NearbyFragment.NAME,
            HotelFragment.NAME,
            MallFragment.NAME,
            SightsFragment.NAME};
    private Context mContext;

    TourGuidePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = Fragment.instantiate(mContext, NearbyFragment.class.getName());


                break;

            case 1:
                fragment = Fragment.instantiate(mContext, HotelFragment.class.getName());
                break;

            case 2:
                fragment = Fragment.instantiate(mContext, MallFragment.class.getName());
                break;
            case 3:
                fragment = Fragment.instantiate(mContext, SightsFragment.class.getName());
                break;
        }
        assert fragment != null;
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
