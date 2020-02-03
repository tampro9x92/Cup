package com.t3h.bigproject.fragment.screen.login.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.t3h.bigproject.api.Api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginApiBuilder {
		private static LoginApi instance;
		public static LoginApi getInstance(String baseUrl){
			if (instance==null){
				Gson gson = new GsonBuilder()
						.setLenient()
						.create();
				instance = new Retrofit.Builder()
						.addConverterFactory(GsonConverterFactory.create(gson))
						.baseUrl(baseUrl)
						.build().create(LoginApi.class);
			}
			return instance;
		}
}
