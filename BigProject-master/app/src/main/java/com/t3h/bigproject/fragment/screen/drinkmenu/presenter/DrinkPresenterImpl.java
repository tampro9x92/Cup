package com.t3h.bigproject.fragment.screen.drinkmenu.presenter;

import android.app.Activity;
import android.widget.Toast;

import com.t3h.bigproject.base.presenter.BasePresenter;
import com.t3h.bigproject.fragment.screen.drinkmenu.api.DrinkMenuApiService;
import com.t3h.bigproject.fragment.screen.drinkmenu.view.DrinkView;
import com.t3h.bigproject.model.Image;
import com.t3h.bigproject.model.Product;

import java.util.ArrayList;
import java.util.List;

public class DrinkPresenterImpl implements BasePresenter, DrinkPresenter {
	private final DrinkView mView;
	private Activity context;
	private DrinkMenuApiService drinkMenuApiService = new DrinkMenuApiService();

	public DrinkPresenterImpl(DrinkView mView, Activity context) {
		this.mView = mView;
		this.context = context;
	}

	@Override
	public void start() {
		if (mView != null) {
			mView.onInit();
		}
	}

	@Override
	public void searchDrinkMenu(final String nameDrink) {
		drinkMenuApiService.drinkMenu(new DrinkMenuApiService.ServiceCallBack() {
			@Override
			public void success(String code, Object respone) {
				List<Product> data = (List<Product>) respone;
				if (nameDrink.length() == 0) {
					mView.showDrinkMenu(data);
				} else {
					data.clear();
					data = new ArrayList<>();
					for (int i = 0; i < data.size(); i++) {
						if (data.get(i).getName().indexOf(nameDrink) >= 0) {
							data.add(data.get(i));
						}
					}
					mView.showDrinkMenu(data);
				}
			}

			@Override
			public void fail(String code, String message) {
				Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public void imageDrink(int idOther, int status) {
		drinkMenuApiService.getImage(new DrinkMenuApiService.ServiceCallBack() {
			@Override
			public void success(String code, Object respone) {
				List<Image> data = (List<Image>) respone;
				List<Image> takeLastImage = new ArrayList<>();
				takeLastImage.add(data.get(data.size()-1));

			}

			@Override
			public void fail(String code, String message) {

			}
		}, idOther, status);
	}

}
