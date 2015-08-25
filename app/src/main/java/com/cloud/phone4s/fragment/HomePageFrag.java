package com.cloud.phone4s.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloud.phone4s.R;

/**
 * Created by cloud on 15/8/24.
 */
public class HomePageFrag extends Fragment implements View.OnClickListener {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);
//        menuList = (ListView) view.findViewById(R.id.menu_list);
//        menuList.setAdapter(adapter);
//        menuList.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
