package com.example.starwars.recycleradapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.starwars.R;
import com.example.starwars.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MoviesRecyclerAdapter extends RecyclerView.Adapter<MoviesRecyclerAdapter.RecyclerViewHolder> {

    Context context;
    ArrayList<Movie> movieList;

    public MoviesRecyclerAdapter(Context context, ArrayList<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.star_movie_recycle_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Movie recyclerViewItem = movieList.get(position);

        holder.movieTitleTv.setText(recyclerViewItem.getTitle());
        holder.genreTv.setText(recyclerViewItem.getGenre().toString());
        //holder.movieDurationTv.setText(recyclerViewItem.getRuntime());

        String poster = "https://image.tmdb.org/t/p/w500" + recyclerViewItem.getPosterPath();
        Glide.with(context).load(poster).apply(RequestOptions.centerCropTransform()).into(holder.image);

        //holder.movieTitleTv.setText(recyclerViewItem.get(position).getTitle());
        //holder.genreTv.setText(movieItem.getGenre());
        //holder.movieDurationTv.setText(movieItem.getDuration());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView movieTitleTv;
        TextView genreTv;
        TextView movieDurationTv;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.posterIv);
            movieTitleTv = itemView.findViewById(R.id.movieTitleTv);
            genreTv = itemView.findViewById(R.id.genreTv);
            movieDurationTv = itemView.findViewById(R.id.movieDurationTv);


        }
    }




        /*
            Glide.with(holder.itemView.getContext())
                .load(recyclerViewItem.getImage())
                .circleCrop()
                .into(holder.imageView);

        //holder.imageView.setImageResource(recyclerViewItem.getImage());
     */




}
