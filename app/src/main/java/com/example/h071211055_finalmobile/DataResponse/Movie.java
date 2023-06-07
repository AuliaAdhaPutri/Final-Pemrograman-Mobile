package com.example.h071211055_finalmobile.DataResponse;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Movie implements Parcelable {
    @SerializedName("id") private String id;
    @SerializedName("original_language") private String original_language;
    @SerializedName("poster_path") private String poster_path;
    @SerializedName("release_date") private String release_date;
    @SerializedName("vote_average") private String vote_average;
    @SerializedName("overview") private String overview;
    @SerializedName("original_title") private String original_title;

    protected Movie(Parcel in) {
        id = in.readString();
        original_language = in.readString();
        poster_path = in.readString();
        release_date = in.readString();
        vote_average = in.readString();
        overview = in.readString();
        original_title = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public String getOriginal_title() {
        return original_title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(original_language);
        dest.writeString(poster_path);
        dest.writeString(release_date);
        dest.writeString(vote_average);
        dest.writeString(overview);
        dest.writeString(original_title);
    }

    //    "id": 713704,
//            "original_language": "en",
//            "original_title": "Evil Dead Rise",
//            "overview": "Two sisters find an ancient vinyl that gives birth to bloodthirsty demons that run amok in a Los Angeles apartment building and thrusts them into a primal battle for survival as they face the most nightmarish version of family imaginable.",
//            "popularity": 1696.367,
//            "poster_path": "/mIBCtPvKZQlxubxKMeViO2UrP3q.jpg",
//            "release_date": "2023-04-12",
//            "title": "Evil Dead Rise",
//            "video": false,
//            "vote_average": 7,
//            "vote_count": 207
}
