package com.t3h.bigproject.fragment.screen.login.api;

import com.google.gson.annotations.SerializedName;
import com.t3h.bigproject.api.ApiBuilder;
import com.t3h.bigproject.contant.BaseUrl;
import com.t3h.bigproject.fragment.screen.login.fragment.Login;
import com.t3h.bigproject.model.Empty;
import com.t3h.bigproject.model.OtherLoginParagram;
import com.t3h.bigproject.model.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginApiService {
	private serviceCallBack serviceCallBack;
	private LoginApiBuilder loginApiBuilder;

	public interface serviceCallBack {
		void success(String code, Object respone);

		void fail(String code, String message);
	}

	public <D> void checkSuccess(Response<LoginRespone<D>> response, serviceCallBack serviceCallBack) {
		if (response.isSuccessful() && response.body() != null) {
			if (response.body().getCode() != null && response.body().getCode().equalsIgnoreCase("200"))
				serviceCallBack.success(response.code() + "", response.body().getData());
		} else {
			serviceCallBack.fail(response.code() + "", response.body().getMessage());
		}
	}

	public void checkFail(serviceCallBack serviceCallBack, Throwable t) {
		serviceCallBack.fail("404", t.getMessage());
	}

	public void register(String email, String password, String fullname, String date, int permission, String phoneNumber, String address, String avatar, boolean sex, final serviceCallBack serviceCallBack) {
		LoginApiBuilder.getInstance(BaseUrl.BASE_URL).register(email,password,fullname,date,permission,phoneNumber,address,avatar,sex).enqueue(new Callback<LoginRespone<Empty>>() {
			@Override
			public void onResponse(Call<LoginRespone<Empty>> call, Response<LoginRespone<Empty>> response) {
				checkSuccess(response, serviceCallBack);
			}

			@Override
			public void onFailure(Call<LoginRespone<Empty>> call, Throwable t) {
				checkFail(serviceCallBack, t);
			}
		});
	}

	public void login(String email, String password, final serviceCallBack serviceCallBack) {
		LoginApiBuilder.getInstance(BaseUrl.BASE_URL).login(email, password).enqueue(new Callback<LoginRespone<List<User>>>() {
			@Override
			public void onResponse(Call<LoginRespone<List<User>>> call, Response<LoginRespone<List<User>>> response) {
				checkSuccess(response, serviceCallBack);
			}

			@Override
			public void onFailure(Call<LoginRespone<List<User>>> call, Throwable t) {
				checkFail(serviceCallBack, t);
			}
		});
	}

	public void otherLogin(String id, final serviceCallBack serviceCallBack) {
		LoginApiBuilder.getInstance(BaseUrl.BASE_URL).otherLogin(id).enqueue(new Callback<LoginRespone<Empty>>() {
			@Override
			public void onResponse(Call<LoginRespone<Empty>> call, Response<LoginRespone<Empty>> response) {
				checkSuccess(response, serviceCallBack);
			}

			@Override
			public void onFailure(Call<LoginRespone<Empty>> call, Throwable t) {
				checkFail(serviceCallBack, t);
			}
		});
	}
}
