package com.lingdian.viewpagerincludtor.fragments.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by lingdian on 2018/1/31.
 */

public class BaseFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mItems;

    public BaseFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setItems(List<Fragment> items) {
        this.mItems = items;
    }

    @Override
    public Fragment getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public int getCount() {
        if (mItems == null)
            return 0;
        return mItems.size();
    }
}
