package com.t3h.bigproject.fragment.screen.login.presenter;

import com.t3h.bigproject.base.presenter.BasePresenter;

public interface LoginPresenter extends BasePresenter {
	void register(String email,String password,String fullname,String dateofbirth,String phonenumber,String avatar,String address,boolean sex);
	void login(String email,String password);
	void otherLogin(String id);
}
