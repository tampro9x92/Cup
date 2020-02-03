package com.t3h.bigproject.fragment.screen.drinkmenu.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DrinkApiBuilder {
	private static DrinkApi instance;

	public static DrinkApi getInstance(String baseUrl){
		if (instance==null){
			Gson gson = new GsonBuilder()
					.setLenient()
					.create();
			instance = new Retrofit.Builder()
					.addConverterFactory(GsonConverterFactory.create(gson))
					.baseUrl(baseUrl)
					.build().create(DrinkApi.class);
		}
		return instance;
	}

}
