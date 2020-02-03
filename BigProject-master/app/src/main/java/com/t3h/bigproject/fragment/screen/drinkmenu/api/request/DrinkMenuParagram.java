package com.t3h.bigproject.fragment.screen.drinkmenu.api.request;

import com.google.gson.annotations.SerializedName;

public class DrinkMenuParagram {
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("avatar")
    private int avatar;
    @SerializedName("price")
    private String price;
    @SerializedName("status")
    private String status;
    @SerializedName("id_category")
    private long idCategory;

    public DrinkMenuParagram(long id, String name, int avatar, String price, String status, long idCategory) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.price = price;
        this.status = status;
        this.idCategory = idCategory;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public long getIdCategory() {
        return idCategory;
    }
}
