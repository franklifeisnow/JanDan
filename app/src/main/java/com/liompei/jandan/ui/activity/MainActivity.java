package com.liompei.jandan.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.liompei.jandan.R;
import com.liompei.jandan.base.BaseActivity;
import com.liompei.jandan.ui.adapter.TabMainAdapter;
import com.liompei.jandan.ui.fragment.JokesFragment;
import com.liompei.jandan.ui.fragment.NewsFragment;
import com.liompei.jandan.ui.fragment.OoxxFragment;
import com.liompei.jandan.ui.fragment.PicFragment;

public class MainActivity extends BaseActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private String[] tabNames;
    private Fragment[] fragments;
    private TabMainAdapter mTabMainAdapter;

    private Fragment mNewsFragment;
    private Fragment mPicFragment;
    private Fragment mOoxxFragment;
    private Fragment mJokesFragment;

    private int nowCurrentItem = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mToolbar = findViewById(R.id.toolbar);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewpager);
        mNewsFragment = new NewsFragment();
        mPicFragment = new PicFragment();
        mOoxxFragment = new OoxxFragment();
        mJokesFragment = new JokesFragment();
        tabNames = new String[]{"新鲜事", "无聊图", "妹子图", "段子"};
        fragments = new Fragment[]{mNewsFragment, mPicFragment, mOoxxFragment, mJokesFragment};
        mTabMainAdapter = new TabMainAdapter(getSupportFragmentManager(), tabNames, fragments);
    }

    @Override
    public void initData() {
        mToolbar.setTitle("煎蛋");
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(mTabMainAdapter);
        mViewPager.setOffscreenPageLimit(tabNames.length);
        mViewPager.setCurrentItem(nowCurrentItem);
    }

    @Override
    public void onEvent() {
    }



}
