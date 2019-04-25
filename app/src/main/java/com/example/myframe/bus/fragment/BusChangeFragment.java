package com.example.myframe.bus.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myframe.R;

/**
 * Created by Administrator on 2019/4/12.
 * 换乘查询
 */

public class BusChangeFragment extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_buschange, container, false);
        return view;
    }
}
