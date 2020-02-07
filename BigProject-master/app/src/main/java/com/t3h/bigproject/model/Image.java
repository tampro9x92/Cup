package com.t3h.bigproject.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
	@SerializedName("avatar")
	private String avatar;
}
