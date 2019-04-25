package com.example.myframe.bus.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myframe.R;

/**
 * Created by Administrator on 2019/4/12.
 * 站点查询
 */

public class StationFoundFragment extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_stationfound, container, false);
        return view;
    }
}
