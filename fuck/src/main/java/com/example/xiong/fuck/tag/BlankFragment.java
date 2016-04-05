package com.example.xiong.fuck.tag;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiong.fuck.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private ViewPager viewpager_ppt;

    private TabImgPageIndicator tab;
    private Fragment1 imgItemFragment;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment\
       View view =  inflater.inflate(R.layout.fragment_blank, container, false);
        viewpager_ppt = (ViewPager) view.findViewById(R.id.viewpager_ppt);
        tab = (TabImgPageIndicator) view.findViewById(R.id.tab);

        viewpager_ppt.setAdapter(new PptAdapter(getChildFragmentManager()));
        tab.setViewPager(viewpager_ppt);
        return view;
    }
    class PptAdapter extends FragmentPagerAdapter {

        public PptAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //每一张ppt的fragment
            imgItemFragment = new Fragment1();
            //设置对应的url地址
//            imgItemFragment.setOnPptItemClink(new PptItemFragment.pptItemClick() {
//                @Override
//                public void itemClick() {
//                    setVisibleOrNot();
//                }
//            });
//            imgItemFragment.sendImgResource(imgPptUrl.get(position));
            return imgItemFragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
//            return imgPptUrl.get(position);

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
        public int getCount() {
            return 5;
        }
    }
}
