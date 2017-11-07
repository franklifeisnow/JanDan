package com.liompei.jandan.contract;

/**
 * Created by Liompei
 * time : 2017/11/7 13:29
 * 1137694912@qq.com
 * remark:
 */

public interface MainContract {
    interface Model {
        void netNews();

    }

    interface View {
        void showProgress();
        void hideProgress();

        void updateData();
    }

    interface Presenter {

    }
}
