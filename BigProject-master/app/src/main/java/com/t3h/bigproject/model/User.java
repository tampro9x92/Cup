package com.t3h.bigproject.model;

import com.google.gson.annotations.SerializedName;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
	@SerializedName("email")
	String email;
	@SerializedName("password")
	String password;
	@SerializedName("fullname")
	String FullName;
	@SerializedName("dateofbirth")
	String date;
	@SerializedName("permission")
	int permission;
	@SerializedName("phonenumber")
	String phoneNumber;
	@SerializedName("address")
	String address;
	@SerializedName("sex")
	boolean sex;

}
