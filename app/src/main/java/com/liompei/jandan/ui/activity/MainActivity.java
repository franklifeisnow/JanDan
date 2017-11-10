package com.liompei.jandan.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;

import com.liompei.jandan.R;
import com.liompei.jandan.base.BaseActivity;
import com.liompei.jandan.ui.adapter.TabMainAdapter;
import com.liompei.jandan.ui.fragment.JokesFragment;
import com.liompei.jandan.ui.fragment.NewsFragment;
import com.liompei.jandan.ui.fragment.OoxxFragment;
import com.liompei.jandan.ui.fragment.PicFragment;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends BaseActivity {

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
        getToolbar("煎蛋", false);
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
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(mTabMainAdapter);
        mViewPager.setOffscreenPageLimit(tabNames.length);
        mViewPager.setCurrentItem(nowCurrentItem);
    }

    @Override
    public void onEvent() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:

                break;
            case R.id.action_about_me:
                new AlertDialog.Builder(this)
                        .setTitle("Liompei")
                        .setMessage("https://github.com/liompei")
                        .setPositiveButton("支持我", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                try {
                                    String alipayqr = "alipayqr://platformapi/startapp?saId=10000007&clientVersion=3.7.0.0718&qrcode=" + URLEncoder.encode("HTTPS://QR.ALIPAY.COM/FKX05878UGST3IDEDHAC5A", "utf-8");
                                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(alipayqr));
                                    startActivity(intent);
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                            }
                        })
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
