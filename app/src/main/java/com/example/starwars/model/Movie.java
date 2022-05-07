package com.example.starwars.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Movie {
    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("title")
    private String title;

    @SerializedName("genre_ids")
    ArrayList<Integer> genre;

    public ArrayList<Integer> getGenre() {
        return genre;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

}