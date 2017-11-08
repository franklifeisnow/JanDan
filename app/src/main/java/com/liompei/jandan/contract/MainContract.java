package com.liompei.jandan.contract;

import com.liompei.jandan.bean.NewsBean;
import com.liompei.jandan.bean.OtherBean;

/**
 * Created by Liompei
 * time : 2017/11/7 13:29
 * 1137694912@qq.com
 * remark:
 */

public interface MainContract {


    interface Model {
        void netNews(int page);

        void netPic(int page);

        void netOOXX(int page);

        void netJokes(int page);

    }

    interface View {
        void showProgress();

        void hideProgress();

        void nextNews(int page,NewsBean newsBean);

        void nextPic(int page,OtherBean otherBean);

        void nextOOXX(int page,OtherBean otherBean);

        void nextJokes(int page,OtherBean otherBean);
    }

    interface Presenter {
        void doNews(int page);

        void doPic(int page);

        void doOOXX(int page);

        void doJokes(int page);

        void newsNext(int page,NewsBean newsBean);

        void picNext(int page,OtherBean otherBean);

        void ooxxNext(int page,OtherBean otherBean);

        void jokesNext(int page,OtherBean otherBean);

        void compile();
    }
}
