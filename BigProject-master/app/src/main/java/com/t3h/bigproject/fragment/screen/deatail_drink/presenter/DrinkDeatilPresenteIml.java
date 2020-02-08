package com.t3h.bigproject.fragment.screen.deatail_drink.presenter;

import android.app.Activity;

import androidx.annotation.DrawableRes;

import com.t3h.bigproject.R;
import com.t3h.bigproject.base.presenter.BasePresenter;
import com.t3h.bigproject.fragment.screen.deatail_drink.fragment.DrinkDetail;
import com.t3h.bigproject.fragment.screen.deatail_drink.model.ProductDetail;
import com.t3h.bigproject.fragment.screen.drinkmenu.api.DrinkMenuApiService;
import com.t3h.bigproject.model.Image;

import java.util.ArrayList;
import java.util.List;

public class DrinkDeatilPresenteIml implements BasePresenter,DrinkDetailPresenter {
	private DrinkDetail mView;
	private Activity context;
	private DrinkMenuApiService drinkMenuApiService = new DrinkMenuApiService();

	public DrinkDeatilPresenteIml(DrinkDetail mView, Activity context) {
		this.mView = mView;
		this.context = context;
	}

	@Override
	public void start() {
		if (mView!=null){
			mView.onInit();
		}
	}

	@Override
	public void getDrinkDetail() {
		List<Integer> lstImage = new ArrayList<>();
		for (int i = 0; i < 2000 ; i++) {
			lstImage.add(R.drawable.sangria);
			lstImage.add(R.drawable.black_cafe);
			lstImage.add(R.drawable.hot_chocolate);
			lstImage.add(R.drawable.starbucks_articlelarge);
			lstImage.add(R.drawable.cafebackground);
			lstImage.add(R.drawable.wine);
			lstImage.add(R.drawable.cafebackground1);
			lstImage.add(R.drawable.capuchino);
		}
			ProductDetail productDetail = new ProductDetail(1,"black cafe",lstImage,4,5);
			mView.showDrinkDetail(productDetail);
	}

	@Override
	public void getOtherDrink() {

	}

	@Override
	public void getComment() {

	}
}
