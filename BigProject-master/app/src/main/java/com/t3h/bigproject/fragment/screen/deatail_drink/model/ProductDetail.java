package com.t3h.bigproject.fragment.screen.deatail_drink.model;

import androidx.annotation.DrawableRes;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetail {
	private int id;
	private String name;
	private List<Integer> image;
	private float rating;
	private int numberRating;

	public ProductDetail(int id, String name, List<Integer> image, float rating, int numberRating) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.rating = rating;
		this.numberRating = numberRating;
	}
}
