package com.t3h.bigproject.fragment.screen.drinkmenu.api;

import com.t3h.bigproject.contant.BaseUrl;
import com.t3h.bigproject.fragment.screen.drinkmenu.api.request.DrinkMenuParagram;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkMenuApiService {
	private DrinkApiBuilder drinkApiBuilder;

	public interface serviceCallBack{
		void success(String code,Object respone);
		void fail(String code,String message);
	}

	public <D> void checkSuccess(Response<DrinkMenuRespone<D>> response,serviceCallBack serviceCallBack){
		if (response.isSuccessful()&&response.body()!=null){
			if (response.body().getCode() !=null && response.body().getCode().equalsIgnoreCase("200")){
				serviceCallBack.success(response.code()+"",response.body().getMessage());
			}
		}else {
			serviceCallBack.fail(response.code()+"",response.body().getMessage());
		}
	}

	public <D> void checkFail(serviceCallBack serviceCallBack,Throwable t){
		serviceCallBack.fail("404",t.getMessage());
	}

	public void drinkMenu(final serviceCallBack serviceCallBack){
		drinkApiBuilder.getInstance(BaseUrl.BASE_URL).getDrinkMenu().enqueue(new Callback<DrinkMenuRespone<List<DrinkMenuParagram>>>() {
			@Override
			public void onResponse(Call<DrinkMenuRespone<List<DrinkMenuParagram>>> call, Response<DrinkMenuRespone<List<DrinkMenuParagram>>> response) {
				checkSuccess(response,serviceCallBack);
			}

			@Override
			public void onFailure(Call<DrinkMenuRespone<List<DrinkMenuParagram>>> call, Throwable t) {
				checkFail(serviceCallBack,t);
			}
		});

	}
}
