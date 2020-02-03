package com.t3h.bigproject.fragment.screen.drinkmenu.api;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DrinkMenuRespone<D> {
	@SerializedName("total")
	String total;
	@SerializedName("message")
	String message;
	@SerializedName("code")
	String code;
	@SerializedName("data")
	D data;
}
