package com.liompei.jandan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;

import com.liompei.jandan.R;
import com.liompei.jandan.base.BaseFragment;
import com.liompei.zxlog.Zx;

/**
 * Created by Liompei
 * time : 2017/11/7 15:07
 * 1137694912@qq.com
 * remark:
 */

public class AutoFragment extends BaseFragment {
    private ProgressBar mProgressBar;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_auto;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mProgressBar = findViewById(R.id.progressBar);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onEvent() {

    }

    public void update(int type) {
        switch (type) {
            case 0:
                Zx.d("加载新鲜事");
                break;
            case 1:
                Zx.d("加载无聊图");
                break;
            case 2:
                Zx.d("加载妹子图");
                break;
            case 3:
                Zx.d("加载段子");
                break;
        }
    }


}
