package com.t3h.bigproject.fragment.screen.drinkmenu.api;

import com.t3h.bigproject.contant.BaseUrl;
import com.t3h.bigproject.model.Image;
import com.t3h.bigproject.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrinkMenuApiService {
	private DrinkApiBuilder drinkApiBuilder;

	public interface ServiceCallBack{
		void success(String code,Object respone);
		void fail(String code,String message);
	}

	public <D> void checkSuccess(Response<DrinkMenuRespone<D>> response,ServiceCallBack ServiceCallBack){
		if (response.isSuccessful()&&response.body()!=null){
			if (response.body().getCode() !=null && response.body().getCode().equalsIgnoreCase("200")){
				ServiceCallBack.success(response.code()+"",response.body().getData());
			}
		}else {
			ServiceCallBack.fail(response.code()+"",response.body().getMessage());
		}
	}

	public <D> void checkFail(ServiceCallBack ServiceCallBack,Throwable t){
		ServiceCallBack.fail("404",t.getMessage());
	}

	public void getImage(final ServiceCallBack ServiceCallBack,int otherId,int idStatus){
		drinkApiBuilder.getInstance(BaseUrl.BASE_URL).getImage(otherId,idStatus).enqueue(new Callback<DrinkMenuRespone<List<Image>>>() {
			@Override
			public void onResponse(Call<DrinkMenuRespone<List<Image>>> call, Response<DrinkMenuRespone<List<Image>>> response) {
				checkSuccess(response,ServiceCallBack);
			}

			@Override
			public void onFailure(Call<DrinkMenuRespone<List<Image>>> call, Throwable t) {
				checkFail(ServiceCallBack,t);
			}
		});
	}
	public void drinkMenu(final ServiceCallBack ServiceCallBack){
		drinkApiBuilder.getInstance(BaseUrl.BASE_URL).getDrinkMenu().enqueue(new Callback<DrinkMenuRespone<List<Product>>>() {
			@Override
			public void onResponse(Call<DrinkMenuRespone<List<Product>>> call, Response<DrinkMenuRespone<List<Product>>> response) {
				checkSuccess(response,ServiceCallBack);
			}

			@Override
			public void onFailure(Call<DrinkMenuRespone<List<Product>>> call, Throwable t) {
				checkFail(ServiceCallBack,t);
			}
		});
	}
}
