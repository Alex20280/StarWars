package com.example.starwars.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toolbar;

import com.example.starwars.R;
import com.example.starwars.model.MovieResponse;
import com.example.starwars.model.Movie;
import com.example.starwars.network.ApiClient;
import com.example.starwars.network.ApiInterface;
import com.example.starwars.recycleradapters.MoviesRecyclerAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StarMovieActivity extends AppCompatActivity {



    Toolbar mTopToolbar;
    private RecyclerView recyclerView;
    private MoviesRecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<Movie> movieList;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_item, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_movie);


        movieList = new ArrayList<>();
        recyclerView = findViewById(R.id.activityMain_recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new MoviesRecyclerAdapter(getApplicationContext(), movieList);
        layoutManager = new GridLayoutManager(this,2);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> call = apiService.getPopularMovies("9c4b9deab9d391df1258857ba5f58b9c");
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                     movieList = response.body().getResults();
                    recyclerView.setAdapter(new MoviesRecyclerAdapter(getApplicationContext(), movieList));
                    recyclerView.smoothScrollToPosition(0);
                    Log.e("event success", " " + response.body().toString());
                } else {
                    Log.e("Message", "sorry!.......we are unable to fetch user info .......");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d("TAG", "Response = " + t.toString());
            }
        });



    }


}