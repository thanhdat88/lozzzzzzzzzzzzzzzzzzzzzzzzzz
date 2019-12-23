package com.example.quanlydiemsinhvien.config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkProvider {
    private static final String BASE_URL = "http://172.20.10.10:8200/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}
