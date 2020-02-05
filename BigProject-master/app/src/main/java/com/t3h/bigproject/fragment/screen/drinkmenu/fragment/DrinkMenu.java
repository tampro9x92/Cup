package com.t3h.bigproject.fragment.screen.drinkmenu.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.t3h.bigproject.R;
import com.t3h.bigproject.base.fragment.BaseFragment;
import com.t3h.bigproject.fragment.screen.drinkmenu.adapter.DrinkMenuAdapter;
import com.t3h.bigproject.fragment.screen.drinkmenu.presenter.DrinkPresenterImpl;
import com.t3h.bigproject.fragment.screen.drinkmenu.view.DrinkView;
import com.t3h.bigproject.model.Product;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;

public class DrinkMenu extends BaseFragment<DrinkPresenterImpl> implements DrinkView {
	private RecyclerView rcvDrinkMenu;
	private DrinkMenuAdapter drinkMenuAdapter;
	@Override
	protected View setLayoutFragment(LayoutInflater inflater, ViewGroup container) {
		return inflater.inflate(R.layout.fragment_drink_menu,container,false);
	}

	@Override
	protected DrinkPresenterImpl getPresenter() {
		return new DrinkPresenterImpl(this,activity);
	}

	@Override
	public void onInit() {
		rcvDrinkMenu = vFragmentLayout.findViewById(R.id.rcvDrinkMenu);
		presenter.searchDrinkMenu("");
	}

	@Override
	public void showDrinkMenu(List<Product> data) {
		drinkMenuAdapter = new DrinkMenuAdapter(data,activity);
		rcvDrinkMenu.setAdapter(drinkMenuAdapter);
	}
}
