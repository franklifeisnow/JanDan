package com.liompei.jandan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.liompei.jandan.R;
import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.contract.OtherContract;
import com.liompei.jandan.ui.adapter.PictureAdapter;

/**
 * Created by Liompei
 * time : 2017/11/9 10:26
 * 1137694912@qq.com
 * remark:妹子图
 */

public class OoxxFragment extends BaseFragment {

    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    private OtherContract.Presenter mPresenter;
    private PictureAdapter mPicAdapter;

    private int mPage;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_auto;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onEvent() {

    }
}
