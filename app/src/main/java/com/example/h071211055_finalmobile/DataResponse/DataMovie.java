package com.example.h071211055_finalmobile.DataResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataMovie {
    @SerializedName("results")

    private List<Movie>  dataMovie;
    public List<Movie> getDataMovie() { return dataMovie; }


}
