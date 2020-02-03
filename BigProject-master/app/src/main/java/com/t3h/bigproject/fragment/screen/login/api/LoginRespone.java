package com.t3h.bigproject.fragment.screen.login.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;

@Getter
public class LoginRespone<D> {
	@SerializedName("total")
	String total;
	@SerializedName("message")
	String message;
	@SerializedName("code")
	String code;
	@SerializedName("data")
	D data;
}
