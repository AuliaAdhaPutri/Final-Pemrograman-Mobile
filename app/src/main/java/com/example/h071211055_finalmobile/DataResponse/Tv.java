package com.example.h071211055_finalmobile.DataResponse;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Tv implements Parcelable {
    @SerializedName("id") private String id;
    @SerializedName("poster_path") private String poster_path;
    @SerializedName("original_name") private String original_name;
    @SerializedName("vote_average") private String vote_average;
    @SerializedName("overview") private String overview;
    @SerializedName("backdrop_path") private String backdrop_path;
    @SerializedName("first_air_date") private String first_air_date;

    protected Tv(Parcel in) {
        id = in.readString();
        poster_path = in.readString();
        original_name = in.readString();
        vote_average = in.readString();
        overview = in.readString();
        backdrop_path = in.readString();
        first_air_date = in.readString();
    }

    public static final Creator<Tv> CREATOR = new Creator<Tv>() {
        @Override
        public Tv createFromParcel(Parcel in) {
            return new Tv(in);
        }

        @Override
        public Tv[] newArray(int size) {
            return new Tv[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(poster_path);
        dest.writeString(original_name);
        dest.writeString(vote_average);
        dest.writeString(overview);
        dest.writeString(backdrop_path);
        dest.writeString(first_air_date);
    }
    //     "id": 101463,
//             "name": "Al rojo vivo",
//             "origin_country": [
//             "ES"
//             ],
//             "original_language": "es",
//             "original_name": "Al rojo vivo",
//             "overview": "",
//             "popularity": 2184.062,
//             "poster_path": "/ag6PmoBxkF2s1uY3An618NCEt3g.jpg",
//             "vote_average": 1.5,
//             "vote_count": 4
//},
//        {
//        "backdrop_path": "/t2rAdgjSh0WYbXzdOB5zTDqzdCI.jpg",
//        "first_air_date": "2022-11-02",
//        "genre_ids": [
//        18
//        ],
}
