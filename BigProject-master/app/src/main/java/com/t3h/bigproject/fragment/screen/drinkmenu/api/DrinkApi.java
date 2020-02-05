package com.t3h.bigproject.fragment.screen.drinkmenu.api;

import com.t3h.bigproject.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface DrinkApi {
	@POST("drinkmenu")
	Call<DrinkMenuRespone<List<Product>>> getDrinkMenu();
}
