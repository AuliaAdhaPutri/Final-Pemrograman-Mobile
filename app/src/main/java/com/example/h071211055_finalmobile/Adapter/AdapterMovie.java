package com.example.h071211055_finalmobile.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.h071211055_finalmobile.Activity.detailMovie;
import com.example.h071211055_finalmobile.Activity.detailTv;
import com.example.h071211055_finalmobile.DataResponse.Movie;
import com.example.h071211055_finalmobile.DataResponse.Tv;
import com.example.h071211055_finalmobile.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.ViewHolder> {
    Context context;
    private List<Movie> dataFilm1;

    public AdapterMovie(Context context, List<Movie> dataFilm1) {
        this.context = context;
        this.dataFilm1 = dataFilm1;
    }

    @NonNull
    @Override
    public AdapterMovie.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemrv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = dataFilm1.get(position);
//        Glide.with(holder.itemView.getContext()) .load(movie.getPoster_path()).into(holder.picture);
        holder.judul.setText(movie.getOriginal_title());
//        holder.year.setText(movie.getRelease_date());


        String releaseDate = movie.getRelease_date();
        if (releaseDate != null && !releaseDate.isEmpty()){
            String year = releaseDate.substring(0,4);
            holder.Year.setText(year);
        }else{
            holder.Year.setText("");
        }

        String poster = "https://image.tmdb.org/t/p/w500" + movie.getPoster_path();
        Glide.with(holder.picture.getContext())
                        .load(poster)
                        .into(holder.picture);
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), detailMovie.class);
            intent.putExtra("datamovie", movie);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dataFilm1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView picture;
        TextView judul,Year;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.iv_pic);
            judul = itemView.findViewById(R.id.tv_judul);
            Year = itemView.findViewById(R.id.tv_year);
        }
    }
}