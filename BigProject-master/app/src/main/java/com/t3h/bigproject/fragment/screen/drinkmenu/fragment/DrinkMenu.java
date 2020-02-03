package com.t3h.bigproject.fragment.screen.drinkmenu.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.t3h.bigproject.R;
import com.t3h.bigproject.base.fragment.BaseFragment;
import com.t3h.bigproject.fragment.screen.drinkmenu.api.request.DrinkMenuParagram;
import com.t3h.bigproject.fragment.screen.drinkmenu.presenter.DrinkPresenterImpl;
import com.t3h.bigproject.fragment.screen.drinkmenu.view.DrinkView;

import java.util.List;

import okhttp3.RequestBody;

public class DrinkMenu extends BaseFragment<DrinkPresenterImpl> implements DrinkView {
	private RecyclerView rcvDrinkMenu;
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
	}

	@Override
	public void showDrinkMenu(List<DrinkMenuParagram> data) {

	}
}
