package com.t3h.bigproject.base;

import android.content.Context;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Const {
    public static String ToMD5(String text){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(text.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte arrAray:
                 array) {
                sb.append(Integer.toHexString(arrAray & 0xff|0x100)).substring(1,3);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
