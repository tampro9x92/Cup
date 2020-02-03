package com.t3h.bigproject.fragment.screen.login.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.t3h.bigproject.api.ApiBuilder;
import com.t3h.bigproject.base.presenter.BasePresenter;
import com.t3h.bigproject.contant.BaseUrl;
import com.t3h.bigproject.fragment.screen.login.api.LoginApiBuilder;
import com.t3h.bigproject.fragment.screen.login.api.LoginApiService;
import com.t3h.bigproject.fragment.screen.login.view.LoginView;
import com.t3h.bigproject.model.OtherLoginParagram;
import com.t3h.bigproject.model.User;

public class LoginPresenterImpl implements BasePresenter, LoginPresenter {
    private final LoginView mView;
    private Activity context;
	private LoginApiService loginApiService = new LoginApiService();

    public LoginPresenterImpl(LoginView mView, Activity context) {
        this.mView = mView;
        this.context = context;
    }

    @Override
    public void start() {
        if (mView != null) {
            mView.onInit();
        }
    }

	@Override
	public void register(String email,String password,String fullname,String dateofbirth,String phonenumber,String avatar,String address,boolean sex) {
		loginApiService.register(email,password,fullname,dateofbirth,2,phonenumber,address,avatar,sex,new LoginApiService.serviceCallBack() {
			@Override
			public void success(String code, Object respone) {
				Toast.makeText(context, code, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void fail(String code, String message) {
				Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public void login(String email, String password) {
		loginApiService.login(email,password, new LoginApiService.serviceCallBack() {
			@Override
			public void success(String code, Object respone) {
				Toast.makeText(context, code, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void fail(String code, String message) {
				Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
			}
		});
    }

	@Override
	public void otherLogin(String id) {
		loginApiService.otherLogin(id, new LoginApiService.serviceCallBack() {
			@Override
			public void success(String code, Object respone) {
				Toast.makeText(context, code, Toast.LENGTH_SHORT).show();
			}

			@Override
			public void fail(String code, String message) {
				Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
			}
		});
	}
}
