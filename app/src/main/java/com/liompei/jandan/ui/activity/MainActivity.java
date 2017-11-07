package com.liompei.jandan.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.liompei.jandan.R;
import com.liompei.jandan.base.BaseActivity;
import com.liompei.jandan.ui.adapter.TabMainAdapter;
import com.liompei.jandan.ui.fragment.AutoFragment;

public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private String[] tabNames;
    private Fragment[] fragments;
    private TabMainAdapter mTabMainAdapter;

    private AutoFragment mAutoFragment1;
    private AutoFragment mAutoFragment2;
    private AutoFragment mAutoFragment3;
    private AutoFragment mAutoFragment4;

    private boolean isOneLoaded = true;  //第一个界面是否加载过
    private boolean isTwoLoaded = false;  //第二个界面是否加载过
    private boolean isThreeLoaded = false;  //第三个界面是否加载过
    private boolean isFourLoaded = false;  //第四个界面是否加载过


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mToolbar = findViewById(R.id.toolbar);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewpager);
        mAutoFragment1 = new AutoFragment();
        mAutoFragment2 = new AutoFragment();
        mAutoFragment3 = new AutoFragment();
        mAutoFragment4 = new AutoFragment();
        tabNames = new String[]{"新鲜事", "无聊图", "妹子图", "段子"};
        fragments = new Fragment[]{mAutoFragment1, mAutoFragment2, mAutoFragment3, mAutoFragment4};
        mTabMainAdapter = new TabMainAdapter(getSupportFragmentManager(), tabNames, fragments);
    }

    @Override
    public void initData() {
        mToolbar.setTitle("煎蛋");
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(mTabMainAdapter);
        mViewPager.setOffscreenPageLimit(tabNames.length);
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        if (!isOneLoaded) {
                            mAutoFragment1.update(position);
                            isOneLoaded = true;
                        }
                        break;
                    case 1:
                        if (!isTwoLoaded) {
                            mAutoFragment2.update(position);
                            isTwoLoaded = true;
                        }
                        break;
                    case 2:
                        if (!isThreeLoaded) {
                            mAutoFragment3.update(position);
                            isThreeLoaded = true;
                        }
                        break;
                    case 3:
                        if (!isFourLoaded) {
                            mAutoFragment4.update(position);
                            isFourLoaded = true;
                        }
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onEvent() {

    }

}
