package com.example.tour;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class TourGuideActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private NavigationView nv;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        dl = findViewById(R.id.drawer_layout);
        nv = findViewById(R.id.nvView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, toolbar, R.string.drawer_open, R.string.drawer_close);

        dl.setDrawerListener(toggle);
        toggle.syncState();
        final ViewPager viewPager = findViewById(R.id.viewpager);
        FragmentPagerAdapter fragmentPagerAdapter = new TourGuidePagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(fragmentPagerAdapter);


        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


        final ViewPager vp = findViewById(R.id.viewpager);
        PagerAdapter pa = new TourGuidePagerAdapter(getSupportFragmentManager(), this);
        TabLayout dot = findViewById(R.id.dots);
        vp.setAdapter(pa);

        dot.setupWithViewPager(vp);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                nv.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageSelected(int position) {
                nv.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


        nv.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        switch (menuItem.getItemId()) {
                            case R.id.f1:
                                viewPager.setCurrentItem(0);

                                break;
                            case R.id.f2:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.f3:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.f4:
                                viewPager.setCurrentItem(4);
                                break;
                            default:
                        }

                        dl.closeDrawers();
                        return true;
                    }
                });


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            dl.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}

