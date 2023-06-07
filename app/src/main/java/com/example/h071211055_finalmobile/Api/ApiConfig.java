package com.example.h071211055_finalmobile.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private  static  final  String API_KEY = "420df2532cf4992ec1cb1bf2ab501978";

    public static ApiService getApiService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ApiService.class);
    }

    public static  String getApiKey(){
        return  API_KEY;
    }
}
