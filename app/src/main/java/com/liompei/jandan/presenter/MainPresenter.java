package com.liompei.jandan.presenter;

import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.bean.NewsBean;
import com.liompei.jandan.bean.OtherBean;
import com.liompei.jandan.contract.MainContract;
import com.liompei.jandan.model.MainModel;

/**
 * Created by Liompei
 * time : 2017/11/7 13:29
 * 1137694912@qq.com
 * remark:
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.Model mModel;
    private MainContract.View mView;

    public MainPresenter(BaseFragment baseFragment, MainContract.View view) {
        mModel = new MainModel(baseFragment, this);
        mView = view;
    }


    @Override
    public void doNews(int page) {
        mModel.netNews(page);

    }

    @Override
    public void doPic(int page) {
        mModel.netPic(page);
    }

    @Override
    public void doOOXX(int page) {
        mModel.netOOXX(page);
    }

    @Override
    public void doJokes(int page) {
        mModel.netJokes(page);
    }

    @Override
    public void newsNext(int page,NewsBean newsBean) {
        mView.nextNews(page,newsBean);
    }

    @Override
    public void picNext(int page,OtherBean otherBean) {
        mView.nextPic(page,otherBean);
    }

    @Override
    public void ooxxNext(int page,OtherBean otherBean) {
        mView.nextOOXX(page,otherBean);
    }

    @Override
    public void jokesNext(int page,OtherBean otherBean) {
        mView.nextJokes(page,otherBean);
    }

    @Override
    public void compile() {
        mView.hideProgress();
    }


}
