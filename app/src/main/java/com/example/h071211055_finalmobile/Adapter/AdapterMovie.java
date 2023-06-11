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
import com.example.h071211055_finalmobile.DataResponse.Movie;
import com.example.h071211055_finalmobile.R;

import java.util.List;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.ViewHolder> {
    private Context context;
    private List<Movie> dataFilm;

    public AdapterMovie(Context context, List<Movie> dataFilm) {
        this.context = context;
        this.dataFilm = dataFilm;
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
        Movie movie = dataFilm.get(position);
        holder.judul.setText(movie.getTitle());

        String releaseDate = movie.getRelease_date();
        if (releaseDate != null && !releaseDate.isEmpty()) {
            String year = releaseDate.substring(0, 4);
            holder.year.setText(year);
        } else {
            holder.year.setText("");
        }

        String poster = "https://image.tmdb.org/t/p/w500" + movie.getPoster_path();
        Glide.with(holder.picture.getContext())
                .load(poster)
                .into(holder.picture);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, detailMovie.class);
                intent.putExtra("datamovie", movie);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataFilm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView picture;
        TextView judul, year;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.iv_pic);
            judul = itemView.findViewById(R.id.tv_judul);
            year = itemView.findViewById(R.id.tv_year);
        }
    }
}
