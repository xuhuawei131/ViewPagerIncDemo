package com.lingdian.viewpagerincludtor;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by lingdian on 2018/1/15.
 */

public class ScrollBarView extends LinearLayout implements ViewPager.OnPageChangeListener {
    private View srcollBarView;
    private int color;
    private Drawable bgDrawable;
    private float barItemWidth;
    private float barItemHeight;
    private int itemNum;

    private int screenWidth;
    private int itemWidth;
    private float myOffset;
    public ScrollBarView(Context context) {
        super(context);
        init(context, null);
    }

    public ScrollBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ScrollBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ScrollBarView);//TypedArray是一个数组容器
        color = typedArray.getColor(R.styleable.ScrollBarView_barColor, 0xff000000);
        bgDrawable=typedArray.getDrawable(R.styleable.ScrollBarView_barDrawable);
        barItemWidth = typedArray.getDimension(R.styleable.ScrollBarView_barWidth, dip2px(context,22));
        barItemHeight = typedArray.getDimension(R.styleable.ScrollBarView_barHeight,  dip2px(context,5));
        itemNum = typedArray.getInt(R.styleable.ScrollBarView_itemNum, 2);
        typedArray.recycle();


        screenWidth=getWindowWidth(context);
        itemWidth = screenWidth / itemNum;
        myOffset=(itemWidth / 2 - barItemWidth / 2);




        setOrientation(VERTICAL);
        srcollBarView = new View(context);
        LinearLayout.MarginLayoutParams layoutParams = new LinearLayout.MarginLayoutParams((int) barItemWidth, (int) barItemHeight);
        srcollBarView.setBackgroundColor(color);
        addView(srcollBarView,layoutParams);

        setScrollPosition(0,0);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     * @param context
     * @param dpValue
     * @return
     */
    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 获取屏幕宽度
     * @param activity
     * @return
     */
    private int getWindowWidth(Context activity) {
        if (activity == null)
            return 0;
        WindowManager wm = (WindowManager) activity
                .getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        return width;
    }

    private void setScrollPosition(int position, int offset) {
        float margin =  myOffset + position * itemWidth + offset;
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) srcollBarView.getLayoutParams();
        params.leftMargin = (int) margin;
        srcollBarView.setLayoutParams(params);
    }

    //----------------------------------
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        setScrollPosition(position,positionOffsetPixels/itemNum);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
