package com.example.xiong.xionglearing.xcc.ancitvity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.xiong.xionglearing.R;
import com.example.xiong.xionglearing.xcc.fragment.FragmentHome;
import com.example.xiong.xionglearing.xcc.fragment.FragmentStudy;
import com.example.xiong.xionglearing.xcc.fragment.SettingFragment;
import com.example.xiong.xionglearing.xcc.pagertab.OnTabSelectedListener;
import com.example.xiong.xionglearing.xcc.pagertab.ViewPagerTab;

import java.util.ArrayList;
import java.util.List;

public class PageTabActivity extends AppCompatActivity {
    private List<Fragment> list;
    ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_tab);
        Resources res = getResources();
        list = new ArrayList<>();
        Fragment fragment;
        fragment = new FragmentHome();
        list.add(fragment);
        fragment = new FragmentStudy();
        list.add(fragment);
        fragment = new SettingFragment();
        list.add(fragment);
        vp = (ViewPager) findViewById(R.id.vp);
        mTab = (ViewPagerTab) findViewById(R.id.pagerTab);
        vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mTab.setIndicatorColor(res.getColor(R.color.sw_bg_bar_on_color));
        mTab.setTitleColor(Color.BLACK);
        mTab.setTitleColorSelected(Color.WHITE);
        mTab.bindPager(vp);


        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

            @Override
            public void onPageSelected(int position) {
                mTab.setCurrentTab(position);
            }
        });
        mTab.setTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                vp.setCurrentItem(position);
            }
        });
    }

    private ViewPagerTab mTab;

    class MyAdapter extends FragmentPagerAdapter {


        public MyAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "首页";
                case 1:
                    return "学习";
                case 2:
                    return "设置";
                default:
                    return "设置";
            }
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }


}
