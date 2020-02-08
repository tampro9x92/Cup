package com.t3h.bigproject.model;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
	@SerializedName("id")
	private int id;
	@SerializedName("avatar")
	private String avatar;
	@SerializedName("other_id")
	private int otherId;
	@SerializedName("status")
	private int status;
	@SerializedName("date")
	private String date;
}
