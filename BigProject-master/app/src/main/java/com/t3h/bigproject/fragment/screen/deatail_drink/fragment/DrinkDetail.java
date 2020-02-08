package com.t3h.bigproject.fragment.screen.deatail_drink.fragment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.t3h.bigproject.R;
import com.t3h.bigproject.base.fragment.BaseFragment;
import com.t3h.bigproject.fragment.screen.deatail_drink.model.ProductDetail;
import com.t3h.bigproject.fragment.screen.deatail_drink.presenter.DrinkDeatilPresenteIml;
import com.t3h.bigproject.fragment.screen.deatail_drink.presenter.DrinkDetailPresenter;
import com.t3h.bigproject.fragment.screen.deatail_drink.view.DrinkDetailView;
import com.t3h.bigproject.model.OtherDrink;

import org.w3c.dom.Comment;
import org.w3c.dom.Text;

import java.util.List;

public class DrinkDetail extends BaseFragment<DrinkDeatilPresenteIml> implements DrinkDetailView {
	private Activity activity;
	private RecyclerView rcvDrinkDetailImage;
	private TextView tvDrinkDetailName,tvNumberRate;
	private RatingBar rateDrink;

	@Override
	protected View setLayoutFragment(LayoutInflater inflater, ViewGroup container) {
		return inflater.inflate(R.layout.fragment_drink_detail,container,false);
	}

	@Override
	protected DrinkDeatilPresenteIml getPresenter() {
		return new DrinkDeatilPresenteIml(this,activity);
	}

	@Override
	public void onInit() {
		rcvDrinkDetailImage = vFragmentLayout.findViewById(R.id.rcvDrinkdetailImage);
		tvDrinkDetailName =vFragmentLayout.findViewById(R.id.tvDrinkDetailName);
		tvNumberRate = vFragmentLayout.findViewById(R.id.tvNameDrink);
	}

	@Override
	public void showDrinkDetail(ProductDetail productDetail) {

	}

	@Override
	public void showOtherDrink(List<OtherDrink> lstOtherDrinks) {

	}

	@Override
	public void showComment(List<Comment> lstComment) {

	}
}
