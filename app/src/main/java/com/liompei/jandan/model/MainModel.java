package com.liompei.jandan.model;

import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.bean.NewsBean;
import com.liompei.jandan.bean.OtherBean;
import com.liompei.jandan.contract.MainContract;
import com.liompei.jandan.network.HttpRequest;
import com.liompei.jandan.network.base.HttpCallback;

/**
 * Created by Liompei
 * time : 2017/11/7 13:29
 * 1137694912@qq.com
 * remark:
 */

public class MainModel implements MainContract.Model {

    private BaseFragment mBaseFragment;
    private MainContract.Presenter mPresenter;

    public MainModel(BaseFragment baseFragment, MainContract.Presenter presenter) {
        mBaseFragment = baseFragment;
        mPresenter = presenter;
    }

    @Override
    public void netNews(final int page) {
        HttpRequest.getInstance().news(mBaseFragment, page, new HttpCallback<NewsBean>() {
            @Override
            public void onNext(NewsBean newsBean) {
                mPresenter.newsNext(page, newsBean);
            }

            @Override
            public void onComplete() {
                mPresenter.compile();
            }
        });
    }

    @Override
    public void netPic(final int page) {
        HttpRequest.getInstance().pic(mBaseFragment, page, new HttpCallback<OtherBean>() {
            @Override
            public void onNext(OtherBean otherBean) {
                mPresenter.picNext(page, otherBean);
            }

            @Override
            public void onComplete() {
                mPresenter.compile();
            }
        });
    }

    @Override
    public void netOOXX(final int page) {
        HttpRequest.getInstance().ooxx(mBaseFragment, page, new HttpCallback<OtherBean>() {
            @Override
            public void onNext(OtherBean otherBean) {
                mPresenter.ooxxNext(page, otherBean);
            }

            @Override
            public void onComplete() {
                mPresenter.compile();
            }
        });
    }

    @Override
    public void netJokes(final int page) {
        HttpRequest.getInstance().jokes(mBaseFragment, page, new HttpCallback<OtherBean>() {
            @Override
            public void onNext(OtherBean otherBean) {
                mPresenter.ooxxNext(page, otherBean);
            }

            @Override
            public void onComplete() {
                mPresenter.compile();
            }
        });
    }
}
