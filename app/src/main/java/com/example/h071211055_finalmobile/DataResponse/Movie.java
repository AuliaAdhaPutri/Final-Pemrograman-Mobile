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
    @SerializedName(" backdrop_path") private String  backdrop_path;
    @SerializedName("overview") private String overview;
    @SerializedName("title") private String title;

    protected Movie(Parcel in) {
        id = in.readString();
        original_language = in.readString();
        poster_path = in.readString();
        release_date = in.readString();
        vote_average = in.readString();
        overview = in.readString();
        title = in.readString();
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

    public String getTitle() {
        return title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setTitle(String title) {
        this.title = title;
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
        dest.writeString(title);
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
