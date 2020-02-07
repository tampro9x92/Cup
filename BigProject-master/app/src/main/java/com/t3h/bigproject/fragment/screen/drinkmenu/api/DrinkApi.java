package com.t3h.bigproject.fragment.screen.drinkmenu.api;

import com.t3h.bigproject.model.Image;
import com.t3h.bigproject.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface DrinkApi {
	@POST("drinkmenu")
	Call<DrinkMenuRespone<List<Product>>> getDrinkMenu();

	@POST("getimage")
	Call<DrinkMenuRespone<List<Image>>> getImage(@Field("other_id") int otherId,@Field("status") int status);
}
