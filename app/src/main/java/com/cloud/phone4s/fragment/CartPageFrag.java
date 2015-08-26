package com.cloud.phone4s.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloud.phone4s.R;
import com.cloud.phone4s.common.ActionBarView;

/**
 * Created by cloud on 15/8/24.
 */
public class CartPageFrag extends Fragment {

    private ActionBarView actionBarRoot;
    View view;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_cart, container, false);
        initView();
//        menuList = (ListView) view.findViewById(R.id.menu_list);
//        menuList.setAdapter(adapter);
//        menuList.setOnItemClickListener(this);
        return view;
    }

    public void initView() {
        actionBarRoot = (ActionBarView) view.findViewById(R.id.actionBarRoot);
        actionBarRoot.setTitleText(getResources().getString(R.string.buy_cart));
    }

}
