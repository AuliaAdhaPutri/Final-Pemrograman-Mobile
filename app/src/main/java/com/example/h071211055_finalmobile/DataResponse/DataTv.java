package com.example.h071211055_finalmobile.DataResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataTv {
    @SerializedName("results")

    private List<Tv> results;
    public List<Tv> getDataTv() { return results; }
}
