package com.example.starwars.network;

import com.example.starwars.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/popular") //movie/popular
    Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey);



}
