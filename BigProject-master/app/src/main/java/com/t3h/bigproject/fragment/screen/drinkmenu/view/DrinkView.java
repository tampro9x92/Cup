package com.t3h.bigproject.fragment.screen.drinkmenu.view;

import com.t3h.bigproject.base.view.BaseView;
import com.t3h.bigproject.model.Product;

import java.util.List;

public interface DrinkView extends BaseView {
	void showDrinkMenu(List<Product> data);
}
