package com.tradexl.rxjavatest;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by Raghav on 21-Aug-17.
 */

public class Constant {
    //    public static String BASEURL = "https://api.stackexchange.com/2.2/";
    public static String BASEURL = "http://tradexl.com/lp/tapi/";

    public static String getAuthToken() {
        byte[] data = new byte[0];
        try {
            data = ("admin" + ":" + "admin123").getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }
}
