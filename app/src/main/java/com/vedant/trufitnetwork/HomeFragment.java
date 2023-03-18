package com.vedant.trufitnetwork;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        FragmentPagerAdapter myPageProf;
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout_home);


        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager_home);

        myPageProf = new MyPageProfile(getChildFragmentManager());

        viewPager.setAdapter(myPageProf);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;
    }
    public static class MyPageProfile extends FragmentPagerAdapter{
        private static int NUM_ITEMS = 2;

        public MyPageProfile(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new HomeDashboard();
                case 1:
                    return new NewsFragment();
                default:
                    return new HomeDashboard();
            }
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    }
}