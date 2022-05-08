package com.example.starwars.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.starwars.R;
import com.example.starwars.model.Movie;
import com.example.starwars.model.Utils;

import java.util.ArrayList;

public class MovieDetailsActivity extends AppCompatActivity {

    ImageView mainPosterIv;
    TextView viewAllTv, moviewNameTv, moviewGenreTv, sinopsinTextTv;
    String name;
    String photo;
    ArrayList <Integer> genreList;
    String overView;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.forward_item, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        viewAllTv = findViewById(R.id.viewAllTv);
        moviewNameTv = findViewById(R.id.moviewNameTv);
        mainPosterIv = findViewById(R.id.mainPosterIv);
        moviewGenreTv = findViewById(R.id.moviewGenreTv);
        sinopsinTextTv = findViewById(R.id.sinopsinTextTv);


        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        photo = intent.getStringExtra("photo");
        genreList = intent.getIntegerArrayListExtra("genre");
        overView = intent.getStringExtra("overview");


        Glide.with(this).load(photo).apply(RequestOptions.centerCropTransform()).into(mainPosterIv);

        moviewNameTv.setText(name);

        moviewGenreTv.setText(Utils.getGenreList(genreList, Utils.CONSTANT_MAP).toString().replace("[", "").replace("]", ""));

        sinopsinTextTv.setText(overView);





        viewAllTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MovieDetailsActivity.this, CastAndCrewActivity.class);
                startActivity(intent);

            }
        });
    }
}