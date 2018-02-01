package com.lingdian.viewpagerincludtor.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lingdian.viewpagerincludtor.R;
import com.lingdian.viewpagerincludtor.fragments.adapters.BaseFragmentAdapter;
import com.lingdian.viewpagerincludtor.views.MainViewPager;

import java.util.Arrays;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private BaseFragmentAdapter mPagerAdapter;
    private MainViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        viewPager = findViewById(R.id.vp_main_pager);
        mPagerAdapter = new BaseFragmentAdapter(getSupportFragmentManager());

        Fragment fragments[]=new Fragment[4];
        fragments[0]=Fragment.instantiate(this,Fragment1.class.getName());
        fragments[1]=Fragment.instantiate(this,Fragment2.class.getName());
        fragments[2]=Fragment.instantiate(this,Fragment3.class.getName());
        fragments[3]=Fragment.instantiate(this,Fragment4.class.getName());
        List<Fragment> arrayList= Arrays.asList(fragments);
        mPagerAdapter.setItems(arrayList);
        viewPager.setAdapter(mPagerAdapter);

    }
}
