package com.example.mentos;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.mentos.Fragment.MainFragment;
import com.example.mentos.Fragment.MenuFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_temp;
    Button btn_temp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);

        ViewPagerAdpater viewPagerAdpater = new ViewPagerAdpater(getSupportFragmentManager());
        viewPagerAdpater.addFragment(new MainFragment(), "메인");
        viewPagerAdpater.addFragment(new MenuFragment(), "메뉴");

        viewPager.setAdapter(viewPagerAdpater);

        tabLayout.setupWithViewPager(viewPager);

    }

    class ViewPagerAdpater extends FragmentPagerAdapter {

        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;

        ViewPagerAdpater(FragmentManager fm) {
            super(fm);
            this.fragments = new ArrayList<>();
            this.titles = new ArrayList<>();
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            titles.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
