package com.t3h.bigproject.fragment.screen.drinkmenu.view;

import com.t3h.bigproject.base.view.BaseView;
import com.t3h.bigproject.fragment.screen.drinkmenu.api.request.DrinkMenuParagram;

import java.util.List;

public interface DrinkView extends BaseView {
	void showDrinkMenu(List<DrinkMenuParagram> data);
}
