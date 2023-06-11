package com.example.h071211055_finalmobile.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.h071211055_finalmobile.DataResponse.Movie;
import com.example.h071211055_finalmobile.R;

import java.util.List;

public class AdapterFavorite extends RecyclerView.Adapter<AdapterFavorite.ViewHolder> {
    private Context context;
    private List<Movie> favoriteMovies;

    public AdapterFavorite(Context context, List<Movie> favoriteMovies) {
        this.context = context;
        this.favoriteMovies = favoriteMovies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fav, parent, false);
        return new ViewHolder(view);
    }
    public void setData(List<Movie> favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = favoriteMovies.get(position);
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

        holder.itemView.setOnClickListener(view -> {
            // Handle item click event
        });
    }

    @Override
    public int getItemCount() {
        return favoriteMovies.size();
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

