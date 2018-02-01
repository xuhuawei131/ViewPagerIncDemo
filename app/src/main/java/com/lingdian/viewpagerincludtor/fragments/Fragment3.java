package com.lingdian.viewpagerincludtor.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lingdian.viewpagerincludtor.R;
import com.lingdian.viewpagerincludtor.fragments.adapters.BaseFragmentAdapter;
import com.lingdian.viewpagerincludtor.views.MainViewPager;
import com.lingdian.viewpagerincludtor.views.SubViewPager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lingdian on 2018/1/31.
 */

public class Fragment3 extends Fragment {

    private View rootView;
    private BaseFragmentAdapter mPagerAdapter;
    private SubViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView=inflater.inflate(R.layout.fragment_two,container,false);
        viewPager=rootView.findViewById(R.id.vp_sub_pager);
        mPagerAdapter = new BaseFragmentAdapter(getChildFragmentManager());

        Fragment fragments[]=new Fragment[2];
        fragments[0]=Fragment.instantiate(getContext(),Fragment5.class.getName());
        fragments[1]=Fragment.instantiate(getContext(),Fragment6.class.getName());

        List<Fragment> arrayList= Arrays.asList(fragments);
        mPagerAdapter.setItems(arrayList);
        viewPager.setAdapter(mPagerAdapter);
        return rootView;
    }
}
