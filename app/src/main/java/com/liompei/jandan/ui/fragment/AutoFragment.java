package com.liompei.jandan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.liompei.jandan.R;
import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.bean.NewsBean;
import com.liompei.jandan.bean.OtherBean;
import com.liompei.jandan.contract.MainContract;
import com.liompei.jandan.presenter.MainPresenter;
import com.liompei.zxlog.Zx;

/**
 * Created by Liompei
 * time : 2017/11/7 15:07
 * 1137694912@qq.com
 * remark:
 */

public class AutoFragment extends BaseFragment implements MainContract.View, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private MainContract.Presenter mPresenter;

    private int type = 0;
    private int page = 1;

    public AutoFragment setType(int type) {
        this.type = type;
        return this;
    }


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_auto;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mProgressBar = findViewById(R.id.progressBar);
        mRefreshLayout = findViewById(R.id.swipe);
        mRecyclerView = findViewById(R.id.recycler);
    }

    @Override
    protected void initData() {
        mRefreshLayout.setOnRefreshListener(this);
        mPresenter = new MainPresenter(this, this);
    }


    @Override
    protected void onEvent() {
    }

    @Override
    protected void lazyLoad() {
        update(type);
    }

    public void update(int type) {
        Zx.d(type);
        this.type = type;
        switch (type) {
            case 0:
                Zx.d("加载新鲜事");
                mPresenter.doNews(page);
                break;
            case 1:
                Zx.d("加载无聊图");
                mPresenter.doPic(page);
                break;
            case 2:
                Zx.d("加载妹子图");
                mPresenter.doOOXX(page);
                break;
            case 3:
                Zx.d("加载段子");
                mPresenter.doJokes(page);
                break;
        }
    }

    @Override
    public void onRefresh() {
        page = 1;
        switch (type) {
            case 0:  //新鲜事
                mPresenter.doNews(page);
                break;
            case 1:  //无聊图
                mPresenter.doPic(page);
                break;
            case 2:  //妹子图
                mPresenter.doOOXX(page);
                break;
            case 3:  //段子
                mPresenter.doJokes(page);
                break;
            default:
                toast("参数有误");
                break;
        }
    }


    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void nextNews(int page, NewsBean newsBean) {

    }

    @Override
    public void nextPic(int page, OtherBean otherBean) {

    }

    @Override
    public void nextOOXX(int page, OtherBean otherBean) {

    }

    @Override
    public void nextJokes(int page, OtherBean otherBean) {

    }


}
