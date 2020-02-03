package com.t3h.bigproject.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OtherLoginParagram {
	@SerializedName("id_user")
	private String idUser;
}
