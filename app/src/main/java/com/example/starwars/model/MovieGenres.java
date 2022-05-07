package com.example.starwars.model;

import com.google.gson.annotations.SerializedName;

public class MovieGenres {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String  name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
