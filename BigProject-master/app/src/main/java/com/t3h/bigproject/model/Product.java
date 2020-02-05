package com.t3h.bigproject.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	@SerializedName("id")
	private int id;
	@SerializedName("name")
	private String name;
	@SerializedName("price")
	private String price;
	@SerializedName("status")
	private int status;
}
