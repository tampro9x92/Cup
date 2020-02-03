package com.t3h.bigproject.base.presenter;

import android.view.View;

import com.t3h.bigproject.base.view.BaseView;

public class BasePresenterImpl<T extends BaseView> implements BasePresenter {
    protected T mView;

    //khai báo đưa hàm sử lý dữ liệu chính ra fragment
    @Override
    public void start() {
        if (mView!=null) {
            mView.onInit();
        }
    }


}
