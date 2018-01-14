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
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  int screenWidth ;
    private final int itemWidth = screenWidth / 3;
    private final int BarItemWidth = UIUtils.dip2px(22);
    private  int offset=(itemWidth-BarItemWidth)/2;
    private View srcollBarView;
    private int currentPosition=0;
    private List<View> viewList;
    private ViewPager  viewPager;
    private int one = offset * 2 + BarItemWidth;// 页卡1 -> 页卡2 偏移量
    private int two = one * 2;// 页卡1 -> 页卡3 偏移量
    private int three = one * 3;

    private View view1, view2, view3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        screenWidth=UIUtils.getWindowWidth(this);

        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        srcollBarView=findViewById(R.id.view_scroll_bar);

        viewPager.setOffscreenPageLimit(3);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(viewPagerListener);
        init();

    }
    private void init(){

        LayoutInflater inflater=getLayoutInflater();
        view1 = inflater.inflate(R.layout.layout, null);
        view2 = inflater.inflate(R.layout.layout,null);
        view3 = inflater.inflate(R.layout.layout, null);

        ArrayList<View> viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(viewList);
        viewPager.setAdapter(pagerAdapter);
    }

    private void getScrollPosition(int position,int offset,float positionOffset) {
        Log.v("xhw","position "+position+" offset "+offset+" positionOffset "+positionOffset+" currentPosition "+currentPosition);

        if (position==0){

        }else if (position==1){

        }else if (position==2){

        }

        if (offset!=0){
            int margin = (int) ((itemWidth / 2 - BarItemWidth / 2) + position * itemWidth+offset);
//            Log.v("xhw","position "+position+" offset "+offset+" margin "+margin+" positionOffset "+positionOffset);

            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) srcollBarView.getLayoutParams();
            params.leftMargin = margin;
            srcollBarView.setLayoutParams(params);
        }
    }
    private ViewPager.OnPageChangeListener viewPagerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            getScrollPosition(position,positionOffsetPixels/3,positionOffset) ;
        }

        @Override
        public void onPageSelected(int position) {
            currentPosition=position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
