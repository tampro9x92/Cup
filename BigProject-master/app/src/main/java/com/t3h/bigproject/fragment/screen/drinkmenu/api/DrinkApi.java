package com.t3h.bigproject.fragment.screen.drinkmenu.api;

import com.t3h.bigproject.fragment.screen.drinkmenu.api.request.DrinkMenuParagram;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface DrinkApi {
	@POST("drinkmenu")
	Call<DrinkMenuRespone<List<DrinkMenuParagram>>> getDrinkMenu();
}
