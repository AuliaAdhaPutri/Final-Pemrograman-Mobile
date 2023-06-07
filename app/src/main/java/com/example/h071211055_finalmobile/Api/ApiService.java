package com.example.h071211055_finalmobile.Api;

import com.example.h071211055_finalmobile.DataResponse.DataMovie;
import com.example.h071211055_finalmobile.DataResponse.DataTv;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("tv/airing_today?")
    Call<DataTv> getDataTv(@Query("api_key") String apiKey);

    @GET("movie/now_playing?")
    Call<DataMovie> getDataMovie(@Query("api_key") String apiKey);
}
