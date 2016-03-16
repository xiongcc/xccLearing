package com.example.xiong.xionglearing.xcc.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiong.xionglearing.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMy extends Fragment {


    public FragmentMy() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_my, container, false);
    }

}
