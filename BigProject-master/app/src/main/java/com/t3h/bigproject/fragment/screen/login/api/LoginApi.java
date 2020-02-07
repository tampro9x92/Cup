package com.t3h.bigproject.fragment.screen.login.api;

import com.google.gson.annotations.SerializedName;
import com.t3h.bigproject.fragment.screen.login.fragment.Login;
import com.t3h.bigproject.model.Empty;
import com.t3h.bigproject.model.OtherLoginParagram;
import com.t3h.bigproject.model.User;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginApi {
	@POST("register")
	@FormUrlEncoded
	Call<LoginRespone<Empty>> register(@Field("email")
			String email,
			@Field("password")
					String password,
			@Field("fullname")
					String FullName,
			@Field("dateofbirth")
					String date,
			@Field("permission")
	int permission,
	@Field("phonenumber")
	String phoneNumber,
	@Field("address")
	String address,
	@Field("avatar")
	String avatar,
	@Field("sex")
	boolean sex);

	@POST("login")
	@FormUrlEncoded
	Call<LoginRespone<List<User>>> login(@Field("email") String email,@Field("password") String password);

}
