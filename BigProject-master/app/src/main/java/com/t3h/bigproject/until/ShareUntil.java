package com.t3h.bigproject.until;

import android.content.Context;
import android.content.SharedPreferences;

public class ShareUntil {
    private SharedPreferences share;

    public ShareUntil(Context context){
        this.share = context.getSharedPreferences("ShareUntil",context.MODE_PRIVATE);
    }

    public void put(String key,String password){
        share.edit().putString(key,password).commit();
    }

    public String get(String key){
        return share.getString(key,"");
    }
}
