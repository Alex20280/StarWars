package com.example.starwars.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MovieGenres implements Parcelable {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String  name;

    protected MovieGenres(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<MovieGenres> CREATOR = new Creator<MovieGenres>() {
        @Override
        public MovieGenres createFromParcel(Parcel in) {
            return new MovieGenres(in);
        }

        @Override
        public MovieGenres[] newArray(int size) {
            return new MovieGenres[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
    }
}
