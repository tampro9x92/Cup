package com.t3h.bigproject.fragment.screen.deatail_drink.view;

import com.t3h.bigproject.base.view.BaseView;
import com.t3h.bigproject.fragment.screen.deatail_drink.fragment.DrinkDetail;
import com.t3h.bigproject.fragment.screen.deatail_drink.model.ProductDetail;
import com.t3h.bigproject.model.OtherDrink;

import org.w3c.dom.Comment;

import java.util.List;

public interface DrinkDetailView extends BaseView {
	void showDrinkDetail(ProductDetail productDetail);
	void showOtherDrink(List<OtherDrink> lstOtherDrinks);
	void showComment(List<Comment> lstComment);
}
