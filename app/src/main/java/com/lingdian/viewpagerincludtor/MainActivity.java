package com.lingdian.viewpagerincludtor;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lingdian.viewpagerincludtor.adapters.MyPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int screenWidth;
    private  int itemWidth;
    private  int BarItemWidth = UIUtils.dip2px(22);
    private int myOffset ;
    private View srcollBarView;
    private int currentPosition = 0;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenWidth = UIUtils.getWindowWidth(this);
        itemWidth = screenWidth / 3;
        myOffset=(itemWidth / 2 - BarItemWidth / 2);

        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        srcollBarView = findViewById(R.id.view_scroll_bar);

        viewPager.setOffscreenPageLimit(3);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(viewPagerListener);
        init();
    }

    private void init() {

        LayoutInflater inflater = getLayoutInflater();
        View view1 = inflater.inflate(R.layout.layout, null);
        View view2 = inflater.inflate(R.layout.layout, null);
        View view3 = inflater.inflate(R.layout.layout, null);

        ArrayList<View> viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(viewList);
        viewPager.setAdapter(pagerAdapter);
        getScrollPosition(0, 0);
    }

    private void getScrollPosition(int position, int offset) {
        int margin =  myOffset + position * itemWidth + offset;
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) srcollBarView.getLayoutParams();
        params.leftMargin = margin;
        srcollBarView.setLayoutParams(params);
    }

    private ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            getScrollPosition(position, positionOffsetPixels / 3);
        }

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
