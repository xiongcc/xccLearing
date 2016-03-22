package com.example.xiong.xionglearing.xcc.ancitvity;

import android.content.res.Resources;
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
import com.example.xiong.xionglearing.xcc.pagertab.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

public class PageTabMoveActivity extends AppCompatActivity {
    private List<Fragment> list;
    ViewPager vp;
    TabPageIndicator mTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_tab_move);
        vp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabPageIndicator) findViewById(R.id.pagerTab);
        Resources res = getResources();
        list = new ArrayList<>();
        Fragment fragment;
        fragment = new FragmentHome();
        list.add(fragment);
        fragment = new FragmentStudy();
        list.add(fragment);
        fragment = new SettingFragment();
        list.add(fragment);
        fragment = new FragmentHome();
        list.add(fragment);
        fragment = new FragmentStudy();
        list.add(fragment);
        fragment = new SettingFragment();
        list.add(fragment);
        fragment = new FragmentHome();
        list.add(fragment);
        fragment = new FragmentStudy();
        list.add(fragment);
        fragment = new SettingFragment();
        list.add(fragment);
        fragment = new FragmentHome();
        list.add(fragment);
        fragment = new FragmentStudy();
        list.add(fragment);
        fragment = new SettingFragment();
        list.add(fragment);
        vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        mTab.setViewPager(vp);
    }

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
