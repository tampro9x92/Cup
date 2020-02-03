package com.t3h.bigproject.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBuilder {
    private static Api instance;
    public static Api getInstance(String baseUrl){
        if (instance==null){

            instance = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .build().create(Api.class);
        }
        return instance;
    }
}
