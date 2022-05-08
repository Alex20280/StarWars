package com.example.starwars.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Movie  {
    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("overview")
    private String overview;

    @SerializedName("title")
    private String title;

    @SerializedName("genre_ids")
    ArrayList<Integer> genre;


    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Integer> getGenre() {
        return genre;
    }
}